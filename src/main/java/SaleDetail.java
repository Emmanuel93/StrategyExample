
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SaleDetail implements Discountable {

    private Product product;

    private Float quantity;

    private Float unitaryCost;

    private Float discount;

    private List<ProductTypeStrategy> discountB;

    public SaleDetail(Product product, Float quantity){
        this.product = product;
        this.quantity = quantity;
        this.unitaryCost = quantity * product.getPrice();
        discountB = new ArrayList<>();
    }

    public String toString(){
        return this.product + "->" + this.quantity +"->"+this.discount+"->"+this.unitaryCost;
    }


}
