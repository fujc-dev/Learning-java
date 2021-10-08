package com.zc58s.springioc.visitorpattern;

import com.zc58s.springioc.visitorpattern.element.HanXin;
import com.zc58s.springioc.visitorpattern.element.ZhuangZhou;
import com.zc58s.springioc.visitorpattern.vistor.Player;
import com.zc58s.springioc.visitorpattern.vistor.impl.MengLeiPlayer;
import com.zc58s.springioc.visitorpattern.vistor.impl.XiaoBaiPlayer;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/26 14:25
 */
public class Programs {
    public static void main(String[] args) {

        //Element是节点
        //Rectangle具体的节点实现，这个节点主要是用于
        ObjectStructure os = new ObjectStructure();
        ElementHero zhuangZhou = new ZhuangZhou();
        ElementHero hanXin = new HanXin();
        os.addHero(zhuangZhou);
        os.addHero(hanXin);
        Player visitorMe = new XiaoBaiPlayer();
        Player visitorOthers = new MengLeiPlayer();
        // 让访问者访问对象结构中的元素
        os.handleRequest(visitorMe);
        os.handleRequest(visitorOthers);
    }

}
