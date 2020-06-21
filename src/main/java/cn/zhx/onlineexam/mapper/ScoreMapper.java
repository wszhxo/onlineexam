package cn.zhx.onlineexam.mapper;

import cn.zhx.onlineexam.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
public interface ScoreMapper {
//@Select("SELECT u.`name`,s.score,s.userid,\n" +
//        "timediff(s.endtime,s.begintime) lasttime\n" +
//        "FROM`student-exam` AS s LEFT JOIN\n" +
//        "`user` AS u on s.userid=u.id\n" +
//        "where s.examid=#{examid} and u.classid=#{classid}\n" +
//        "ORDER BY s.score,timediff(s.endtime,s.begintime)")
    List<Score> listScore(@Param("examid") Long examid, @Param("classid")Long classid);
}
