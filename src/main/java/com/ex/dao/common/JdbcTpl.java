package com.ex.dao.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ex.Cons;
import com.ex.util.Ut;

public class JdbcTpl extends JdbcTemplate {
  private final PagiType pagiType;

  public JdbcTpl(PagiType pagiType) {
    super();
    this.pagiType = pagiType;
  }

  public JdbcTpl(DataSource dataSource, PagiType pagiType) {
    super(dataSource);
    this.pagiType = pagiType;
  }

  public JdbcTpl(DataSource dataSource, boolean lazyInit, PagiType pagiType) {
    super(dataSource, lazyInit);
    this.pagiType = pagiType;
  }

  public long queryTotalCount(String sql, Object... args)
      throws DataAccessException {
    String sql0 = Ut.joins("SELECT COUNT(*) FROM (", sql, ") T1");
    return queryForLong(sql0, args);
  }

  public List<Map<String, Object>> queryForList(String sql, int start, int limit)
      throws DataAccessException {
    String limitSelect = pagiType.getLimit(sql, start, limit);
    return queryForList(limitSelect);
  }

  @Deprecated
  public List<Map<String, Object>> queryForList(String sql, Object[] args,
      int[] argTypes, int start, int limit) throws DataAccessException {
    String limitSelect = pagiType.getLimit(sql, start, limit);
    return queryForList(limitSelect, args, argTypes);
  }

  public <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper,
      int start, int limit) throws DataAccessException {
    String limitSelect = pagiType.getLimit(sql, start, limit);
    return query(limitSelect, args, rowMapper);
  }

  public List<Map<String, Object>> queryForList(String sql, int start,
      int limit, Object... args) throws DataAccessException {
    String limitSelect = pagiType.getLimit(sql, start, limit);
    return queryForList(limitSelect, args);
  }

  public Map<String, Object> queryPagingTotalCount(String sql, int start,
      int limit, Object... args) throws DataAccessException {
    Map<String, Object> result = new HashMap<String, Object>(2);
    result.put(Cons.KTotalCount, queryTotalCount(sql, args));
    result.put(Cons.KItems, queryForList(sql, start, limit, args));
    return result;
  }
}
