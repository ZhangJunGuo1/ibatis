/**
 * User: Clinton Begin
 * Date: Jul 13, 2003
 * Time: 7:20:47 PM
 */
package com.ibatis.jpetstore.persistence.sqlmapdao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.jpetstore.domain.IbatisDemo;
import com.ibatis.jpetstore.persistence.iface.IbatisDemoDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IbatisDemoSqlMapDao extends BaseSqlMapDao implements IbatisDemoDao {

  public IbatisDemoSqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }

  @Override
  public int updateBatch(List<IbatisDemo> ibatisDemoList) {
    int size=0;
    //使用list作为参数测试
//    size=update("updateBatchDemo",ibatisDemoList);
    IbatisDemo demo1=new IbatisDemo();
    demo1.setStudentId("66");
    demo1.setId("100");
    List<IbatisDemo> list2=new ArrayList<>();
    list2.add(demo1);
    //使用map作为参数测试
    Map<String,Object> param=new HashMap<>();
    List<Integer> list1=new ArrayList<>();
    list1.add(66);
    list1.add(67);
    param.put("list",list2);
    param.put("id","201");
    size=update("updateBatchDemo",param);
    //使用java代码批量处理
//    try {
//      if(ibatisDemoList!=null){
//        this.getSqlMapExecutor().startBatch();
//        for(IbatisDemo ibatisDemo:ibatisDemoList){
//          update("updateBatch",ibatisDemo);
//        }
//        size=this.getSqlMapExecutor().executeBatch();
//      }
//    }catch (Exception e){
//      e.printStackTrace();
//    }
    return size;
  }

  @Override
  public List<IbatisDemo> selectBatch(IbatisDemo ibatisDemo) {
    return queryForList("selectBatch",ibatisDemo);
  }

  @Override
  public Object addBatch(List<IbatisDemo> ibatisDemoList) {
    return insert("addBatchWages",ibatisDemoList);
  }
}
