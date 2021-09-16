package com.algorithm.array;

import java.io.*;

/**
 * @Author fujc
 * @Date: 2021/9/16 21:13
 * @Version 1.0
 */
public class AgeStatistics {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\age.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        long start = System.currentTimeMillis();
        int data[] = new int[200];
        String str = "";
        int total = 0;
        while ((str = bufferedReader.readLine()) != null) {
            int age = Integer.valueOf(str);
            data[age]++;
            total++;
        }
        //时间复杂度：O(n) 14亿. 我们计算机处理能力很强的，基本上100万+ -  1000万+条数据的处理能力
        //读6G的数据文件，没有用到大数据，分布式等等之类的框架完成了
        System.out.println("总共数据大小：" + total);
        for (int i = 0; i < 200; i++) {
            System.out.println("" + i + "：" + data[i]);
        }
        System.out.println("计算花费的时间为：" + (System.currentTimeMillis() - start) + "ms");
        //计算花费的时间为：73491ms
    }
}
