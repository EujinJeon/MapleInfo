package com.example.mapleinfo.entity.item;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Item {

    private String item_equipment_part;
    private String item_equipment_slot;
    private String item_name;
    private String item_icon;
    private String item_description;
    private String item_shape_name;
    private String item_shape_icon;
    private String item_gender;
    private ToatalOption toatalOption;
    private BaseOption baseOption;
    private String potential_option_grade;
    private String additional_potential_option_grade;
    private String potential_option_1;
    private String potential_option_2;
    private String potential_option_3;
    private String additional_potential_option_1;
    private String additional_potential_option_2;
    private String additional_potential_option_3;
    private long equipment_level_increase;
    private ExceptionalOption exceptionalOption;
    private AddOption addOption;
    private long growth_exp;
    private long growth_level;
    private String scroll_upgrade;
    private String cuttable_count;
    private String golden_hammer_flag;
    private String scroll_resilience_count;
    private String scroll_upgradable_count;
    private String soul_name;
    private String soul_option;
    private EtcOption etcOption;
    private String starforce;
    private String starforce_scroll_flag;
    private StarforceOption starforceOption;
    private long special_ring_level;
    private Date date_expire;
}
