package com.example.demo.domain.accor.facility_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
public class Description {

    @XStreamAlias("Text")
    private String text;

}
