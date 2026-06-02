# Generate Binary Strings Without Consecutive 1s

## Problem Link

TUF+ Problem: Generate Binary Strings Without Consecutive 1s

## Difficulty

Easy

## Topic

Recursion, Backtracking

---

## Problem Statement

Given an integer `n`, return all binary strings of length `n` that do not contain consecutive `1`s.

Return the result in lexicographically increasing order.

A binary string consists only of characters `'0'` and `'1'`.

---

## Examples

### Example 1

**Input**

```text
n = 3
```

**Output**

```text
["000","001","010","100","101"]
```

**Explanation**

All strings are of length `3` and none contain consecutive `1`s.

---

### Example 2

**Input**

```text
n = 2
```

**Output**

```text
["00","01","10"]
```

---

## Intuition

At every position, we have two choices:

1. Place `0`
2. Place `1`

However, we can place `1` only if the previous character is not `1`.

Since we need to generate all valid strings, recursion naturally fits this problem.

The idea is to build the string character by character while ensuring that no two consecutive `1`s appear.

---

## Approach

1. Start with an empty string.
2. At each recursive call:

   * Always append `0`.
   * Append `1` only if:

     * The string is empty, or
     * The last character is not `1`.
3. When the current string length becomes `n`, add it to the answer list.
4. Continue exploring all valid possibilities.

---

## Recursion Tree (n = 3)

```text
                    ""
                 /      \
               0         1
             /   \       |
           00    01     10
          / \     |    /  \
       000 001  010 100 101
```

Generated Strings:

```text
000
001
010
100
101
```

---

## Dry Run

### Input

```text
n = 3
```

### Execution

```text
"" 
├── "0"
│   ├── "00"
│   │   ├── "000" ✔
│   │   └── "001" ✔
│   │
│   └── "01"
│       └── "010" ✔
│
└── "1"
    └── "10"
        ├── "100" ✔
        └── "101" ✔
```

### Output

```text
["000","001","010","100","101"]
```

---

## Java Solution

```java
class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        calc(0, n, "", ans);
        return ans;
    }

    public void calc(int i, int n, String curr, List<String> ans) {
        if (i == n) {
            ans.add(curr);
            return;
        }

        // Always place 0
        calc(i + 1, n, curr + "0", ans);

        // Place 1 only if previous character is not 1
        if (curr.isEmpty() || curr.charAt(curr.length() - 1) != '1') {
            calc(i + 1, n, curr + "1", ans);
        }
    }
}
```

---

## Complexity Analysis

### Time Complexity

Every valid binary string is generated exactly once.

```text
O(2^n)
```

In the worst case, the recursion explores all possible combinations.

---

### Space Complexity

```text
O(n)
```

For the recursion stack.

The output list is not included in auxiliary space complexity.

---

## Pattern Learned

✔ Recursion

✔ Backtracking

✔ Generate All Valid Configurations

✔ Decision Tree Traversal

---

## Similar Problems

1. Generate Parentheses
2. Letter Combinations of a Phone Number
3. Subsets
4. Permutations
5. N-Queens
6. Restore IP Addresses

---

## Key Takeaway

When generating all possible combinations under certain constraints:

* Build the answer incrementally.
* Validate choices before making recursive calls.
* Prune invalid branches early.

This is a classic Backtracking pattern where constraints are checked while constructing the solution instead of after generating all possibilities.
