package org.pcdd.javadatastructure.queue;

import java.util.Iterator;

/**
 * ArrayQueue2 改进版
 * 进一步优化性能：
 * 若除数满足2^n，那么被除数的后n位即为余数
 * 0110_1111 111 被除数
 * 0001_0000 16  除数
 * 0000_1111 15  余数
 * 0000_0110 6   商
 * 求被除数后n位（余数）技巧：被除数与 2^n-1 按位与
 *
 * @author pcdd
 */
public class ArrayQueue3<E> implements Queue<E> {

    private final E[] array;
    private int head;
    private int tail;

    /**
     * capacity 必须满足 2^n
     */
    public ArrayQueue3(int capacity) {

        if ((capacity & capacity - 1) != 0) {
            // 策略一：不满足抛异常
            // throw new IllegalArgumentException("容量必须满足2^n");

            // 策略二：改为离capacity最近且比capacity大的 2^n
            // 计算方法一：n = log2(N) = log10(N) / log10(2)
            // int n = (int) (Math.log10(capacity - 1) / Math.log10(2)) + 1;
            // 2^n
            // capacity = 1 << n;
            // 计算方法二（性能最好）
            capacity--;
            capacity |= capacity >> 1;
            capacity |= capacity >> 2;
            capacity |= capacity >> 4;
            capacity |= capacity >> 8;
            capacity |= capacity >> 16;
            capacity++;
        }
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        // array[(int) (Integer.toUnsignedLong(tail) % array.length)] = value;
        array[tail & array.length - 1] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        // E value = array[(int) (Integer.toUnsignedLong(head) % array.length)];
        E value = array[head & array.length - 1];
        head++;
        return value;
    }

    @Override
    public E peek() {
        // return isEmpty() ? null : array[(int) (Integer.toUnsignedLong(head) % array.length)];
        return isEmpty() ? null : array[head & array.length - 1];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                // E value = array[(int) (Integer.toUnsignedLong(p) % array.length)];
                E value = array[p & array.length - 1];
                p++;
                return value;
            }
        };
    }

}
