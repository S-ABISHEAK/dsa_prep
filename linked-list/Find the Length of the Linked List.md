# Find the Length of the Linked List

## Problem

Given the head of a singly linked list, return the number of nodes present in the linked list.

### Constraints

```text
0 <= number of nodes <= 10^5
0 <= ListNode.val <= 10^4
```

### Example

Input:

```text
head = [1, 2, 3, 4, 5]
```

Output:

```text
5
```

---

## Code

```java
class Solution {
    public int getLength(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }
}
```

---

## Code Explanation

### Initialize Counter and Pointer

```java
int count = 0;
ListNode temp = head;
```

* `count` stores the number of nodes.
* `temp` is used to traverse the list.

Visual:

```text
head,temp
    ↓
[1] → [2] → [3] → [4] → [5] → null
```

---

### Traverse the Linked List

```java
while(temp != null){
    count++;
    temp = temp.next;
}
```

* Visit every node.
* Increase count by 1.
* Move to the next node.

Visual:

```text
Step 1:
temp → [1]
count = 1

Step 2:
temp → [2]
count = 2

Step 3:
temp → [3]
count = 3

...

temp → null
Stop
```

---

### Return Answer

```java
return count;
```

* `count` now contains the total number of nodes.

---

## Time Complexity

```text
O(n)
```

* Visit each node exactly once.

---

## Space Complexity

```text
O(1)
```

* Only one pointer and one counter are used.

---

## Pattern

Linked List Traversal

---

## When To Use This Pattern

* Counting nodes in a linked list.
* Searching for an element.
* Finding sum, maximum, minimum, or any property of all nodes.
* Any problem that requires visiting every node once.
