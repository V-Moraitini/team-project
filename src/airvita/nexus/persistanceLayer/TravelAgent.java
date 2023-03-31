package airvita.nexus.persistanceLayer;
import java.math.BigDecimal;
import java.util.*;

class TravelAgent {
    private String name;
    private String address;
    private List<Blank> blanks;
    private List<TravelAdvisor> advisors;

    public TravelAgent(String name, String address) {
        this.name = name;
        this.address = address;
        this.blanks = new ArrayList<Blank>();
        this.advisors = new ArrayList<TravelAdvisor>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Blank> getBlanks() {
        return blanks;
    }

    public void addBlank(Blank blank) {
        blanks.add(blank);
    }

    public List<TravelAdvisor> getAdvisors() {
        return advisors;
    }

    public void addAdvisor(TravelAdvisor advisor) {
        advisors.add(advisor);
    }
}
