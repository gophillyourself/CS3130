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

    static StringJoiner searchString = new StringJoiner(",");

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

    //left, root, right
    void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.key + ", ");
            inorder(root.right);
        }
    }

    //root, left, right
    void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.key + ", ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //left, right, root
    void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + ", ");
        }
    }

    static Node search(Node root, int key) {
        try {
            searchString.add(String.valueOf(root.key));
            if (root == null || root.key == key) {
                return root;
            }
            if (root.key > key) {
                return search(root.left, key);
            }
            return search(root.right, key);
        } catch (NullPointerException e ) {
            return new Node(-1);
        }
    }

    static Node deleteKey(int key) {
        root = delete(root, key);
        return root;
    }

    static Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }

        return root;
    }

    static int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    static void treeToArray(Node root, List<Integer> arr) {
        if(root != null) {
            arr.add(root.key);
            treeToArray(root.left, arr);
            treeToArray(root.right, arr);
        }
    }

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
