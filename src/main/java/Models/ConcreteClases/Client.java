package Models.ConcreteClases;

import lombok.Data;

@Data
public class Client {

    private String name;

    private String type;

    public Client(String name, String type){
        this.name = name;
        this.type = type;
    }
}
