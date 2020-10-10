package com.example.demo.controller;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class GuavaController {

    private static LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().expireAfterAccess(1,TimeUnit.DAYS).build(new CacheLoader<String, String>() {
        @Override
        public String load(@NotNull String key) {
            if("test".equals(key)){
                return null;
            }
            return key + "_" + UUID.randomUUID();
        }
    });

    public static void main(String[] args) {
        System.out.println(getFromLocalCache("hi"));
        System.out.println("-----------------------");
        System.out.println(getFromLocalCache("hi"));
        System.out.println(getFromLocalCache("hello"));
        System.out.println(getFromLocalCache("test"));
    }

    public static String getFromLocalCache(String facilityId){
        return loadingCache.getUnchecked(facilityId);
    }

}
