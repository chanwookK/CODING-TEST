class Solution {

    boolean[] visited;
    List<List<Integer>> results = new ArrayList<>();
    int[] numsArr;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        numsArr = nums;

        for (int i = 0; i< nums.length; i++) {
            visited[i] = true;
            dfs(i, nums[i], new ArrayList<>());
            visited[i] = false;
        }
        return results;
    }

    public void dfs(int index, int num, List<Integer> permu) {
        permu.add(num);
        if (permu.size() == numsArr.length) {
            results.add(permu);
            return;
        }

        for (int i = 0; i < numsArr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i, numsArr[i], new ArrayList<>(permu));
            visited[i] = false;
        }
    }
}