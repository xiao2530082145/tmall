package com.mcdh.tmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PropertyValue {
    private int id;
    private Product product;//pid
    private Property property;//ptid
    private String value;
}
