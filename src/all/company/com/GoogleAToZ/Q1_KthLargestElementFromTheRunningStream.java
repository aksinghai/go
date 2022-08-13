package all.company.com.GoogleAToZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Q1_KthLargestElementFromTheRunningStream {
    static int k;
    static int size;
    static List<Integer> list;

    static PriorityQueue<Integer> priorityQueue;

    public static void main(String[] args) {
        k = 4;
        list = new ArrayList<>();
        init(new ArrayList<>(Arrays.asList(1,2,3,4)));
        for(int i = 5; i <= 10; i++){
            System.out.println(k + " largest "+ add(i));
            System.out.println(list);
        }
    }

    private static void init(List<Integer> nums){
        size = 0;
        priorityQueue = new PriorityQueue<>(k);
        for (Integer integer : nums) {
            add(integer);
        }
    }

    private static int add(int l){
        list.add(l);
        if(size < k){
            priorityQueue.add(l);
            size++;
        } else {
            if(priorityQueue.peek() < l){
                priorityQueue.remove();
                priorityQueue.add(l);
            }
        }
        return priorityQueue.peek();
    }
}