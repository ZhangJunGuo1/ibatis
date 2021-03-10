/**
 * User: Clinton Begin
 * Date: Jul 13, 2003
 * Time: 7:24:04 PM
 */
package com.ibatis.jpetstore.persistence.sqlmapdao;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.execution.BatchException;

import java.sql.SQLException;
import java.util.List;

public class BaseSqlMapDao extends SqlMapDaoTemplate {

  protected static final int PAGE_SIZE = 4;

  public BaseSqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }


  @Override
  public Object insert(String s) throws SQLException {
    return null;
  }

  @Override
  public int update(String s) throws SQLException {
    return 0;
  }

  @Override
  public int delete(String s) throws SQLException {
    return 0;
  }

  @Override
  public Object queryForObject(String s) throws SQLException {
    return null;
  }

  @Override
  public List queryForList(String s) throws SQLException {
    return null;
  }

  @Override
  public List queryForList(String s, int i, int i1) throws SQLException {
    return null;
  }

  @Override
  public void queryWithRowHandler(String s, RowHandler rowHandler) throws SQLException {

  }

  @Override
  public PaginatedList queryForPaginatedList(String s, int i) throws SQLException {
    return null;
  }

  @Override
  public List executeBatchDetailed() throws SQLException, BatchException {
    return null;
  }
}
