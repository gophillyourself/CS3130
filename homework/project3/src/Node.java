import java.util.List;
import java.util.StringJoiner;

public class Node {
    int key;
    static Node root;
    Node left;
    Node right;
    Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        if(root.key > key) {
            root.left = insert(root.left, key);
        } else if( root.key < key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    static Node insert(int key) {
        root = insert(root, key);
        return root;
    }

    static Node insert(List<Integer> keys) {
        for (Integer integer : keys) {
            root = insert(integer);
        }
        return root;
    }

    void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.key + ", ");
            inorder(root.right);
        }
    }

    void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.key + ", ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + ", ");
        }
    }

    static Node search(Node root, int key) {
        System.out.print(root.key + ", ");
        if(root == null || root.key == key) {
            return root;
        }
        if(root.key > key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    static Node delete(Node root, int key)

    @Override
    public String toString() {
        return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                .add("key=" + key)
                .add("root=" + root)
                .add("left=" + left)
                .add("right=" + right)
                .toString();
    }
}
