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
public class ClientPersonClass extends PersonClass{
    public ClientPersonClass(String name, String last_name, int id, String email) {
        super(name, last_name, id, email);
    }
    
    public String getClient(int idClient){
        String message = "No hay ningún cliente con ese id.";
        if (readPerson(idClient) != null) {
            String header = StylesInterface.ANSI_GREEN + "\n*****" + StylesInterface.ANSI_RESET + "Datos del cliente" + StylesInterface.ANSI_GREEN + "*****" + StylesInterface.ANSI_RESET ;
            message = header + readPerson(idClient);
        }
        return message;
    }
}
