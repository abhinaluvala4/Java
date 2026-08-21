import java.util.Scanner;

public class Main {

    public static void showAll(Displayable[] items) {
        for (Displayable item : items) {
            item.display();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.println("  STUDENT CAREER GUIDANCE SYSTEM ");
        System.out.println("");
        System.out.println("  1. Register (New Student)");
        System.out.println("  2. Login    (Existing Student)");
        System.out.println("");
        System.out.print("Enter choice: ");
        int startChoice = Integer.parseInt(sc.nextLine().trim());

        Student student = null;

        // ── LOGIN ──────────────────────────────────────────
        if (startChoice == 2) {
            System.out.print("Enter Name  : ");
            String loginName = sc.nextLine();
            System.out.print("Enter Email : ");
            String loginEmail = sc.nextLine();

            student = FileManager.loginStudent(loginName, loginEmail);

            if (student == null) {
                System.out.println("  No account found. Please register first.");
                sc.close();
                return;
            }
            System.out.println("  Login successful! Welcome back, " + student.getName() + ".");
        }

        else if (startChoice == 1) {
            System.out.print("Enter Name  : ");
            String name = sc.nextLine();

            System.out.print("Enter Age   : ");
            int age = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Email : ");
            String email = sc.nextLine();

            System.out.println("\nChoose Domain:");
            System.out.println("  1. Web Development");
            System.out.println("  2. Data Science");
            System.out.println("  3. Cyber Security");
            System.out.print("Enter choice: ");
            int domainChoice = Integer.parseInt(sc.nextLine().trim());

            switch (domainChoice) {
                case 1:
                    System.out.print("Preferred Framework (e.g. React, Angular, Vue): ");
                    student = new WebDevStudent(name, age, email, sc.nextLine());
                    break;
                case 2:
                    System.out.print("Preferred Language (e.g. Python, R): ");
                    student = new DataScienceStudent(name, age, email, sc.nextLine());
                    break;
                case 3:
                    System.out.print("Specialisation (e.g. Ethical Hacking, Forensics): ");
                    student = new CyberSecStudent(name, age, email, sc.nextLine());
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Web Development.");
                    student = new WebDevStudent(name, age, email, "React");
            }

            FileManager.saveStudent(student);
            System.out.println("  Account created successfully!");
        } else {
            System.out.println(" ⚠️ Invalid Choice!!");
            sc.close();
            return;
        }
        Roadmap roadmap = Roadmap.forDomain(student.getDomain());
        Career career = Career.forDomain(student.getDomain());

        // All three implement Displayable — no common parent, connected only by the
        // interface.
        // showAll() loops over them and calls display() polymorphically.
        Displayable[] dashboardItems = { student, career, roadmap };

        int choice;
        do {
            System.out.println("\n==================================");
            System.out.println("            MAIN MENU            ");
            System.out.println("==================================");
            System.out.println("  1. Show Profile");
            System.out.println("  2. Show Career Info");
            System.out.println("  3. Show Learning Roadmap");
            System.out.println("  4. Show Full Dashboard (Profile + Career + Roadmap)");
            System.out.println("  5. Update Progress");
            System.out.println("  6. Save Data");
            System.out.println("  7. Exit");
            System.out.println("==================================");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    student.display(); // Displayable
                    break;
                case 2:
                    career.display(); // Displayable
                    break;
                case 3:
                    roadmap.display(); // Displayable
                    break;
                case 4:
                    // Polymorphic loop — showAll() doesn't know or care about the concrete types
                    showAll(dashboardItems);
                    break;
                case 5:
                    student.updateProgress(); // Progressable
                    break;
                case 6:
                    FileManager.saveStudent(student); // Saveable
                    break;
                case 7:
                    System.out.println("\n  Happy learning — see you soon!");
                    break;
                default:
                    System.out.println("  Invalid option. Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
