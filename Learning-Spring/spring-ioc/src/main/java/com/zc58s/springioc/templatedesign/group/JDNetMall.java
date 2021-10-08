package com.zc58s.springioc.templatedesign.group;

import com.alibaba.fastjson.JSON;
import com.zc58s.springioc.templatedesign.HttpClient;
import com.zc58s.springioc.templatedesign.NetMall;
import sun.misc.BASE64Encoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/11 10:15
 */
public class JDNetMall extends NetMall {


    public JDNetMall(String uId, String wPwd) {
        super(uId, wPwd);
    }

    @Override
    protected Boolean login(String uId, String uPwd) {
        System.out.println("模拟京东用户登录 uId：" + uId + "uPwd：" + uPwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "5999.00");
        System.out.println("京东商品爬虫解析：" + map.get("name") + " | " + map.get("price"));
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println("模拟生成京东商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }
}
