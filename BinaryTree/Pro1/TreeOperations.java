package Pro1;

import java.util.*;

class TreeNode 
{
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class NaryNode 
{
    int val;
    List<NaryNode> children;
    NaryNode(int x) 
    { 
        val = x; 
        children = new ArrayList<>();
    }
}

public class TreeOperations 
{
    static Scanner sc = new Scanner(System.in);

    // Build Binary Tree from array input (Level Order, -1 = null)
    public static TreeNode buildBinaryTree(Integer[] arr) 
    {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) 
        {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) 
            {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) 
            {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Height of Binary Tree
    static int height(TreeNode root) 
    {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Count Parents (nodes with at least one child)
    static int countParents(TreeNode root) 
    {
        if (root == null) return 0;
        int count = 0;
        if (root.left != null || root.right != null) count++;
        return count + countParents(root.left) + countParents(root.right);
    }

    // PostOrder Traversal
    static void postOrder(TreeNode root) 
    {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // BST Search
    static boolean searchBST(TreeNode root, int key) 
    {
        if (root == null) return false;
        if (root.val == key) return true;
        return key < root.val ? searchBST(root.left, key) : searchBST(root.right, key);
    }

    // Level Order Traversal
    static void levelOrder(TreeNode root) 
    {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) 
        {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    // N-ary PreOrder Traversal
    static void preorderNary(NaryNode root) 
    {
        if (root == null) return;
        System.out.print(root.val + " ");
        for (NaryNode child : root.children) 
        {
            preorderNary(child);
        }
    }

    public static void main(String[] args) 
    {
        System.out.println("Enter array input (like 1 2 3 or [1,4,6] or [\"3\",\"9\",\"20\",\"null\",\"15\"]):");
        String raw = sc.nextLine().trim();

        String clean = raw.replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .replace(",", " ")
                .trim()
                .replaceAll("\\s+", " "); // multiple spaces → single space

        String[] parts = clean.split(" ");
        Integer[] arr = new Integer[parts.length];

        for (int i = 0; i < parts.length; i++) 
        {
            if (parts[i].equalsIgnoreCase("null") || parts[i].equals("-1")) {
                arr[i] = null; 
            } 
            else 
            {
                arr[i] = Integer.parseInt(parts[i]); 
            }
        }


        TreeNode root = buildBinaryTree(arr);

        System.out.println("Height of Binary Tree: " + height(root));
        System.out.println("Number of Parents: " + countParents(root));

        System.out.print("PostOrder Traversal: ");
        postOrder(root);
        System.out.println();

        System.out.print("Level Order Traversal: ");
        levelOrder(root);
        System.out.println();

        System.out.print("Enter element to search in BST: ");
        int key = sc.nextInt();
        System.out.println("Element " + key + (searchBST(root, key) ? " found" : " not found"));


        NaryNode nroot = new NaryNode(1);
        NaryNode child1 = new NaryNode(2);
        NaryNode child2 = new NaryNode(3);
        NaryNode child3 = new NaryNode(4);
        nroot.children.add(child1);
        nroot.children.add(child2);
        child2.children.add(child3);

        System.out.print("N-ary Tree Preorder Traversal: ");
        preorderNary(nroot);
    }
}
// Enter array input (like 1 2 3 or [1,4,6] or ["3","9","20","null","15"]):
// 10 5 15 3 7 -1 18
// Height of Binary Tree: 3
// Number of Parents: 3
// PostOrder Traversal: 3 7 5 18 15 10
// Level Order Traversal: 10 5 15 3 7 18
// Enter element to search in BST: 7
// Element 7 found
// N-ary Tree Preorder Traversal: 1 2 3 4
import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[][] field1 = {
            {'.', '#', '#'},
            {'#', '.', '.'},
            {'.', '.', '.'}
        };
        System.out.println(Arrays.toString(solution(field1))); // [4, 4]

        char[][] field2 = {
            {'.', '#', '#'},
            {'.', '.', '#'},
            {'.', '.', '.'}
        };
        System.out.println(Arrays.toString(solution(field2))); // [3, 6]
    }

    public static int[] solution(char[][] field) {
        int rows = field.length;
        int cols = field[0].length;

        int alreadyFilled = 0;////
        for (int r = 0; r < rows; r++) {
            if (field[r][0] == '#') {
                alreadyFilled++;
            }
        }

        int need = rows - alreadyFilled; // empty cells to fill in first column

        // -------- Minimum Moves --------
        // Always drop blocks directly into each empty cell
        int minMoves = need;

        // -------- Maximum Moves --------
        // Each block could "waste" steps by sliding right first, 
        // then falling back to column 0.
        // Worst case: each empty cell in column 0 might need several drops.
        int maxMoves = 0;

        for (int r = 0; r < rows; r++) {
            if (field[r][0] == '.') {
                // How far right will a block from this row go?
                int col = 0;
                while (col < cols && field[r][col] == '.') {
                    col++;
                }
                // It will eventually fall down until it lands in this empty cell
                // Worst case: need (col) blocks to fill this one first-column cell
                maxMoves += col;
            }
        }

        return new int[]{minMoves, maxMoves};
    }
}

///////////////////////////////////////////////////////////
    public int[] solution(char[][] field) 
    {
        int rows = field.length;
        int cols = field[0].length;

        int minMoves = 0;
        int maxMoves = 0;

        for (int r = 0; r < rows; r++) 
        {
            if (field[r][0] == '#') continue;
            int empty = 0;
            while (empty < cols && field[r][empty] == '.') 
            {
                empty++;
            }
            minMoves = minMoves + 1;
            maxMoves = maxMoves + empty;
        }
        return new int[]{minMoves, maxMoves};
    }

    //////////////////////////////////////////////////////
int[] solution(char[][] field) {
    int rows = field.length;
    int cols = field[0].length;
    int[] result = new int[2];
    final int[] minMoves = {Integer.MAX_VALUE};
    final int[] maxMoves = {Integer.MIN_VALUE};

    // Count blocks in first column
    java.util.function.Function<char[][], Integer> countBlocks = (board) -> {
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == '#') cnt++;
        }
        return cnt;
    };

    // Deep copy board
    java.util.function.Function<char[][], char[][]> copyBoard = (board) -> {
        char[][] copy = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, cols);
        }
        return copy;
    };

    // Drop block in chosen row
    java.util.function.BiConsumer<char[][], Integer> dropBlock = (board, row) -> {
        int r = row, c = 0;
        while (c + 1 < cols && board[r][c + 1] == '.') c++;
        while (r + 1 < rows && board[r + 1][c] == '.') r++;
        board[r][c] = '#';
    };

    // Recursive solver
    java.util.function.BiConsumer<char[][], Boolean> solve = new java.util.function.BiConsumer<>() {
        @Override
        public void accept(char[][] board, Boolean findMax) {
            int moves = 0;
            solveRecursive(board, moves, findMax);
        }
        private void solveRecursive(char[][] board, int moves, boolean findMax) {
            int filled = countBlocks.apply(board);
            if (filled == rows) {
                if (findMax) {
                    maxMoves[0] = Math.max(maxMoves[0], moves);
                } else {
                    minMoves[0] = Math.min(minMoves[0], moves);
                }
                return;
            }

            for (int r = 0; r < rows; r++) {
                if (board[r][0] != '#') {
                    char[][] nextBoard = copyBoard.apply(board);
                    dropBlock.accept(nextBoard, r);
                    solveRecursive(nextBoard, moves + 1, findMax);
                    if (!findMax) break; // For minimum moves, pick topmost empty row first
                }
            }
        }
    };

    solve.accept(field, false);
    solve.accept(field, true);

    result[0] = minMoves[0];
    result[1] = maxMoves[0];
    return result;
}