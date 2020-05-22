package com.example.demo.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class HotelInfo {
    private Long id;

    private String hotelNo;

    private String hotelName;

    private String hotelNameEn;

    private String brandNo;

    private String brand;

    private Integer hotelLevel;

    private String source;

    private String pmsType;

    private String nation;

    private String telephone;

    private String fax;

    private String zip;

    private String email;

    private String describe;

    private String nationNo;

    private String provinceNo;

    private String cityNo;

    private String areaNo;

    private String address;

    private String hotelAddressShort;

    private Integer roomCount;

    private Integer hotelType;

    private Integer hotelStyle;

    private Boolean isOpening;

    private String business;

    private BigDecimal commentScore;

    private Integer commentCount;

    private String photo;

    private BigDecimal lng;

    private BigDecimal lat;

    private Boolean isSupportValueCardPay;

    private Boolean isSupport360View;

    private Boolean isOpenResv;

    private Boolean isOpenOnlineCheckIn;

    private Boolean isEnableRestaurant;

    private Boolean isSupportMixPointPay;

    private Boolean isOnlyChinese;

    private Integer recommendVal;

    private Date overhaulTime;

    private Integer scaleOfTaxpayer;

    private Integer isOpenOnlinePreAuth;

    private BigDecimal preAuthChargeRatio;

    private BigDecimal preAuthChargeAmount;

    private Integer hotelStatus;

    private Boolean isShowWeb;

    private Integer priceDecimalDigits;

    private Integer cleanLevel;

    private Boolean isDelete;

    private Date createTime;

    private String createUser;

    private Date modifyTime;

    private String modifyUser;

    private Date timestamp;

}