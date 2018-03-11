package BussinesRules;

import Models.ConcreteClases.Client;
import Models.ConcreteClases.Product;
import Models.ConcreteClases.Sale;
import Models.ConcreteClases.SaleDetail;
import Models.Interfaces.DiscountBehaivor;
import Models.Stretegies.DairyDiscountStrategy;
import Models.Stretegies.FruitDiscountStrategy;
import Models.Stretegies.OldClientDiscountStrategy;
import Models.Stretegies.SausagesDiscountStrategy;

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

        productList.add(new SaleDetail(leche,10F));
        productList.add(new SaleDetail(leche,0.5F));
        productList.add(new SaleDetail(leche,0.25F));
        productList.add(new SaleDetail(leche,0.5F));
        productList.add(new SaleDetail(leche,1.0F));
        productList.add(new SaleDetail(leche,2.0F));

        LocalDate date = LocalDate.now();
        DayOfWeek now = date.getDayOfWeek();

        Sale sale = new Sale(client,productList,getDiscountByDayOFWeek(now));

    }

    public static List<DiscountBehaivor> getDiscountByDayOFWeek(DayOfWeek now){
        ArrayList<DiscountBehaivor> discounts = new ArrayList<>();

        switch (now.getValue()){
            case 1:
                discounts.add(new OldClientDiscountStrategy(5F));
                break;
            case 3:
                discounts.add(new DairyDiscountStrategy(10F));
                break;
            case 4:
                discounts.add(new FruitDiscountStrategy(15F));
                break;
            case 5:
                discounts.add(new SausagesDiscountStrategy(5F));
                discounts.add(new DairyDiscountStrategy(15F));
                break;
            case 7:
                discounts.add(new OldClientDiscountStrategy(5F));
            default:
                break;
        }

        return discounts;

    }
}
