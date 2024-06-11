import java.util.*;

/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Implement KthLargest class:
 * <p>
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream
 * and returns the element representing the kth largest element in the stream.
 * <p>
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */
public class KthLargestElementInAStream {

    PriorityQueue<Integer> pq;
    int cap;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.cap = k;
        if (nums.length == 0) return;
        int i = 0;
        for (; i < nums.length && i < k; i++) {
            pq.add(nums[i]);
        }

        while (i < nums.length) {
            if (pq.size() > 0 && nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
            i++;
        }
    }

    public int add(int val) {
        if (pq.size() > 0 && pq.size() == this.cap && val > pq.peek()) {
            pq.remove();
            pq.add(val);
        } else if (pq.size() < this.cap) {
            pq.add(val);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {0};
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(2, arr);
        System.out.println(kthLargest.add(-1));   // return 4
        System.out.println(kthLargest.add(1));   // return 5
        System.out.println(kthLargest.add(-2));  // return 5
        System.out.println(kthLargest.add(-4));   // return 8
        System.out.println(kthLargest.add(3));   // return 8
    }
}
