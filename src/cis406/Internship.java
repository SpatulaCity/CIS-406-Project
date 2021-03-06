/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dean Sofer
 */
public class Internship {

    private int id;
    private int companyId;
    private int careerPathId;
    private String title;
    private String description;
    private Date postDate;
    private Date expiration;
    private int quantity;
    private String attachment;
    private String message = "";

    public Internship() {
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getCareerPathId() {
        return careerPathId;
    }

    public void setCareerPathId(int careerPathId) {
        this.careerPathId = careerPathId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiration() {
        return expiration.toString();
    }

    public boolean setExpiration(String expiration) {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        try {
            this.expiration = df.parse(expiration);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to convert the expiration date");
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostDate() {
        return postDate.toString();
    }

    public boolean setPostDate(String postDate) {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        try {
            this.postDate = df.parse(postDate);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to convert the post date");
            return false;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void save() {
        if (validateInternship()) {
            java.sql.Date sqlDate;
            Database db = new Database("internship");
            db.addField("title", title);
            // Add Attachment
            File attachmentFile = new File(attachment);
            //db.addField("attachment", attachmentFile);

            db.addField("company_id", companyId);
            db.addField("career_path_id", careerPathId);
            // Add date fields

            sqlDate = new java.sql.Date(postDate.getTime());
            db.addField("post_date", sqlDate);
            if (expiration != null) {
                sqlDate = new java.sql.Date(expiration.getTime());
                db.addField("expiration", sqlDate);
            }
            db.addField("description", description);
            db.addField("quantity", quantity);
            try {
                db.insert();
            } catch (Exception e) {
                System.out.println("Failed to add the internship");
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, message);
        }
    }

    /**
     * Populates a internships report table
     * @return
     */
    static public CisTable generateTable() {
        CisTable table = new CisTable("internship");
        table.setIdField("internship_id");
        return table.parseData();
    }

    /**
     * Validator method for intenship form fields
     * @return
     */
    public boolean validateInternship() {
        boolean validForm = true;
        if (title.isEmpty()) {
            message = message + "Please enter an Internship Title\n";
            validForm = false;
        }
        if (quantity <= 0) {
            message = message + "Please ensure that internship positions are 1 or more\n";
            validForm = false;
        }
        if (postDate.after(expiration)) {
            message = message + "Expiration date must be after post date\n";
            validForm = false;
        }


        return validForm;
    }
}
