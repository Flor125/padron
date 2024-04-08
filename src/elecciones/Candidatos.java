package elecciones;

import Clases.conectar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.net.InetAddress;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Candidatos extends javax.swing.JFrame {
    private static conectar con;
    private static final long serialVersionUID = 1L; 
    ButtonGroup grupoBotones = new ButtonGroup(); 
    private String candidatoSeleccionado;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPartido;
    private javax.swing.JLabel labelLista;
    public int dniVotante;
    public int idVotante;
    private String dniIngresado;
    
    private boolean isInternetConnected() {
    try {
        InetAddress address = InetAddress.getByName("www.google.com"); // Intenta conectarse a Google
        return address.isReachable(1000); // Tiempo de espera en milisegundos
    } catch (IOException e) {
        return false; // Si no se puede conectar, considera que no hay conexión a Internet
    }
}
    
     public int convertirDNANumero(String dni) {
    try {
        
        return Integer.parseInt(dni);
    } catch (NumberFormatException e) {
        return -1; // Valor inválido
    }
}
    
    public Candidatos(int dni) {
        initComponents();
        inicializarComponentesPersonalizados();
        this.dniVotante = dni;
        this.dniIngresado = String.valueOf(dni);
    }
    public Candidatos() {
        initComponents();
        inicializarComponentesPersonalizados();
    }
    private void inicializarComponentesPersonalizados() {
        grupoBotones = new ButtonGroup();
        grupoBotones.add(jRadioButton1);
        grupoBotones.add(jRadioButton2);
        grupoBotones.add(jRadioButton3);
        grupoBotones.add(jRadioButton4);
        grupoBotones.add(jRadioButton5);
        grupoBotones.add(jRadioButton6);

        labelNombre = new javax.swing.JLabel();
        labelPartido = new javax.swing.JLabel();
        labelLista = new javax.swing.JLabel();
        
        // Agrega un listener común a todos los radio buttons.
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JRadioButton radioButton = (JRadioButton) actionEvent.getSource();
                int partidoId = Integer.parseInt(radioButton.getActionCommand());
                cargarDatosCandidato(partidoId);
            }
        };
        
        jRadioButton1.setActionCommand("1");
        jRadioButton2.setActionCommand("2");
        jRadioButton3.setActionCommand("3");
        jRadioButton4.setActionCommand("4");
        jRadioButton5.setActionCommand("5");
        jRadioButton6.setActionCommand("6");
        
        jRadioButton1.addActionListener(actionListener);
        jRadioButton2.addActionListener(actionListener);
        jRadioButton3.addActionListener(actionListener);
        jRadioButton4.addActionListener(actionListener);
        jRadioButton5.addActionListener(actionListener);
        jRadioButton6.addActionListener(actionListener);
    }
    
    private void cargarDatosCandidato(int partidoId) {

    try (Connection conexion = conectar.getConnection()) {
        String consulta = "SELECT NOMBRE, PARTIDO, LISTA FROM presidente WHERE ID = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
            preparedStatement.setInt(1, partidoId);
            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    String nombre = resultado.getString("NOMBRE");
                    String partido = resultado.getString("PARTIDO");
                    String lista = resultado.getString("LISTA");

                    // ETIQUETAS
                    labelNombre.setText("NOMBRE: " + nombre);
                    labelPartido.setText("PARTIDO: " + partido);
                    labelLista.setText("LISTA: " + lista);
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar datos desde la base de datos: " + e.getMessage());
        Incidencia.registrarIncidencia("", "ERROR AL CARGAR LOS DATOS DESDE LA BASE DE DATOS");
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        votebotton = new javax.swing.JButton();
        jRadioButton6 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Elecciones 2023");

        jLabel2.setText("Presidentes");

        jRadioButton1.setText("Javier Milei");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Sergio Massa");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Patricia Bullrich");

        jRadioButton4.setText("Juan Schiaretti");

        jRadioButton5.setText("Myriam Bregman");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("Libertad Avanza");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setText("Unión por la Patria");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel6.setText("Juntos por el Cambio");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel7.setText("Hacemos por nuestro país");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setText("Frente de Izquierda");

        votebotton.setText("Votar");
        votebotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votebottonActionPerformed(evt);
            }
        });

        jRadioButton6.setText("Voto en blanco");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton2)
                                .addComponent(jRadioButton3)
                                .addComponent(jRadioButton5)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)))
                                .addComponent(jRadioButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(votebotton)
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addGap(18, 18, 18)
                .addComponent(votebotton)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
    if (jRadioButton1.isSelected()) {
        cargarDatosCandidato(1);
    } else if (jRadioButton2.isSelected()) {
        cargarDatosCandidato(2);
    } else if (jRadioButton3.isSelected()) {
        cargarDatosCandidato(3);
    } else if (jRadioButton4.isSelected()) {
        cargarDatosCandidato(4);
    } else if (jRadioButton5.isSelected()) {
        cargarDatosCandidato(5);
        } else if (jRadioButton6.isSelected()) {
        cargarDatosCandidato(6);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private String obtenerCandidatoSeleccionado() {
    if (jRadioButton1.isSelected()) {
        return jRadioButton1.getText();
    } else if (jRadioButton2.isSelected()) {
        return jRadioButton2.getText();
    } else if (jRadioButton3.isSelected()) {
        return jRadioButton3.getText();
    } else if (jRadioButton4.isSelected()) {
        return jRadioButton4.getText();
    } else if (jRadioButton5.isSelected()) {
        return jRadioButton5.getText();
    } else if (jRadioButton6.isSelected()) {
        return jRadioButton6.getText();
    }
    return null; //SI NO SE SELECCIONA EL CANDIDATO.
}
    
    // Método para registrar incidencia en la tabla incidencia
private void registrarIncidencia(String observacion) {
    String usuarioActual = "";
    try (Connection conexion = conectar.getConnection()) {
        String sql = "INSERT INTO incidencia (USUARIO, HORA, OBSERVACION) VALUES (?, NOW(), ?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, usuarioActual); // Debes establecer el usuario actual
            preparedStatement.setString(2, observacion);
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al registrar la incidencia: " + e.getMessage());
    }
}
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

private void registraVotoenBaseDeDatos(String dniVotante) {
    
    String sqlUsuario = "SELECT USUARIO FROM acceso_presidentemesa"; 
    
    // Luego el SQL para actualizar el voto
    String sqlVoto = "UPDATE padron SET ESTADO_VOTACION = 1 WHERE DNI = ?";
    
    try (Connection conexion = conectar.getConnection()) {
        // Obtenemos el nombre de usuario
        try (PreparedStatement psUsuario = conexion.prepareStatement(sqlUsuario)) {
            ResultSet rsUsuario = psUsuario.executeQuery();
            if (rsUsuario.next()) {
                String usuario = rsUsuario.getString("USUARIO");
                
                // Ahora procedemos a registrar el voto
                if (votanteYaRegistrado(dniVotante)) {
                    JOptionPane.showMessageDialog(this, "Este votante ya ha emitido su voto.");
                } else {
                    try (PreparedStatement psVoto = conexion.prepareStatement(sqlVoto)) {
                        psVoto.setString(1, dniVotante);
                        int filasAfectadas = psVoto.executeUpdate();
                        if (filasAfectadas > 0) {
                            JOptionPane.showMessageDialog(this, "Su voto ha sido registrado en la base de datos.");
                            Incidencia.registrarIncidencia(usuario, "VOTO REGISTRADO CON ÉXITO EN LA BASE DE DATOS");
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al registrar el voto.");
                            Incidencia.registrarIncidencia(usuario, "ERROR AL REGISTRAR EL VOTO");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener el usuario de la mesa.");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
    }
}


// Método para restablecer el acceso del presidente de mesa
private void restablecerAccesoPresidente() {
    try (Connection conexion = conectar.getConnection()) {
        String sql = "UPDATE acceso_presidentedemesa SET ACCESO = 0";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al restablecer el acceso: " + e.getMessage());
    }
}

    
    private void votebottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votebottonActionPerformed

        candidatoSeleccionado = obtenerCandidatoSeleccionado();

    if (candidatoSeleccionado != null && !candidatoSeleccionado.isEmpty()) {
        registraVotoenBaseDeDatos(dniIngresado);
        if (!isInternetConnected()) {
            JOptionPane.showMessageDialog(this, "No se registró voto, no hay conexión a Internet. Se reinicia el contador para que el presidente de mesa vuelva a ingresar y continuar con la votación.");
            restablecerAccesoPresidente();
            registrarIncidencia("No se registró voto, no hay conexión a Internet. Se reinicia el contador para que el presidente de mesa vuelva a ingresar y continuar con la votación.");
            
        } else {
            int idCandidato = obtenerIdCandidato(candidatoSeleccionado);
            if (idCandidato > 0) {
                registrarVotoEnBaseDeDatos();
                JOptionPane.showMessageDialog(this, "Votaste a:" + candidatoSeleccionado);

                votebotton.setEnabled(false);
                Elecciones elecciones = new Elecciones();
                elecciones.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el ID del candidato.");
            }
        }
        
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un candidato antes de votar.");
    
    }
    }//GEN-LAST:event_votebottonActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private int obtenerIdCandidato(String nombreCandidato) {
    int idCandidato = -1;

    try (Connection conexion = conectar.getConnection()) {
        String sql = "SELECT ID FROM presidente WHERE NOMBRE = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, nombreCandidato);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    idCandidato = resultSet.getInt("ID");
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
    }
    return idCandidato;
}    
    
    private void registrarVotoEnBaseDeDatos() {

    try (Connection conexion = conectar.getConnection()) {
        String sql = "INSERT INTO votacion (ID, CANDIDATO, FECHA_HORA) VALUES (?, ?, NOW())";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idVotante);
            preparedStatement.setString(2, candidatoSeleccionado);

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "¡Voto registrado con éxito!");
                
                
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el voto.");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
    }

}
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new Candidatos().setVisible(true);
                new Login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JButton votebotton;
    // End of variables declaration//GEN-END:variables
}
