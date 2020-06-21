package cn.zhx.onlineexam.pojo;

import org.springframework.stereotype.Component;

@Component
public class Question {

  private Long id;
  private String title;
  private String optA;
  private String optB;
  private String optC;
  private String optD;
  private String answer;
  Category category;
  Difficult difficult;
  Course course;
  private Long categoryid;
  private Long difficultid;
  private Long courseid;

  public Long getCourseid() {
    return courseid;
  }

  public void setCourseid(Long courseid) {
    this.courseid = courseid;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Difficult getDifficult() {
    return difficult;
  }

  public void setDifficult(Difficult difficult) {
    this.difficult = difficult;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getOptA() {
    return optA;
  }

  public void setOptA(String optA) {
    this.optA = optA;
  }


  public String getOptB() {
    return optB;
  }

  public void setOptB(String optB) {
    this.optB = optB;
  }


  public String getOptC() {
    return optC;
  }

  public void setOptC(String optC) {
    this.optC = optC;
  }


  public String getOptD() {
    return optD;
  }

  public void setOptD(String optD) {
    this.optD = optD;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public Long getCategoryid() {
    return categoryid;
  }

  public void setCategoryid(Long categoryid) {
    this.categoryid = categoryid;
  }


  public Long getDifficultid() {
    return difficultid;
  }

  public void setDifficultid(Long difficultid) {
    this.difficultid = difficultid;
  }

}
