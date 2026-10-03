class OperatorsDemo {
    public static void main(String[] args) {

        // ============ 1. ARITHMETIC OPERATORS ============
        int a = 17, b = 5;
        System.out.println("a + b = " + (a + b));   // 22
        System.out.println("a - b = " + (a - b));   // 12
        System.out.println("a * b = " + (a * b));   // 85
        System.out.println("a / b = " + (a / b));   // 3  -> int / int gives int, the fraction is dropped
        System.out.println("a % b = " + (a % b));   // 2  -> remainder of 17 / 5

        System.out.println("17.0 / 5 = " + (17.0 / 5));     // 3.4  -> one double operand makes it floating-point division
        System.out.println("42.25 % 10 = " + (42.25 % 10)); // 2.25 -> % works on floats in Java (not in C)

        // TRAP: + is left to right, and once a String is involved it joins text.
        // "..." + a gives a String, then + b joins b's digits as text. Parentheses fix it.
        System.out.println("Without parentheses: " + a + b);  // 175 (text "17" + text "5")

        // Increment / decrement
        int x = 5;
        int y = x++;     // POSTFIX: y gets the old value 5 first, THEN x becomes 6
        int z = ++x;     // PREFIX: x becomes 7 first, THEN z gets 7
        System.out.println("x=" + x + " y=" + y + " z=" + z);  // x=7 y=5 z=7

        int w = 10;
        w--;             // 9
        --w;             // 8  (alone on a line, prefix and postfix behave the same)
        System.out.println("w = " + w);                        // 8

        // ============ 2. ASSIGNMENT OPERATORS ============
        int c = 10;
        c += 5;          // c = c + 5  -> 15
        c -= 3;          // c = c - 3  -> 12
        c *= 2;          // c = c * 2  -> 24
        c /= 4;          // c = c / 4  -> 6
        c %= 4;          // c = c % 4  -> 2
        System.out.println("c = " + c);                        // 2

        byte bt = 10;
        bt += 5;         // OK: compound assignment has an implicit cast back to byte
        // bt = bt + 5;  // ERROR: bt + 5 is promoted to int, and int can't go into a byte without a cast
        System.out.println("bt = " + bt);                      // 15

        int p, q, r;
        p = q = r = 100; // chained assignment, evaluated right to left: r = 100, then q = r, then p = q
        System.out.println("p q r = " + p + " " + q + " " + r);  // 100 100 100

        // ============ 3. RELATIONAL OPERATORS (result is always boolean) ============
        int m = 10, n = 20;
        System.out.println("m == n : " + (m == n));  // false
        System.out.println("m != n : " + (m != n));  // true
        System.out.println("m > n : " + (m > n));    // false
        System.out.println("m < n : " + (m < n));    // true
        System.out.println("m >= 10 : " + (m >= 10));// true
        System.out.println("n <= 15 : " + (n <= 15));// false

        // For objects, == compares REFERENCES (addresses), .equals() compares CONTENT
        String s1 = new String("hi");
        String s2 = new String("hi");
        System.out.println("s1 == s2 : " + (s1 == s2));        // false -> two different objects
        System.out.println("s1.equals(s2) : " + s1.equals(s2)); // true  -> same text

        // ============ 4. BOOLEAN LOGICAL OPERATORS ============
        boolean t = true, f = false;
        System.out.println("t & f = " + (t & f));    // false -> AND is true only if both are true
        System.out.println("t | f = " + (t | f));    // true  -> OR is true if at least one is true
        System.out.println("t ^ f = " + (t ^ f));    // true  -> XOR is true if the operands DIFFER
        System.out.println("t ^ t = " + (t ^ t));    // false -> operands are the same
        System.out.println("!t = " + (!t));          // false -> NOT flips the value
        System.out.println("t && f = " + (t && f));  // false
        System.out.println("t || f = " + (t || f));  // true

        // Short-circuit (&&, ||) vs non-short-circuit (&, |)
        int k = 0;
        boolean sc1 = (false && (++k > 0));  // left side is false, so && SKIPS the right side
        System.out.println("k after && = " + k);   // 0 -> ++k never ran
        boolean sc2 = (false & (++k > 0));   // & ALWAYS evaluates both sides
        System.out.println("k after & = " + k);    // 1 -> ++k did run

        int d = 0, num = 10;
        if (d != 0 && num / d > 2)           // d != 0 is false, so num / d is never evaluated
            System.out.println("not printed");
        else
            System.out.println("Safe: && skipped the division by zero");
        // if (d != 0 & num / d > 2)  // would throw ArithmeticException: / by zero, since & evaluates both sides

        // ============ 5. TERNARY (?) OPERATOR ============
        // form: condition ? value_if_true : value_if_false
        int i = -10;
        int abs = i < 0 ? -i : i;            // i < 0 is true, so abs = -i = 10
        int max = (m > n) ? m : n;           // m > n is false, so max = n = 20
        String res = (m > n) ? "m is bigger" : "n is bigger";
        System.out.println("abs = " + abs);   // 10
        System.out.println("max = " + max);   // 20
        System.out.println(res);              // n is bigger

        // ============ 6. PRECEDENCE AND PARENTHESES ============
        int p1 = 10 + 5 * 2 - 8 / 4;   // * and / first: 10 + 10 - 2 = 18
        int p2 = (10 + 5) * 2;         // parentheses override precedence: 15 * 2 = 30
        int p3 = 100 / 10 * 2;         // same level, left to right: (100/10)*2 = 20 (NOT 100/20 = 5)
        System.out.println("10 + 5 * 2 - 8 / 4 = " + p1);   // 18
        System.out.println("(10 + 5) * 2 = " + p2);          // 30
        System.out.println("100 / 10 * 2 = " + p3);          // 20

        boolean q1 = true || false && false;     // && is higher than ||, so true || (false && false) = true
        boolean q2 = (true || false) && false;   // parentheses change the order: true && false = false
        System.out.println("q1 = " + q1);   // true
        System.out.println("q2 = " + q2);   // false

        // ============ BONUS: BITWISE (not in your listed items, low priority) ============
        // 5 = 0101, 3 = 0011 in binary
        System.out.println("5 & 3 = " + (5 & 3));        // 1   (0001) bit is 1 only if both bits are 1
        System.out.println("5 | 3 = " + (5 | 3));        // 7   (0111) bit is 1 if either bit is 1
        System.out.println("5 ^ 3 = " + (5 ^ 3));        // 6   (0110) bit is 1 if the bits differ
        System.out.println("~5 = " + (~5));              // -6  flips every bit
        System.out.println("5 << 1 = " + (5 << 1));      // 10  shift left = multiply by 2
        System.out.println("-16 >> 2 = " + (-16 >> 2));  // -4  signed shift: keeps the sign bit
        System.out.println("-16 >>> 2 = " + (-16 >>> 2));// 1073741820  unsigned shift: fills with 0s
    }
}