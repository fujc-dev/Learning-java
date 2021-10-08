package com.zc58s.springioc.templatedesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/11 9:47
 */
public abstract class NetMall {

    private String uId;
    private String wPwd;

    public NetMall(String uId, String wPwd) {
        this.uId = uId;
        this.wPwd = wPwd;
    }

    /**
     * 生成商品推广海报
     *
     * @param skuUrl 商品地址
     * @return 海报图片base64信息
     */
    public String generateGoodsPoster(String skuUrl) {
        //1、验证登录
        if (!login(this.uId, this.wPwd)) return null;
        //2、爬取商品
        Map<String, String> reptile = reptile(skuUrl);
        //生成海报
        return createBase64(reptile);
    }


    /**
     * 第一步：登录
     *
     * @param uId
     * @param uPwd
     * @return
     */
    protected abstract Boolean login(String uId, String uPwd);

    /**
     * 第二步：爬取信息
     *
     * @param skuUrl
     * @return
     */
    protected abstract Map<String, String> reptile(String skuUrl);

    /**
     * 第三步：生成海报
     *
     * @param goodsInfo
     * @return
     */
    protected abstract String createBase64(Map<String, String> goodsInfo);
}
