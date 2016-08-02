package com.upsoft.semantic.util;

import java.util.UUID;

/**
 * Created by admin on 2016/8/2.
 */
public class IDCreator {
    public static String create(){
         return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
