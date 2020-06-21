package cn.zhx.onlineexam.mapper;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.pojo.Exam;
import cn.zhx.onlineexam.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
public interface ExamMapper {
    List<Exam> listExams(Criteria criteria);

    int addExam(Exam exam);
    @Delete("delete from exam where id=#{id}")
    int delExam(Long id);


    int editExam(Exam exam);

//    @Select("SELECT * FROM exam WHERE courseid IN \n" +
//        "(select courseid from `class-course` where classid=#{classid})  and  NOW() < endtime\n" +
//    "AND id not IN (SELECT examid from `student-exam` where userid=#{id})")
    @Select("SELECT * FROM exam WHERE classids LIKE '%${classid}%'   and  NOW() < endtime\n" +
            "AND id not IN (SELECT examid from `student-exam` where userid=#{id})")
    List<Exam> findExamsByClassId(User user);
    @Select(" select * from exam where id=#{id} ")
    Exam findExamsByid(Long id);
    @Insert("INSERT into `exam-question`(examid,userid,questionid,sort) VALUES(#{examid},#{userid},#{questionid},#{i})")
    int addExamQuestion(Long examid, Long userid, Long questionid, int i);
    @Select(" select count(id) from `exam-question` where examid=#{examid} and userid=#{userid} ")
    int findExamsByexamidAnduserid(Long examid, Long userid);
    @Update("update `exam-question` set answer=#{answer},istrue=#{istrue},score=#{score} where userid=#{userid} and questionid=#{questionid} and examid=#{examid}")
    int updateExamQuestion(Long questionid, Long userid, String answer, Integer istrue, Double score,Long examid);

    @Insert("INSERT into `student-exam`(examid,begintime,endtime,score,userid) VALUES(#{examid},#{begintime},#{endtime},#{total},#{userid})")
    int addStudentExam(Long examid, String begintime, String endtime, Double total, Long userid) ;


    List<Exam> listHisExams(Criteria criteria);

    List<Exam> findHisExamsByClassId(User user);
    @Select("select * from exam where id =#{id}")
    Exam getExamById(Long id);

    @Delete("delete from `student-exam` where examid=#{id}")
    void delStudentExamByExamId(Long id);
    @Delete("delete from `eaxm-question` where examid=#{id}")
    void delExamQuestionByExamId(Long id);

    @Delete("delete from `student-exam` where  userid=#{userid} and examid=#{examid}")
    int delStudentExam(Long userid, Long examid);
    @Delete("delete from `eaxm-question` where  userid=#{userid} and examid=#{examid}")
    int delExamQuestion(Long userid, Long examid);

    @Update("update `student-exam` set score=#{score},editsubject=#{editsubject}  where userid=#{userid} and  examid=#{examid}")
    int updateStudentExam(Long userid, Long examid, Double score,Integer editsubject);
    @Select("select COUNT(id) from  `exam-question` where userid=#{userid} and  examid=#{examid} and score is NULL ")
    Integer checkSubject(Long userid, Long examid);
    @Select("SELECT * FROM exam WHERE classids LIKE '%${classid}%'   and  NOW() > endtime\n" +
            "AND id not IN (SELECT examid from `student-exam` where userid=#{id})")
    List<Exam> findExpireExamsByClassId(User user);


}
