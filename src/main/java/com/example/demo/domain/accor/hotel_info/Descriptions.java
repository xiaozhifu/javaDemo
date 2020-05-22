package com.example.demo.domain.accor.hotel_info;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

@Data
public class Descriptions {

    @XStreamImplicit(itemFieldName = "Description")
    private List<Description> descriptionList;

}
