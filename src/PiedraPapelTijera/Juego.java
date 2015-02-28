/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiedraPapelTijera;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco A. Reyes
 */
public class Juego extends javax.swing.JFrame {

    PiedraPapelTijera ppt = new PiedraPapelTijera();
    Icon aplauso = new ImageIcon("src/PiedraPapelTijera/Imagenes/aplauso.gif");
    Icon rage = new ImageIcon("src/PiedraPapelTijera/Imagenes/rage.gif");
    Icon normalDer = new ImageIcon("src/PiedraPapelTijera/Imagenes/normalDer.png");
    Icon normalIzq = new ImageIcon("src/PiedraPapelTijera/Imagenes/normalIzq.png");
    Icon piedraDer = new ImageIcon("src/PiedraPapelTijera/Imagenes/piedraDer.png");
    Icon piedraIzq = new ImageIcon("src/PiedraPapelTijera/Imagenes/piedraIzq.png");
    Icon papelDer = new ImageIcon("src/PiedraPapelTijera/Imagenes/papelDer.png");
    Icon papelIzq = new ImageIcon("src/PiedraPapelTijera/Imagenes/papelIzq.png");
    Icon tijeraDer = new ImageIcon("src/PiedraPapelTijera/Imagenes/tijeraDer.png");
    Icon tijeraIzq = new ImageIcon("src/PiedraPapelTijera/Imagenes/tijeraIzq.png");
    Icon homer = new ImageIcon("src/PiedraPapelTijera/Imagenes/homer.gif");
    int opcion;

    /**
     * Creates new form Juego
     */
    public Juego() {
        initComponents();
        nombreJugador.setText(" " + VentanaInicio.getNombreJ1());
        ppt.setNumTotalVictorias(VentanaInicio.nTotalVictoria); 
        ppt.generarJugada();
        this.jugarPartida.setEnabled(false);

        this.setColorUser();

    }

    private void setColorUser() {
        switch (VentanaInicio.colorSelec) {
            case 0:
                nombreJugador.setForeground(Color.red);
                cartel.setForeground(Color.red);
                eleccionJ1.setForeground(Color.red);
                marcaJ1.setForeground(Color.red);
                nombreCPU.setForeground(Color.red);
                marcaCPU.setForeground(Color.red);
                break;
            case 1:
                nombreJugador.setForeground(Color.blue);
                cartel.setForeground(Color.blue);
                eleccionJ1.setForeground(Color.blue);
                marcaJ1.setForeground(Color.blue);
                nombreCPU.setForeground(Color.blue);
                marcaCPU.setForeground(Color.blue);
                break;
            case 2:
                nombreJugador.setForeground(Color.green);
                cartel.setForeground(Color.green);
                eleccionJ1.setForeground(Color.green);
                marcaJ1.setForeground(Color.green);
                nombreCPU.setForeground(Color.green);
                marcaCPU.setForeground(Color.green);
                break;
            case 3:
                nombreJugador.setForeground(Color.pink);
                cartel.setForeground(Color.pink);
                eleccionJ1.setForeground(Color.pink);
                marcaJ1.setForeground(Color.pink);
                nombreCPU.setForeground(Color.pink);
                marcaCPU.setForeground(Color.pink);
                break;
        }
    }

    private void setTexto() {
        if (ppt.getResultadoJugada() == 1 && ppt.getVictoriasPlayer() < ppt.getNumTotalVictorias()) {
            cartel.setText("Ouh Yeah");
            
        } else {
            if (ppt.getResultadoJugada() == 2 && ppt.getVictoriasCPU() < ppt.getNumTotalVictorias()) {
                cartel.setText("Fail");
            } else {
                if (ppt.getResultadoJugada() == 0) {
                    cartel.setText("Tablas");
                }
            }
        }
    }

    private void checkFinalResult() {
        if (ppt.getVictoriasPlayer() == ppt.getNumTotalVictorias()) {

            int reinicioXwin = JOptionPane.showConfirmDialog(this, "Enhorabuena, has ganado. ¿Reiniciar?", "VICTORIA", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, aplauso);
            switch (reinicioXwin) {
                case JOptionPane.YES_OPTION:
                    String[] options = {"Mejor de 3", "Mejor de 5", "Mejor de 7", "Mejor de 9"};
                    opcion = JOptionPane.showOptionDialog(this, "Elige duración", "Nueva partida", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, homer, options, options[0]);
                    switch (opcion) {
                        case 0:
                            ppt.setNumTotalVictorias(2);
                            break;
                        case 1:
                            ppt.setNumTotalVictorias(3);
                            break;
                        case 2:
                            ppt.setNumTotalVictorias(4);
                            break;
                        case 3:
                            ppt.setNumTotalVictorias(5);
                            break;
                        case JOptionPane.CLOSED_OPTION:

                    }

                    this.eleccionJ1.setText(null);
                    this.eleccionCPU.setText(null);
                    this.marcaJ1.setText(null);
                    this.marcaCPU.setText(null);
                    this.cartel.setText(null);
                    ppt.setNullVictorias();
                    ppt.jugadaPlayer1 = null;
                    ppt.jugadaCPU = null;
                    ppt.generarJugada();
                    this.jugarPartida.setEnabled(false);
                    this.piedrabtn.setEnabled(true);
                    this.papelbtn.setEnabled(true);
                    this.tijerabtn.setEnabled(true);
                    manoJ1icon.setIcon(normalIzq);
                    manoCPUicon.setIcon(normalDer);
                    break;
                case JOptionPane.NO_OPTION:
                    Runtime.getRuntime().exit(0);
                    break;
                case JOptionPane.CLOSED_OPTION:
                    Runtime.getRuntime().exit(0);
                    break;

            }

        } else {
            if (ppt.getVictoriasCPU() == ppt.getNumTotalVictorias()) {
                int reinicioXfail = JOptionPane.showConfirmDialog(this, "Lo siento, has perdido. ¿Reiniciar?", "DERROTA", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, rage);

                switch (reinicioXfail) {
                    case JOptionPane.YES_OPTION:
                        String[] options = {"Mejor de 3", "Mejor de 5", "Mejor de 7", "Mejor de 9"};
                        opcion = JOptionPane.showOptionDialog(this, "Elige duración", "Nueva partida", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, homer, options, options[0]);
                        switch (opcion) {
                            case 0:
                                ppt.setNumTotalVictorias(2);
                                break;
                            case 1:
                                ppt.setNumTotalVictorias(3);
                                break;
                            case 2:
                                ppt.setNumTotalVictorias(4);
                                break;
                            case 3:
                                ppt.setNumTotalVictorias(5);
                                break;
                            case JOptionPane.CLOSED_OPTION:

                        }

                        this.eleccionJ1.setText(null);
                        this.eleccionCPU.setText(null);
                        this.marcaJ1.setText(null);
                        this.marcaCPU.setText(null);
                        this.cartel.setText(null);
                        ppt.setNullVictorias();
                        ppt.jugadaPlayer1 = null;
                        ppt.jugadaCPU = null;
                        ppt.generarJugada();
                        this.jugarPartida.setEnabled(false);
                        this.piedrabtn.setEnabled(true);
                        this.papelbtn.setEnabled(true);
                        this.tijerabtn.setEnabled(true);
                        manoJ1icon.setIcon(normalIzq);
                        manoCPUicon.setIcon(normalDer);
                        break;
                    case JOptionPane.NO_OPTION:
                        Runtime.getRuntime().exit(0);
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        Runtime.getRuntime().exit(0);
                        break;

                }

            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        piedrabtn = new javax.swing.JButton();
        papelbtn = new javax.swing.JButton();
        tijerabtn = new javax.swing.JButton();
        nombreJugador = new javax.swing.JLabel();
        eleccionJ1 = new javax.swing.JLabel();
        eleccionCPU = new javax.swing.JLabel();
        jugarPartida = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        nombreCPU = new javax.swing.JLabel();
        marcaCPU = new javax.swing.JLabel();
        marcaJ1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cartel = new javax.swing.JLabel();
        manoCPUicon = new javax.swing.JLabel();
        manoJ1icon = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        piedrabtn.setBackground(new java.awt.Color(204, 204, 255));
        piedrabtn.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 11)); // NOI18N
        piedrabtn.setText("PIEDRA");
        piedrabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piedrabtnActionPerformed(evt);
            }
        });
        getContentPane().add(piedrabtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 80, -1));

        papelbtn.setText("PAPEL");
        papelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                papelbtnActionPerformed(evt);
            }
        });
        getContentPane().add(papelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 80, -1));

        tijerabtn.setText("TIJERA");
        tijerabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tijerabtnActionPerformed(evt);
            }
        });
        getContentPane().add(tijerabtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 80, -1));

        nombreJugador.setFont(new java.awt.Font("Yu Mincho Light", 1, 11)); // NOI18N
        nombreJugador.setForeground(new java.awt.Color(255, 255, 51));
        nombreJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 60, 20));

        eleccionJ1.setBackground(new java.awt.Color(255, 255, 255));
        eleccionJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eleccionJ1.setOpaque(true);
        getContentPane().add(eleccionJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, 20));

        eleccionCPU.setBackground(new java.awt.Color(255, 255, 255));
        eleccionCPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eleccionCPU.setOpaque(true);
        getContentPane().add(eleccionCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 100, 20));

        jugarPartida.setText("Jugar Partida");
        jugarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarPartidaActionPerformed(evt);
            }
        });
        getContentPane().add(jugarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 100, -1));

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        getContentPane().add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 100, -1));

        nombreCPU.setFont(new java.awt.Font("Yu Mincho Light", 1, 11)); // NOI18N
        nombreCPU.setForeground(new java.awt.Color(255, 255, 51));
        nombreCPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCPU.setText("CPU");
        getContentPane().add(nombreCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 70, 20));

        marcaCPU.setBackground(new java.awt.Color(255, 255, 255));
        marcaCPU.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        marcaCPU.setForeground(new java.awt.Color(255, 255, 51));
        marcaCPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(marcaCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 60, 50));

        marcaJ1.setBackground(new java.awt.Color(255, 255, 255));
        marcaJ1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        marcaJ1.setForeground(new java.awt.Color(255, 255, 51));
        marcaJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(marcaJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 60, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PiedraPapelTijera/Imagenes/marcador.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 220, 90));

        cartel.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        cartel.setForeground(new java.awt.Color(255, 255, 51));
        cartel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(cartel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 170, 50));

        manoCPUicon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        manoCPUicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PiedraPapelTijera/Imagenes/normalDer.png"))); // NOI18N
        getContentPane().add(manoCPUicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 280, 120));

        manoJ1icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PiedraPapelTijera/Imagenes/normalIzq.png"))); // NOI18N
        getContentPane().add(manoJ1icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 280, 120));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PiedraPapelTijera/Imagenes/ROKBOX-5-RGBAW.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void piedrabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piedrabtnActionPerformed
        ppt.setJugadaPlayer(ppt.PIEDRA);
        eleccionJ1.setText(ppt.getJugadaPlayer1());
        this.jugarPartida.setEnabled(true);
    }//GEN-LAST:event_piedrabtnActionPerformed

    private void papelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_papelbtnActionPerformed
        ppt.setJugadaPlayer(ppt.PAPEL);
        eleccionJ1.setText(ppt.getJugadaPlayer1());
        this.jugarPartida.setEnabled(true);
    }//GEN-LAST:event_papelbtnActionPerformed

    private void tijerabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tijerabtnActionPerformed
        ppt.setJugadaPlayer(ppt.TIJERA);
        eleccionJ1.setText(ppt.getJugadaPlayer1());
        this.jugarPartida.setEnabled(true);
    }//GEN-LAST:event_tijerabtnActionPerformed

    private void jugarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarPartidaActionPerformed
        
        ppt.comparaJugada();
        
        switch (ppt.getJugadaPlayer()) {
            case 1:
                manoJ1icon.setIcon(piedraIzq);
                break;
            case 2:
                manoJ1icon.setIcon(papelIzq);
                break;
            case 3:
                manoJ1icon.setIcon(tijeraIzq);
                break;
        }
        switch (ppt.getIntJugadaCPU()) {
            case 1:
                manoCPUicon.setIcon(piedraDer);
                break;
            case 2:
                manoCPUicon.setIcon(papelDer);
                break;
            case 3:
                manoCPUicon.setIcon(tijeraDer);
                break;
        }
        this.piedrabtn.setEnabled(false);
        this.papelbtn.setEnabled(false);
        this.tijerabtn.setEnabled(false);

        this.setTexto();

        eleccionCPU.setText(ppt.getJugadaCPU());
        marcaJ1.setText(String.valueOf(ppt.getVictoriasPlayer()));
        marcaCPU.setText(String.valueOf(ppt.getVictoriasCPU()));
        jugarPartida.setEnabled(false);

        this.checkFinalResult();
       
    }//GEN-LAST:event_jugarPartidaActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        ppt.generarJugada();
        eleccionJ1.setText(null);
        eleccionCPU.setText(null);
        cartel.setText(null);
        this.piedrabtn.setEnabled(true);
        this.papelbtn.setEnabled(true);
        this.tijerabtn.setEnabled(true);

        manoJ1icon.setIcon(normalIzq);
        manoCPUicon.setIcon(normalDer);
    }//GEN-LAST:event_siguienteActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel cartel;
    private javax.swing.JLabel eleccionCPU;
    private javax.swing.JLabel eleccionJ1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jugarPartida;
    private javax.swing.JLabel manoCPUicon;
    private javax.swing.JLabel manoJ1icon;
    private javax.swing.JLabel marcaCPU;
    private javax.swing.JLabel marcaJ1;
    private javax.swing.JLabel nombreCPU;
    private javax.swing.JLabel nombreJugador;
    private javax.swing.JButton papelbtn;
    private javax.swing.JButton piedrabtn;
    private javax.swing.JButton siguiente;
    private javax.swing.JButton tijerabtn;
    // End of variables declaration//GEN-END:variables
}
