
public class Roadmap implements Displayable {
    protected final String domain;
    protected final String[] steps;

    public Roadmap(String domain, String[] steps) {
        this.domain = domain;
        this.steps = steps;
    }

    public void showRoadmap() {
        System.out.println("----------------------------------");
        System.out.println("   LEARNING ROADMAP: " + domain);
        System.out.println("----------------------------------");
        int i = 1;
        for (String step : steps) {
            System.out.println("  Step " + i++ + ": " + step);
        }
        System.out.println("----------------------------------");
    }

    // Satisfies Displayable — delegates to showRoadmap()
    @Override
    public void display() {
        showRoadmap();
    }

    // Factory method — returns the right Roadmap subclass
    public static Roadmap forDomain(String domain) {
        switch (domain) {
            case "Web Development":
                return new WebDevRoadmap();
            case "Data Science":
                return new DataScienceRoadmap();
            case "Cyber Security":
                return new CyberSecRoadmap();
            default:
                throw new IllegalArgumentException("Unknown domain: " + domain);
        }
    }
}



class WebDevRoadmap extends Roadmap {
    public WebDevRoadmap() {
        super("Web Development", new String[] {
                "Learn HTML & CSS",
                "Learn JavaScript ",
                "Learn a Framework (React / Angular / Vue)",
                "Learn Backend (Node.js / Java Spring/ Django)",
                "Build & Deploy Projects"
        });
    }
}

class DataScienceRoadmap extends Roadmap {
    public DataScienceRoadmap() {
        super("Data Science", new String[] {
                "Learn Python or R",
                "Learn Statistics & Probability",
                "Learn Data Analysis (Pandas, NumPy)",
                "Learn Machine Learning (Scikit-learn, TensorFlow)",
                "Build & Present Projects"
        });
    }
}

class CyberSecRoadmap extends Roadmap {
    public CyberSecRoadmap() {
        super("Cyber Security", new String[] {
                "Learn Networking Fundamentals",
                "Learn Linux & Command Line",
                "Learn Security Concepts & Protocols",
                "Practice Ethical Hacking (CTF, Kali Linux)",
                "Get Certified (CEH / CompTIA Security+)"
        });
    }
}
