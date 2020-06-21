package cn.zhx.onlineexam.mapper;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.pojo.Category;
import cn.zhx.onlineexam.pojo.Difficult;
import cn.zhx.onlineexam.pojo.ExamQuestion;
import cn.zhx.onlineexam.pojo.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
public interface QuestionMapper {
    List<Question> listQuestion(Criteria criteria);


    @Insert("insert into question(title,optA,optB,optC,optD,answer,categoryid,difficultid,courseid)" +
            " values(#{title},#{optA},#{optB},#{optC},#{optD},#{answer},#{categoryid},#{difficultid},#{courseid})")
    int addQuestion(Question question);

    @Delete("delete from question where id=#{id}")
    int delQuestion(Long id);

    int editQuestion(Question question);

    @Select("select * from category ")
    List<Category> listCategory();
    @Select("select * from difficult ")
    List<Difficult> listDifficult();

    @Select("select * from question where id=#{id}")
    Question findQuestionById(Long id);

    @Select("SELECT * FROM `question`  WHERE categoryid=#{category} and difficultid=#{difficultid} ORDER BY RAND() LIMIT #{num} ")
    List<Question> listQuestionsByNum(Long num, int category,Long difficultid);


    @Select("SELECT q.id, q.categoryid, q.title, q.optA, q.optB, q.optC, q.optD,\n" +
            "q.answer, q.difficultid, q.courseid\n" +
            "FROM `exam-question` AS e LEFT JOIN\n" +
            "question AS q ON e.questionid=q.id\n" +
            "where e.examid=#{examid} AND e.userid=#{userid} and q.categoryid=#{categoryid}\n" +
            "ORDER BY e.sort\n")
    List<Question> findHisQuestions(Long examid, Long userid, int categoryid);

    List<ExamQuestion> findHisExamQuestions(@Param("examid") Long examid, @Param("userid") Long userid, @Param("categoryid") Integer categoryid);
}
