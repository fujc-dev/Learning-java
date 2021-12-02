package com.zc58s.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * @author fjc.dane@gmail.com
 * @createtime : 2021/12/02
 */
public class LongAccumulatorTest {

    public static void main(String[] args) throws InterruptedException {
        // 累加 x+y
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);

        ExecutorService executor = Executors.newFixedThreadPool(8);
        // 1到9累加
        IntStream.range(1, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

        Thread.sleep(2000);
        System.out.println(accumulator.getThenReset());

    }
}
