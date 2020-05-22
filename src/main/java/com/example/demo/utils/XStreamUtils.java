package com.example.demo.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.springframework.util.StringUtils;

public class XStreamUtils {

    public static <T> T xmlToBean(String xml, Class<T> classType){
        if(StringUtils.isEmpty(xml)){
            return null;
        }
        // xml 转 bean
        XStream xstream = new XStream() {
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        if (definedIn == Object.class) {
                            return false;
                        }
                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(new Class[]{classType});
        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(classType);
        return (T) xstream.fromXML(xml);
    }

}
