package org.pcdd.javadatastructure.queue;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pcdd
 */
@Slf4j
public class ArrayQueue1Test {
    public static void main(String[] args) {
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(3);
        queue.offer(3366);
        log.info("{}", queue.peek());
        queue.poll();
        log.info("{}", queue.peek());
        queue.offer(4399);
        log.info("{}", queue.peek());
        log.info("{}", queue.size());
    }
}
