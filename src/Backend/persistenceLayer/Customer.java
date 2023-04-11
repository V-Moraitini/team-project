package Backend.persistenceLayer;

public class Customer {

    private int customerID;
    private String customerName;
    private String customerAlias;
    private String customerEmail;
    private int customerPhone;
    private Boolean customerIsValued;
    private float customerFixedDiscountPercentage;

    public Customer(String customerName, String customerAlias, String customerEmail, int customerPhone, Boolean customerIsValued, float customerFixedDiscountPercentage) {
        this.customerName = customerName;
        this.customerAlias = customerAlias;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerIsValued = customerIsValued;
        this.customerFixedDiscountPercentage = customerFixedDiscountPercentage;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAlias() {
        return customerAlias;
    }

    public void setCustomerAlias(String customerAlias) {
        this.customerAlias = customerAlias;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Boolean getCustomerIsValued() {
        return customerIsValued;
    }

    public void setCustomerIsValued(Boolean customerIsValued) {
        this.customerIsValued = customerIsValued;
    }

    public float getCustomerFixedDiscountPercentage() {
        return customerFixedDiscountPercentage;
    }

    public void setCustomerFixedDiscountPercentage(float customerFixedDiscountPercentage) {
        this.customerFixedDiscountPercentage = customerFixedDiscountPercentage;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone=" + customerPhone +
                ", customerIsValued=" + customerIsValued +
                ", customerFixedDiscountPercentage=" + customerFixedDiscountPercentage +
                '}';
    }
}
