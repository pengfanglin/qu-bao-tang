package com.fanglin.core.others;


import com.fanglin.utils.LogUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 自定义序列化处理器
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/2 17:54
 **/
@Slf4j
public class AjaxSerializerModifier extends BeanSerializerModifier {
    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        //循环所有的beanPropertyWriter
        for (BeanPropertyWriter writer : beanProperties) {
            //字段类型
            Class<?> clazz = writer.getMember().getRawType();
            if (clazz.getPackage() == null || "Object".equals(clazz.getSimpleName())) {
                this.writeNullObject(writer);
                continue;
            }
            if (clazz.isArray() || clazz.equals(List.class) || clazz.equals(Set.class)) {
                this.writeNullObject(writer);
            } else if (Objects.equals("java.lang", clazz.getPackage().getName()) || clazz.equals(Date.class)) {
                this.writeNullString(writer);
            } else if (clazz.isEnum()) {
                this.writeNullString(writer);
            } else {
                this.writeNullObject(writer);
            }
        }
        return beanProperties;
    }

    /**
     * 对象类型，序列化为{}
     *
     * @param writer
     */
    private void writeNullObject(BeanPropertyWriter writer) {
        writer.assignNullSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
                if (value == null) {
                    jsonGenerator.writeStartObject();
                    jsonGenerator.writeEndObject();
                } else {
                    jsonGenerator.writeObject(value);
                }
            }
        });
    }

    /**
     * 枚举、基本数据类型、基本数据类型包装类型序列化为空字符串
     *
     * @param writer
     */
    private void writeNullString(BeanPropertyWriter writer) {
        writer.assignNullSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
                if (value == null) {
                    jsonGenerator.writeString("");
                } else {
                    jsonGenerator.writeObject(value);
                }
            }
        });
    }

    /**
     * array，list，set则序列化为[]
     *
     * @param writer
     */
    private void writeNullArray(BeanPropertyWriter writer) {
        writer.assignNullSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
                if (value == null) {
                    jsonGenerator.writeStartArray();
                    jsonGenerator.writeEndArray();
                } else {
                    jsonGenerator.writeObject(value);
                }
            }
        });
    }
}