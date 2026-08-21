// Implements Displayable — Person knows how to display itself.
// display() is the interface contract; showBasicInfo() is the internal method
// that Student subclasses extend via super.showBasicInfo().
public class Person implements Displayable {
    protected String name;
    protected int age;
    protected String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Used internally by Student.showBasicInfo() via super call
    public void showBasicInfo() {
        System.out.println("  Name  : " + name);
        System.out.println("  Age   : " + age);
        System.out.println("  Email : " + email);
    }

    // Satisfies Displayable — delegates to showBasicInfo()
    @Override
    public void display() {
        showBasicInfo();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
