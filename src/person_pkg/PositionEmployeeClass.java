/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person_pkg;

/**
 *
 * @author ydhurtado
 */
public class PositionEmployeeClass {
    private String hierarchy_level;
    private String name_position;

    public String getHierarchy_level() {
        return hierarchy_level;
    }

    public void setHierarchy_level(String hierarchy_level) {
        this.hierarchy_level = hierarchy_level;
    }

    public String getName_position() {
        return name_position;
    }

    public void setName_position(String name_position) {
        this.name_position = name_position;
    }
    
    public void createPosition(String level, String name){
        this.setHierarchy_level(level);
        this.setName_position(name);
    }
    
    public String readPositions(int index){
        String positions = index + ". " + this.getName_position() + "\n";
        
        return positions;
    }
    
    public void updatePosition(int option, String value){
        switch (option) {
            case 1:
                this.setHierarchy_level(value);
                break;
            case 2:
                this.setName_position(value);
                break;
            default:
                throw new AssertionError();
        }
    }
}
