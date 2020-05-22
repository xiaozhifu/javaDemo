package com.example.demo.xml_converter;

import com.example.demo.domain.accor.contact_info.CountryName;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CountryNameConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        //转换条件
        return type.equals(CountryName.class);
    }

    /**
     * 将java对象转为xml时使用
     */
    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        CountryName countryName = (CountryName) source;
        writer.addAttribute("Code", countryName.getCode());
        writer.setValue(countryName.getValue());
    }

    /**
     * 将xml转为java对象使用
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        CountryName countryName = new CountryName();
        countryName.setCode(reader.getAttribute("Code"));
        countryName.setValue(reader.getValue());
        return countryName;
    }

}
