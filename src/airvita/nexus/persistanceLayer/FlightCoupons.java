package airvita.nexus.persistanceLayer;
import java.util.Date;

class FlightCoupon {
    private String origin;
    private String destination;
    private String flightNumber;
    private Date date;

    public FlightCoupon(String origin, String destination, String flightNumber, Date date) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Date getDate() {
        return date;
    }
}


