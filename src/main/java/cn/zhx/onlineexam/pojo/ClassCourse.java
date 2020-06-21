package cn.zhx.onlineexam.pojo;

import org.springframework.stereotype.Component;

@Component
public class ClassCourse {

  private Long classid;
  private Long courseid;


  public Long getClassid() {
    return classid;
  }

  public void setClassid(Long classid) {
    this.classid = classid;
  }


  public Long getCourseid() {
    return courseid;
  }

  public void setCourseid(Long courseid) {
    this.courseid = courseid;
  }

}
