package com.example.demo.controller;

import com.example.demo.domain.accor.HotelDescriptiveContent;
import com.example.demo.domain.accor.facility_info.FacilityInfo;
import com.example.demo.domain.accor.facility_info.GuestRoom;
import com.example.demo.domain.accor.facility_info.GuestRooms;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class OptionalController {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        HotelDescriptiveContent hotelDescriptiveContent = new HotelDescriptiveContent();
        List<GuestRoom> guestRoomList = new ArrayList<>();
        GuestRoom guestRoom = new GuestRoom();
        guestRoom.setCode("TEST");
        guestRoomList.add(guestRoom);
        GuestRooms guestRooms = new GuestRooms();
        guestRooms.setGuestRoomList(guestRoomList);
        FacilityInfo facilityInfo = new FacilityInfo();
        facilityInfo.setGuestRooms(guestRooms);
        hotelDescriptiveContent.setFacilityInfo(facilityInfo);
        List<GuestRoom> guestRoomList1 = Optional.of(hotelDescriptiveContent).map(HotelDescriptiveContent::getFacilityInfo).map(FacilityInfo::getGuestRooms).map(GuestRooms::getGuestRoomList).orElse(null);
        if(CollectionUtils.isEmpty(guestRoomList1)){
            log.info("source:{}-hDataHotelNo:{} 酒店房型为空", 1, 2);
        }else{
            log.info("结果：{}", guestRooms);
        }
    }

}
