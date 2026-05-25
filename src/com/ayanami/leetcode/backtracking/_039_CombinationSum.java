package com.ayanami.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, target, candidates, ans, path);
        return ans;
    }

    private void dfs(int i, int target, int[] candidates, List<List<Integer>> ans, List<Integer> path) {
        if (target == 0) {
            // 找到一个合法组合
            ans.add(new ArrayList<>(path));
            return;
        }

        if (i == candidates.length || target<candidates[i]) {
            return;
        }

        // 不选
        dfs(i + 1, target, candidates, ans, path);

        // 选
        path.add(candidates[i]);
        dfs(i, target - candidates[i], candidates, ans, path);
        path.remove(path.size() - 1); // 恢复现场
    }
}
