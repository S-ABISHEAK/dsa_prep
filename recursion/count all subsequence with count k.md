# Count All Subsequences With Sum K

## Problem

Given an array `nums` and an integer `k`, return the number of non-empty subsequences whose sum is equal to `k`.

### Example

Input:

```text
nums = [4, 9, 2, 5, 1]
k = 10
```

Output:

```text
2
```

---

## Code

```java
class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return calc(nums , k , 0 , 0);
    }

    public static int calc(int[] nums , int k , int sum , int i){
        if(i == nums.length){
            return sum == k ? 1 : 0;
        }

        int take = calc(nums , k , sum + nums[i] , i+1);
        int not_take = calc(nums , k , sum , i+1);

        return take + not_take;
    }
}
```

---

## Code Explanation

### Base Case

```java
if(i == nums.length){
    return sum == k ? 1 : 0;
}
```

* Reached the end of the array.
* If current sum equals `k`, count this subsequence.
* Otherwise return `0`.

---

### Take Current Element

```java
int take = calc(nums , k , sum + nums[i] , i+1);
```

* Include the current element.
* Add it to the running sum.

---

### Don't Take Current Element

```java
int not_take = calc(nums , k , sum , i+1);
```

* Skip the current element.
* Sum remains unchanged.

---

### Return Total Count

```java
return take + not_take;
```

* Total valid subsequences =

  * Count from taking the element
  * * Count from not taking the element

---

## Time Complexity

```text
O(2^n)
```

* Every element has 2 choices:

  * Take
  * Not Take

---

## Space Complexity

```text
O(n)
```

* Recursion stack depth.

---

## Pattern

Recursion + Backtracking

### Decision Tree

For every element:

```text
Take it
Don't take it
```

---

## When To Use This Pattern

* When you need to generate, count, or check all possible subsequences.
* Problems involving subset sum, target sum, partitioning, or combination counting.
* Whenever each element has exactly two choices: **Pick / Not Pick**.
