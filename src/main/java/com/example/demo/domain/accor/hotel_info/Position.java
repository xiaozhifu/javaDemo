package com.example.demo.domain.accor.hotel_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Position {

    @XStreamAsAttribute
    @XStreamAlias("Latitude")
    private BigDecimal latitude;

    @XStreamAsAttribute
    @XStreamAlias("Longitude")
    private BigDecimal longitude;

}
