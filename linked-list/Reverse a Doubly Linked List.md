# Reverse a Doubly Linked List

## Problem

Given the head of a doubly linked list, reverse the list and return the head.

### Constraints

```text
1 <= number of nodes <= 10^6
0 <= node.val <= 10^4
```

### Example

Input:

```text
head = [10, 20, 30]
```

Output:

```text
[30, 20, 10]
```

---

## Code

```java
class Solution {
    public ListNode reverseDLL(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode left = head;
        ListNode right = head;

        while(right.next != null){
            right = right.next;
        }

        while(left != right && left.prev != right){
            int temp = left.data;
            left.data = right.data;
            right.data = temp;

            left = left.next;
            right = right.prev;
        }

        return head;
    }
}
```

---

## Code Explanation

### Find the Last Node

```java
ListNode right = head;

while(right.next != null){
    right = right.next;
}
```

Visual:

```text
head
 ↓
[10] ⇄ [20] ⇄ [30] ⇄ [40]
                          ↑
                        right
```

* Move `right` to the last node.
* `left` starts at the head.

---

### Swap Values from Both Ends

```java
int temp = left.data;
left.data = right.data;
right.data = temp;
```

Before:

```text
left               right
 ↓                   ↓
[10] ⇄ [20] ⇄ [30] ⇄ [40]
```

After Swap:

```text
left               right
 ↓                   ↓
[40] ⇄ [20] ⇄ [30] ⇄ [10]
```

* Exchange values at both ends.

---

### Move Towards the Center

```java
left = left.next;
right = right.prev;
```

Visual:

```text
Before

left               right
 ↓                   ↓
[40] ⇄ [20] ⇄ [30] ⇄ [10]

After

        left   right
          ↓      ↓
[40] ⇄ [20] ⇄ [30] ⇄ [10]
```

* `left` moves forward.
* `right` moves backward.

---

### Stop When Pointers Meet

```java
while(left != right && left.prev != right)
```

Visual:

```text
Even Length

[40] ⇄ [30] ⇄ [20] ⇄ [10]
          ↑     ↑
       stop here

Odd Length

[30] ⇄ [20] ⇄ [10]
          ↑
       stop here
```

* Stop when pointers meet or cross each other.

---

## Time Complexity

```text
O(n)
```

* One traversal to find the last node.
* Another traversal to swap values.

---

## Space Complexity

```text
O(1)
```

* No extra data structure used.

---

## Pattern

Two Pointers (DLL)

---

## When To Use This Pattern

* When you need to process elements from both ends.
* Useful in palindrome checks and value swapping problems.
* Works well in Doubly Linked Lists because we can move in both directions.
