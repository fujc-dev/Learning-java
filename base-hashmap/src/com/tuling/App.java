package com.tuling;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/15 16:06
 */
public class App {


    public static void main(String[] args) {
        Bean a = new Bean("A");
        Bean c = new Bean("C");
        a.next = c;

        //
        a.next = a;

        System.out.println(a.toString());




    }

}
