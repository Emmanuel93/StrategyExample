
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MiTiendita {

    public MiTiendita(){
        ApplyVenta();
    }

    public void ApplyVenta(){

        Client client =  new Client("Emmanuel", "TERCERAEDAD");

        List<SaleDetail> productList = new ArrayList<>();
        Product leche = new Product("1lt de leche",30.0F,"LACTEO");
        Product crema = new Product("1kg Crema",25.5F,"LACTEO");
        Product mantequilla = new Product("1kg mantequilla",15.9F,"EMBUTIDO");
        Product queso = new Product("1kg de queso",60.0F,"LACTEO");
        Product platano = new Product("1kg platano macho",12.5F,"FRUTAS");
        Product manzana = new Product("1kg manzanas",32.5F,"FRUTAS");


        //(30*10)+(25.5*.5)+(.25*15.9)+(60*.5)+(12.5*1)+(2*32.5)
        //((30*10)+(25.5*.5)+(.25*15.9)+(60*.5)+(12.5*1)+(2*32.5))*1.16

        productList.add(new SaleDetail(leche,10F));
        productList.add(new SaleDetail(crema,0.5F));
        productList.add(new SaleDetail(mantequilla,0.25F));
        productList.add(new SaleDetail(queso,0.5F));
        productList.add(new SaleDetail(platano,1.0F));
        productList.add(new SaleDetail(manzana,2.0F));

        LocalDate date = LocalDate.now();
        DayOfWeek now = DayOfWeek.FRIDAY;

        Sale sale = new Sale(client,productList,getDiscountByDayOFWeek(client,now,productList));

    }

    public static List<ClientTypeStrategy> getDiscountByDayOFWeek(Client client, DayOfWeek now,
                                                                List<SaleDetail> products){
        ArrayList<ClientTypeStrategy> discounts = new ArrayList<>();

        switch (now.getValue()){
            case 1:
                if(client.getType().equals("TERCERAEDAD"))
                    discounts.add(new OldClientDiscountStrategy(5F));
                break;
            case 3:
                products.stream()
                        .forEach( product -> {
                            ArrayList<ProductTypeStrategy> discountsP = new ArrayList<>();

                            if(product.getProduct().getType().equals("LACTEO")){
                                discountsP.add(new DairyDiscountStrategy(10F));
                            }
                            product.setDiscountB( discountsP );
                        });
                break;
            case 4:
                products.stream()
                        .forEach( product -> {
                            ArrayList<ProductTypeStrategy> discountsP = new ArrayList<>();

                            if(product.getProduct().getType().equals("FRUTAS")){
                                discountsP.add(new FruitDiscountStrategy(15F));
                            }
                            product.setDiscountB( discountsP );
                        });
                break;
            case 5:
                products.stream()
                        .forEach( product -> {
                            ArrayList<ProductTypeStrategy> discountsP = new ArrayList<>();

                            if(product.getProduct().getType().equals("LACTEO")){
                                discountsP.add(new DairyDiscountStrategy(15F));
                            }

                            if (product.getProduct().getType().equals("EMBUTIDO")){
                                discountsP.add(new SausagesDiscountStrategy(5F));
                            }
                            product.setDiscountB( discountsP );
                        });
                break;
            case 7:
                if(client.getType().equals("TERCERAEDAD"))
                    discounts.add(new OldClientDiscountStrategy(5F));
            default:
                break;
        }

        return discounts;

    }
}
