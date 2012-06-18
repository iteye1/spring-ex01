package com.ex.web;

import static com.ex.Cons.Json_JSP;
import static com.ex.Cons.Json_Var;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.dao.Ex01Dao;
import com.ex.dao_v1.Ex01DaoV1;
import com.ex.util.Ut;

@Controller
public class Ex01Controller {
  @Autowired
  private Ex01Dao dao;
  
  @Autowired
  private Ex01DaoV1 dao1;

  @RequestMapping(value = "/ex01/ids")
  public String getEx01Ids(Model model) {
    String rlt = Ut.toJsonp(dao.getEx01Ids());
    model.addAttribute(Json_Var, rlt);
    return Json_JSP;
  }
  
  @RequestMapping(value = "/ex01/ids2")
  public String getEx01Ids2(Model model) {
    List<Map<String, Object>> items1=dao1.getEx01Ids();
    List<Map<String, Object>> items2=dao.getEx01Ids();
    Ut.mergeList(items1, items2);
    String rlt = Ut.toJsonp(items1);
    model.addAttribute(Json_Var, rlt);
    return Json_JSP;
  }
}
