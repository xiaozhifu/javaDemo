package com.example.demo.domain.accor.facility_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
public class FacilityInfo {

    @XStreamAlias("GuestRooms")
    private GuestRooms guestRooms;

}
