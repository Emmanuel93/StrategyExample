import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Sale implements Discountable {

    private Client client;

    private List<SaleDetail> listOfProducts;

    private Float total;

    private Float subtotal;

    private Float tax=16.0F;

    private Float discount;

    private List<ClientTypeStrategy> discounts;

    public Sale(Client client, List<SaleDetail> listOfProducts, List<ClientTypeStrategy> discount){
        this.client = client;
        this.listOfProducts = listOfProducts;
        this.discounts =  discount;
        applyDiscountOfProduct();
        calculateSale();
        applyDiscountOfSale();
    }

    public void applyDiscountOfSale(){

        discounts.stream()
            .forEach(strategy -> {
                strategy.applyDiscount(this);
         });

    }

    public  void applyDiscountOfProduct(){
        listOfProducts.stream()
                .forEach(product ->{
                    product.getDiscountB().stream()
                            .forEach( discount -> {
                                discount.applyDiscount(product);
                            });
                });
    }

    public void calculateSale(){
        this.subtotal = Float.valueOf(String.valueOf(this.listOfProducts.stream()
                .mapToDouble(SaleDetail::getUnitaryCost)
                .sum()));

        this.total = subtotal * (1+(tax/100));

    }

    public String toString(){
        String ticket="";
        ticket += this.subtotal+"->"+this.tax+"% ->"+this.total+"\n";

        ticket +=this.listOfProducts
                .stream()
                .map(SaleDetail::toString)
                .collect(Collectors.joining("\n"));

        return ticket;

    }

}
