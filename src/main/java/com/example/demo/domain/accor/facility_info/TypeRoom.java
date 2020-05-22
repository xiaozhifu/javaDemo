package com.example.demo.domain.accor.facility_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

@Data
public class TypeRoom {

    @XStreamAsAttribute
    @XStreamAlias("Name")
    private String name;

    @XStreamAsAttribute
    @XStreamAlias("BedTypeCode")
    private String bedTypeCode;

}
