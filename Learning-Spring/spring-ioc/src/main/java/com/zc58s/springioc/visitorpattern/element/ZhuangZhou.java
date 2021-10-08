package com.zc58s.springioc.visitorpattern.element;

import com.zc58s.springioc.visitorpattern.ElementHero;
import com.zc58s.springioc.visitorpattern.vistor.Player;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/26 16:09
 */
public class ZhuangZhou extends ElementHero {



    /**
     * @param visitor
     */
    @Override
    public void Accept(Player visitor) {
        visitor.Visit(this);
    }


    public void operate() {
        System.out.println("庄周放出了技能");
    }
}
