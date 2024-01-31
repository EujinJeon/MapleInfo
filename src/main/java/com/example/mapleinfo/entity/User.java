package com.example.mapleinfo.entity;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
public class User {

    private Date date; // 조회날짜
    private String character_name; // 캐릭터이름
    private String world_name; //월드
    private String character_gender; //캐릭터 성별
    private String character_class; //직업
    private String character_class_level;
    private Long character_level; //레벨
    private Long character_exp; //경헙치
    private String character_exp_rate; //경험치비율
    private String character_guild_name; //길드이름
    private String character_image; //캐릭터이미지

}
