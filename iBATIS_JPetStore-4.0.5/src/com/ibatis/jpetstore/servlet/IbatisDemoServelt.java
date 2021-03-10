package com.ibatis.jpetstore.servlet;

import com.ibatis.jpetstore.domain.IbatisDemo;
import com.ibatis.jpetstore.service.IbatisDemoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by zjg on 2021/2/27
 */
public class IbatisDemoServelt extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String protocol = req.getProtocol();
            List<IbatisDemo> ibatisDemoList=new ArrayList<>();
            IbatisDemoService ibatisDemoService=IbatisDemoService.getInstance();
            IbatisDemo ibatisDemo1=new IbatisDemo("","66","200","100");
            ibatisDemo1.setStudentId("66");
            ibatisDemo1.setScope("100");
            List<IbatisDemo>list=ibatisDemoService.selectBatch(ibatisDemo1);
            IbatisDemo ibatisDemo2=new IbatisDemo("","李四","200","66");
            ibatisDemoList.add(ibatisDemo1);
            ibatisDemoList.add(ibatisDemo2);
//            Object i=ibatisDemoService.addBatch(ibatisDemoList);
//            int i=ibatisDemoService.updateBatch(ibatisDemoList);
//            System.out.println("更新成功的数量:"+i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
