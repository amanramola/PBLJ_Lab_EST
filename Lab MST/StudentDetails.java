import java.util.*;

class ifEmpty extends Exception {
    public ifEmpty(String message) {
        super(message);
    }
}

class StudentList {
    private ArrayList<String> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String student) {
        students.add(student);
    }

    public void removeStudent(String student) throws ifEmpty {
        if (students.isEmpty()) {
            throw new ifEmpty("Student list is empty!");
        }
        if (students.remove(student)) {
            System.out.println(student + " removed.");
        } else {
            System.out.println(student + " not found.");
        }
    }

    public void displaySorted() throws ifEmpty {
        if (students.isEmpty()) {
            throw new ifEmpty("Student list is empty!");
        }
        ArrayList<String> sorted = new ArrayList<>(students);
        Collections.sort(sorted);
        for (String student : sorted) {
            System.out.println(student);
        }
    }
}

public class StudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList sl = new StudentList();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Sorted Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int ch;
            try {
                ch = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (ch) {
                case 1 :

                    System.out.print("Enter student name to add: ");
                    String nameToAdd = sc.nextLine();
                    sl.addStudent(nameToAdd);
                    System.out.println("Student added.");
                    break;
                case 2 :

                    System.out.print("Enter student name to remove: ");
                    String nameToRemove = sc.nextLine();
                    try {
                        sl.removeStudent(nameToRemove);
                    } catch (ifEmpty e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                case 3 :

                    try {
                        System.out.println("Sorted Student List:");
                        sl.displaySorted();
                    } catch (ifEmpty e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                case 4 :

                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}