package com.ex.dao.common;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class MyDaoBase {

  protected JdbcTpl jte;

  @Resource(name = "myDataSource")
  public void setDataSource(DataSource dataSource) {
    this.jte = new JdbcTpl(dataSource, PagiType.Mys);
  }

}
