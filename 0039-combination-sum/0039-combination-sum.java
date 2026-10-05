class Solution {
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            dfs(i, candidates[i], candidates[i], new ArrayList<>(), target, candidates);
        }

        return results;
    }

    public void dfs(int l, int num, int sum, List<Integer> permu, int target, int[] candidates) {
        permu.add(num);
        if (sum > target) return;
        if (sum == target) {
            results.add(permu);
            return;
        }

        for (int i = l; i < candidates.length; i++) {
            dfs(i, candidates[i], sum + candidates[i], new ArrayList<>(permu), target, candidates);
        }

    }
}