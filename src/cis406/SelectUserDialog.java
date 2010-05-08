/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectUserDialog.java
 *
 * Created on May 6, 2010, 6:37:43 PM
 */

package cis406;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.application.Action;

/**
 *
 * @author qwerty
 */
public class SelectUserDialog extends javax.swing.JDialog {

    /** Creates new form SelectUserDialog */
    public SelectUserDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("User ID");
        model.addColumn("Username");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        tblUsers.setModel(model);

        try {
            ResultSet rs = Database.execute("select * from user");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("user_id"), rs.getString("Username"), rs.getString("first_name"), rs.getString("last_name")});

            }

        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }
    }

    @Action public void closeAboutBox() {
        dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        tbnLoadUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User ID", "Username", "First Name", "Last Name"
            }
        ));
        tblUsers.setName("tblUsers"); // NOI18N
        jScrollPane1.setViewportView(tblUsers);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(SelectUserDialog.class);
        tblUsers.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblUsers.columnModel.title0")); // NOI18N
        tblUsers.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tblUsers.columnModel.title1")); // NOI18N
        tblUsers.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tblUsers.columnModel.title2")); // NOI18N
        tblUsers.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tblUsers.columnModel.title3")); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getActionMap(SelectUserDialog.class, this);
        tbnLoadUser.setAction(actionMap.get("closeAboutBox")); // NOI18N
        tbnLoadUser.setText(resourceMap.getString("tbnLoadUser.text")); // NOI18N
        tbnLoadUser.setName("tbnLoadUser"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addComponent(tbnLoadUser, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(tbnLoadUser)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectUserDialog dialog = new SelectUserDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);


            }
        });
    }

    public static String getValue() {
        SelectUserDialog userDialog = new SelectUserDialog(new javax.swing.JFrame(), true);
        userDialog.setVisible(true);
        return userDialog.getReturnValue();
    }

    private String getReturnValue() {
        return tblUsers.getValueAt(tblUsers.getSelectedRow(), 0).toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsers;
    private javax.swing.JButton tbnLoadUser;
    // End of variables declaration//GEN-END:variables

}
