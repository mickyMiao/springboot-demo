package com.msn.springbootdemo.domain;

import lombok.Data;

@Data
public class Permission {
    private Integer id;
    private String permission;
    private Integer role_id;
}
