# Insertion at the Head of Linked List

## Problem

Given the head of a singly linked list and an integer `X`, insert a node with value `X` at the head of the linked list.

### Example

Input:

```text
head = [1, 2, 3]
X = 7
```

Output:

```text
[7, 1, 2, 3]
```

---

## Code

```java
class Solution {
    public ListNode insertAtHead(ListNode head, int X) {
        ListNode newnode = new ListNode(X);
        newnode.next = head;
        return newnode;
    }
}
```

---

## Code Explanation

### Create New Node

```java
ListNode newnode = new ListNode(X);
```

* Create a node with value `X`.

Visual:

```text
newnode

[7 | null]
```

---

### Connect New Node to Current Head

```java
newnode.next = head;
```

Before:

```text
head

[1] → [2] → [3] → null
```

After:

```text
newnode
   ↓
[7] → [1] → [2] → [3] → null
```

* New node points to the old head.

---

### Return New Head

```java
return newnode;
```

* Since `7` is now the first node, return it as the new head.

Final List:

```text
head

[7] → [1] → [2] → [3] → null
```

---

## Time Complexity

```text
O(1)
```

* Only one node is created.

---

## Space Complexity

```text
O(1)
```

* No extra data structure used.

---

## Pattern

Linked List - Head Insertion

---

## When To Use This Pattern

* Insert a node at the beginning of a linked list.
* Build a linked list in reverse order.
* Whenever the new node must become the first node.
