
public abstract class Student extends Person implements Saveable, Progressable {

    protected String domain;
    protected int completedTopics;
    protected int totalTopics;

    public Student(String name, int age, String email, String domain, int totalTopics) {
        super(name, age, email);
        this.domain = domain;
        this.totalTopics = totalTopics;
        this.completedTopics = 0;
    }

    @Override
    public void updateProgress() {
        if (completedTopics < totalTopics) {
            completedTopics++;
            System.out.println("  Progress updated! Completed: " + completedTopics + "/" + totalTopics);
        } else {
            System.out.println("  All topics already completed!");
        }
    }

    @Override
    public int getProgress() {
        return (totalTopics > 0) ? (completedTopics * 100) / totalTopics : 0;
    }

    public String getDomain() {
        return domain;
    }

    public int getCompletedTopics() {
        return completedTopics;
    }

    public int getTotalTopics() {
        return totalTopics;
    }

    @Override
    public void showBasicInfo() {
        System.out.println("----------------------------------");
        System.out.println("         STUDENT PROFILE         ");
        System.out.println("----------------------------------");
        super.showBasicInfo();
        System.out.println("  Domain  : " + domain);
        System.out.println("  Progress: " + completedTopics + "/" + totalTopics
                + " topics (" + getProgress() + "%)");
        System.out.println("----------------------------------");
    }

    public abstract String getFileName();

    public abstract String toFileData();

    protected String baseFileData() {
        return name + "\n" + age + "\n" + email + "\n"
                + domain + "\n" + completedTopics + "\n" + totalTopics;
    }

    public void restoreProgress(int completed, int total) {
        this.completedTopics = completed;
        this.totalTopics = total;
    }
}
