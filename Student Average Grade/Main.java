import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Grade: " + grade);
    }
}

class StudentManager {

    ArrayList<Student> students = new ArrayList<>();
    double baseExamGrade; // not set

    // Set Base Exam Grade
    public void setBaseExamGrade(double grade) {
        baseExamGrade = grade;
        System.out.println("Base exam grade has been set successfully.");
    }

    // Add Student (prevent duplicate ID)
    public void addStudent(int id, String name, double grade) {

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Error: Student with this ID already exists.");
                return;
            }
        }

        Student s = new Student(id, name, grade);
        students.add(s);
        System.out.println("Student added successfully.");
    }

    // Remove Student
    public void removeStudent(int id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                System.out.println("Student removed successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Display All Students (sorted by ID ascending)
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Collections.sort(students, Comparator.comparingInt(s -> s.id));

        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    public void searchStudent(int id) {

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student found:");
                s.display();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Calculate Average + Analyze Exam Difficulty
    public void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No students to calculate average.");
            return;
        }

        double sum = 0;
        for (Student s : students) {
            sum += s.grade;
        }

        double average = sum / students.size();

        System.out.println("Average Grade: " + average);
        System.out.println("Base Exam Grade: " + baseExamGrade);

        if (average >= (0.8*baseExamGrade)) {
            System.out.println("The exam seems EASY for students.");
        }
        else if ((average >= (0.5*baseExamGrade)) && (average <= (0.8*baseExamGrade))) {
            System.out.println("The exam seems NORMAL for students.");
        }
        else {
            System.out.println("The exam seems HARD for students.");
        }
    }

    // Edit Student Data
    public boolean isEmpty() {
        return students.isEmpty();
    }

    public boolean editStudent(int oldId, int newId, String newName, double newGrade) {

        Student targetStudent = null;

        // Find student with old ID
        for (Student s : students) {
            if (s.id == oldId) {
                targetStudent = s;
                break;
            }
        }

        if (targetStudent == null) {
            return false; // student not found
        }

        // If ID is being changed, check for duplicate
        if (oldId != newId) {
            for (Student s : students) {
                if (s.id == newId) {
                    System.out.println("Error: New ID already exists.");
                    return false;
                }
            }
        }

        // Update data
        targetStudent.id = newId;
        targetStudent.name = newName;
        targetStudent.grade = newGrade;

        System.out.println("Student data updated successfully.");
        return true;
    }
}

public class Main {

    public static boolean confirmAction(Scanner input) {
        System.out.println("Press 1 to continue or 0 to return to Main Menu:");
        int confirm = input.nextInt();
        return confirm == 1;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        System.out.println("=================================");
        System.out.println("      Student Average Grade      ");
        System.out.println("=================================");

        // FORCE Base Exam Grade First
        String baseInput;
        double baseGrade;

        while (true) {
            System.out.print("Enter Base Exam Grade (numbers only): ");
            baseInput = input.next();

            if (baseInput.matches("\\d+(\\.\\d+)?")) {
                baseGrade = Double.parseDouble(baseInput);
                manager.setBaseExamGrade(baseGrade);
                break;
            } else {
                System.out.println("Invalid input! Must be numeric.");
            }
        }

        while (true) {

            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student");
            System.out.println("5. Calculate Average Grade");
            System.out.println("6. Edit Student");
            System.out.println("7. Exit");

            int choice = input.nextInt();

            // 🔥 FORCE ADD STUDENT IF EMPTY
            if (manager.isEmpty() && choice != 1 && choice != 7) {
                System.out.println("No students available. You must add at least one student.");

                choice = 1;
            }

            switch (choice) {

                case 1:

                    System.out.println("=================================");
                    System.out.println("      Add Student      ");
                    System.out.println("=================================");

                    if (!confirmAction(input)) {
                        break;
                    }

                    String countInput;
                    int count;

                    while (true) {
                        System.out.print("How many students do you want to add? ");
                        countInput = input.next();

                        if (countInput.matches("\\d+")) {
                            count = Integer.parseInt(countInput);

                            if (count <= 0) {
                                System.out.println("Number must be greater than 0.");
                                continue;
                            }

                            break;
                        } else {
                            System.out.println("Invalid input! Enter numbers only.");
                        }
                    }

                    int added = 0;

                    while (added < count) {

                        System.out.println("\nEntering student " + (added + 1) + " of " + count);

                        String idInput;
                        int id;

                        while (true) {
                            System.out.print("Enter ID (numbers only): ");
                            idInput = input.next();

                            if (idInput.matches("\\d+")) {
                                id = Integer.parseInt(idInput);
                                break;
                            } else {
                                System.out.println("Invalid input! ID must contain numbers only.");
                            }
                        }

                        String name;

                        while (true) {
                            System.out.print("Enter Name (letters only): ");
                            name = input.next();

                            if (name.matches("[a-zA-Z]+")) {
                                break;
                            } else {
                                System.out.println("Invalid input! Name must contain letters only.");
                            }
                        }

                        String gradeInput;
                        double grade;

                        while (true) {
                            System.out.print("Enter Grade (numbers only): ");
                            gradeInput = input.next();

                            if (gradeInput.matches("\\d+(\\.\\d+)?")) {
                                grade = Double.parseDouble(gradeInput);

                                if (grade > manager.baseExamGrade) {
                                    System.out.println("Warning! Grade cannot exceed Base Exam Grade ("
                                            + manager.baseExamGrade + ")");
                                    continue;
                                }

                                break;
                            } else {
                                System.out.println("Invalid input! Grade must be numeric.");
                            }
                        }

                        manager.addStudent(id, name, grade);

                        added++;

                        System.out.println("✔ Added " + added + " student(s).");
                        System.out.println("✔ Remaining " + (count - added) + " student(s).");
                    }

                    break;

                case 2:
                    System.out.println("=================================");
                    System.out.println("      Remove Student      ");
                    System.out.println("=================================");
                    if (!confirmAction(input)) {
                        break;
                    }
                    System.out.print("Enter ID to remove: ");
                    int removeId = input.nextInt();
                    manager.removeStudent(removeId);
                    break;

                case 3:
                    System.out.println("=================================");
                    System.out.println("      Display All Students      ");
                    System.out.println("=================================");
                    if (!confirmAction(input)) {
                        break;
                    }
                    manager.displayAllStudents();
                    break;

                case 4:
                    System.out.println("=================================");
                    System.out.println("      Search Student      ");
                    System.out.println("=================================");
                    if (!confirmAction(input)) {
                        break;
                    }
                    System.out.print("Enter ID to search: ");
                    int searchId = input.nextInt();
                    manager.searchStudent(searchId);
                    break;

                case 5:
                    System.out.println("=================================");
                    System.out.println("      Calculate Average Grade      ");
                    System.out.println("=================================");
                    if (!confirmAction(input)) {
                        break;
                    }

                    manager.calculateAverage();
                    break;

                case 6:
                    System.out.println("=================================");
                    System.out.println("      Edit Student      ");
                    System.out.println("=================================");
                    if (!confirmAction(input)) {
                        break;
                    }

                    System.out.print("Enter current ID to edit: ");
                    int oldId = input.nextInt();

                    System.out.print("Enter new ID: ");
                    int newId = input.nextInt();

                    System.out.print("Enter new name: ");
                    String newName = input.next();

                    String newGradeInput;
                    double newGrade;

                    while (true) {
                        System.out.print("Enter new grade (numbers only): ");
                        newGradeInput = input.next();

                        if (newGradeInput.matches("\\d+(\\.\\d+)?")) {
                            newGrade = Double.parseDouble(newGradeInput);

                            if (newGrade > manager.baseExamGrade) {
                                System.out.println("Warning! Grade cannot exceed Base Exam Grade ("
                                        + manager.baseExamGrade + ")");
                                continue;
                            }

                            break;
                        } else {
                            System.out.println("Invalid input! Grade must be numeric.");
                        }
                    }

                    boolean updated = manager.editStudent(oldId, newId, newName, newGrade);

                    if (!updated) {
                        System.out.println("Edit failed. Student not found or duplicate ID.");
                    }

                    break;

                case 7:
                    System.out.println("=================================");
                    System.out.println("      Exit      ");
                    System.out.println("=================================");
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}