
package Objetos;

import java.io.Serializable;

public class Objeto implements Serializable{
    protected int id;

    public Objeto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\r\n";
    }
     
}
