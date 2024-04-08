package Clases;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class conexion extends javax.swing.JFrame {

    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "";
    public static final String url = "jdbc:mysql://localhost:3308/padron";
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPartido;
    private javax.swing.JLabel labelLista;

    public conexion() {
        initComponents();
        this.setLocationRelativeTo(null); //Esto centra la pantalla
        
    }
    

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexión exitosa");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("error al conectar" + e);
            JOptionPane.showMessageDialog(null, "Conexión fallida, verifique");
        }
        return con;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jButton1)
                                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jButton1)
                                .addContainerGap(234, Short.MAX_VALUE))
        );

        pack();
    }
   public void setDniVotante(int dni) {
    
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         *
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new conexion().setVisible(true);
        });
        
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    // End of variables declaration                   
}