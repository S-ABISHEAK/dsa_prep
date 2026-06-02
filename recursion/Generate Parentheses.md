# 22. Generate Parentheses

## Problem

Given `n` pairs of parentheses, generate all combinations of well-formed parentheses.

### Example

Input:

```text
n = 3
```

Output:

```text
["((()))","(()())","(())()","()(())","()()()"]
```

---

## Code

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        calc(ans , "" , 0 , 0 , n);
        return ans;
    }

    public static void calc(List<String> ans , String curr , int open , int close , int n){
        if(curr.length() == (2*n)){
            ans.add(curr);
            return;
        }

        if(open < n){
            calc(ans , curr + "(" , open + 1 , close , n);
        }

        if(close < open){
            calc(ans , curr + ")" , open , close + 1 , n);
        }
    }
}
```

---

## Code Explanation

### Base Case

```java
if(curr.length() == (2*n)){
    ans.add(curr);
    return;
}
```

* A valid string contains `n` opening and `n` closing brackets.
* Total length becomes `2 * n`.
* Add it to the answer.

---

### Add Opening Bracket

```java
if(open < n){
    calc(ans , curr + "(" , open + 1 , close , n);
}
```

* Add `(` if we still have opening brackets left.
* Increase `open` count.

---

### Add Closing Bracket

```java
if(close < open){
    calc(ans , curr + ")" , open , close + 1 , n);
}
```

* Add `)` only when there is an unmatched `(`.
* Ensures the parentheses remain valid.

---

## Time Complexity

```text
O(4^n / √n)
```

* Generates all valid parenthesis combinations.

---

## Space Complexity

```text
O(n)
```

* Recursion stack depth.

---

## Pattern

Recursion + Backtracking
