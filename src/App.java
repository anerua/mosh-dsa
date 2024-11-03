import Array.Array;
import LinkedList.LinkedList;
import LinkedList.Node;
import java.util.Arrays;
import java.util.Stack;

public class App {

    public void runArray() {
        Array numbers = new Array(4);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.print();
        numbers.removeAt(1);
        numbers.print();
        System.out.println(numbers.indexOf(30));
    }

    public void runNode() {
        Node node = new Node(2, null);
        System.out.println(node.getValue());
        System.out.println(node.getNext().getValue());
    }

    public void runLinkedList() {
        var linkedList = new LinkedList();
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addLast(3);
        System.out.println(linkedList.contains(3));
        System.out.println(linkedList.indexOf(3));
        var array1 = linkedList.toArray();
        System.out.println(Arrays.toString(array1));
        linkedList.print();
        linkedList.reverse();
        System.out.println("The reversed list");
        linkedList.print();
        System.out.println(linkedList.size());
        linkedList.deleteFirst();
        linkedList.print();
        System.out.println(linkedList.size());
        linkedList.deleteFirst();
        linkedList.print();
        System.out.println(linkedList.size());
        linkedList.deleteLast();
        linkedList.print();
        linkedList.reverse();
        System.out.println("The reversed list");
        linkedList.print();
        var array2 = linkedList.toArray();
        System.out.println(Arrays.toString(array2));
        System.out.println(linkedList.size());
        System.out.println(linkedList.contains(8));
        System.out.println(linkedList.indexOf(3));
    }

    public String stackReverseStringExample(String str) {
        if (str == null)
            throw new IllegalArgumentException();

        var stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++)
            stack.push(str.charAt(i));
        
        // My implementation
        // String reversed = "";
        // while (!stack.empty())
        //     reversed += stack.pop();

        // Mosh
        var reversed = new StringBuilder();
        while (!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        
        // app.runArray();
        // app.runNode();
        // app.runLinkedList();

        // Reverse a string
        String text = "ABCDEFG";
        String reversed = app.stackReverseStringExample(text);
        System.out.println(reversed);
    }
}
