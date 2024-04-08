package elecciones;
import java.sql.Connection;
import Clases.conectar;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Login extends javax.swing.JFrame {
    private static boolean votacionesCerradas = false;

    public Login() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ButtonLogin = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        CierreVot = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingreso");

        jLabel2.setText("Usuario");

        usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });

        jLabel3.setText("Contrasela");

        ButtonLogin.setText("Ingresar");
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        CierreVot.setText("Cierre");
        CierreVot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CierreVotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usertext, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(jPasswordField1)))
                            .addComponent(CierreVot)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ButtonLogin)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLogin)
                    .addComponent(CierreVot))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
    String user = usertext.getText();
    String paswd = String.valueOf(jPasswordField1.getPassword());

    if (user.isEmpty() || paswd.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Complete los campos solicitados.");
        return;
    }

    String sqlEstadoMesa = "SELECT CIERREMESA FROM acceso_presidentemesa WHERE USUARIO = ?";
    String sql = "SELECT * FROM acceso_presidentemesa WHERE USUARIO = ? AND PASS = ?";

    try (Connection conexion = conectar.getConnection()) {
        try (PreparedStatement preparedStatementCierreCheck = conexion.prepareStatement(sqlEstadoMesa)) {
            preparedStatementCierreCheck.setString(1, user);
            ResultSet resultSet = preparedStatementCierreCheck.executeQuery();

            if (resultSet.next() && resultSet.getInt("CIERREMESA") == 1) {
                JOptionPane.showMessageDialog(this, "Cierre de mesa - no puede ingresar");
                return; // CIERREMESA = 1 indica que la mesa ya está cerrada.
            }
        }
        LocalTime now = LocalTime.now();
        if (now.isBefore(LocalTime.of(8, 0)) || now.isAfter(LocalTime.of(18, 0))) {
            JOptionPane.showMessageDialog(this, "El tiempo de votación ha finalizado.");
            System.exit(0);
        }

        // Proceso de autenticación y acceso
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, paswd);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if(resultSet.getBoolean("ACCESO")) {
                    JOptionPane.showMessageDialog(null, "Usted ya ha ingresado.");
                    System.exit(0);
                } else {
                    String sqlIngreso = "UPDATE acceso_presidentemesa SET ACCESO = 1, APERTURAREAL = NOW() WHERE USUARIO = ?";
                    try (PreparedStatement preparedStatementIngreso = conexion.prepareStatement(sqlIngreso)) {
                        preparedStatementIngreso.setString(1, user);
                        preparedStatementIngreso.executeUpdate();
                    }

                    JOptionPane.showMessageDialog(this, "Ingreso Exitoso");
                    Incidencia.registrarIncidencia(user, "INGRESO AL SISTEMA");

                    Elecciones elecciones = new Elecciones();
                    elecciones.setVisible(true);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
                Incidencia.registrarIncidencia(user, "CREDENCIALES INCORRECTAS.");
                System.exit(0);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
        Incidencia.registrarIncidencia(user, "ERROR AL CONECTAR CON LA BASE DE DATOS.");
    }
    }//GEN-LAST:event_ButtonLoginActionPerfo

   private void cerrarVotaciones() {
    String sqlCierreCombinado = "UPDATE acceso_presidentemesa SET HORACIERRE = NOW(), CIERREMESA = 1";
    
    try (Connection conexion = conectar.getConnection()) {
        conexion.setAutoCommit(false);
        try {
            try (PreparedStatement preparedStatementCierre = conexion.prepareStatement(sqlCierreCombinado)) {
                preparedStatementCierre.executeUpdate();
            }
            conexion.commit();
            
            Incidencia.registrarIncidencia("", "CIERRE DE MESA EXITOSO");
            JOptionPane.showMessageDialog(this, "Cierre de votaciones exitoso.");
        } catch (SQLException e) {
            conexion.rollback();
            JOptionPane.showMessageDialog(this, "Error durante el proceso de cierre de mesa: " + e.getMessage());
            Incidencia.registrarIncidencia("", "ERROR DURANTE CIERRE DE MESA");
        } finally {
            conexion.setAutoCommit(true);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cerrar votaciones: " + e.getMessage());
        Incidencia.registrarIncidencia("", "ERROR AL CERRAR VOTACIONES");
    }
}

private void mostrarEstadisticas() {
    String sqlEstadisticas = "SELECT candidato, COUNT(*) as votos FROM votacion GROUP BY candidato";
    String user = usertext.getText();

    try (Connection conexion = conectar.getConnection();
         PreparedStatement preparedStatementEstadisticas = conexion.prepareStatement(sqlEstadisticas);
         PreparedStatement preparedStatementTotal = conexion.prepareStatement("SELECT COUNT(*) as total FROM votacion")) {

        ResultSet resultSetTotal = preparedStatementTotal.executeQuery();
        resultSetTotal.next(); 
        int totalVotos = resultSetTotal.getInt("total");

        ResultSet resultSet = preparedStatementEstadisticas.executeQuery();
        StringBuilder estadisticas = new StringBuilder("Datos finales: \n");
        ArrayList<String> candidatosGanadores = new ArrayList<>();
        int votosGanador = 0;

        while (resultSet.next()) {
            String candidato = resultSet.getString("candidato");
            int votosRecibidos = resultSet.getInt("votos");
            double porcentaje = (votosRecibidos * 100.0) / totalVotos;

            estadisticas.append(candidato).append(": ").append(votosRecibidos).append(" votos (").append(String.format("%.2f", porcentaje)).append("%)\n");
            
            if (votosRecibidos > votosGanador) {
                votosGanador = votosRecibidos;
                candidatosGanadores.clear();
                candidatosGanadores.add(candidato);
            } else if (votosRecibidos == votosGanador) {
                candidatosGanadores.add(candidato);
            }
        }
        
        if (!candidatosGanadores.isEmpty()) {
            if (candidatosGanadores.size() == 1) {
                estadisticas.append("Ganando: ").append(candidatosGanadores.get(0)).append(" con ").append(String.format("%.2f%%", (votosGanador * 100.0) / totalVotos)).append(" de los votos");
            } else {
                estadisticas.append("Ballotage entre: ");
                for (int i = 0; i < candidatosGanadores.size(); i++) {
                    estadisticas.append(candidatosGanadores.get(i));
                    if (i < candidatosGanadores.size() - 1) {
                        estadisticas.append(" y ");
                    }
                }
                estadisticas.append(".\n  Todos con ").append(votosGanador).append(" votos (").append(String.format("%.2f%%", (votosGanador * 100.0) / totalVotos)).append(" de los votos)");
            }
        }

        JOptionPane.showMessageDialog(this, estadisticas.toString());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al obtener estadísticas: " + e.getMessage());
        Incidencia.registrarIncidencia(user, "ERROR AL OBTENER ESTADÍSTICAS");
    }
}

    private void usertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertextActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_usertextActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void CierreVotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CierreVotActionPerformed
     votacionesCerradas = true;
    cerrarVotaciones();  // Cierra las votaciones actualizando la base de datos
    mostrarEstadisticas();  // Muestra las estadísticas de las votaciones

    // Registra la acción de mostrar estadísticas con el usuario adecuado
    String user = usertext.getText(); // Asume que usertext es el campo de texto del usuario
    Incidencia.registrarIncidencia(user, "MUESTRA LAS ESTADISTICAS");
    System.exit(0);
    }//GEN-LAST:event_CierreVotActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new Login().setVisible(true);
                Login ventanaLogin = new Login();
                if (votacionesCerradas) {
                ventanaLogin.mostrarEstadisticas();
                System.exit(0); 
                } else {
                ventanaLogin.setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton CierreVot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField usertext;
    // End of variables declaration//GEN-END:variables
}
