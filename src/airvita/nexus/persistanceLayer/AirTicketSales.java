package airvita.nexus.persistanceLayer;
import java.math.BigDecimal;
import java.util.*;

class AirTicketSales {
    private List<Ticket> tickets;
    private List<CommissionRate> commissionRates;
    private Map<String, BigDecimal> exchangeRates;

    public AirTicketSales() {
        this.tickets = new ArrayList<Ticket>();
        this.commissionRates = new ArrayList<CommissionRate>();
        this.exchangeRates = new HashMap<String, BigDecimal>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
    public void sellTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void refundTicket(Ticket ticket) {
        ticket.setRefunded(true);
    }

    public List<CommissionRate> getCommissionRates() {
        return commissionRates;
    }

    public void addCommissionRate(CommissionRate commissionRate) {
        commissionRates.add(commissionRate);
    }

    public void removeCommissionRate(CommissionRate commissionRate) {
        commissionRates.remove(commissionRate);
    }

    public Map<String, BigDecimal> getExchangeRates() {
        return exchangeRates;
    }

    public void addExchangeRate(String currencyCode, BigDecimal exchangeRate) {
        exchangeRates.put(currencyCode, exchangeRate);
    }

    public void removeExchangeRate(String currencyCode) {
        exchangeRates.remove(currencyCode);
    }
}

