package cn.zhx.onlineexam.mapper;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
public interface UserMapper {

    List<User> listUsers(Criteria criteria);

    @Select("select * from user where id=#{id}")
    User checkUser(int id) throws Exception;

    @Update("update user set password=#{password} where id = #{id}")
    int editPwd(User user) throws Exception;

    @Delete("delete from user where id=#{id}")
    int delUser(Long id);

//    @Update("update user set name=#{name},email=#{email},phone=#{phone},sex=#{sex},classid=#{classid} where id=#{id}")
    int editUser(User user);
    @Update("update user set password='e10adc3949ba59abbe56e057f20f883e' where id=#{id}")
    int editPSW(Long id);
    @Insert("insert into user values(#{id},#{password},#{name},#{email},#{phone},#{sex},#{classid},111)")
    int addStudent(User user);
    @Insert("insert into user values(#{id},#{password},#{name},#{email},#{phone},#{sex},0,11)")
    int addTeacher(User user);
    @Delete("delete from user where classid=#{id}")
    void delUserByClassid(Long id);
}
