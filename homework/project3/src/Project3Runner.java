import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project3Runner {

    static Scanner scanner;

    static Node root;

    Project3Runner() {
    }

    static String defaultValues = "30,10,45,38,20,50,25,33,8,12";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print("Binary Search Tree Project Patent Pending");
        List<Integer> numberArray = getNumberArray();
        System.out.println("0. New Array");
        System.out.println("1. Traversal");
        System.out.println("2. Search");
        int choice = 0;
        while(choice != -1) {
            System.out.print("Choose one: ");
            choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 0:
                    getNumberArray();
                case 1:
                    traversal(numberArray);
                case 2:
                    search(numberArray);


            }
        }
    }

    private static void traversal(List<Integer> intArray) {
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

    private static void search(List<Integer> intArray) {
        root = Node.insert(intArray);
        System.out.println("What key should we find");
        int key = Integer.parseInt(scanner.next());
        Node search = Node.search(root, key);
        if(search == null) {
            System.out.println(key + " was not found");
        } else {
            System.out.println(key + " was found");
        }
    }

    private static List<Integer> getNumberArray() {
        System.out.print("Enter a digit at a time or -1 to finish");
        System.out.print("Type default to use default values");
        int number = 0;
        List<Integer> ret = new ArrayList<>();
        while(number != -1) {
            String next = scanner.next();
            try {
                number = Integer.parseInt(next);
                if(number != -1) {
                    ret.add(number);
                }
            } catch (NumberFormatException e) {
                if(next.equals("default")) {
                    return new ArrayList(Arrays.asList(defaultValues.split(",")));
                }
                System.out.println("Couldn't parse that, try again");
            }
        }
        return ret;
    }
}
