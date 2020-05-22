package com.example.demo.domain.accor.hotel_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
public class Description {

    @XStreamAlias("Text")
    private String text;

}
