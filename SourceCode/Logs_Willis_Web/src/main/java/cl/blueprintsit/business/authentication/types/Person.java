package cl.blueprintsit.business.authentication.types;

import cl.blueprintsit.business.authentication.RUT;

import java.util.List;

/**
 * Created by Ivan on 12-02-2015.
 */
public class Person {
    private String name;
    private String email;
    private RUT rut;
    private String username;
    private List<String> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RUT getRut() {
        return rut;
    }

    public void setRut(RUT rut) {
        this.rut = rut;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
