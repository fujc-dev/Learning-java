package com.zc58s.springioc.visitorpattern.vistor.impl;

import com.zc58s.springioc.visitorpattern.element.HanXin;
import com.zc58s.springioc.visitorpattern.element.ZhuangZhou;
import com.zc58s.springioc.visitorpattern.vistor.Player;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/26 17:21
 */
public class MengLeiPlayer implements Player {


    @Override
    public void Visit(ZhuangZhou element) {
        System.out.println("玩家其他人访问庄周，庄周开始使出技能");
        element.operate();
    }

    @Override
    public void Visit(HanXin element) {
        System.out.println("玩家其他人访问韩信，甄姬开始使出技能");
        element.operate();
    }
}
