
public abstract class ProductTypeStrategy extends AbstractDiscount {

    protected ProductTypeStrategy(Float discountRate) {
        super(discountRate);
    }

    @Override
    public void applyDiscount(Sale sale) {
        sale.getListOfProducts()
                    .stream()
                    .forEach(saleDetail ->{
                        Float price = saleDetail.getProduct().getPrice();
                        Float quantity = saleDetail.getQuantity();
                        Float unitaryCost = price*quantity;
                        Float discount = unitaryCost * (this.discountRate/100);
                        saleDetail.setDiscount(discount);
                        Float total = unitaryCost-discount;
                        saleDetail.setUnitaryCost(total);
                    } );

        sale.calculateSale();
    }
}
