package Backend;

class Blank444 extends Blank {
    private FlightCoupon[] flightCoupons;

    public Blank444(String number) {
        super(number);
        this.flightCoupons = new FlightCoupon[4];
    }

    public void setFlightCoupon(int index, FlightCoupon flightCoupon) {
        this.flightCoupons[index] = flightCoupon;
    }

    public FlightCoupon[] getFlightCoupons() {
        return flightCoupons;
    }

    public String getType() {
        return "444";
    }
}