package airvita.nexus.persistanceLayer;
import java.math.BigDecimal;
import java.util.*;

class TravelAdvisor {
    private String name;
    private List<Blank> blanks;

    public TravelAdvisor(String name) {
        this.name = name;
        this.blanks = new ArrayList<Blank>();
    }

    public String getName() {
        return name;
    }

    public List<Blank> getBlanks() {
        return blanks;
    }

    public void addBlank(Blank blank) {
        blanks.add(blank);
        blank.setAssigned(true);
    }

    public void removeBlank(Blank blank) {
        blanks.remove(blank);
        blank.setAssigned(false);
    }
}

// Class for a ticket sold by a travel advisor
class Ticket {
    private Blank blank;
    private List<FlightCoupon> flightCoupons;
    private List<AuditorCoupon> auditorCoupons;
    private BigDecimal fare;
    private BigDecimal commission;
    private PaymentType paymentType;
    private boolean refunded;

    public Ticket(Blank blank, List<FlightCoupon> flightCoupons, List<AuditorCoupon> auditorCoupons, BigDecimal fare, BigDecimal commission, PaymentType paymentType) {
        this.blank = blank;
        this.flightCoupons = flightCoupons;
        this.auditorCoupons = auditorCoupons;
        this.fare = fare;
        this.commission = commission;
        this.paymentType = paymentType;
        this.refunded = false;
    }

    public Blank getBlank() {
        return blank;
    }

    public List<FlightCoupon> getFlightCoupons() {
        return flightCoupons;
    }

    public List<AuditorCoupon> getAuditorCoupons() {
        return auditorCoupons;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }
}

// Enumeration of payment types
enum PaymentType {
    CASH,
    CREDIT_CARD,
    LOCAL_CURRENCY,
    USD
}
