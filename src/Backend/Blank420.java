package Backend;

class Blank420 extends Blank {
    private FlightCoupon[] flightCoupons;

    public Blank420(String number) {
        super(number);
        this.flightCoupons = new FlightCoupon[2];
    }

    public void setFlightCoupon(int index, FlightCoupon flightCoupon) {
        this.flightCoupons[index] = flightCoupon;
    }

    public FlightCoupon[] getFlightCoupons() {
        return flightCoupons;
    }

    public String getType() {
        return "420";
    }
}
