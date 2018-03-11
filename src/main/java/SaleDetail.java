package Models.ConcreteClases;

import lombok.Data;

@Data
public class SaleDetail {

    private Models.ConcreteClases.Product product;

    private Float quantity;

    private Float unitaryCost;

    private Float discount;

    public SaleDetail(Models.ConcreteClases.Product product, Float quantity ){
        this.product = product;
        this.quantity = quantity;
        this.unitaryCost = quantity * product.getPrice();
    }

    public String toString(){
        return this.product + "->" + this.quantity +"->"+ this.unitaryCost;
    }


}
