package spring.hometask.service.impl.discount;

import spring.hometask.domain.User;

import java.time.LocalDate;

public class BirthdayDiscountStrategy implements DiscountStrategy {

    protected final int discount;
    protected final int daysWindow;

    public BirthdayDiscountStrategy(int discount, int daysWindow) {
        this.discount = discount;
        this.daysWindow = daysWindow;
    }

    @Override
    public int getDiscountPercent(User user, int numberOfTickets) {
        // 5% discount if user has a birthday within 5 days of air date
        LocalDate currentYearUserBirthday = user.getBirthday().withYear(LocalDate.now().getYear());

        LocalDate fiveDaysInPast = user.getBirthday().minusDays(daysWindow);
        LocalDate fiveDaysInFuture = user.getBirthday().plusDays(daysWindow);

        if (currentYearUserBirthday.isAfter(fiveDaysInPast) && currentYearUserBirthday.isBefore(fiveDaysInFuture)) {
            return discount;
        }

        return 0;
    }
}