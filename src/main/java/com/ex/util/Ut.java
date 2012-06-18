package com.ex.util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Ut {
  public static String toJsonp(Object data){
    return toJsonp(data, null);
  }

  public static String toJsonp(Object data, String callback) {
    Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    String rlt=gs.toJson(data);
    if(callback!=null){
      return Ut.joins(callback, "(", rlt, ");");
    }else{
      return rlt;
    }
  }
  
  /**
   * merge objects to a string
   * @param objs objects
   * @return a string
   */
  public static String joins(Object... objs){
    StringBuilder sb=new StringBuilder();
    for(Object s:objs){
      sb.append(s);
    }
    return sb.toString();
  }

  public static <T> List<T> mergeList(
      List<T> items1, List<T> items2) {
    if(items1!=null){
      if(items2!=null){
        items1.addAll(items2);    
      }
    }else{
      items1=items2;
    }
    return items1;
  }
}
