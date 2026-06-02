# Generate Binary Strings Without Consecutive 1s

## Problem

Given an integer `n`, generate all binary strings of length `n` that do not contain consecutive `1`s.

### Example

Input:

```text
n = 3
```

Output:

```text
["000","001","010","100","101"]
```

---

## Code

```java
class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        calc(0 , n , "" , ans);
        return ans;
    }

    public void calc(int i , int n , String curr , List<String> ans){
        if(i == n){
            ans.add(curr);
            return;
        }

        calc(i+1 , n , curr + "0" , ans);

        if(curr.isEmpty() || curr.charAt(curr.length() - 1) != '1'){
            calc(i+1 , n , curr + "1" , ans);
        }
    }
}
```

---

## Code Explanation

### Base Case

```java
if(i == n){
    ans.add(curr);
    return;
}
```

* Generated a string of length `n`.
* Add it to answer.

---

### Always Add '0'

```java
calc(i+1 , n , curr + "0" , ans);
```

* `0` can always be placed.
* Move to next position.

---

### Add '1' Only When Valid

```java
if(curr.isEmpty() || curr.charAt(curr.length() - 1) != '1'){
    calc(i+1 , n , curr + "1" , ans);
}
```

* Add `1` only if previous character is not `1`.
* Prevents consecutive `11`.

---

## Time Complexity

```text
O(2^n)
```

* Exploring all valid binary combinations.

---

## Space Complexity

```text
O(n)
```

* Recursion stack depth is `n`.

---

## Pattern

Recursion + Backtracking
