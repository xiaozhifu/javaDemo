package com.example.demo.domain.accor.contact_info;

import com.example.demo.xml_converter.EmailConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;

@Data
@XStreamAlias("Email")
@XStreamConverter(EmailConverter.class)
public class Email {

    private String emailType;

    private String value;

}
