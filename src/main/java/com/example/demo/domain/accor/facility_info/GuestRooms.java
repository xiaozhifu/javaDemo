package com.example.demo.domain.accor.facility_info;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

@Data
public class GuestRooms {

    @XStreamImplicit(itemFieldName = "GuestRoom")
    private List<GuestRoom> guestRoomList;

}
