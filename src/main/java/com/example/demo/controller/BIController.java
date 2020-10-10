package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.demo.domain.bi.BaseResponse;
import com.example.demo.domain.bi.CleanLevelVO;
import com.example.demo.utils.OkHttpUtils;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BIController {

    private static final String SECRET = "";

    public static void main(String[] args) throws Exception {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String host = "";

        String path = "";

        Map<String, String> params = new HashMap<>();
        params.put("ff:date", "2020-08");
        params.put("ff:hotelid", "0670221");
        params.put("time", dateTimeFormatter.format(LocalDateTime.now()));
        params.put("app", "HZH");

        path = getPath(path, params);

        System.out.println(path);

        String res = OkHttpUtils.get(host + path);

        System.out.println(res);

        BaseResponse<CleanLevelVO> baseResponse = JSON.parseObject(res, new TypeReference<BaseResponse<CleanLevelVO>>(){});

        System.out.println(baseResponse.getBody().getCleanLevel());

    }

    /**
     * 获取请求 BI 接口的 path
     * @param path
     * @param params
     * @return
     */
    public static String getPath(String path, Map<String, String> params){
        // 请求参数按照字母顺序排序
        String sortedParams = sortParams(params);
        // 拼接 path
        String pathWithParams = path + "?" + sortedParams;
        // 拼接 Secret (被加密的字符串)
        String signString = pathWithParams + SECRET;
        // MD5 加密 获取签名
        String signValue = DigestUtils.md5DigestAsHex(signString.getBytes());
        // 参数最后拼接 签名
        pathWithParams = pathWithParams + "&sign=" + signValue;
        return pathWithParams;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String sortParams(Map<String, String> params) {
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            String value = params.get(key);
            sb.append(key).append("=").append(value).append("&");
        }
        String result = sb.toString();
        result = result.substring(0, result.length()-1);
        return result;
    }

}
