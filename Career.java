
public class Career implements Displayable {
    protected final String domain;
    protected final String skills;
    protected final String salary;
    protected final String projects;

    public Career(String domain, String skills, String salary, String projects) {
        this.domain = domain;
        this.skills = skills;
        this.salary = salary;
        this.projects = projects;
    }

    public void showCareerInfo() {
        System.out.println("----------------------------------");
        System.out.println("        CAREER INFORMATION       ");
        System.out.println("----------------------------------");
        System.out.println("  Domain   : " + domain);
        System.out.println("  Skills   : " + skills);
        System.out.println("  Salary   : " + salary);
        System.out.println("  Projects : " + projects);
        System.out.println("----------------------------------");
    }

    // Satisfies Displayable — delegates to showCareerInfo()
    @Override
    public void display() {
        showCareerInfo();
    }

    // Factory method — returns the right Career subclass
    public static Career forDomain(String domain) {
        switch (domain) {
            case "Web Development":
                return new WebDevCareer();
            case "Data Science":
                return new DataScienceCareer();
            case "Cyber Security":
                return new CyberSecCareer();
            default:
                throw new IllegalArgumentException("Unknown domain: " + domain);
        }
    }
}

// ---------- domain subclasses ----------

class WebDevCareer extends Career {
    public WebDevCareer() {
        super("Web Development",
                "HTML, CSS, JavaScript, React/Angular, Node.js",
                "4 - 14 LPA",
                "Portfolio Site, E-Commerce App, Blog Platform");
    }
}

class DataScienceCareer extends Career {
    public DataScienceCareer() {
        super("Data Science",
                "Python/R, Statistics, ML, Pandas, TensorFlow",
                "6 - 18 LPA",
                "Sentiment Analysis, Price Predictor, Dashboard");
    }
}

class CyberSecCareer extends Career {
    public CyberSecCareer() {
        super("Cyber Security",
                "Networking, Linux, Ethical Hacking, SIEM Tools",
                "5 - 16 LPA",
                "Vulnerability Scanner, Firewall Config, CTF Challenges");
    }
}
