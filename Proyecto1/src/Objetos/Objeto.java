
package Objetos;

public class Objeto {
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
