/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

/**
 *
 * @author Mark Lenser
 */
public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Saves the company and returns the created id
     * @return newId if set to 0, save failed.
     */
    public int save() {
        int newId = 0;
        Database db = new Database("company");
        db.addField("name", name);
        try {
            newId = db.insert();
        } catch (Exception e) {
            System.out.println("Failed to add the company");
            System.out.println(e.getMessage());
        }
        return newId;
    }
}
