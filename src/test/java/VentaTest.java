import Models.concreteclasses.Client;
import Models.concreteclasses.Product;
import Models.concreteclasses.Sale;
import Models.concreteclasses.SaleDetail;
import bussinesrules.MiTiendita;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VentaTest {

    MiTiendita miTienda = new MiTiendita();

    Client client;

    List<SaleDetail> productList;

    public VentaTest(){
        this.client =  new Client("Emmanuel", "TERCERAEDAD");

        this.productList = new ArrayList<>();

        Product leche = new Product("1lt de leche",30.0F,"LACTEO");
        Product crema = new Product("1kg Crema",25.5F,"LACTEO");
        Product mantequilla = new Product("1kg mantequilla",15.9F,"EMBUTIDO");
        Product queso = new Product("1kg de queso",60.0F,"LACTEO");
        Product platano = new Product("1kg platano macho",12.5F,"FRUTAS");
        Product manzana = new Product("1kg manzanas",32.5F,"FRUTAS");

        this.productList.add(new SaleDetail(leche,10F));
        this.productList.add(new SaleDetail(crema,0.5F));
        this.productList.add(new SaleDetail(mantequilla,0.25F));
        this.productList.add(new SaleDetail(queso,0.5F));
        this.productList.add(new SaleDetail(platano,1.0F));
        this.productList.add(new SaleDetail(manzana,2.0F));
    }

    @Test
    public void generarVentaLunes(){

        DayOfWeek lunes = DayOfWeek.MONDAY;

        Sale sale = new Sale(client,productList);
        miTienda.setDiscountByDayOFWeek(sale,lunes);
        sale.calculateTotalOfSale();

        System.out.println(sale);
        assertEquals(467.49595,sale.getTotal(),0.01);
    }

    @Test
    public void generarVentaMartes(){

        DayOfWeek martes = DayOfWeek.TUESDAY;

        Sale sale = new Sale(client,productList);
        miTienda.setDiscountByDayOFWeek(sale,martes);
        sale.calculateTotalOfSale();

        System.out.println(sale);
        assertEquals(492.101,sale.getTotal(),0.1);

    }

    @Test
    public void generarVentaMiercoles(){

        DayOfWeek miercoles = DayOfWeek.WEDNESDAY;

        Sale sale = new Sale(client,productList);
        miTienda.setDiscountByDayOFWeek(sale,miercoles);
        sale.calculateTotalOfSale();
        System.out.println(sale);

        assertEquals(452.342,sale.getTotal(),0.1);

    }
    @Test
    public void generarVentaJueves(){

        DayOfWeek jueves = DayOfWeek.THURSDAY;

        Sale sale = new Sale(client,productList);
        miTienda.setDiscountByDayOFWeek(sale,jueves);
        sale.calculateTotalOfSale();
        System.out.println(sale);

        assertEquals(478.616,sale.getTotal(),0.1);

    }
    @Test
    public void generarVentaViernes(){

        DayOfWeek viernes = DayOfWeek.FRIDAY;

        Sale sale = new Sale(client,productList);
        miTienda.setDiscountByDayOFWeek(sale,viernes);
        sale.calculateTotalOfSale();
        System.out.println(sale);

        assertEquals(432.23195,sale.getTotal(),0.1);

    }
    @Test
    public void generarVentaSabado(){
        DayOfWeek sabado = DayOfWeek.SATURDAY;

        Sale sale = new Sale(client,productList);
        miTienda.setDiscountByDayOFWeek(sale,sabado);
        sale.calculateTotalOfSale();
        System.out.println(sale);

        assertEquals(492.101,sale.getTotal(),0.1);

    }
    @Test
    public void generarVentaDomingo(){

        DayOfWeek domingo = DayOfWeek.SUNDAY;

        Sale sale = new Sale(client,productList);
        miTienda.setDiscountByDayOFWeek(sale,domingo);
        sale.calculateTotalOfSale();
        System.out.println(sale);

        assertEquals(467.49595,sale.getTotal(),0.01);

    }
}
