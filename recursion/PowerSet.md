# Power Set

## Problem

Given an array of unique integers `nums`, return all possible subsets (power set).

### Example

Input:

```text
nums = [1, 2, 3]
```

Output:

```text
[[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
```

---

## Code

```java
class Solution {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        calc(ans , nums , 0 , new ArrayList<>());
        return ans;
    }

    public static void calc(List<List<Integer>> ans , int[] nums , int i , List<Integer> curr){
        if(i == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        calc(ans , nums , i + 1 , curr);

        curr.remove(curr.size() - 1);
        calc(ans , nums , i + 1 , curr);
    }
}
```

---

## Code Explanation

### Base Case

```java
if(i == nums.length){
    ans.add(new ArrayList<>(curr));
    return;
}
```

* Reached the end of the array.
* Store the current subset.

---

### Include Current Element

```java
curr.add(nums[i]);
calc(ans , nums , i + 1 , curr);
```

* Take the current element.
* Move to the next index.

---

### Exclude Current Element

```java
curr.remove(curr.size() - 1);
calc(ans , nums , i + 1 , curr);
```

* Remove the previously added element.
* Explore the path where the element is not included.

---

## Time Complexity

```text
O(2^n)
```

* Every element has 2 choices:

  * Include
  * Exclude

Total subsets = `2^n`.

---

## Space Complexity

```text
O(n)
```

* Maximum recursion depth is `n`.

---

## Pattern

Recursion + Backtracking

### Decision Tree

For every element:

```text
Take it
Don't take it
```

This "Pick / Not Pick" pattern is one of the most important recursion patterns.
