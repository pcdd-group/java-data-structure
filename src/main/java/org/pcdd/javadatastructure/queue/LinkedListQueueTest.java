package org.pcdd.javadatastructure.queue;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pcdd
 */
@Slf4j
public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);
        log.info("linkedListQueue.isEmpty() = {}", queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        log.info("linkedListQueue.isEmpty() = {}", queue.isEmpty());
        print(queue);
        log.info("linkedListQueue.size() = {}", queue.size());
        log.info("linkedListQueue.peek() = {}", queue.peek());
        log.info("linkedListQueue.poll() = {}", queue.poll());
        log.info("linkedListQueue.peek() = {}", queue.peek());
        print(queue);
        log.info("linkedListQueue.size() = {}", queue.size());
    }

    static void print(LinkedListQueue<Integer> linkedListQueue) {
        for (Integer integer : linkedListQueue) {
            log.info("Node value: {}", integer);
        }
    }
}
