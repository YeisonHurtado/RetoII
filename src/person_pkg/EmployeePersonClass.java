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
public class EmployeePersonClass extends PersonClass{
    
    private int salary;
    private PositionEmployeeClass position;
    
    public EmployeePersonClass(String name, String last_name, int id, String email) {
        super(name, last_name, id, email);
    }
    
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
            
    public String getEmployee(int idEmployee){
        String message = "No hay ningún empleado con ese id.";
        if (readPerson(idEmployee) != null) {
            String header = StylesInterface.ANSI_GREEN + "\n*****" + StylesInterface.ANSI_RESET + "Datos del empleado" + StylesInterface.ANSI_GREEN + "*****" + StylesInterface.ANSI_RESET ;
            message = header + readPerson(idEmployee) 
                    + StylesInterface.ANSI_GREEN +  "\nSalario: " + StylesInterface.ANSI_RESET + this.getSalary()
                    + StylesInterface.ANSI_GREEN +  "\nCargo: " + StylesInterface.ANSI_RESET + this.getPosition().getName_position();
        }
        return message;
    }

    public PositionEmployeeClass getPosition() {
        return position;
    }

    public void setPosition(PositionEmployeeClass position) {
        this.position = position;
    }
}
