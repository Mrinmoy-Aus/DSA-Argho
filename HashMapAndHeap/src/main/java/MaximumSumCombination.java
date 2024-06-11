import java.util.*;

public class MaximumSumCombination {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int[] ans = new int[C];
        PriorityQueue<Integer> pqA = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqB = new PriorityQueue<>((a, b) -> b - a);
        pqA.addAll(A);
        PriorityQueue<Integer> tempA;
        PriorityQueue<Integer> tempB;
        for (int i = 0; i < 2; i++) {
            tempA = i == 0 ? pqA : pqB;
            tempB = i == 0 ? pqB : pqA;
            int a = tempA.remove();
            int size = tempB.size();
            for (int j = 0; j < C; j++) {
                if (size-- > 0) {
                    int b = tempB.remove();
                    int sum = a + b;
                    if (sum > ans[j]) {
                        ans[j] = sum;
                    }
                    tempB.add(b);
                }
            }
            tempA.add(a);
        }

        ArrayList<Integer> returnList = new ArrayList<>();
        for (int val : ans) {
            returnList.add(val);
        }
        return returnList;
    }
}
