
class JumpDemo {

    // ----- helper methods for the return examples -----
    static int square(int n) {
        return n * n;                       // return WITH a value: sends n*n back to the caller
    }

    static void checkAge(int age) {
        if (age < 18) {
            System.out.println("7. Under 18, leaving the method early");
            return;                         // return WITHOUT a value (void method): exits immediately
        }
        System.out.println("7. Age is " + age + ", eligible");   // skipped if the return above ran
    }

    public static void main(String[] args) {

        // ========== 1. break: EXIT A LOOP ==========
        // break ends the NEAREST enclosing loop immediately.
        System.out.print("1. break in loop: ");
        for (int x = 1; x <= 10; x++) {
            if (x == 5)
                break;                      // loop stops when x reaches 5
            System.out.print(x + " ");      // prints 1 2 3 4
        }
        System.out.println();

        // ========== 2. break: SEARCH AND STOP ==========
        int[] data = {4, 9, 15, 22, 30};
        int target = 15, foundAt = -1;
        for (int p = 0; p < data.length; p++) {
            if (data[p] == target) {
                foundAt = p;
                break;                      // no need to check the remaining elements
            }
        }
        System.out.println("2. " + target + " found at index " + foundAt);   // 2

        // ========== 3. break: END A switch CASE ==========
        // (covered in selection statements; break stops fall-through)
        int day = 2;
        switch (day) {
            case 1: System.out.println("3. Monday"); break;
            case 2: System.out.println("3. Tuesday"); break;     // runs, then break leaves the switch
            case 3: System.out.println("3. Wednesday"); break;
        }

        // ========== 4. LABELED break ("civilized goto") ==========
        // A plain break leaves only the INNER loop. A labeled break leaves the labeled (outer) loop.
        System.out.print("4. labeled break: ");
        outer:                              // label (name followed by a colon) placed before the outer loop
        for (int r = 1; r <= 3; r++) {
            for (int c = 1; c <= 3; c++) {
                if (r == 2 && c == 2)
                    break outer;            // exits BOTH loops
                System.out.print(r + "" + c + " ");
            }
        }
        System.out.println();               // printed: 11 12 13 21

        // For comparison, a plain break inside nested loops:
        System.out.print("4. plain break:   ");
        for (int r = 1; r <= 3; r++) {
            for (int c = 1; c <= 3; c++) {
                if (r == 2 && c == 2)
                    break;                  // exits only the INNER loop; the outer loop continues
                System.out.print(r + "" + c + " ");
            }
        }
        System.out.println();               // printed: 11 12 13 21 31 32 33

        // ========== 5. continue: SKIP ONE ITERATION ==========
        // continue skips the rest of the CURRENT iteration and jumps to the next one.
        System.out.print("5. continue (skip 3 and 6): ");
        for (int x = 1; x <= 8; x++) {
            if (x == 3 || x == 6)
                continue;                   // jumps straight to x++ and the condition check
            System.out.print(x + " ");      // 1 2 4 5 7 8
        }
        System.out.println();

        // print only odd numbers using continue
        System.out.print("5. odd numbers: ");
        for (int x = 1; x <= 9; x++) {
            if (x % 2 == 0)
                continue;                   // skip even numbers
            System.out.print(x + " ");
        }
        System.out.println();

        // ========== 6. LABELED continue ==========
        // Skips the rest of the INNER loop AND continues with the next iteration of the OUTER loop.
        System.out.print("6. labeled continue: ");
        rows:
        for (int r = 1; r <= 3; r++) {
            for (int c = 1; c <= 3; c++) {
                if (c > r)
                    continue rows;          // abandon this row, start the next one
                System.out.print(r + "" + c + " ");
            }
        }
        System.out.println();               // printed: 11 21 22 31 32 33

        // ========== 7. return ==========
        // return exits the CURRENT METHOD and goes back to the caller.
        System.out.println("7. square(6) = " + square(6));   // 36
        checkAge(15);
        checkAge(20);

        // ========== 8. return INSIDE main ==========
        System.out.println("8. before return");
        return;                             // ends main, so the program stops here
        // Any statement written after this line is an "unreachable code" compile error.
    }
}