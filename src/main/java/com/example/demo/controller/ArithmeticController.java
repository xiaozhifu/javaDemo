package com.example.demo.controller;

import java.util.*;

public class ArithmeticController {

    public static void main(String[] args) {
        jiaoJi();
        bingJi();
    }

    /**
     * 拉链法求交集
     */
    public static void jiaoJi(){
        int[] arr1 = {1,3,5,8};
        int[] arr2 = {3,6,8,9,11};

        int i = 0;
        int j = 0;

        List<Integer> res = new ArrayList<>();

        while (i != arr1.length && j != arr2.length) {
            if (arr1[i] == arr2[j]) {
                res.add(arr1[i]);
                i++;
                j++;
            } else if(arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println("交集：" + res);
    }

    /**
     * 拉链法求并集
     */
    public static void bingJi(){
        int[] arr1 = {1,3,3,5,8};
        int[] arr2 = {3,6,8,8,9,11};

        int i = 0;
        int j = 0;

        Set<Integer> res = new TreeSet<>();

        while ( i < arr1.length) {
            int element;
            if (arr1[i] < arr2[j]) {
                element = arr1[i];
                i++;
            } else if (arr1[i] == arr2[j]) {
                element = arr1[i];
                i++;
                j++;
            } else {
                element = arr2[j];
                j++;
            }
            res.add(element);
        }

        for(int m=j; m<arr2.length; m++){
            res.add(arr2[m]);
        }

        System.out.println("并集：" + res);
    }

}
