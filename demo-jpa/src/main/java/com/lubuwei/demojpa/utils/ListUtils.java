package com.lubuwei.demojpa.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/6.
 */
public class ListUtils {

    public static<F,T> List<T> entityListToModelList(List<F> fromList, Class<T> tClass){
        if(fromList.isEmpty() || fromList == null){
            return null;
        }
        List<T> list = new ArrayList<>();
        for(F f : fromList){
            T t = entityToModel(f, tClass);
            list.add(t);
        }
        return list;
    }

    public static<F,T> T entityToModel(F entity, Class<T> modelClass) {
        Object model = null;
        if (entity == null || modelClass ==null) {
            return null;
        }

        try {
            model = modelClass.newInstance();
        } catch (InstantiationException e) {
            //
        } catch (IllegalAccessException e) {
            //
        }
        BeanUtils.copyProperties(entity, model);
        return (T)model;
    }

}
