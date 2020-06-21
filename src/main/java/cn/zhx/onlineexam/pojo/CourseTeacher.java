package cn.zhx.onlineexam.pojo;

import org.springframework.stereotype.Component;

@Component
public class CourseTeacher {

  private Long courseid;
  private Long teacherid;


  public Long getCourseid() {
    return courseid;
  }

  public void setCourseid(Long courseid) {
    this.courseid = courseid;
  }


  public Long getTeacherid() {
    return teacherid;
  }

  public void setTeacherid(Long teacherid) {
    this.teacherid = teacherid;
  }

}
