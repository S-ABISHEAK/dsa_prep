# Search in Linked List

## Problem

Given the head of a singly linked list and an integer `key`, return `true` if the key exists in the linked list, otherwise return `false`.

### Constraints

```text
1 <= number of nodes <= 10^5
1 <= Node.val <= 10^5
1 <= key <= 10^5
```

### Example

Input:

```text
head = [1, 2, 3, 4]
key = 3
```

Output:

```text
true
```

---

## Code

```java
class Solution {
    public boolean searchKey(ListNode head, int key) {
        ListNode temp = head;

        while(temp != null){
            if(temp.val == key){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }
}
```

---

## Code Explanation

### Create Traversal Pointer

```java
ListNode temp = head;
```

* `temp` starts from the head.
* Used to traverse the linked list.

Visual:

```text
head,temp
    ↓
[1] → [2] → [3] → [4] → null
```

---

### Traverse the List

```java
while(temp != null)
```

* Visit each node one by one.

Visual:

```text
temp → [1] → [2] → [3] → [4] → null
         ↓
         ↓
         ↓
```

---

### Check for Key

```java
if(temp.val == key){
    return true;
}
```

* Compare current node value with `key`.
* If found, return `true` immediately.

Visual:

```text
key = 3

[1] → [2] → [3] → [4]
              ↑
            Found
```

---

### Move to Next Node

```java
temp = temp.next;
```

* Move to the next node.

Visual:

```text
Before:
temp → [1] → [2] → [3]

After:
[1] → temp → [2] → [3]
```

---

### Key Not Found

```java
return false;
```

* Reached the end of the list.
* Key does not exist.

Visual:

```text
[1] → [2] → [3] → [4] → null
                              ↑
                            temp

Not Found
```

---

## Time Complexity

```text
O(n)
```

* In the worst case, every node is visited once.

---

## Space Complexity

```text
O(1)
```

* Only one extra pointer is used.

---

## Pattern

Linked List Traversal + Linear Search

---

## When To Use This Pattern

* Searching for an element in a linked list.
* Finding the first occurrence of a value.
* Any problem that requires checking every node until a condition is met.
