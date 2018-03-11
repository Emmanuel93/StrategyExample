import BussinesRules.MiTiendita;
import Models.ConcreteClases.Client;
import Models.ConcreteClases.Product;
import Models.Sale;
import Models.ConcreteClases.SaleDetail;
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
        this.productList.add(new SaleDetail(leche,0.5F));
        this.productList.add(new SaleDetail(leche,0.25F));
        this.productList.add(new SaleDetail(leche,0.5F));
        this.productList.add(new SaleDetail(leche,1.0F));
        this.productList.add(new SaleDetail(leche,2.0F));
    }

    @Test
    public void generarVentaLunes(){

        DayOfWeek lunes = DayOfWeek.MONDAY;

        Sale sale = new Sale(client,productList,miTienda.getDiscountByDayOFWeek(lunes));

        assertEquals(495.9,sale.getTotal(),0.1);
    }

    @Test
    public void generarVentaMartes(){

        DayOfWeek martes = DayOfWeek.TUESDAY;

        Sale sale = new Sale(client,productList,miTienda.getDiscountByDayOFWeek(martes));

        assertEquals(495.9,sale.getTotal(),0.1);

    }

    @Test
    public void generarVentaMiercoles(){

        DayOfWeek miercoles = DayOfWeek.WEDNESDAY;

        Sale sale = new Sale(client,productList,miTienda.getDiscountByDayOFWeek(miercoles));

        assertEquals(446.3,sale.getTotal(),0.1);

    }
    @Test
    public void generarVentaJueves(){

        DayOfWeek jueves = DayOfWeek.THURSDAY;

        Sale sale = new Sale(client,productList,miTienda.getDiscountByDayOFWeek(jueves));

        assertEquals(421.51,sale.getTotal(),0.1);

    }
    @Test
    public void generarVentaViernes(){

        DayOfWeek viernes = DayOfWeek.FRIDAY;

        Sale sale = new Sale(client,productList,miTienda.getDiscountByDayOFWeek(viernes));

        assertEquals(421.51,sale.getTotal(),0.1);

    }
    @Test
    public void generarVentaSabado(){
        DayOfWeek sabado = DayOfWeek.SATURDAY;

        Sale sale = new Sale(client,productList,miTienda.getDiscountByDayOFWeek(sabado));

        assertEquals(495.9,sale.getTotal(),0.1);

    }
    @Test
    public void generarVentaDomingo(){

        DayOfWeek martes = DayOfWeek.SUNDAY;

        Sale sale = new Sale(client,productList,miTienda.getDiscountByDayOFWeek(martes));

        assertEquals(495.9,sale.getTotal(),0.1);

    }
}
