package cn.zhx.onlineexam.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Exam {

  private Long id;
  private String name;
  private String begintime;
  private String endtime;
  private String lasttime;
  private Long choicenum=0L;
  private Long choicesnum=0L;
  private Long tofnum=0L;
  private Long subjectivenum=0L;
  private Long fillnum=0L;
  private Double choicescore=0.0;
  private Double choicesscore=0.0;
  private Double tofscore=0.0;
  private Double subjectscore=0.0;
  private Double fillscore=0.0;
  private Double total;
  private Long courseid;
  private String classids;
  private Long teacherid;
  private Long difficultid;

  private Difficult difficult;
  private Course course;
  private User user;
  private String classidsname;
  private List<Class> classList=new ArrayList<>();

  public String getClassidsname() {
    return classidsname;
  }

  public void setClassidsname(String classidsname) {
    this.classidsname = classidsname;
  }

  public Long getDifficultid() {
    return difficultid;
  }

  public void setDifficultid(Long difficultid) {
    this.difficultid = difficultid;
  }

  public Difficult getDifficult() {
    return difficult;
  }

  public void setDifficult(Difficult difficult) {
    this.difficult = difficult;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Class> getClassList() {
    return classList;
  }

  public void setClassList(List<Class> classList) {
    this.classList = classList;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
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


  public String getBegintime() {
    return begintime;
  }

  public void setBegintime(String begintime) {
    this.begintime = begintime;
  }


  public String getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }


  public String getLasttime() {
    return lasttime;
  }

  public void setLasttime(String lasttime) {
    this.lasttime = lasttime;
  }


  public Long getCourseid() {
    return courseid;
  }

  public void setCourseid(Long courseid) {
    this.courseid = courseid;
  }


  public String getClassids() {
    return classids;
  }

  public void setClassids(String classids) {
    this.classids = classids;
  }


  public Long getChoicenum() {
    return choicenum;
  }

  public void setChoicenum(Long choicenum) {
    this.choicenum = choicenum;
  }


  public Long getChoicesnum() {
    return choicesnum;
  }

  public void setChoicesnum(Long choicesnum) {
    this.choicesnum = choicesnum;
  }


  public Long getTofnum() {
    return tofnum;
  }

  public void setTofnum(Long tofnum) {
    this.tofnum = tofnum;
  }


  public Long getSubjectivenum() {
    return subjectivenum;
  }

  public void setSubjectivenum(Long subjectivenum) {
    this.subjectivenum = subjectivenum;
  }


  public Long getFillnum() {
    return fillnum;
  }

  public void setFillnum(Long fillnum) {
    this.fillnum = fillnum;
  }


  public Double getChoicescore() {
    return choicescore;
  }

  public void setChoicescore(Double choicescore) {
    this.choicescore = choicescore;
  }


  public Double getChoicesscore() {
    return choicesscore;
  }

  public void setChoicesscore(Double choicesscore) {
    this.choicesscore = choicesscore;
  }


  public Double getTofscore() {
    return tofscore;
  }

  public void setTofscore(Double tofscore) {
    this.tofscore = tofscore;
  }


  public Double getSubjectscore() {
    return subjectscore;
  }

  public void setSubjectscore(Double subjectscore) {
    this.subjectscore = subjectscore;
  }


  public Double getFillscore() {
    return fillscore;
  }

  public void setFillscore(Double fillscore) {
    this.fillscore = fillscore;
  }


  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }


  public Long getTeacherid() {
    return teacherid;
  }

  public void setTeacherid(Long teacherid) {
    this.teacherid = teacherid;
  }



}
