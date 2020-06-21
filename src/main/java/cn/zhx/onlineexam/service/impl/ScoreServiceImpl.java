package cn.zhx.onlineexam.service.impl;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.entity.Score;
import cn.zhx.onlineexam.mapper.ScoreMapper;
import cn.zhx.onlineexam.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    ScoreMapper scoreMapper;
    @Override
    public List<Score> listScore(Long examid, Long classid) {
        return scoreMapper.listScore( examid,classid);
    }
}
