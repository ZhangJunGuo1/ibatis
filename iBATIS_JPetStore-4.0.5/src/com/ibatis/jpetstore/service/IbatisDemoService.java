package com.ibatis.jpetstore.service;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.jpetstore.domain.IbatisDemo;
import com.ibatis.jpetstore.domain.LineItem;
import com.ibatis.jpetstore.domain.Order;
import com.ibatis.jpetstore.persistence.DaoConfig;
import com.ibatis.jpetstore.persistence.iface.IbatisDemoDao;
import com.ibatis.jpetstore.persistence.iface.ItemDao;
import com.ibatis.jpetstore.persistence.iface.OrderDao;
import com.ibatis.jpetstore.persistence.iface.SequenceDao;

import java.util.List;

/**
 * <p/>
 * Date: Mar 6, 2004 11:22:36 PM
 * 
 * @author Clinton Begin
 */
public class IbatisDemoService {

  /* Constants */
  private static final IbatisDemoService instance = new IbatisDemoService();

  /* Private Fields */
  private DaoManager daoManager = DaoConfig.getDaomanager();
  private IbatisDemoDao ibatisDemoDao;

  /* Constructors */
  public IbatisDemoService() {
    ibatisDemoDao = (IbatisDemoDao) daoManager.getDao(IbatisDemoDao.class);
  }

  /* Public Methods */
  public static IbatisDemoService getInstance() {
    return instance;
  }
  public List<IbatisDemo> selectBatch(IbatisDemo ibatisDemo) {
    List<IbatisDemo> ibatisDemoList;
    try {
      daoManager.startTransaction();
      ibatisDemoList=ibatisDemoDao.selectBatch(ibatisDemo);
      daoManager.commitTransaction();
    } finally {
      daoManager.endTransaction();
    }
    return ibatisDemoList;
  }

  public int updateBatch(List<IbatisDemo> ibatisDemoList) {
    int resultSize=0;
    try {
      daoManager.startTransaction();
      resultSize=ibatisDemoDao.updateBatch(ibatisDemoList);
      daoManager.commitTransaction();
    } finally {
      daoManager.endTransaction();
    }
    return resultSize;
  }
  public Object addBatch(List<IbatisDemo> ibatisDemoList) {
    Object resultSize;
    try {
      daoManager.startTransaction();
      resultSize=ibatisDemoDao.addBatch(ibatisDemoList);
      daoManager.commitTransaction();
    } finally {
      daoManager.endTransaction();
    }
    return resultSize;
  }


}
