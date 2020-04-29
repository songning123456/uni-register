package com.uni.register.tool.classconvert.service;


import com.uni.register.tool.DateTools;

/**
 * @author songning
 * @date 2020/1/21
 * description
 */
public class StringToDateImpl implements IClassConvert {

    @Override
    public Object classConvert(Object param) {
        return DateTools.strToDate(param.toString(), "yyyy-MM-dd HH:mm:ss");
    }
}
