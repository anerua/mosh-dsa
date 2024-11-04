import Array.Array;
import LinkedList.LinkedList;
import LinkedList.Node;
import Stack.Stack;
import java.util.Arrays;

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

    public void runStack() {
        // Reverse a string
        // String text = "ABCDEFG";
        // var reverser = new StringReverser();
        // String reversed = reverser.reverse(text);
        // System.out.println(reversed);

        // Balanced Expressions
        // String expression = "(())()<[(>])";
        // var checker = new SyntaxChecker();
        // System.out.println(checker.checker(expression));

        // Building a Stack with an Array
        var stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        // app.runArray();
        // app.runNode();
        // app.runLinkedList();
        app.runStack();
    }
}
