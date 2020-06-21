#### 删除排序数组中的重复项

```java
public int removeDuplicates(int[] nums) { 
  if (nums.length == 0) {
    return 0;
  }
  int i = 0;
  for (int j = 1; j < nums.length; j++) {
    if (nums[j] != nums[i]) {
      i++;
      nums[i] = nums[j];
    }
  }
  return i + 1;
}
```

#### 旋转数组

使用额外的数组来

```java
public void rotate(int[] nums, int k) {
  int[] a = new int[nums.length];
  for (int i = 0; i < nums.length; i++) {
    a[(i + k) % nums.length] = nums[i];
  }
  for (int i = 0; i < nums.length; i++) {
    nums[i] = a[i];
  }
}
```

#### 合并两个有序链表

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode result = null;
    ListNode first = l1;
    ListNode second = l2;
    ListNode nextNode = null;
    while (first != null || second != null) {
        ListNode node = null;
        if (first == null) {
            node = new ListNode(second.val); 
            second = second.next;
        } else if (second == null) {
            node = new ListNode(first.val); 
            first = first.next;
        } else {
            if (first.val >= second.val) {
                node = new ListNode(second.val);
                second = second.next;
            } else {
                node = new ListNode(first.val);
                first = first.next;
            }
        }
        if (result == null) {
            result = node;
        } else {
            nextNode.next = node;
        }
        nextNode = node;   
    }
    return result;
}
```

#### 合并两个有序数组

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, index = m + n - 1;
    while (i >= 0 && j >= 0) {
        if (nums2[j] >= nums1[i]) {
            nums1[index--] = nums2[j--];
        } else {
            nums1[index--] = nums1[i--];
        }
    }
    if (i < 0 && j >= 0) {
        while (j >= 0)
            nums1[index--] = nums2[j--];
    }
}
```



