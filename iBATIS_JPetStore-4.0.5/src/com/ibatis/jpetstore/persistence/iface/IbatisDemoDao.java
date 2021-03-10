/**
 * User: Clinton Begin
 * Date: Jul 13, 2003
 * Time: 8:18:50 PM
 */
package com.ibatis.jpetstore.persistence.iface;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.jpetstore.domain.IbatisDemo;
import com.ibatis.jpetstore.domain.Order;

import java.util.List;

public interface IbatisDemoDao {

  public int updateBatch(List<IbatisDemo> ibatisDemoList);
  public List<IbatisDemo>selectBatch(IbatisDemo ibatisDemo);
  public Object addBatch(List<IbatisDemo> ibatisDemoList);
}
