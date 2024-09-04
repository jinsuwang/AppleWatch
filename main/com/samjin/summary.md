
<h1>Array</h1>

1. PrefixSum
2. Two pointers 
- one array (left = 0; right = length -1)
- two arrays (left_1 = 0, left_2 = 0)
3. one pass with max/min value
4. two pass (forward and backward)

<h1>Backtracking</h1>

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // 结束条件：如果临时列表大小达到 k
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList)); // 复制当前组合到结果中
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);               // 选择当前元素
            backtrack(result, tempList, i + 1, n, k); // 递归调用
            tempList.remove(tempList.size() - 1); // 撤销选择
        }
    }
<h1>Search and Sorting</h1>
    
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length-1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]){
                right = mid - 1;
            }
            if (target > nums[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }
    // 左闭右开
    public static int search2 (int[] nums, int target){
        if (target < nums[0] || target > nums[nums.length-1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    // 左右逼近
    public static int search3(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid;
            }
        }

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

<h1>BFS</h1>

    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            List<Integer> neighbors = graph.get(node);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return result;
    }


<h1>DFS</h1>

    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);

                List<Integer> neighbors = graph.get(node);
                if (neighbors != null) {
                    // 倒序加入栈中，保证顺序遍历
                    for (int i = neighbors.size() - 1; i >= 0; i--) {
                        stack.push(neighbors.get(i));
                    }
                }
            }
        }

        return result;
    }


<h1>Stack and Queue</h1>

<h1>Tree</h1>

1. In/Pre/Post - ordertraversal
2. Level order traversal - BFS with queue
3. Vertical order traversal - 2 queues, index queue + node queue
4. Boundary traversal

<h1>Heap</h1>
- pick 2 items to select top 2.

<h1>LinkedList</h1>
1. Reverse LinkedList Node. 

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode tmp = null;

        while( curr != null ){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }
1.1 swap node in pairs - two temp.
2. fast/slow node to find a mid point.
3. Merge K sorted list - divide and conquer

<h1>HashHap</h1>

<h1>DP</h1>

<h1>Others</h1>

<h1>OOP</h1>

<h1>System Design</h1>







