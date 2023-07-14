package com.noname.heysoAdmin.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LiveShoppingItem {
    private int idx;
    private String title;
    private String description;
    private String pageUrl;
    private String imageUrl;
    private boolean useYN;
    private String createId;
    private LocalDateTime createDate;
    private String updateId;
    private LocalDateTime updateDate;
}