package Models.ConcreteClases;

import Models.Interfaces.DiscountBehaivor;
import lombok.Data;

import java.util.List;

@Data
public class Sale {

    private Client client;

    private List<SaleDetail> listOfProducts;

    private Float total;

    private Float subtotal;

    private Float tax=16.0F;

    private Float discount;

    private List<DiscountBehaivor> discounts;

    public Sale(Client client, List<SaleDetail> listOfProducts, List<DiscountBehaivor> discount){
        this.client = client;
        this.listOfProducts = listOfProducts;
        this.discounts =  discount;
        calculateSale();
    }

    public void applyDiscount(){
        discounts.stream().forEach(strategy -> {
            strategy.applyDiscount(this);
        });
    }

    public void calculateSale(){
        this.subtotal = Float.valueOf(String.valueOf(this.listOfProducts.stream()
                .mapToDouble(SaleDetail::getUnitaryCost)
                .sum()));

        this.total = subtotal* (1+(tax/100));
    }

    public String toString(){
        return this.subtotal+"->"+this.tax+"% ->"+this.total;
    }

}
