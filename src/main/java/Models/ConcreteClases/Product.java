package Models.ConcreteClases;


import lombok.Data;

@Data
public class Product {

    private String name;

    private Float price;

    private String type;

    public Product(String name,Float price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String toString(){
        return this.name+"->"+this.type+"->"+this.price;
    }


}
