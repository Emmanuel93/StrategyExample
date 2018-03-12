
public abstract class AbstractDiscount implements DiscountBehaivor{

    protected Float discountRate;

    protected AbstractDiscount(Float discountRate){
        this.discountRate = discountRate;
    }

    public abstract void applyDiscount(Discountable sale);

}
