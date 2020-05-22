package com.example.demo.domain.accor.hotel_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

@Data
public class HotelInfo {

    @XStreamAsAttribute
    @XStreamAlias("HotelStatusCode")
    private Integer hotelStatusCode;

    @XStreamAlias("HotelName")
    private HotelName hotelName;

    @XStreamAlias("Descriptions")
    private Descriptions descriptions;

    @XStreamAlias("Position")
    private Position position;

}
