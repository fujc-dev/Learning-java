package com.zc58s.springioc.visitorpattern.element;

import com.zc58s.springioc.visitorpattern.ElementHero;
import com.zc58s.springioc.visitorpattern.vistor.Player;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/26 16:09
 */
public class HanXin extends ElementHero {
    /**
     * @param visitor
     */
    @Override
    public void Accept(Player visitor) {
        visitor.Visit(this);
    }

    //自身的技能
    public void operate() {
        System.out.println("韩信放出了技能");
    }
}
