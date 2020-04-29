package com.uni.register.tool.classconvert.service;


import com.uni.register.tool.DateTools;

import java.util.Date;

/**
 * @author: songning
 * @date: 2020/2/15 18:29
 */
public class DateToStringImpl implements IClassConvert {

    @Override
    public Object classConvert(Object param) {
        return DateTools.dateToStr((Date) param, "yyyy-MM-dd HH:mm:ss");
    }
}
