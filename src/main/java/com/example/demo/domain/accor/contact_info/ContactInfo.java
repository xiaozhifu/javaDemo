package com.example.demo.domain.accor.contact_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

@Data
public class ContactInfo {

    @XStreamAsAttribute
    @XStreamAlias("ContactProfileType")
    private String contactProfileType;

    @XStreamAlias("Addresses")
    private Addresses addresses;

    @XStreamAlias("Phones")
    private Phones phones;

    @XStreamAlias("Emails")
    private Emails emails;

}
