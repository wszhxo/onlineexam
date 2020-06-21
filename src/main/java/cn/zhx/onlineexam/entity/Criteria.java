package cn.zhx.onlineexam.entity;

public class Criteria {
    //学生,老师信息搜索条件
    int type;//老师还是学生还是管理员
    String name;
    int classid;
    //题目信息搜索条件,,或者试卷的搜索条件
    int categoryid;
    int difficultid;
    int courseid;
    int userid;
    String title;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getDifficultid() {
        return difficultid;
    }

    public void setDifficultid(int difficultid) {
        this.difficultid = difficultid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
