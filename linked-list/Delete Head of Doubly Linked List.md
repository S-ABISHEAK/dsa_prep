# Delete Head of Doubly Linked List

## Problem

Given the head of a doubly linked list, delete the head node and return the new head.

### Constraints

```text
1 <= n <= 100
0 <= ListNode.data <= 100
```

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
        if(head == null){
            return null;
        }

        if(head.next == null){
            return null;
        }

        head = head.next;
        head.prev = null;

        return head;
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

Visual:

```text
head
 ↓
null
```

* Nothing to delete.

---

### Single Node Check

```java
if(head.next == null){
    return null;
}
```

Before:

```text
null ← [7] → null
        ↑
      head
```

After:

```text
head → null
```

* Deleting the only node leaves an empty list.

---

### Move Head Forward

```java
head = head.next;
```

Before:

```text
null ← [1] ⇄ [2] ⇄ [3] → null
        ↑
      head
```

After:

```text
null ← [1] ⇄ [2] ⇄ [3] → null
              ↑
            head
```

* Head now points to the second node.

---

### Remove Previous Link

```java
head.prev = null;
```

Before:

```text
[1] ⇄ [2] ⇄ [3]
       ↑
     head
```

After:

```text
null ← [2] ⇄ [3] → null
         ↑
       head
```

* New head should not have any previous node.
* Disconnect the old head completely.

---

### Return New Head

```java
return head;
```

Final List:

```text
null ← [2] ⇄ [3] → null
         ↑
       head
```

---

## Time Complexity

```text
O(1)
```

* Only pointer updates.

---

## Space Complexity

```text
O(1)
```

* No extra space used.

---

## Pattern

Doubly Linked List - Head Deletion

---

## When To Use This Pattern

* Delete the first node of a doubly linked list.
* Move the head to the next node.
* Whenever deleting a DLL node, remember to update both forward and backward links.
