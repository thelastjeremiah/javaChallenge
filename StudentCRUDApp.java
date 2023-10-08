import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class StudentCRUDApp {
    private static List<Student> students = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student CRUD Application");
            System.out.println("1. Create Student");
            System.out.println("2. Read Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            if (choice == 1) {
                createStudent(scanner);
            } else if (choice == 2) {
                readStudents();
            } else if (choice == 3) {
                updateStudent(scanner);
            } else if (choice == 4) {
                deleteStudent(scanner);
            } else if (choice == 5) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = new Student(nextId++, name);
        students.add(student);
        System.out.println("Student created with ID: " + student.getId());
    }

    private static void readStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of Students:");
            for (Student student : students) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
            }
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Student studentToUpdate = findStudentById(id);
        if (studentToUpdate == null) {
            System.out.println("Student not found.");
        } else {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            studentToUpdate.setName(newName);
            System.out.println("Student updated successfully.");
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Student studentToDelete = findStudentById(id);
        if (studentToDelete == null) {
            System.out.println("Student not found.");
        } else {
            students.remove(studentToDelete);
            System.out.println("Student deleted successfully.");
        }
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
