package com.example.mapleinfo.entity.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseOption {
    private String str;
    private String dex;
    private String Int;
    private String luck;
    private String max_hp;
    private String max_mp;
    private String attack_power;
    private String magic_power;
    private String armor;
    private String speed;
    private String jump;
    private String boss_damage;
    private String ignore_monster_armor;
    private String all_stat;
    private String damage;
    private String max_hp_rate;
    private String max_mp_rate;
    private long base_equipment_level;
}
