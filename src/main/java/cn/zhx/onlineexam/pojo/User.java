package cn.zhx.onlineexam.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {

  private Long id;
  private String password;
  private String name;
  private String email;
  private String phone;
  private String sex;
  private Class cls;
  private Long type;
  private Long classid;

  public Long getClassid() {
    return classid;
  }

  public void setClassid(Long classid) {
    this.classid = classid;
  }

  public Class getCls() {
    return cls;
  }

  public void setCls(Class cls) {
    this.cls = cls;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }




  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", sex='" + sex + '\'' +
            ", cls=" + cls +
            ", type=" + type +
            ", classid=" + classid +
            '}';
  }
}
