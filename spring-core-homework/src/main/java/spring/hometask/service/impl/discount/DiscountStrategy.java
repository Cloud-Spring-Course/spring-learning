package spring.hometask.service.impl.discount;

import com.sun.istack.internal.NotNull;
import spring.hometask.domain.User;

public interface DiscountStrategy {

    int getDiscountPercent(@NotNull User user, int numberOfTickets);
}