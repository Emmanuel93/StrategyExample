package Models.strategies;

import Models.abstractclasses.AbstractDiscount;
import Models.concreteclasses.Sale;
import Models.interfaces.Discountable;

public abstract class ClientTypeStrategy extends AbstractDiscount {

    protected ClientTypeStrategy(Float discountRate) {
        super(discountRate);
    }

    @Override
    public void applyDiscount(Discountable discountable) {
        Sale sale = (Sale)discountable;
        Float discount = sale.getTotal() * (this.discountRate/100);
        sale.setDiscount(discount);
        sale.setTotal(sale.getTotal()-discount);

    }
}
