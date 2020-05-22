package com.example.demo.domain.accor.facility_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

@Data
public class GuestRoom {

    @XStreamAsAttribute
    @XStreamAlias("Code")
    private String code;

    @XStreamAsAttribute
    @XStreamAlias("MaxOccupancy")
    private Integer maxOccupancy;

    @XStreamAsAttribute
    @XStreamAlias("MaxAdultOccupancy")
    private Integer maxAdultOccupancy;

    @XStreamAsAttribute
    @XStreamAlias("MaxChildOccupancy")
    private Integer maxChildOccupancy;

    @XStreamAlias("TypeRoom")
    private TypeRoom typeRoom;

    @XStreamAlias("Description")
    private Description description;

}
