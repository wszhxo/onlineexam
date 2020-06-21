package cn.zhx.onlineexam.controller;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.entity.Score;
import cn.zhx.onlineexam.pojo.User;
import cn.zhx.onlineexam.service.ScoreService;
import cn.zhx.onlineexam.service.UserService;
import cn.zhx.onlineexam.utils.LayuiJSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ScoreController {
    @Resource
    ScoreService scoreService;


    //成绩排序界面
    @GetMapping("/score/{examid}")
    public  @ResponseBody String getscore(@PathVariable(value = "examid") Long examid,
                                          @RequestParam(value = "classid" ,defaultValue = "0") Long classid) {
        List<Score> list = scoreService.listScore(examid,classid);
        return LayuiJSON.jsonStr("",list.size(),list);
    }
    //跳转到成绩排序界面
    @GetMapping("/toScore/{examid}")
    public String toscore(@PathVariable(value = "examid") Long examid, Model model) {
        model.addAttribute("examid",examid);
        return "/admin/score/score";
    }

}
