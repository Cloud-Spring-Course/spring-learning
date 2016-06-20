package spring.hometask.service.impl.discount;

import spring.hometask.domain.Event;
import spring.hometask.domain.User;
import spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    protected final List<DiscountStrategy> strategies;

    public DiscountServiceImpl(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public int getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, int numberOfTickets) {
        return strategies.stream()
                .mapToInt(strategy -> strategy.getDiscountPercent(user, numberOfTickets))
                .max()
                .getAsInt();
    }
}