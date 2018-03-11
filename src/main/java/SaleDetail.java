
import lombok.Data;

@Data
public class SaleDetail {

    private Product product;

    private Float quantity;

    private Float unitaryCost;

    private Float discount;

    public SaleDetail(Product product, Float quantity ){
        this.product = product;
        this.quantity = quantity;
        this.unitaryCost = quantity * product.getPrice();
    }

    public String toString(){
        return this.product + "->" + this.quantity +"->"+ this.unitaryCost;
    }


}
