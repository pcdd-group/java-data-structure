package org.pcdd.javadatastructure.queue;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pcdd
 */
@Slf4j
public class ArrayQueue2Test {
    public static void main(String[] args) {
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.poll();
        for (Integer integer : queue) {
            log.info("{}", integer);
        }
    }
}
