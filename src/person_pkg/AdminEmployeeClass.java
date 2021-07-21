package person_pkg;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ydhurtado
 */
public class AdminEmployeeClass extends EmployeePersonClass{
    private String category;
    private int num_subordinates;
    private ArrayList<EmployeePersonClass> subordinates;
    
    public AdminEmployeeClass(String name, String last_name, int id, String email) {
        super(name, last_name, id, email);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNum_subordinates() {
        return num_subordinates;
    }

    public void setNum_subordinates(int num_subordinates) {
        this.num_subordinates = num_subordinates;
    }

    public ArrayList<EmployeePersonClass> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(ArrayList<EmployeePersonClass> subordinates) {
        this.subordinates = subordinates;
    }
   
}
