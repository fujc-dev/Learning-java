package com.zc58s.springioc.visitorpattern;

import com.zc58s.springioc.visitorpattern.vistor.Player;

/**
 * 抽象节点，Element，所有英雄的模板
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/26 16:07
 */
public abstract class ElementHero {

    /**
     * @param visitor
     */
    public abstract void Accept(Player visitor);
}
