package com.zc58s.springioc.visitorpattern.vistor;

import com.zc58s.springioc.visitorpattern.element.*;

/**
 *
 *
 * 访问者，玩家抽象
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/26 16:32
 */
public interface Player {

    void Visit(HanXin hanXin);

    void Visit(ZhuangZhou zhuangZhou);
}
