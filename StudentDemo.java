import java.util.Scanner;

class Student {
    String usn;                                      // instance variables: every Student has its own copy
    String name;
    String branch;
    String phone;

    Student(String usn, String name, String branch, String phone) {   // constructor with parameters
        this.usn = usn;                              // this.usn = the field, usn = the parameter
        this.name = name;
        this.branch = branch;
        this.phone = phone;
    }

    void display() {                                 // prints one student's row
        System.out.printf("%-14s%-16s%-10s%-12s%n", usn, name, branch, phone);
    }
}
class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(sc.nextLine());     // read as a line, then convert, to avoid the leftover newline

        Student[] list = new Student[n];             // n empty slots (all null), NOT n objects yet

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of student " + (i + 1));
            System.out.print("USN: ");
            String usn = sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();             // nextLine lets the name contain spaces
            System.out.print("Branch: ");
            String branch = sc.nextLine();
            System.out.print("Phone: ");
            String phone = sc.nextLine();

            list[i] = new Student(usn, name, branch, phone);   // NOW the object is created and stored in slot i
        }

        // ---- print with headings ----
        System.out.println();
        // %-14s = left-aligned string in a field 14 characters wide, %n = newline
        System.out.printf("%-14s%-16s%-10s%-12s%n", "USN", "Name", "Branch", "Phone");
        System.out.println("--------------------------------------------------");
        for (Student s : list)                       // for-each over the array of objects
            s.display();

        sc.close();
    }
}

