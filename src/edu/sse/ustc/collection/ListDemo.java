package edu.sse.ustc.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List的特点：
 * 1. 有序的 2. 允许多个Null元素 3. 具体实现：ArrayList、Vector、LinkedList
 * @author imarklei90
 * @since 2018.11.12
 */
public class ListDemo {

    /**
     * ArrayList:(1.8)
     * 1. 实现原理：采用动态对象数组实现，默认构造方法创建了一个空数组
     * 2. 第一次添加元素，扩充容量为10，之后的扩充算法：原来数组大小+原来数组大小的一半
     * 3. 不适合插入或者删除操作
     * 4. 为了防止数组扩充次数过多，建议创建ArrayList时给定一个初始容量
     * 5. 多线程不安全，适合在单线程的情况下使用，效率较高
     */
    private static void arrayList(){
        List<String> list = new ArrayList<>();
        list.add("元素1");
        list.add("元素2");
        list.add("元素3");

        int size = list.size();
        for(int i = 0; i < size; i++){
            System.out.println(list.get(i));
        }

    }

    /**
     * Vector：；
     * 1. 实现原理：采用动态对象数组实现，默认构造方法创建了一个大小为10的对象数组
     * 2. 扩充算法：当增量为0时，扩充为原来大小的2倍，当增量大于0，扩充为原来大小+增量
     * 3. 不适合删除和插入操作
     * 4. 为了防止数组扩充次数过多，建议创建Vector时给定一个初始容量
     * 5. 线程安全，适合在多线程的情况下使用，但是在单线程效率较低
     *
     */
    private static void vector(){
        Vector<String> vector = new Vector<>();
        vector.add("元素1");
        vector.add("元素2");
        vector.add("元素3");

        int size = vector.size();
        for (int i = 0; i < size; i++) {
            System.out.println(vector.get(i));
        }
    }

    /**
     * LinkedList:
     * 1. 实现原理：采用双向链表结构实现
     * 2. 适合插入删除操作，效率高
     */
    private static void linkedList(){
        List<String> linkedLists = new LinkedList<>();
        linkedLists.add("元素1");
        linkedLists.add("元素2");
        linkedLists.add("元素3");

        int size = linkedLists.size();
        for (int i = 0; i < size; i++) {
            System.out.println(linkedLists.get(i));
        }
    }

    public static void main(String[] args) {
        // arrayList();
        // vector();
        linkedList();
    }
}
