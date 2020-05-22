package com.example.demo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class PageData {

    private Long id;
    private String username;
    private String password;
    private String phone;
    private LocalDateTime createTime;

}
