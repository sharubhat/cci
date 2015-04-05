package practicalunittesting;

/**
 * Created by sharath on 4/4/15.
 */
public class Money {
    private final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        if(amount < 0)
            throw new IllegalArgumentException("illegal amount: [" + amount + "]");
        if(currency == null || currency.isEmpty())
            throw new IllegalArgumentException("illegal currency [" + currency + "]");

        this.currency = currency;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Money) {
            Money that = (Money) obj;

            return that.getCurrency().equals(this.getCurrency())
                    && that.getAmount() == this.getAmount();
        }
        return false;
    }
}
