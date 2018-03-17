package Models.strategies;

import Models.abstractclasses.AbstractDiscount;
import Models.concreteclasses.SaleDetail;
import Models.interfaces.Discountable;

public abstract class ProductTypeStrategy extends AbstractDiscount {

    protected ProductTypeStrategy(Float discountRate) {
        super(discountRate);
    }

    @Override
    public void applyDiscount(Discountable discountable) {
        SaleDetail product = (SaleDetail)discountable;
        Float discount = product.getUnitaryCost() * (this.discountRate/100);
        product.setDiscount(discount);
        product.setUnitaryCost(product.getUnitaryCost() - discount);

    }
}
