package cn.zhx.onlineexam.pojo;

import org.springframework.stereotype.Component;

@Component
public class ExamQuestion {

  private Long id;
  private Long examid;
  private Long questionid;
  private Question question;
  private Long userid;
  private Long istrue;
  private Double score;
  private String answer;
  private Long sort;


  private Double oldScore;//原来的总分
  private Double total;//原来的该题分数


    public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public Double getOldScore() {
    return oldScore;
  }

  public void setOldScore(Double oldScore) {
    this.oldScore = oldScore;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
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


  public Long getQuestionid() {
    return questionid;
  }

  public void setQuestionid(Long questionid) {
    this.questionid = questionid;
  }


  public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }


  public Long getIstrue() {
    return istrue;
  }

  public void setIstrue(Long istrue) {
    this.istrue = istrue;
  }


  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public Long getSort() {
    return sort;
  }

  public void setSort(Long sort) {
    this.sort = sort;
  }

}
