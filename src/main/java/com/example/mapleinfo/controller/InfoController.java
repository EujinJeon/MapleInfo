package com.example.mapleinfo.controller;

import com.example.mapleinfo.service.InfoService;
import com.example.mapleinfo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
//@RequestMapping("/info")
public class InfoController {

    private final InfoService infoService;
    @GetMapping("/info")
    public String getInfo(Model model, @RequestParam("username") String username){
        if (Objects.equals(username, "")){
            return "redirect:/";
        }
        else {
            String userId = this.infoService.getUserId(username);
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
            User user = this.infoService.getUserInfo(userId, checkDate);
            model.addAttribute("user", user);
            return "user_form";
        }
    }
}