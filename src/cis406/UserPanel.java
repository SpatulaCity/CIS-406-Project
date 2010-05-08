/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserTab.java
 *
 * Created on May 3, 2010, 3:15:24 PM
 */

package cis406;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author OK Computer
 */
public class UserPanel extends javax.swing.JPanel implements CisPanel{

    /** Creates new form UserTab */
    public UserPanel() {
        initComponents();
    }

    public void clickNew() {

    }

    public void clickSave() {
        User user = new User();

        user.setUserID(Integer.parseInt(txtUserID.getText()));
        user.setUsername(txtUsername.getText());
        user.setfName(txtFirstName.getText());
        user.setlName(txtLastName.getText());
        user.setPassword(txtPassword1.getText());
        user.setStatus(Integer.parseInt(txtStatus.getText()));
        user.setEmail(txtEmail.getText());

        AddUpdateDelete.updateUser(user);


        String firstPassword = txtPassword1.getText();
        String secondPassword = txtPassword2.getText();

        if (firstPassword.equals(secondPassword)){
            // Make sure password meets requirements
            String lowercase = "((?=.*[a-z]).{8,})";
            String uppercase = "((?=.*[A-Z]).{8,})";
            String numbers = "((?=.*\\d).{8,})";
            String complexchars = "((?=.*[\\s.,?!:;()\\[\\]{}<>/|\\\\+-=*@#$%&_~'^\"]).{8,})";
            Integer complexityCount = 0;

            if (txtPassword1.getText().matches(lowercase)) { complexityCount++; }
            if (txtPassword1.getText().matches(uppercase)) { complexityCount++; }
            if (txtPassword1.getText().matches(numbers)) { complexityCount++; }
            if (txtPassword1.getText().matches(complexchars)) { complexityCount++; }

            if (complexityCount < 3)
            {
                    JOptionPane.showMessageDialog(null, "Change your password, it doesn't meet CSU Pomona's password complexity requirements");
            }
            else{
                user.username = txtUsername.getText();
                user.fName = txtFirstName.getText();
                user.lName = txtLastName.getText();
                user.password = firstPassword;
                user.status = Integer.parseInt(txtStatus.getText());
                user.email = txtEmail.getText();

                AddUpdateDelete.updateUser(user);
            }
        }
    }

    public void clickLoad() {
        String userID = SelectUserDialog.getValue();

        if (Integer.parseInt(userID) > -1) {
            try {
                ResultSet rs = Database.execute("select * from user where user_id = '" + userID + "'");
                while (rs.next()) {
                    txtUserID.setText(rs.getString("user_id"));
                    txtUsername.setText(rs.getString("username"));
                    txtFirstName.setText(rs.getString("first_name"));
                    txtLastName.setText(rs.getString("last_name"));
                    txtEmail.setText(rs.getString("email"));
                    txtStatus.setText(rs.getString("status"));
                    ddlSecurityLevel.setSelectedIndex(Integer.parseInt(rs.getString("clearance")));
                    //txtPassword.setText(rs.getString("password"));
                }

            } catch (Exception e) {
                System.out.println("Could not execute query");
                System.out.println(e.getMessage());
            }
        }

    }

    public void clickDelete() {

    }

    public void clickClear() {

    }

    public void clickReport() {

    }

    public void clickForm() {

    }

    public void switchTo(javax.swing.ButtonGroup activeView) {

    }

    public void switchAway() {

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfPass = new javax.swing.JLabel();
        ddlSecurityLevel = new javax.swing.JComboBox();
        lblSecurityLevel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword1 = new javax.swing.JTextField();
        txtPassword2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ddlSecurityQuestions = new javax.swing.JComboBox();
        txtAnswer = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(UserPanel.class);
        txtFirstName.setText(resourceMap.getString("txtFirstName.text")); // NOI18N
        txtFirstName.setName("txtFirstName"); // NOI18N

        txtLastName.setText(resourceMap.getString("txtLastName.text")); // NOI18N
        txtLastName.setName("txtLastName"); // NOI18N

        usernameLabel.setText(resourceMap.getString("usernameLabel.text")); // NOI18N
        usernameLabel.setName("usernameLabel"); // NOI18N

        lblFirstName.setText(resourceMap.getString("lblFirstName.text")); // NOI18N
        lblFirstName.setName("lblFirstName"); // NOI18N

        lblLastName.setText(resourceMap.getString("lblLastName.text")); // NOI18N
        lblLastName.setName("lblLastName"); // NOI18N

        txtUsername.setText(resourceMap.getString("txtUsername.text")); // NOI18N
        txtUsername.setName("txtUsername"); // NOI18N

        lblEmail.setText(resourceMap.getString("lblEmail.text")); // NOI18N
        lblEmail.setName("lblEmail"); // NOI18N

        lblPassword.setText(resourceMap.getString("lblPassword.text")); // NOI18N
        lblPassword.setName("lblPassword"); // NOI18N

        lblConfPass.setText(resourceMap.getString("lblConfPass.text")); // NOI18N
        lblConfPass.setName("lblConfPass"); // NOI18N

        ddlSecurityLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Coordinator", "Assistant" }));
        ddlSecurityLevel.setName("ddlSecurityLevel"); // NOI18N

        lblSecurityLevel.setText(resourceMap.getString("lblSecurityLevel.text")); // NOI18N
        lblSecurityLevel.setName("lblSecurityLevel"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        txtStatus.setText(resourceMap.getString("txtStatus.text")); // NOI18N
        txtStatus.setName("txtStatus"); // NOI18N

        txtEmail.setText(resourceMap.getString("txtEmail.text")); // NOI18N
        txtEmail.setName("txtEmail"); // NOI18N

        txtPassword1.setText(resourceMap.getString("txtPassword1.text")); // NOI18N
        txtPassword1.setName("txtPassword1"); // NOI18N

        txtPassword2.setText(resourceMap.getString("txtPassword2.text")); // NOI18N
        txtPassword2.setName("txtPassword2"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        ddlSecurityQuestions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What city were you born in?", "What year did you graduate high school?" }));
        ddlSecurityQuestions.setName("ddlSecurityQuestions"); // NOI18N

        txtAnswer.setText(resourceMap.getString("txtAnswer.text")); // NOI18N
        txtAnswer.setName("txtAnswer"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        txtUserID.setEditable(false);
        txtUserID.setText(resourceMap.getString("txtUserID.text")); // NOI18N
        txtUserID.setName("txtUserID"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblConfPass)
                            .addComponent(lblPassword)
                            .addComponent(lblFirstName)
                            .addComponent(usernameLabel)
                            .addComponent(lblLastName)
                            .addComponent(lblEmail)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserID)
                            .addComponent(txtPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(txtFirstName)
                            .addComponent(txtLastName)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtPassword1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(lblSecurityLevel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStatus)
                            .addComponent(ddlSecurityLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel10))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAnswer)
                            .addComponent(ddlSecurityQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfPass)
                    .addComponent(txtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddlSecurityLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSecurityLevel))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddlSecurityQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ddlSecurityLevel;
    private javax.swing.JComboBox ddlSecurityQuestions;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblConfPass;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSecurityLevel;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword1;
    private javax.swing.JTextField txtPassword2;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

}
