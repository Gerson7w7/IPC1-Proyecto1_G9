
package Objetos;

public class Usuario {
    private String usarname;
    private String password;

    public Usuario(String usarname, String password) {
        this.usarname = usarname;
        this.password = password;
    }

    public String getUsarname() {
        return usarname;
    }

    public void setUsarname(String usarname) {
        this.usarname = usarname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
       
}
