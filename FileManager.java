import java.io.*;

public class FileManager {

    // Accepts any Saveable — not tied to Student specifically (Saveable interface
    // in use)
    public static void saveStudent(Saveable s) {
        try {
            FileWriter fw = new FileWriter(s.getFileName());
            fw.write(s.toFileData());
            fw.close();
            System.out.println("  Data saved to: " + s.getFileName());
        } catch (Exception e) {
            System.out.println("  Error saving file: " + e.getMessage());
        }
    }

    // Login: search all .txt files for matching name + email
    // Returns the reconstructed Student object, or null if not found
    public static Student loginStudent(String name, String email) {
        // Possible file prefixes based on domain subclasses
        String[] prefixes = { "webdev_", "datascience_", "cybersec_" };
        String namePart = name.replaceAll("\\s+", "_").toLowerCase();

        for (String prefix : prefixes) {
            String fileName = prefix + namePart + ".txt";
            File file = new File(fileName);
            if (!file.exists())
                continue;

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String savedName = br.readLine();
                int savedAge = Integer.parseInt(br.readLine().trim());
                String savedEmail = br.readLine();
                String savedDomain = br.readLine();
                int completed = Integer.parseInt(br.readLine().trim());
                int total = Integer.parseInt(br.readLine().trim());
                String extra = br.readLine();
                br.close();

                // Check name and email match
                if (!savedName.equalsIgnoreCase(name) || !savedEmail.equalsIgnoreCase(email)) {
                    continue;
                }

                // Reconstruct the correct subclass
                Student s;
                switch (savedDomain) {
                    case "Web Development":
                        s = new WebDevStudent(savedName, savedAge, savedEmail,
                                extra != null ? extra : "");
                        break;
                    case "Data Science":
                        s = new DataScienceStudent(savedName, savedAge, savedEmail,
                                extra != null ? extra : "");
                        break;
                    case "Cyber Security":
                        s = new CyberSecStudent(savedName, savedAge, savedEmail,
                                extra != null ? extra : "");
                        break;
                    default:
                        s = new WebDevStudent(savedName, savedAge, savedEmail, "");
                }

                s.restoreProgress(completed, total);
                return s;

            } catch (Exception e) {
                // File exists but couldn't be read — skip
            }
        }

        return null; // not found
    }

    // Load and display student data from their file
    /*public static void loadStudent(Student s) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(s.getFileName()));
            System.out.println("----------------------------------");
            System.out.println("        SAVED STUDENT DATA       ");
            System.out.println("----------------------------------");
            System.out.println("  Name      : " + br.readLine());
            System.out.println("  Age       : " + br.readLine());
            System.out.println("  Email     : " + br.readLine());
            System.out.println("  Domain    : " + br.readLine());
            int completed = Integer.parseInt(br.readLine().trim());
            int total = Integer.parseInt(br.readLine().trim());
            System.out.println("  Progress  : " + completed + "/" + total
                    + " topics (" + (total > 0 ? (completed * 100) / total : 0) + "%)");
            String extra = br.readLine();
            if (extra != null && !extra.isEmpty()) {
                System.out.println("  Extra     : " + extra);
            }
            br.close();
            System.out.println("----------------------------------");

            s.restoreProgress(completed, total);

        } catch (FileNotFoundException e) {
            System.out.println("  No saved data found for " + s.getName()
                    + " (" + s.getFileName() + ")");
        } catch (Exception e) {
            System.out.println("  Error loading file: " + e.getMessage());
        }
    }*/
}
