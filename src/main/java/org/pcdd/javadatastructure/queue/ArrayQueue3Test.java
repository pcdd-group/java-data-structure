package org.pcdd.javadatastructure.queue;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pcdd
 */
@Slf4j
public class ArrayQueue3Test {
    public static void main(String[] args) {
        ArrayQueue3<Integer> queue = new ArrayQueue3<>(10);
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        // 只有继承了Iterable<E>的子类才能使用增强型for循环
        for (Integer integer : queue) {
            log.info("{}", integer);
        }
    }
}
