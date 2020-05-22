package com.example.demo.domain.accor.contact_info;

import com.example.demo.xml_converter.CountryNameConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;

@Data
@XStreamAlias("CountryName")
@XStreamConverter(CountryNameConverter.class)
public class CountryName {

    private String code;

    private String value;

}
