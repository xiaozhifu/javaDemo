package com.example.demo.domain.accor.contact_info;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

@Data
public class ContactInfos {

    @XStreamImplicit(itemFieldName = "ContactInfo")
    private List<ContactInfo> contactInfoList;

}
