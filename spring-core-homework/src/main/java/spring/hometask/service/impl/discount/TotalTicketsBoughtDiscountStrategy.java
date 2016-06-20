package spring.hometask.service.impl.discount;

import spring.hometask.domain.User;

public class TotalTicketsBoughtDiscountStrategy implements DiscountStrategy {

    protected final int totalTickets;
    protected final int discount;

    public TotalTicketsBoughtDiscountStrategy(int totalTickets, int discount) {
        this.totalTickets = totalTickets;
        this.discount = discount;
    }

    @Override
    public int getDiscountPercent(User user, int numberOfTickets) {
        int ticketsBought = user.getTickets().size() + numberOfTickets;

        if (ticketsBought >= totalTickets) {
            return discount;
        }

        return 0;
    }
}