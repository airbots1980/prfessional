package edu.unl.hcc.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * 1. insert(val) : Inserts an item val to the set if not already present.
 * 2. remove(val) : Removes an item val from the set if present.
 * 3. getRandom : Returns a random element from current set of elements. Each element
 * must have the same probability of being returned.
 */
public class UniformInsertRandomRemove {

    static HashMap<Integer, Integer> storage = new HashMap();
    static int length=0;
    static ArrayList<Integer> list = new ArrayList();

    public static void insert(int val) {
        if(storage.containsKey(val)) return;
        storage.put(val, length++);
        list.add(val);
    }

    public static void remove(int val) {
        if(storage.size()==0||length==0) return;
        if(storage.containsKey(val)) {
            if(length>=1) {
                list.set(storage.get(val), list.get(length-1));
            }
            list.remove(--length);
            storage.remove(val);
        }
    }

    public static int getRandom() {
        Random ran = new Random();
        int idx = ran.nextInt(length);
        return list.get(idx);
    }


    public static void main(String[] args) {

        insert(0);
        insert(0);
        remove(0);
        insert(1);
        insert(2);
        insert(3);
        System.out.println(getRandom());
        System.out.println(getRandom());
        System.out.println(getRandom());
        System.out.println(getRandom());
        System.out.println(getRandom());
        System.out.println(getRandom());
    }
}
