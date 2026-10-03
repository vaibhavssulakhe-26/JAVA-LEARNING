import java.util.Scanner;

class MatrixAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the order N: ");
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] sum = new int[n][n];

        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                b[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sum[i][j] = a[i][j] + b[i][j];

        System.out.println("Sum of the matrices:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(sum[i][j] + "\t");
            System.out.println();                 // new line after each row
        }
        sc.close();
    }
}