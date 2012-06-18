package com.ex.dao_v1;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ex.dao.common.MyDaoBase_v1;
import com.ex.util.Ut;

@Repository
public class Ex01DaoV1 extends MyDaoBase_v1 {

  public List<Map<String, Object>> getEx01Ids() {
    String sql = Ut.joins("select * from shard");
    return jte.queryForList(sql);
  }

}
