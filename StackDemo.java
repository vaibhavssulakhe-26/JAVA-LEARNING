import java.util.Scanner;

class Stack {
    private int[] arr;                  // storage for the elements
    private int top;                    // index of the top element, -1 means empty
    private static final int MAX = 10;  // maximum capacity (a constant shared by the class)

    Stack() {                           // constructor: same name as the class, no return type
        arr = new int[MAX];             // allocate space for 10 integers
        top = -1;                       // stack starts empty
    }

    boolean isEmpty() { return top == -1; }
    boolean isFull()  { return top == MAX - 1; }    // last valid index is 9

    void push(int x) {
        if (isFull())
            System.out.println("Stack Overflow: cannot push " + x);
        else {
            top++;                      // move top up first
            arr[top] = x;               // then store the value
            System.out.println(x + " pushed");
        }
    }

    void pop() {
        if (isEmpty())
            System.out.println("Stack Underflow: stack is empty");
        else {
            System.out.println(arr[top] + " popped");   // read before decrementing
            top--;                      // the old value stays in the array but is ignored
        }
    }

    void peek() {
        if (isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println("Top element = " + arr[top]);
    }

    void display() {
        if (isEmpty())
            System.out.println("Stack is empty");
        else {
            System.out.println("Stack (top to bottom):");
            for (int i = top; i >= 0; i--)              // walk from the top down
                System.out.println(arr[i]);
        }
    }
}

class StackDemo {
    public static void main(String[] args) {
        Stack s = new Stack();          // constructor runs here
        Scanner sc = new Scanner(System.in);
        int choice;

        do {                            // menu repeats until the user picks Exit
            System.out.println("\n1.Push 2.Pop 3.Peek 4.Display 5.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    s.push(sc.nextInt());
                    break;
                case 2: s.pop(); break;
                case 3: s.peek(); break;
                case 4: s.display(); break;
                case 5: System.out.println("Exiting"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 5);
        sc.close();
    }
}