package com.zc58s.springioc.visitorpattern;

import com.zc58s.springioc.visitorpattern.vistor.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/26 17:22
 */
public class ObjectStructure {

    //保存所有需要被访问的元素
    private List<ElementHero> heros = new ArrayList<ElementHero>();
    public void handleRequest(Player visitor) {
        //访问所有元素
        for(ElementHero hero : heros) {
            hero.Accept(visitor);
        }
    }
    public void addHero(ElementHero hero) {
        heros.add(hero);
    }
}
