package Backend;
import java.math.BigDecimal;
import java.util.*;

class CommissionRate {
    private String ticketType;
    private BigDecimal rate;

    public CommissionRate(String ticketType, BigDecimal rate) {
        this.ticketType = ticketType;
        this.rate = rate;
    }

    public String getTicketType() {
        return ticketType;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
