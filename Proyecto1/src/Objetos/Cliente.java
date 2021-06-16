
package Objetos;

import java.io.Serializable;

public class Cliente extends Objeto implements Serializable{
    private String name;
    private String address;
    private int phone;
    private String nit;

    public Cliente(int id, String name, String address, int phone, String nit) {
        super(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente: " + name + "\r\nDirección: " + address 
                + "\r\nTeléfono: " + phone + "\r\nNit: " + nit + "\r\n";
    }
 
}
