// Inherits from Student -> Person
// Data saved to: webdev_<name>.txt
public class WebDevStudent extends Student {

    private String preferredFramework;

    public WebDevStudent(String name, int age, String email, String preferredFramework) {
        super(name, age, email, "Web Development", 5);
        this.preferredFramework = preferredFramework;
    }

    public String getPreferredFramework() {
        return preferredFramework;
    }

    @Override
    public void showBasicInfo() {
        super.showBasicInfo();
        System.out.println("  Framework : " + preferredFramework);
        System.out.println("----------------------------------");
    }

    @Override
    public String getFileName() {
        return "webdev_" + name.replaceAll("\\s+", "_").toLowerCase() + ".txt";
    }

    @Override
    public String toFileData() {
        return baseFileData() + "\n" + preferredFramework;
    }
}
