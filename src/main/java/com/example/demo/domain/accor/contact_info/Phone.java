package com.example.demo.domain.accor.contact_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Phone {

    @XStreamAsAttribute
    @XStreamAlias("PhoneTechType")
    private String phoneTechType;

    @XStreamAsAttribute
    @XStreamAlias("PhoneNumber")
    private String phoneNumber;

}
