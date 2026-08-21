// Inherits from Student -> Person
// Data saved to: cybersec_<name>.txt
public class CyberSecStudent extends Student {

    private String specialisation;

    public CyberSecStudent(String name, int age, String email, String specialisation) {
        super(name, age, email, "Cyber Security", 5);
        this.specialisation = specialisation;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public void showBasicInfo() {
        super.showBasicInfo();
        System.out.println("  Specialisation : " + specialisation);
        System.out.println("----------------------------------");
    }

    @Override
    public String getFileName() {
        return "cybersec_" + name.replaceAll("\\s+", "_").toLowerCase() + ".txt";
    }

    @Override
    public String toFileData() {
        return baseFileData() + "\n" + specialisation;
    }
}
