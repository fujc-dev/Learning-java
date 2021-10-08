package com.zc58s.springioc.visitorpattern.vistor.impl;

import com.zc58s.springioc.visitorpattern.element.ZhuangZhou;
import com.zc58s.springioc.visitorpattern.element.HanXin;
import com.zc58s.springioc.visitorpattern.vistor.Player;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/26 16:53
 */
public class XiaoBaiPlayer implements Player {
    @Override
    public void Visit(HanXin hanXin) {
        System.out.println("玩家我访问韩信，庄周开始使出技能");
        hanXin.operate();
    }

    @Override
    public void Visit(ZhuangZhou useZhuangZhou) {
        System.out.println("玩家我访问庄周，甄姬开始使出技能");
        useZhuangZhou.operate();
    }
}
