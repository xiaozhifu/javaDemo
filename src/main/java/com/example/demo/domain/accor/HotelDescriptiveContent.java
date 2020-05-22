package com.example.demo.domain.accor;

import com.example.demo.domain.accor.contact_info.ContactInfos;
import com.example.demo.domain.accor.facility_info.FacilityInfo;
import com.example.demo.domain.accor.hotel_info.HotelInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@XStreamAlias("HotelDescriptiveContent")
public class HotelDescriptiveContent {

    @XStreamAsAttribute
    @XStreamAlias("HotelCode")
    private String hotelCode;

    @XStreamAsAttribute
    @XStreamAlias("BrandCode")
    private String brandCode;

    @XStreamAsAttribute
    @XStreamAlias("HotelName")
    private String hotelName;

    @XStreamAsAttribute
    @XStreamAlias("BrandName")
    private String brandName;

    @XStreamAsAttribute
    @XStreamAlias("CurrencyCode")
    private String currencyCode;

    @XStreamAsAttribute
    @XStreamAlias("LanguageCode")
    private String languageCode;

    @XStreamAlias("HotelInfo")
    private HotelInfo hotelInfo;

    @XStreamAlias("FacilityInfo")
    private FacilityInfo facilityInfo;

    @XStreamAlias("ContactInfos")
    private ContactInfos contactInfos;

}
