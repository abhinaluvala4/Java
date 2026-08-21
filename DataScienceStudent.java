// Inherits from Student -> Person
// Data saved to: datascience_<name>.txt
public class DataScienceStudent extends Student {

    private String programmingLanguage;

    public DataScienceStudent(String name, int age, String email, String programmingLanguage) {
        super(name, age, email, "Data Science", 5);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public void showBasicInfo() {
        super.showBasicInfo();
        System.out.println("  Language  : " + programmingLanguage);
        System.out.println("----------------------------------");
    }

    @Override
    public String getFileName() {
        return "datascience_" + name.replaceAll("\\s+", "_").toLowerCase() + ".txt";
    }

    @Override
    public String toFileData() {
        return baseFileData() + "\n" + programmingLanguage;
    }
}
