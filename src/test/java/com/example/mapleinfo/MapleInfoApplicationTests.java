package com.example.mapleinfo;

import com.example.mapleinfo.entity.Equiment;
import com.example.mapleinfo.entity.Rank;
import com.example.mapleinfo.entity.item.Item;
import com.example.mapleinfo.service.EquiService;
import com.example.mapleinfo.service.InfoService;
import com.example.mapleinfo.entity.User;
import com.example.mapleinfo.service.RankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@SpringBootTest
class MapleInfoApplicationTests {

    private  final static String base_url = "https://open.api.nexon.com";
    @Autowired
    private InfoService infoService;
    @Autowired
    private RankService rankService;
    @Autowired
    private EquiService equiService;
    @Test
    void contextLoads() {
        String ocid = infoService.getUserId("삼한제일검사");
        System.out.println(ocid);
    }

    @Test
    void getInfo(){
        User u  = infoService.getUserInfo("a822608230d2c9c8ad90e407240123fb", "2024-01-09");
        System.out.println(u.getCharacter_name());
    }

    @Test
    void uriTest(){
        URI uri = UriComponentsBuilder.fromUriString(base_url + "/maplestory/v1/basic")
                .queryParam("ocid", "a822608230d2c9c8ad90e407240123fb")
                .queryParam("date", "2024-01-09")
                .build().encode().
                toUri();
        System.out.println(uri.toString());
    }

    @Test
    void equalTest(){
        String ocid = "a822608230d2c9c8ad90e407240123fb";
        System.out.println(ocid.equals("a822608230d2c9c8ad90e407240123fb"));
    }

    @Test
    void date(){
        int hours  = LocalDateTime.now().getHour();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
        if (hours > 1){
            calendar.add(Calendar.DATE, -1);
        }

        else {
            calendar.add(Calendar.DATE, -2);
        }
        String checkDate = SDF.format(calendar.getTime());
        System.out.println(hours);
    }

    @Test
    void loadRank() {
        List<Rank.RankLoad> ranking = rankService.rankList("2024-01-17", 1, 1);
        System.out.println(ranking.get(0).getCharacter_name());
    }

    @Test
    void loadEquiment(){
        String ocid = infoService.getUserId("삼한제일검사");
        Equiment equiment = equiService.getUserEquiment(ocid, "2024-02-15");
        //Item testItem = equiment.getItem_equiment().get(0);
        //System.out.println(testItem);
        System.out.println(equiment.getCharacter_class());
    }
}
