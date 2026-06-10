# Insert Node Before Head in Doubly Linked List

## Problem

Given the head of a doubly linked list and an integer `X`, insert a node with value `X` before the head and return the new head.

### Constraints

```text
1 <= n <= 100
0 <= ListNode.val <= 100
0 <= X <= 100
```

### Example

Input:

```text
head = [1, 2, 3]
X = 3
```

Output:

```text
[3, 1, 2, 3]
```

---

## Code

```java
class Solution {
    public ListNode insertBeforeHead(ListNode head, int data) {

        ListNode temp = new ListNode(data);

        if(head == null){
            return temp;
        }

        temp.next = head;
        head.prev = temp;

        return temp;
    }
}
```

---

## Code Explanation

### Create New Node

```java
ListNode temp = new ListNode(data);
```

Visual:

```text
temp

null ← [3] → null
```

* Create a new node with value `data`.

---

### Empty List Case

```java
if(head == null){
    return temp;
}
```

Visual:

```text
head → null

After insertion:

null ← [3] → null
```

* If the list is empty, the new node becomes the head.

---

### Connect New Node to Current Head

```java
temp.next = head;
```

Before:

```text
head
 ↓
null ← [1] ⇄ [2] ⇄ [3] → null
```

After:

```text
temp
 ↓
[3] → [1] ⇄ [2] ⇄ [3]
```

* New node points to the old head.

---

### Update Previous Pointer

```java
head.prev = temp;
```

After updating both links:

```text
null ← [3] ⇄ [1] ⇄ [2] ⇄ [3] → null
        ↑
      new head
```

* Old head's `prev` points back to the new node.
* Doubly linked list connection is now complete.

---

### Return New Head

```java
return temp;
```

* New node becomes the first node of the list.

---

## Time Complexity

```text
O(1)
```

* Only pointer updates are performed.

---

## Space Complexity

```text
O(1)
```

* Only one new node is created.

---

## Pattern

Doubly Linked List - Head Insertion

---

## When To Use This Pattern

* Insert a node at the beginning of a doubly linked list.
* When the new node must become the head.
* Remember: in DLL, update both `next` and `prev` pointers.
