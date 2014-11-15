package com.stylo.fashion.util;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by goman on 15/11/14.
 */
public class GenerelHelper {
    public static boolean isStringNullOrEmpty(String value){
        if (value == null){
            return true;
        }
        else if (value.length() == 0 ||  value.trim().length() == 0){
            return true;
        }
        return false;
    }

    public static boolean isListNullOrEmpty(Collection<?> collection){
        if (collection == null){
            return true;
        }
        return (collection.size() == 0);
    }

    public static boolean isListNullOrEmpty(Objects[] collection){
        if (collection == null){
            return true;
        }
        return (collection.length == 0);
    }
}
