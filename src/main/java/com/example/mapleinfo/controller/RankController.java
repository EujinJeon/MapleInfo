package com.example.mapleinfo.controller;

import com.example.mapleinfo.entity.Rank;
import com.example.mapleinfo.entity.User;
import com.example.mapleinfo.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rank")
public class RankController {

    private final RankService rankService;
    @GetMapping("/list")
    public String listRank(@RequestParam(value = "world_type", defaultValue = "일반")
                               String worldType, Model model) {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
        if(calendar.get(Calendar.HOUR_OF_DAY) > 1){
            calendar.add(Calendar.DATE, -1);
        }
        else {
            calendar.add(Calendar.DATE, -2);
        }
        String checkDate = SDF.format(calendar.getTime());
        System.out.println(checkDate);
        long type = 0;
        if (worldType.equals("리부트")){
            type = 1;
        }
        List<Rank.RankLoad> tmp = this.rankService.rankList(checkDate,type,1);
        List<Rank.RankLoad> rankList = new ArrayList<>();
        for (int i  = 0; i < 30; i++){
            rankList.add(tmp.get(i));
        }
        model.addAttribute("rankList", rankList);
        System.out.println(type);
        return "rank_list";
    }
}
