import java.util.*;

/**
 * There are given N ropes of different lengths, we need to connect these ropes into one rope.
 * The cost to connect two ropes is equal to sum of their lengths.
 * The task is to connect the ropes with minimum cost. Given N size array arr[] contains the lengths of the ropes.
 *
 * https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
 */
public class ConnectNRopes {
    private static long minCost(long arr[], int n)
    {
        if(arr.length==1) return arr[0];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long minCost = Long.MAX_VALUE;
        for(long val : arr){
            pq.add(val);
        }
        long cost = 0;
        while(pq.size()>=2){
            long p = pq.remove();
            long q = pq.remove();
            long sum = p+q;
            pq.add(sum);
            cost+=sum;
        }
        return cost;
    }

    public static void main(String[] args){
        int n = 5;
        long[] arr = {4, 2, 7, 6, 9};

        System.out.println(minCost(arr,4));
    }
}
