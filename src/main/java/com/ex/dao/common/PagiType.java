package com.ex.dao.common;

import com.ex.util.Ut;

interface PagiType {
  PagiType Ora = new OraclePagi();
  PagiType Mys = new MySQLPagi();

  String getLimit(String sql, int start, int limit);
}

abstract class AbstractPagiType implements PagiType {
  public String getLimit(String sql, int start, int limit) {
    if (start < 0) {
      start = 0;
    }
    if (limit <= 0) {
      limit = 1000;//default limit
    }
    return genLimitSql(sql, start, limit);
  }

  abstract protected String genLimitSql(String sql, int start, int limit);
}

class MySQLPagi extends AbstractPagiType implements PagiType {
  public String genLimitSql(String sql, int start, int limit) {
    return Ut.joins(sql, " limit ", start, ",", limit);
  }
}

class OraclePagi extends AbstractPagiType implements PagiType {
  public String genLimitSql(String sql, int start, int limit) {
    int r1 = start;
    int r2 = start + limit - 1;
    return Ut.joins("SELECT * FROM ( SELECT RW_.*, ROWNUM RN_ FROM ( ",
        sql, " ) RW_ WHERE ROWNUM <= ", r2, ") WHERE RN_ >= ", r1);
  }
}
