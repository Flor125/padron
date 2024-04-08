
package elecciones;
import Clases.conectar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Elecciones extends javax.swing.JFrame {
    public int votoRegistrado;
    
    private final Candidatos candidatosFrame;
    
    public Elecciones() {    
    initComponents();
    candidatosFrame = new Candidatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        textelecc = new javax.swing.JLabel();
        textpadron = new javax.swing.JLabel();
        consultelecc = new javax.swing.JButton();
        DNItext = new javax.swing.JLabel();
        textareaDNI = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        disabledshowlastname = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        disableshowname = new javax.swing.JTextPane();
        eleccsig = new javax.swing.JButton();

        jTextField3.setText("jTextField2");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textelecc.setText("Elecciones 2023");

        textpadron.setText("Consulta de Padrón");

        consultelecc.setText("Consultar");
        consultelecc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consulteleccActionPerformed(evt);
            }
        });

        DNItext.setText("DNI");

        textareaDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textareaDNIActionPerformed(evt);
            }
        });

        name.setText("Nombre");

        lastname.setText("Apellido");

        disabledshowlastname.setEditable(false);
        disabledshowlastname.setBackground(new java.awt.Color(204, 204, 204));
        disabledshowlastname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        disabledshowlastname.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(disabledshowlastname);

        disableshowname.setEditable(false);
        disableshowname.setBackground(new java.awt.Color(204, 204, 204));
        disableshowname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        disableshowname.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(disableshowname);

        eleccsig.setText("Siguiente");
        eleccsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eleccsigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(textelecc))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(textpadron)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastname)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(name)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(DNItext)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textareaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(consultelecc)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(eleccsig)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textareaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DNItext))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textelecc)
                        .addGap(18, 18, 18)
                        .addComponent(textpadron)
                        .addGap(18, 18, 18)
                        .addComponent(consultelecc)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastname)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(eleccsig)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textareaDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textareaDNIActionPerformed
        // TODO add your handling code here:
        consulteleccActionPerformed(evt);
    }//GEN-LAST:event_textareaDNIActionPerformed

    private void consulteleccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consulteleccActionPerformed
        // TODO add your handling code here:                                       
     try {
        String dniIngresado = textareaDNI.getText();
         try (Connection conn = conectar.getConnection()) {
             PreparedStatement ps = conn.prepareStatement("SELECT NOMBRE, APELLIDO, ESTADO_VOTACION FROM padron WHERE DNI = ?");
             ps.setString(1, dniIngresado);
             ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                 String nombreEncontrado = rs.getString("nombre");
                 String apellidoEncontrado = rs.getString("apellido");
                 disableshowname.setText(nombreEncontrado);
                 disabledshowlastname.setText(apellidoEncontrado);
             } else {
                 JOptionPane.showMessageDialog(null, "No se encontraron registros con el DNI ingresado.");
             }}
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
    }

    }//GEN-LAST:event_consulteleccActionPerformed

    private boolean votanteYaRegistrado(String dniVotante) {
    try (Connection conexion = conectar.getConnection()) {
        String sql = "SELECT ESTADO_VOTACION FROM padron WHERE DNI = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, dniVotante);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int estadoVotacion = resultSet.getInt("ESTADO_VOTACION");
                    return estadoVotacion > 0;
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al verificar si el votante ya ha votado: " + e.getMessage());
    }
    return false;
}

    private void eleccsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eleccsigActionPerformed
        // TODO add your handling code here:
         String dniIngresado = textareaDNI.getText();
        try {
            int dniVotante = Integer.parseInt(dniIngresado);
            if (votanteYaRegistrado(dniIngresado)) {
                JOptionPane.showMessageDialog(null, "Este votante ya ha emitido su voto.");
                Incidencia.registrarIncidencia("", "VOTANTE YA EMITIÖ SU VOTO");
                
            }else{
                Candidatos candidatosFr = new Candidatos(dniVotante);
                Incidencia.registrarIncidencia("", "DNI ENCONTRADO EN LA BASE DE DATOS");
                candidatosFr.setVisible(true);
                this.setVisible(false); 
            }
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresa un DNI válido.");
        }
    }//GEN-LAST:event_eleccsigActionPerformed
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Elecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new Elecciones().setVisible(true);
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DNItext;
    private javax.swing.JButton consultelecc;
    private javax.swing.JTextPane disabledshowlastname;
    private javax.swing.JTextPane disableshowname;
    private javax.swing.JButton eleccsig;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lastname;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JLabel name;
    private javax.swing.JTextField textareaDNI;
    private javax.swing.JLabel textelecc;
    private javax.swing.JLabel textpadron;
    // End of variables declaration//GEN-END:variables
}
