package com.ex.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ex.dao.common.MyDaoBase;
import com.ex.util.Ut;

@Repository
public class Ex01Dao extends MyDaoBase {

  public List<Map<String, Object>> getEx01Ids() {
    String sql = Ut.joins("select * from shard");
    return jte.queryForList(sql);
  }

}
