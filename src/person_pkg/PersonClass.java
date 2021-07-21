/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person_pkg;

import styles.StylesInterface;
/**
 *
 * @author ydhurtado
 */
public class PersonClass {
    private String name;
    private String last_name;
    private int id;
    private String email;

    public PersonClass(String name, String last_name, int id, String email) {
        this.name = name;
        this.last_name = last_name;
        this.id = id;
        this.email = email;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String readPerson(int id){
        String message = null;
        if (id == getId()) {
            message = StylesInterface.ANSI_GREEN + "\nNombre: " + StylesInterface.ANSI_RESET +  this.getName() + " " + this.getLast_name() 
                    + StylesInterface.ANSI_GREEN + "\nNro. documento: " + StylesInterface.ANSI_RESET + this.getId()
                    + StylesInterface.ANSI_GREEN + "\nCorreo: " + StylesInterface.ANSI_RESET + this.getEmail();
        }
        
        return message;
    }
}
