class IterationDemo {
    public static void main(String[] args) {

        // ========== 1. while LOOP (entry-controlled) ==========
        // The condition is checked BEFORE every iteration.
        int count = 1;                                  // initialization (outside the loop)
        System.out.print("1. while: ");
        while (count <= 5) {                            // condition
            System.out.print(count + " ");
            count++;                                    // update (forget this and the loop never ends)
        }
        System.out.println();

        // ========== 2. while MAY RUN ZERO TIMES ==========
        int k = 10;
        while (k < 5) {                                 // false on the very first check
            System.out.println("never printed");
        }
        System.out.println("2. while body ran zero times, k = " + k);

        // ========== 3. do-while (exit-controlled) ==========
        // The body runs FIRST and the condition is checked AFTER, so it runs at least once.
        int j = 10;
        do {
            System.out.println("3. do-while ran once, j = " + j);
            j++;
        } while (j < 5);                                // false, but the body already ran once. Note the semicolon.

        // ========== 4. while: SUM OF DIGITS ==========
        int num = 4528;
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;                       // num % 10 picks the last digit
            num /= 10;                                  // num / 10 removes the last digit
        }
        System.out.println("4. Sum of digits of 4528 = " + digitSum);   // 8+2+5+4 = 19

        // ========== 5. for LOOP: FACTORIAL ==========
        // for (initialization; condition; update). All three parts sit on one line.
        int fact = 1;
        for (int x = 1; x <= 5; x++)                    // x exists only inside this loop
            fact *= x;                                  // 1*2*3*4*5
        System.out.println("5. 5! = " + fact);          // 120

        // ========== 6. for WITH TWO VARIABLES (comma operator) ==========
        System.out.print("6. lo-hi pairs: ");
        for (int lo = 0, hi = 5; lo < hi; lo++, hi--)   // both variables change on each pass
            System.out.print(lo + "-" + hi + " ");      // 0-5 1-4 2-3 (stops when lo reaches hi)
        System.out.println();

        // ========== 7. for-each LOOP ==========
        // Walks through every element with no index. Read-only access.
        int[] nums = {10, 20, 30, 40};
        int total = 0;
        System.out.print("7. for-each: ");
        for (int v : nums) {                            // read as "for each int v in nums"
            System.out.print(v + " ");
            total += v;
        }
        System.out.println();
        System.out.println("7. total = " + total);      // 100

        for (int v : nums)
            v = v * 2;                                  // changes only the COPY v, not the array
        System.out.println("7. nums[0] after doubling the copy = " + nums[0]);   // still 10

        // ========== 8. LOCAL VARIABLE TYPE INFERENCE (var) IN LOOPS ==========
        // The compiler works out the type from the initial value (Java 10 and later).
        System.out.print("8. var in for: ");
        for (var n = 1; n <= 3; n++)                    // n is inferred as int
            System.out.print(n * n + " ");              // 1 4 9
        System.out.println();

        String[] names = {"Ram", "Sita"};
        System.out.print("8. var in for-each: ");
        for (var s : names)                             // s is inferred as String
            System.out.print(s + " ");
        System.out.println();
        // var must have an initializer. "var z;" is an error, and "var z = null;" is an error.

        // ========== 9. NESTED LOOPS: 3 x 3 MULTIPLICATION GRID ==========
        // The inner loop completes ALL its iterations for every ONE iteration of the outer loop.
        System.out.println("9. Multiplication grid:");
        for (int r = 1; r <= 3; r++) {                  // outer loop = rows
            for (int c = 1; c <= 3; c++) {              // inner loop = columns
                System.out.print(r * c + "\t");         // \t is a tab, for alignment
            }
            System.out.println();                       // new line after each row
        }

        // ========== 10. PATTERN: RIGHT-ANGLE TRIANGLE OF NUMBERS 0-9 ==========
        // Row 0 prints 1 number, row 1 prints 2 numbers ... row 9 prints 10 numbers.
        System.out.println("10. Number triangle:");
        for (int row = 0; row <= 9; row++) {            // outer loop picks the row (0 to 9)
            for (int col = 0; col <= row; col++) {      // inner loop prints 0..row, so it grows with the row
                System.out.print(col + " ");
            }
            System.out.println();                       // move to the next line after each row
        }
    }
}