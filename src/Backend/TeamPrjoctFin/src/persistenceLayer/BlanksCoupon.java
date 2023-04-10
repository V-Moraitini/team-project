package persistenceLayer;

public class BlanksCoupon {

    private int blankscouponId;
    private int blankscouponBlankId;
    private int blankscouponCouponId;

    public BlanksCoupon(int blankscouponBlankId, int blankscouponCouponId) {
        this.blankscouponBlankId = blankscouponBlankId;
        this.blankscouponCouponId = blankscouponCouponId;
    }

    public int getBlankscouponBlankId() {
        return blankscouponBlankId;
    }

    public void setBlankscouponBlankId(int blankscouponBlankId) {
        this.blankscouponBlankId = blankscouponBlankId;
    }

    public int getBlankscouponCouponId() {
        return blankscouponCouponId;
    }

    public void setBlankscouponCouponId(int blankscouponCouponId) {
        this.blankscouponCouponId = blankscouponCouponId;
    }

    @Override
    public String toString() {
        return "BlanksCoupon{" +
                "blankscouponId=" + blankscouponId +
                ", blankscouponBlankId=" + blankscouponBlankId +
                ", blankscouponCouponId=" + blankscouponCouponId +
                '}';
    }
}
