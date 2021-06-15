
package Objetos;

public class Usuario {
    private String username;
    private String password;

    public Usuario(String usarname, String password) {
        this.username = usarname;
        this.password = password;
    }

    public String getUsarname() {
        return username;
    }

    public void setUsarname(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
       
}
