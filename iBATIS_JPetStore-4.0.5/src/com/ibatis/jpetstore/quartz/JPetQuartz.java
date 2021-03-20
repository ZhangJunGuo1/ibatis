package com.ibatis.jpetstore.quartz;

import org.apache.tools.ant.util.DateUtils;
import org.quartz.*;
import org.quartz.spi.OperableTrigger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by zjg on 2021/3/18
 */
public class JPetQuartz implements Job {
    private static int currRetryCount=0;
    private static boolean flag=true;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+"当前线程:"+Thread.currentThread());
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        JobKey jobKey = jobDetail.getKey();
        String jobName = jobKey.getName();
        String jobGroup = jobKey.getGroup();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        int maxRetryCount = jobDataMap.getInt("maxRetryCount");
        long retryInterval = jobDataMap.getInt("retryInterval");
        if(flag){
            if(currRetryCount<maxRetryCount){
                currRetryCount+=1;
                JobDetail job = jobExecutionContext
                        .getJobDetail()
                        .getJobBuilder()
                        .withIdentity(jobExecutionContext.getJobDetail().getKey().getName() + "_" + currRetryCount, jobExecutionContext.getJobDetail().getKey().getGroup())
                        .usingJobData(jobDataMap)
                        .build();
                OperableTrigger trigger = (OperableTrigger) TriggerBuilder.newTrigger().forJob(job)
                        .startAt(new Date(jobExecutionContext.getFireTime().getTime() + retryInterval)).build();
                System.out.println("当前线程:"+Thread.currentThread()+"当前重试次数"+currRetryCount);
                try {
                    jobExecutionContext.getScheduler().scheduleJob(job, trigger);
                } catch (SchedulerException e1) {
                    e1.printStackTrace();
                }
            }else{
                currRetryCount=0;
                flag=false;//第三次修改开关
            }
        }else{
            flag=true;
        }


    }
}
