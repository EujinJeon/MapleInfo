package com.example.mapleinfo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

public class Rank {
    private List<RankLoad> ranking = new ArrayList<>();

    @Getter
    @Setter
    public static class RankLoad {
        private Date date;
        private Long ranking;
        private String character_name;
        private String world_name;
        private String class_name;
        private String sub_class_name;
        private Long character_level;
        private Long character_exp;
        private Long character_popularity;
        private String character_guildname;
    }
}
