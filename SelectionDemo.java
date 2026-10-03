

class SelectionDemo {
    public static void main(String[] args) {

        // ========== 1. SIMPLE if ==========
        // The block runs only when the condition is true. Otherwise it is skipped.
        int age = 20;
        if (age >= 18)
            System.out.println("1. Eligible to vote");

        // ========== 2. if-else ==========
        // Exactly one of the two paths always runs.
        int num = 7;
        if (num % 2 == 0)                       // even numbers leave remainder 0
            System.out.println("2. " + num + " is even");
        else
            System.out.println("2. " + num + " is odd");

        // ========== 3. NESTED if ==========
        // An if placed inside another if. Used here to find the largest of three numbers.
        int a = 15, b = 42, c = 30;
        int largest;
        if (a > b) {
            if (a > c)                          // inner if runs only when a > b
                largest = a;
            else
                largest = c;
        } else {
            if (b > c)                          // inner if runs only when a <= b
                largest = b;
            else
                largest = c;
        }
        System.out.println("3. Largest = " + largest);

        // ========== 4. if-else-if LADDER ==========
        // Conditions are checked top to bottom. The FIRST true one runs and the rest are skipped.
        int marks = 78;
        char grade;
        if (marks >= 90)grade = 'S';
        else if (marks >= 80)grade = 'A';
        else if (marks >= 70)grade = 'B';                  // 78 reaches here, because the earlier ones were false
        else if (marks >= 60) grade = 'C';
        else if (marks >= 40)grade = 'D';
        else grade = 'F';                             // final else is the "none of the above" case
   
        System.out.println("4. Marks " + marks + " -> Grade " + grade);

        // ========== 5. switch WITH break ==========
        // switch compares one value against each case label. break stops execution
        // from running into the next case. default runs when no case matches.
        int day = 3;
        String name;
        switch (day) {
            case 1:name = "Monday";break;
            case 2:name = "Tuesday";break;
            case 3: name = "Wednesday";break; // day == 3 matches here// jumps out of the switch
            case 4:name = "Thursday";break;
            default:name = "Invalid day";
        }
        System.out.println("5. Day " + day + " is " + name);

        // ========== 6. switch: FALL-THROUGH (break missing) ==========
        // Without break, execution continues into the NEXT case even if its label doesn't match.
        int n = 2;
        System.out.print("6. Starting at case 2: ");
        switch (n) {
            case 1:
                System.out.print("one ");
            case 2:                             // n == 2 matches here, and it prints "two "
                System.out.print("two ");
            case 3:                             // no break above, so it falls into this and prints "three "
                System.out.print("three ");
                break;                          // fall-through stops here
            case 4:
                System.out.print("four ");      // never reached
        }
        System.out.println();

        // ========== 7. switch: FALL-THROUGH USED ON PURPOSE ==========
        // Stacking cases with no code between them lets several values share one block.
        int month = 2;
        int days;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:                             // month == 2 matches here
                days = 28;                      // ignoring leap years
                break;
            default:
                days = -1;                      // invalid month
        }
        System.out.println("7. Month " + month + " has " + days + " days");

        // ========== 8. switch ON char ==========
        char ch = 'e';
        switch (ch) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                System.out.println("8. " + ch + " is a vowel");     // 'e' matches here
                break;
            default:
                System.out.println("8. " + ch + " is a consonant");
        }

        // ========== 9. switch ON String (Java 7 and later) ==========
        // Strings are compared with equals(), so the comparison is case-sensitive.
        String cmd = "stop";
        switch (cmd) {
            case "start":
                System.out.println("9. Starting");
                break;
            case "stop":                        // "stop" equals "stop"
                System.out.println("9. Stopping");
                break;
            default:
                System.out.println("9. Unknown command");
        }
    }
}