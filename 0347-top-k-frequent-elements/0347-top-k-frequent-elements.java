class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Num> pq = new PriorityQueue<>((a, b) -> b.preq - a.preq);
        Map<Integer, Integer> hash = new HashMap<>();

        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        for (int key : hash.keySet()) {
            pq.offer(new Num(key, hash.get(key)));
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().num;
        }
        
        return result;
    }
}

public class Num {
    int num;
    int preq;

    public Num(int num, int preq) {
        this.num = num;
        this.preq = preq;
    }
}