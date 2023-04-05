package Backend;

class Blank101 extends Blank {
    private FlightCoupon flightCoupon;

    public Blank101(String number) {
        super(number);
    }

    public void setFlightCoupon(FlightCoupon flightCoupon) {
        this.flightCoupon = flightCoupon;
    }

    public FlightCoupon getFlightCoupon() {
        return flightCoupon;
    }

    public String getType() {
        return "101";
    }
}
