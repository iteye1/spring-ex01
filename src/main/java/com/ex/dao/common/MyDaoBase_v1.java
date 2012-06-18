package com.ex.dao.common;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class MyDaoBase_v1 {

  protected JdbcTpl jte;

  @Resource(name = "myDataSource_v1")
  public void setDataSource(DataSource dataSource) {
    this.jte = new JdbcTpl(dataSource, PagiType.Mys);
  }

}
