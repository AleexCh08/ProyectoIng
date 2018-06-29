package Ventanas;

import Practica1.Practica1;

public class IAcceso extends javax.swing.JFrame {
    
    static int eleccion = 0;

    public IAcceso() {
        initComponents();     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        mensaje1 = new javax.swing.JLabel();
        botonTradicionalSort = new javax.swing.JRadioButton();
        botonQuickSort = new javax.swing.JRadioButton();
        botonBubbleSort = new javax.swing.JRadioButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mensaje1.setText("Seleccione un algoritmo:");

        grupo1.add(botonTradicionalSort);
        botonTradicionalSort.setText("Tradicional");
        botonTradicionalSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTradicionalSortActionPerformed(evt);
            }
        });

        grupo1.add(botonQuickSort);
        botonQuickSort.setText("Quick sort");
        botonQuickSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuickSortActionPerformed(evt);
            }
        });

        grupo1.add(botonBubbleSort);
        botonBubbleSort.setText("Bubble sort");
        botonBubbleSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBubbleSortActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(mensaje1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(botonTradicionalSort)
                            .addGap(18, 18, 18)
                            .addComponent(botonQuickSort)
                            .addGap(18, 18, 18)
                            .addComponent(botonBubbleSort))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(mensaje1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonTradicionalSort)
                    .addComponent(botonQuickSort)
                    .addComponent(botonBubbleSort))
                .addGap(18, 18, 18)
                .addComponent(botonSalir)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonTradicionalSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTradicionalSortActionPerformed
        eleccion = 1;
        Practica1.ventana2();
        dispose();   
    }//GEN-LAST:event_botonTradicionalSortActionPerformed

    private void botonQuickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuickSortActionPerformed
        eleccion = 2;
        Practica1.ventana2();
        dispose();
    }//GEN-LAST:event_botonQuickSortActionPerformed

    private void botonBubbleSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBubbleSortActionPerformed
        eleccion = 3;
        Practica1.ventana2();
        dispose();
    }//GEN-LAST:event_botonBubbleSortActionPerformed

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
            java.util.logging.Logger.getLogger(IAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IAcceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botonBubbleSort;
    private javax.swing.JRadioButton botonQuickSort;
    private javax.swing.JButton botonSalir;
    private javax.swing.JRadioButton botonTradicionalSort;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.JLabel mensaje1;
    // End of variables declaration//GEN-END:variables
}
