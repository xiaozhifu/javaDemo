package com.example.demo.xml_converter;

import com.example.demo.domain.accor.contact_info.Email;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class EmailConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        //转换条件
        return type.equals(Email.class);
    }

    /**
     * 将java对象转为xml时使用
     */
    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        Email email = (Email) source;
        writer.addAttribute("EmailType", email.getEmailType());
        writer.setValue(email.getValue());
    }

    /**
     * 将xml转为java对象使用
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Email email = new Email();
        email.setEmailType(reader.getAttribute("EmailType"));
        email.setValue(reader.getValue());
        return email;
    }

}
