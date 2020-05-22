package com.example.demo.domain.accor.contact_info;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
public class Address {

    @XStreamAlias("AddressLine")
    private String addressLine;

    @XStreamAlias("CityName")
    private String cityName;

    @XStreamAlias("PostalCode")
    private String postalCode;

    @XStreamAlias("CountryName")
    private CountryName countryName;

}
