package Backend.persistenceLayer;

public class FlightCoupon {

    private int couponId;
    private String couponFromAirport;
    private String couponToAirport;
    private int couponIsInterline;

    public FlightCoupon(String couponFromAirport, String couponToAirport, int couponIsInterline) {
        this.couponFromAirport = couponFromAirport;
        this.couponToAirport = couponToAirport;
        this.couponIsInterline = couponIsInterline;
    }

    public String getCouponFromAirport() {
        return couponFromAirport;
    }

    public void setCouponFromAirport(String couponFromAirport) {
        this.couponFromAirport = couponFromAirport;
    }

    public String getCouponToAirport() {
        return couponToAirport;
    }

    public void setCouponToAirport(String couponToAirport) {
        this.couponToAirport = couponToAirport;
    }

    public int getCouponIsInterline() {
        return couponIsInterline;
    }

    public void setCouponIsInterline(int couponIsInterline) {
        this.couponIsInterline = couponIsInterline;
    }

    @Override
    public String toString() {
        return "flightCoupon{" +
                "couponId=" + couponId +
                ", couponFromAirport='" + couponFromAirport + '\'' +
                ", couponToAirport='" + couponToAirport + '\'' +
                ", couponIsInterline=" + couponIsInterline +
                '}';
    }
}
