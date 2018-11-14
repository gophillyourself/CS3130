import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Project3Runner {

    static Scanner scanner;
    static Node root;
    static List<Integer> intArray;
    static List<Integer> current;

    Project3Runner() {
    }

    static String defaultValues = "30,10,45,38,20,50,25,33,8,12";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Binary Search Tree Project Patent Pending");
        intArray = getIntArray();

        int choice = 0;
        while(choice != -1) {
            System.out.println("Choose one: ");
            System.out.println("0. New Array");
            System.out.println("1. Traversal");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Print Current List");
            choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 0:
                    getIntArray();
                    break;
                case 1:
                    traversal();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    current = new ArrayList<>();
                    Node.treeToArray(root, current);
                    System.out.println(intArray);
            }
        }
    }

    private static void traversal() {
        root = Node.insert(intArray);
        System.out.println("Inorder");
        root.inorder(root);
        System.out.println(" ");
        System.out.println("Preorder");
        root.preOrder(root);
        System.out.println(" ");
        System.out.println("Postorder");
        root.postOrder(root);
        System.out.println(" ");
    }

    private static void search() {
        root = Node.insert(intArray);
        System.out.println("What key should we find");
        int key = Integer.parseInt(scanner.next());
        Node search = Node.search(root, key);
        if(search == null) {
            System.out.println(key + " was not found");
        } else {
            System.out.println(key + " was found");
            System.out.println(Node.searchString.toString());
        }
        Node.searchString = new StringJoiner(",");
    }

    private static void delete() {
        root = Node.insert(intArray);
        System.out.println("What is the value of the node to delete");
        int key = Integer.parseInt(scanner.next());
        Node deleted = Node.deleteKey(key);
        if(deleted == null) {
            System.out.println(key + " could not be found in the binary tree");
        } else {
            System.out.println(key + " was deleted from the binary tree");
        }
        intArray.clear();
        Node.treeToArray(deleted, intArray);
        System.out.println("New Array (Preordered)");
        System.out.println(intArray);
        traversal();
    }

    private static List<Integer> getIntArray() {
        System.out.println("Enter a digit at a time or -1 to finish");
        System.out.println("Type default to use default values");
        System.out.println("Type random to generate values");
        int number = 0;
        List<Integer> ret = new ArrayList<>();
        String next = " ";
        Boolean handled = false;
        while(number != -1 && !handled) {
            next = scanner.next();
            try {
                number = Integer.parseInt(next);
                if(number != -1) {
                    ret.add(number);
                }
            } catch (NumberFormatException e) {
                if(next.equals("default")) {
                    String[] split = defaultValues.split(",");
                    for (String s : split) {
                        ret.add(Integer.parseInt(s));
                    }
                    handled = true;
                } else if(next.equals("random")) {
                    System.out.println("How many random numbers?");
                    int i = scanner.nextInt();
                    ret = getRandomIntegerArray(i);
                }
                handled = true;
                if(!handled) {
                    System.out.println("Couldn't parse that, try again");
                }
            }
        }
        root = Node.insert(ret);
        System.out.println("Working with Array: " + ret);
        return ret;
    }

    private static List<Integer> getRandomIntegerArray(Integer size) {
        List<Integer> ret = new ArrayList<>();
        Random random = new Random();
        int i = 0;
        while(i < size) {
            int randomInt = random.nextInt(100) + 1;
            if(!ret.contains(randomInt)) {
                i++;
                ret.add(randomInt);
            }
        }
        return ret;
    }
}
