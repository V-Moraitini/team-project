package Backend;
import java.util.*;

abstract class Blank {
    private String number;
    private boolean assigned;

    public Blank(String number) {
        super();
        this.number = number;
        this.assigned = false;
    }

    public String getNumber() {
        return number;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public abstract String getType();
}

