# Linked List
Variables:
	primitive: int, double, byte, char
	object reference: Student, String, Integer
List: a collection of items
	add
	remove
	search
Implementation: 
	Array: easy-understanding, quick access to items, memory-wasting
	Linked list: memory-saving, procedural access
		a collection of nodes
		node={data, next}
		linked list variants:
			singly: one-way connection
			doubly: two-way connection
			circular: tail -> head
			tailed: one attribute more "tail"

# Stack & Queue
stack (LIFO): top, 
			  push(), pop(), peek()
	implementation:
		arr
		basic linked list (attr)
		basic linked list (inheritance)

queue (FIFO): front, back,
			  poll(), offer(), peek()
	implementation:
		arr
		tailed linked list (attr)
		tailed linked list (inheritance)


# Recursion
- repeat the process in the same way with the smaller data
- Why?
	easy-understanding
	decompose problems into sub-problems
- function A calls function B
	A: caller function
	B: callee function
	A waits when B is executed
- recipe of recursion:
	base case (stopping condition)
	recursive case
	recursive case must reach the base case
- recursion types
	Tailed Recursion: function calling at the end --> memory optimization
	Backtracking recursion
	Mutual recurison

# Complexity
- Time complexity: number of primitive operations
	+, -, *, /, %, =, <, ...
	problem size: n
	represent as a polinomial of n
	focus on the term with the highest power
	f = O(g): f is an item in a set of functions whose upper bound is g()
	defination of upper bound functions --> lecture slide.
	Big-O family: 1, logn, n,  nlogn, n^2, n^3, 2^n
	Adding rule: code blocks of the same scope --> get max
	Multiplication rule: nested code blocks --> multiply
	Analysis: worst, average, best
	Big-O -> worst case
- Space complexity: memory usage
- Each item has a special attribute called "key" --> compare, find

# Sorting
- input: collection/array
- output: collection/array with items in a specific order

Selection Sort: find the smallest item in the unsorted region, move (swap) it to the head of the unsorted region. O(n^2)

Bubble Sort: compare pairs of consecutive items (overlapped) to swap if there is an inversion. After each pass, the largest item is moved to the end of the unsorted region. Worst case: O(n^2), Best case: O(n)

Insertion Sort: pick the current item, go step by step to the head of the array to find the correct position and insert it there. O(n^2)

Merge Sort: dive the array into two equal halves, sort each half and merge them. O(nlogn)
	The recursive tree has O(logn) levels
	Merging all items in a level costs O(n)
	==> Time complexity: O(nlogn)
	
	The total number of item slots for temporary arrays at each level is O(n). These arrays are destroyed and re-allocated at each level ==> Space complexity: O(n)

Quick sort: select the first item to be the pivot, partition items into S1 (<p, on the left), S2 (>=p, on the right), pivot is in the middle. Invoke recursive step to sort S1 and S2.

Radix Sort: consider items as string, use queues to store items following ones, tens, hundreds, etc. Poll queues in ascending order and the end of each pass to form the udpated array.

In-place Sort: use a constant memory slot. Counter-samples: merge sort, radix sort

Stable Sort: maintain the relative order among items. Counter-samples: selection sort, quick sort

Comparator<T> (interface): define the way to compare two objects of user-define classes.
	a ? b
	> 0: a > b
	= 0: a = b
	< 0: a < b


# Hash Table
Common operations in datasets: insert, delete, find
Direct Addressing Table: keys of items are the same as their indices/positions.
Hash Table: use a hash function to compute the position of item, given its key. h(key) -> position.
Problem of hash function: collision
Hash function:
	fast
	scatter keys evenly
	less collisions
	less space
Load factor alpha = #keys / table_size (how full)
Collision Resolution
	Separate chaining: each item in the hash table is a linked list, items with the same hash value are stored in the same linked list.
	Linear probing: hash(k)->initial position, probe sequence: +1, +2, +3, ..., +k
	Quadratic probing: hash(k)->initial position, probe sequence: +1, +4, +9, ..., +k^2
	Double hashing: h(k) + i*h2(k), i = 1, 2, 3..., h2(k) must not evaluate to 0.
Primary clustering: consecutive occupied slots (linear probing)
Secondary clustering: same probe sequences when initial positions are the same
Criteria of collision resolution
	Minimize clustering
	Always find an empty slot if there exists
	Able to handle secondary clustering
	Fast to compute

# Binary Search Tree
nhiều nodes, node gốc
Node:
	key: so sánh
	data
	left child: key < root.key
	right child: key >= root.key
	0, 1, 2 children
	leave node: 0 children
find: tìm node với key đưa vào
	  O(n): BST giống linked list
insert: thêm vào node lá
	  O(n)
delete: xoá node với key được cho, có 3 trường hợp
	node lá
	node 1 con
	node 2 con (tìm successor hoặc predecessor để thay thế cho node bị xoá)
	O(n)
traverse: duyệt qua từng node để thực hiện thao tác (vd in key ra màn hình)
		  O(n)
*** ý tưởng cốt lõi của các thuật toán đệ qui xử lý cây:
	gọi hàm đệ qui để xử lý cây con, cây con có thể bị biến đổi
	hàm đệ qui trả về node root của cây con (sau xử lý)
	lưu node trả về vào thuộc tính tương ứng (left child hoặc right child) của node ban đầu (node ở lần đệ qui tương ứng).
worst case của BST là khi BST giống linked list


# AVL
keep h = O(logn) để đảm bảo time compelxity cho find, insert, delete là O(logn)
Height: empty tree -> -1
		typical tree -> max(left_height, right_height) + 1
AVL criterion: |x.left.height - x.right.height| <= 1 for every x in the tree
rotate left: right child đưa lên làm root
rotate right: left child đưa lên làm root
balanced factor: bf(x) = x.left.height - x.right.height
left-left: rotateRight
right-right: rotateLeft
left-right: rotateLeft(x.left), rotateRight
right-left: rotateRight(x.right), rotateLeft


# Binary Heap
Lưu trữ phần tử bằng mảng
Mỗi phần tử i có 2 children ở vị trí 2i, 2i+1
Max Heap: A[parent(i)] >= A[i]
Min Heap: A[parent(i)] < A[i]

Binary Complete Tree: thêm phần tử mới vào cây, phải thêm vào đầy một tầng (level) mới được qua tầng tiếp theo. Độ cao logn

Insert: thêm vào cuối mảng, tiến hành so sánh và đổi chỗ ngược lên root. O(logn)
Delete: lấy phần tử đầu mảng. Dời phần tử cuối mảng lên, thực hiện shiftDown. O(logn)
Ứng dụng: PriorityQueue
		  HeapSort


# Graph: vertices and edges
	edges: directed (one-way), undirected (bidirectional)
	edge weight/cost: a number representing information of the edge
	isolated vertices: vertices with no edges
	vertices connected to a vertex x are adjacent vertices/neighbors of x
Sparse/Dense: the number of edges (no guideline for "how many")
Complete graph: there is an edge between every couple of vertices
Degree of a vertex: number of edges (in/out degree -> direction of edges)
Path: a sequence of vertices adjacent to each other.
	  simple path -> no repeated vertices
Path length/cost: number of edges (or summation of edge weights)
Cycle: path starts and ends at the same vertex
	  simple cycle -> no repeated vertices (except the start/end)
Component: a group of vertices (undirected graph), there is a path between every couple of vertices
Connected graph: 1 component
Reachable/Unreachable: whether there is a path between a and b
Subgraph: subset of vertices + subset of edges
Directed acylic graph (DAG): graph with no cycles
Tree: connected graph, |E| = |V| - 1
Bipartite graph (đồ thị lưỡng phân): có thể chia đồ thị thành 2 tập đỉnh con, không có cạnh nối giữa hai đỉnh trong cùng một tập.

Graph representation:
	Adjacency matrix: matrix đối xứng qua đường chéo chính
	Adjacency list
	Edge list


# BFS & DFS
BFS: sử dụng queue để lưu các đỉnh kề trong quá trình duyệt
	 sử dụng mảng p để lưu trữ parent của từng đỉnh
	 O(V+E) trên Adjacency List

DFS: dùng đệ quy xử lý từng đỉnh và gọi đệ quy để xử lý đỉnh kề
	 có thể rơi vào những nhánh "sâu" và tốn thời gian xử lý hơn
	 O(V+E) trên Adjacency List

# MST
tree: a connect graph with V vertices and V-1 edges
spanning tree T of a graph G is a tree consisting of all vertices of G (tree edges are selected from G's)
given a connected graph, there are many ways to select a spanning tree.
the spanning tree with the smallest total weights is call the minimum spanning tree.
there maybe more than one MST in a given graph
Input: a connected undirected weighted graph G
Output: a minimum spanning tree T

Union-Find Disjoint Sets
- Mỗi phần tử thuộc về 1 tập được đại diện bởi 1 phần tử
- Kiểm tra hai phần tử có cùng thuộc một tập
- 2 thao tác thông dụng: tra đại diện của một phần tử, hợp nhất 2 tập

Kruskal:
- Biểu diễn đồ thị dạng EdgeList
- Sắp xếp cạnh tăng dần trọng số
- Duyệt qua các cạnh, nếu không tạo vòng trong cây MST hiện hành thì thêm vào cây
- O(ElogV)

Prim's
- Xuất phát từ đỉnh gốc, thêm các cạnh kề vào PQ
- Mỗi lần lặp, lấy ra 1 cạnh. Nếu đỉnh kia của cạnh chưa có trong T thì thêm vào T. Sau đó, thêm cách cạnh kề của đỉnh đang xét vào PQ (bỏ qua cạnh mà 2 đỉnh đã có trong T).
- O(ElogV)

# SSSP
delta(s, b): the shortest path weight from s to b
- Input: G(V, E), w(a, b): E -> R, s
- Output: delta(s, x) for x in V
Negative weight edges and cycles are noticed in the task of SSSP
Trên đồ thị unweighted, có thể dùng BFS để tìm đường đi ngắn nhất từ đỉnh bắt đầu tới tất cả các đỉnh còn lại.

4 special cases in SSSP problem
- case 1: tree
- case 2: unweighted graph
- case 3: directed and acylic graph (DAG)
- case 4: graph without negative weight/cycle.

Bellman Ford's
- Lặp |V| - 1 lần
	Duyệt qua tất cả cạnh, thực hiện relax
- Sau khi kết thúc, duyệt qua tất cả cạnh thực hiện relax
	Nếu có cập nhật xảy ra -> có negative weight cycles
	Ngược lại, không có negative weight cycles
- O(VE)
- Kết quả thuật toán là khoảng cách ngắn nhất từ s đến tất cả đỉnh còn lại

Dijkstra's
- Mỗi lần lặp
	Lấy đỉnh d,u ra khỏi PQ
	Nếu d = dist[u], duyệt đỉnh kề để relax
- Kết thúc, đường đi ngắn nhất từ source đến tất cả đỉnh
- O((V+E)logV)
- Dijkstra là thuật toán greedy


