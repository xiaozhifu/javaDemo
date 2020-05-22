package com.example.demo.domain.accor.hotel_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

@Data
public class HotelName {

    @XStreamAsAttribute
    @XStreamAlias("HotelShortName")
    private String hotelShortName;

}
