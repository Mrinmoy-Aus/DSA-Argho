import java.util.*;

/**
 * Alice has some number of cards and she wants to rearrange the cards into groups
 * so that each group is of size groupSize, and consists of groupSize consecutive cards.
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
 * return true if she can rearrange the cards, or false otherwise.
 * <p>
 * https://leetcode.com/problems/hand-of-straights/description/
 */
public class HandsOfStraight {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : hand) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            pq.add(val);
        }

        while (!pq.isEmpty()) {
            int t = groupSize;
            int leastVal = pq.peek();
            while (t-- > 0 && !pq.isEmpty()) {
                if (map.containsKey(leastVal)) {
                    pq.remove(leastVal);
                    map.put(leastVal, map.get(leastVal) - 1);
                    if (map.get(leastVal) == 0) map.remove(leastVal);
                    leastVal++;
                } else {
                    return false;
                }
            }
            if (t > 0) return false;
        }
        return true;
    }
}
