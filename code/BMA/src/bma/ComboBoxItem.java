/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bma;

/**
 *
 * @author 
 */
public class ComboBoxItem {
    private int id;
    private String description;

    public ComboBoxItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
    
    @Override
    public boolean equals(Object object) {
        return id == ((ComboBoxItem)object).getId();
    }
}
