class AVLTree {
    class Node {
        int data, height = 1;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    int height(Node n) {
        return n == null ? 0 : n.height;
    }

    int balanceFactor(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    Node rotateRight(Node y) {
        Node x = y.left, T = x.right;
        x.right = y; y.left = T;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right, T = y.left;
        y.left = x; x.right = T;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    Node insert(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.data) node.left = insert(node.left, key);
        else if (key > node.data) node.right = insert(node.right, key);
        else return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = balanceFactor(node);

        if (balance > 1 && key < node.left.data) return rotateRight(node);
        if (balance < -1 && key > node.right.data) return rotateLeft(node);
        if (balance > 1 && key > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && key < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    void insert(int key) {
        root = insert(root, key);
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    void display() {
        inOrder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(25);
        tree.display(); // Output: 10 20 25 30
    }
}
