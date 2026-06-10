# Deletion of the Head of Linked List

## Problem

Given the head of a singly linked list, delete the head node and return the new head.

### Example

Input:

```text
head = [1, 2, 3]
```

Output:

```text
[2, 3]
```

---

## Code

```java
class Solution {
    public ListNode deleteHead(ListNode head) {
        // Java has garbage collector
        // In C/C++, store head in temp, move head, then delete temp
        if(head == null){
            return null;
        }
        return head.next;
    }
}
```

---

## Code Explanation

### Empty List Check

```java
if(head == null){
    return null;
}
```

* If the list is empty, nothing can be deleted.
* Return `null`.

Visual:

```text
head
 ↓
null
```

---

### Move Head to Next Node

```java
return head.next;
```

Before:

```text
head
 ↓
[1] → [2] → [3] → null
```

After:

```text
head
 ↓
[2] → [3] → null
```

* Skip the first node.
* The second node becomes the new head.

---

## Time Complexity

```text
O(1)
```

* Only one pointer change.

---

## Space Complexity

```text
O(1)
```

* No extra space used.

---

## Pattern

Linked List - Head Deletion

---

## When To Use This Pattern

* Delete the first node of a linked list.
* Remove the current head and move to the next node.
* Commonly used in queue implementations using linked lists.
