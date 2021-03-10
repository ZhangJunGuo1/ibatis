package com.ibatis.jpetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class IbatisDemo implements Serializable {

  /* Private Fields */

  private String id;
  public String studentId;
  private String kcId;
  private String scope;

  public IbatisDemo() {
  }

  public IbatisDemo(String id, String studentId, String kcId, String scope) {
    this.id = id;
    this.studentId = studentId;
    this.kcId = kcId;
    this.scope = scope;
  }
  /* JavaBeans Properties */

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getKcId() {
    return kcId;
  }

  public void setKcId(String kcId) {
    this.kcId = kcId;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  @Override
  public String toString() {
    return "IbatisDemo{" +
            "id='" + id + '\'' +
            ", studentId='" + studentId + '\'' +
            ", kcId='" + kcId + '\'' +
            ", scope='" + scope + '\'' +
            '}';
  }
}
