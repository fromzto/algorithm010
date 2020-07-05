# 深度优先搜索、广度 优先搜索

	#### 深度优先搜索

##### 示例代码

``` python
def dfs(node):
	if node in visited:
		return # already visited
		
	visited.add(node)
	
	# process current node
	# ... # logic here
	dfs(node.left)
	dfs(node.right)
```

		##### 多叉树dfs代码-递归写法

```python
visited = set()
def dfs(node, visited):
    if node in visited:
        return
    
	visited.add(node)
	#process curent node here
	for next_node in node.children:
		if not next_node in visited:
			dfs(next_node, visited)
```

##### dfs代码-非递归写法

```python
dsf DFS(self, tree):
    if tree.root is None:
        return []
    visited, stack = [], [tree.node]
    while stack:
        node = stack.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
        ### other processin work
        ...
```



#### 深度优先遍历

##### bfs代码

```python
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)
    
    while queue:
        node = queue.pop()
        visited.add(node)
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
        
        # other processing work
```



## 作业

##### 柠檬水找零

```java
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;
        int tenNum = 0;
        int twentyNum = 0;
        for (int i = 0;i < bills.length;i++) {
            if (bills[i] == 5) {
                fiveNum++;
            } else if (bills[i] == 10) {
                if (fiveNum <= 0) {
                    return false;
                }
                fiveNum--;
                tenNum++;
            } else if (bills[i] == 20) {
                if (fiveNum <= 0) {
                    return false;
                }
                if (tenNum == 0 && fiveNum < 3) {
                    return false;
                }
                if (tenNum > 0) {
                    tenNum--;
                    fiveNum--;
                } else {
                    fiveNum -= 3;
                }
            }
        }
        return fiveNum >= 0 && tenNum >= 0 && twentyNum>=0;
    }
}
```

###### 买卖股票的最佳时机 II

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        
        int highIndex = 0, lowIndex = 0;
        int maxProfit = 0;
        for (int i = 1;i < prices.length;i++) {
            if (prices[i] >= prices[i - 1]) {
                highIndex = i;
            } else {
                if (highIndex > lowIndex) {
                    maxProfit += (prices[highIndex] - prices[lowIndex]);
                }
                lowIndex = i;
            }
        }
        return maxProfit + (highIndex == prices.length - 1 ? (prices[highIndex] - prices[lowIndex]) : 0);
    }
}
```

###### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

1. 采用迭代来计算处理该问题
2. 首先取数组的中间元素mid = left + (right - left) / 2
3. 比较前后各一个元素和中间元素，如果中间元素比前一个元素小，则中间元素为无序的地方；如果中间元素比后一个元素大，则后一个元素为无序的地方。
4. 如果中间元素的前后都有序，则从中间元素的前面区间[left, mid - 1]和后面区间[mid + 1, right]分别计算知道找到该无序处，如果没有，返回-1。
5. 代码如下

```java
public class Solution {

	public static int findIndex(int[] arr) {
		if (arr.length <= 1) {
			return -1;
		}
		return findFromArray(arr, 0, arr.length - 1);
	}
	
	public static int findFromArray(int[] arr, int left, int right) {
		if (left >= right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		
		if (arr[mid] < arr[mid -1]) {
			return mid;
		}
		if (arr[mid + 1] < arr[mid]) {
			return mid + 1;
		}
		int rightIndex = findFromArray(arr, mid + 1, right);
		if (rightIndex > 0) {
			return rightIndex;
		}
		int leftIndex = findFromArray(arr, left, mid - 1);
		
		
		return leftIndex;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, 7, 8, 10, 0, 1, 2};
		System.out.println(findIndex(arr));
	}
}

```



 



