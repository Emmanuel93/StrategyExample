package Models.abstractclasses;

import Models.interfaces.DiscountBehaivor;
import Models.interfaces.Discountable;

public abstract class AbstractDiscount implements DiscountBehaivor {

    protected Float discountRate;

    protected AbstractDiscount(Float discountRate){
        this.discountRate = discountRate;
    }

    public abstract void applyDiscount(Discountable sale);

}
