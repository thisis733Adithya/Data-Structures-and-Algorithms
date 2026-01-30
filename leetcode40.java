import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40 {
    public static void main(String[] args) {
        
    }
/*40. Combination Sum II
Solved
Medium
Topics
premium lock icon
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30 */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combination(candidates , target, result, new ArrayList<>() , 0);
        return result;
    }
   private static void combination(int[] nums, int target ,List<List<Integer>> result, List<Integer> list, int startIndex)
    {
        if(target < 0)
        {
            return;
        }
        if(target == 0)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=startIndex; i<nums.length; i++)
        {
            if(i > startIndex && nums[i] == nums[i-1]) continue;

            list.add(nums[i]);
            combination(nums, target-nums[i], result, list, i + 1);
            list.remove(list.size()-1);
        }
    }

    
}
