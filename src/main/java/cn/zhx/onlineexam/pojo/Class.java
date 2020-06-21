package cn.zhx.onlineexam.pojo;

import org.springframework.stereotype.Component;

@Component
public class Class {

  private Long id;
  private String name;
  private String courseid;
  private String courseidnames;

  public String getCourseid() {
    return courseid;
  }

  public void setCourseid(String courseid) {
    this.courseid = courseid;
  }

  public String getCourseidnames() {
    return courseidnames;
  }

  public void setCourseidnames(String courseidnames) {
    this.courseidnames = courseidnames;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
