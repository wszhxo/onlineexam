package cn.zhx.onlineexam.service;

import cn.zhx.onlineexam.entity.Score;

import java.util.List;

public interface ScoreService {

    List<Score> listScore(Long examid, Long classid);
}
