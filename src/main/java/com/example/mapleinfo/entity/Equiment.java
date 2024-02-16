package com.example.mapleinfo.entity;

import com.example.mapleinfo.entity.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Equiment {
    private Date date;
    private String character_gender;
    private String character_class;
    private long preset_no;
    private List<Item> item_equiment;
}
