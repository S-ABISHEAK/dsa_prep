# Check if There Exists a Subsequence With Sum K

## Problem

Given an array `nums` and an integer `k`, return `true` if there exists a subsequence whose sum is equal to `k`, otherwise return `false`.

### Example

Input:

```text
nums = [1, 2, 3, 4, 5]
k = 8
```

Output:

```text
true
```

---

## Code

```java
class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return calc(nums , k , 0 , 0);
    }

    public static boolean calc(int[] nums , int k , int sum , int i){
        if(i == nums.length){
            return sum == k ? true : false;
        }

        boolean take = calc(nums , k , sum + nums[i] , i+1);
        boolean not_take = calc(nums , k , sum , i+1);

        return take || not_take;
    }
}
```

---

## Code Explanation

### Base Case

```java
if(i == nums.length){
    return sum == k ? true : false;
}
```

* Reached the end of the array.
* Return `true` if the sum equals `k`.
* Otherwise return `false`.

---

### Take Current Element

```java
boolean take = calc(nums , k , sum + nums[i] , i+1);
```

* Include the current element.
* Add its value to the sum.

---

### Don't Take Current Element

```java
boolean not_take = calc(nums , k , sum , i+1);
```

* Skip the current element.
* Sum remains unchanged.

---

### Return Answer

```java
return take || not_take;
```

* If any path returns `true`, answer is `true`.
* We only need one valid subsequence.

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

* When you only need to check whether a valid subsequence exists.
* Problems involving subset sum, target sum, and partitioning.
* Whenever each element has two choices: **Pick / Not Pick** and the final answer is **True/False**.
