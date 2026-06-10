# Length of Loop in Linked List

## Problem

Given the head of a singly linked list, return the length of the loop if a cycle exists, otherwise return `0`.

### Constraints

```text
0 <= number of nodes <= 10^5
0 <= ListNode.val <= 10^4
pos is -1 or a valid index
```

### Example

Input:

```text
1 → 2 → 3 → 4 → 5
    ↑           ↓
    └───────────┘
```

Output:

```text
4
```

---

## Code

```java
class Solution {
    public int findLengthOfLoop(ListNode head) {
        int count = 1;

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                ListNode temp = slow.next;

                while(slow != temp){
                    count++;
                    temp = temp.next;
                }

                return count;
            }
        }

        return 0;
    }
}
```

---

## Code Explanation

### Step 1: Detect Cycle

```java
fast = fast.next.next;
slow = slow.next;
```

Visual:

```text
1 → 2 → 3 → 4 → 5
    ↑           ↓
    └───────────┘

slow -> 1 step
fast -> 2 steps
```

* Use Floyd's Cycle Detection.
* If `slow` and `fast` meet, a loop exists.

---

### Step 2: Meeting Point Found

```java
if(fast == slow)
```

Visual:

```text
1 → 2 → 3 → 4 → 5
        ↑
    slow, fast
```

* Both pointers meet somewhere inside the cycle.

---

### Step 3: Start Counting Loop Length

```java
int count = 1;
ListNode temp = slow.next;
```

Visual:

```text
      slow
        ↓
2 → 3 → 4 → 5
↑           ↓
└───────────┘

temp starts from next node
```

* Keep `slow` fixed.
* Move `temp` around the cycle.

---

### Step 4: Traverse Entire Loop

```java
while(slow != temp){
    count++;
    temp = temp.next;
}
```

Visual:

```text
temp moves

2 → 3 → 4 → 5
↑           ↓
└───────────┘

count = 1 (start)

temp at 4 -> count = 2
temp at 5 -> count = 3
temp at 2 -> count = 4
```

* Continue until `temp` comes back to `slow`.
* Number of steps taken = length of the cycle.

---

### Step 5: Return Length

```java
return count;
```

Visual:

```text
2 → 3 → 4 → 5
↑           ↓
└───────────┘

Length = 4
```

---

## Time Complexity

```text
O(n)
```

* Cycle detection takes O(n).
* Counting the loop takes at most O(n).

---

## Space Complexity

```text
O(1)
```

* Only pointers are used.

---

## Pattern

Floyd's Cycle Detection + Cycle Length

---

## When To Use This Pattern

* Find the length of a cycle in a linked list.
* Detect circular structures.
* Follow-up problem after Linked List Cycle (141).
* Useful when cycle information is needed instead of just detection.

---

## Quick Revision

```text
1. Detect cycle using slow & fast.

2. When they meet:
      count = 1
      temp = slow.next

3. Move temp until it reaches slow again.

4. Count steps.
```

### Core Idea

```text
Detect Cycle
      ↓
Meeting Point
      ↓
Traverse One Full Loop
      ↓
Count Nodes
      ↓
Loop Length
```
