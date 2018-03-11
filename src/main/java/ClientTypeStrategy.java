package Models.Stretegies;

import AbstractClasses.AbstractDiscount;
import Models.Sale;

public abstract class ClientTypeStrategy extends AbstractDiscount{

    protected ClientTypeStrategy(Float discountRate) {
        super(discountRate);
    }

    @Override
    public void applyDiscount(Sale sale) {
        Float discount = sale.getTotal() * this.discountRate;
        sale.setDiscount(discount);
        sale.calculateSale();

    }
}
