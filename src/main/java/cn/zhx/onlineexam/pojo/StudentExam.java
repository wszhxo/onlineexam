package cn.zhx.onlineexam.pojo;

import org.springframework.stereotype.Component;

@Component
public class StudentExam {

  private Long id;
  private Long examid;
  private Exam exam;
  private String begintime;
  private String endtime;
  private Double score;
  private Long userid;
  private User user;
  private Long editsubject;
  public Long getEditsubject() {
    return editsubject;
  }

  public void setEditsubject(Long editsubject) {
    this.editsubject = editsubject;
  }

  public String getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }

  public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Exam getExam() {
    return exam;
  }

  public void setExam(Exam exam) {
    this.exam = exam;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getExamid() {
    return examid;
  }

  public void setExamid(Long examid) {
    this.examid = examid;
  }


  public String getBegintime() {
    return begintime;
  }

  public void setBegintime(String begintime) {
    this.begintime = begintime;
  }




  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

}
