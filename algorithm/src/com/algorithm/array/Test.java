package com.algorithm.array;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * @Author fujc
 * @Date: 2021/9/16 21:32
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) throws Exception {
        final String fileName = "D:\\age.txt";
        final Random random = new Random();
        BufferedWriter objWriter = null;
        objWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        for (int i = 0; i < 1400000000; i++) {
            int age = Math.abs(random.nextInt()) % 180;
            objWriter.write(age + "\r\n");
        }
        objWriter.flush();
        objWriter.close();

    }
}
