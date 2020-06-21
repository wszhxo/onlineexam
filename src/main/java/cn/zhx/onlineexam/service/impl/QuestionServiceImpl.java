package cn.zhx.onlineexam.service.impl;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.mapper.QuestionMapper;
import cn.zhx.onlineexam.pojo.Category;
import cn.zhx.onlineexam.pojo.Difficult;
import cn.zhx.onlineexam.pojo.ExamQuestion;
import cn.zhx.onlineexam.pojo.Question;
import cn.zhx.onlineexam.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    QuestionMapper questionMapper;
    @Override
    public List<Question> listQuestion(Criteria criteria) {
        return questionMapper.listQuestion(criteria);
    }

    @Override
    public int addQuestion(Question question) {
        return questionMapper.addQuestion(question);
    }

    @Override
    public int delQuestion(Long id) {
        return questionMapper.delQuestion(id);
    }

    @Override
    public int editQuestion(Question question) {
        return questionMapper.editQuestion(question);
    }

    @Override
    public List<Category> listCategory() {
        return questionMapper.listCategory();
    }

    @Override
    public List<Difficult> listDifficult() {
        return questionMapper.listDifficult();
    }



    @Override
    public Question findQuestionById(Long id) {
        return questionMapper.findQuestionById(id);
    }

    @Override
    public List<Question> listQuestionsByNum(Long num, int Category,Long difficultid) {
        return questionMapper.listQuestionsByNum(num,Category,difficultid);
    }

    @Override
    public List<Question> findHisQuestions(Long examid, Long userid, int category) {
        return questionMapper.findHisQuestions(examid,userid,category);
    }

    @Override
    public List<ExamQuestion> findHisExamQuestions(Long examid, Long userid, Integer categoryid) {
        return questionMapper.findHisExamQuestions(examid,userid,categoryid);
    }

}
