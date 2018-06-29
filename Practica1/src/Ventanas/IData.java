package Ventanas;
import Practica1.Sort;
import java.util.*;
import java.io.*;


public class IData extends javax.swing.JFrame {
    
    ArrayList<Integer> elemento;
    int []arr;
    String ordenado;
    double tiempo;
    public IData() {
        this.elemento = new ArrayList<>();
        this.ordenado = "";
        this.tiempo = 0;
        initComponents();        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonCargarArreglo = new javax.swing.JButton();
        botonOrdenar = new javax.swing.JButton();
        mensaje1 = new javax.swing.JLabel();
        mensaje2 = new javax.swing.JLabel();
        mensaje3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaTexto2 = new javax.swing.JTextArea();
        textoSeg = new javax.swing.JTextField();
        botonRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonCargarArreglo.setText("Cargar arreglo");
        botonCargarArreglo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarArregloActionPerformed(evt);
            }
        });

        botonOrdenar.setText("Ordenar ->");
        botonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOrdenarActionPerformed(evt);
            }
        });

        mensaje1.setText("Elementos de X:");

        mensaje2.setText("X ordenado:");

        mensaje3.setText("Tiempo de ejecución (seg):");

        areaTexto1.setColumns(20);
        areaTexto1.setRows(5);
        jScrollPane1.setViewportView(areaTexto1);
        areaTexto1.setEditable(false);

        areaTexto2.setColumns(20);
        areaTexto2.setRows(5);
        jScrollPane2.setViewportView(areaTexto2);
        areaTexto2.setEditable(false);

        textoSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoSegActionPerformed(evt);
            }
        });

        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mensaje3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mensaje1)
                                .addGap(149, 149, 149)
                                .addComponent(mensaje2))
                            .addComponent(botonCargarArreglo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonCargarArreglo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mensaje1)
                    .addComponent(mensaje2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(botonOrdenar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mensaje3)
                    .addComponent(textoSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegistrar))
                .addGap(30, 30, 30))
        );

        textoSeg.setEditable(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarArr(){
        String mostrar = "";
        for(int i = 0; i < arr.length; i++){
            mostrar = mostrar + " " + Integer.toString(arr[i]) + " ";
        }
        areaTexto1.setText(mostrar);    
    }
    
    public void cargarArr() throws FileNotFoundException{
        File archivoData = new File("src/Data/data.txt");
        FileReader frData = new FileReader(archivoData);
        try (Scanner entrada = new Scanner(frData)){
            while(entrada.hasNextInt()){
                elemento.add(entrada.nextInt());
            }
            frData.close();
        } catch(IOException e){    
            e.printStackTrace();
        }
        arr = new int[elemento.size()];
        for(int i = 0; i < elemento.size(); i++) {
            arr[i] = elemento.get(i);
        }
    }
    
    private void textoSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoSegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoSegActionPerformed

    private void botonCargarArregloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarArregloActionPerformed
        try {
            cargarArr();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mostrarArr();
    }//GEN-LAST:event_botonCargarArregloActionPerformed

    private void botonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOrdenarActionPerformed

        switch(IAcceso.eleccion){
            case 1: tiempo = System.currentTimeMillis();
                    Sort.Tradicionalsort(arr);
                    tiempo = (System.currentTimeMillis() - tiempo)/1000;
                    for(int i = 0; i < arr.length; i++){
                        ordenado = ordenado + " " + Integer.toString(arr[i]) + " ";
                    }
                    areaTexto2.setText(ordenado);
                    textoSeg.setText(Objects.toString(tiempo));
                    break;
                    
            case 2: tiempo = System.currentTimeMillis();
                    Sort.Quicksort(arr, 0, arr.length - 1);
                    tiempo = (System.currentTimeMillis() - tiempo)/1000;
                    for(int i = 0; i < arr.length; i++){
                        ordenado = ordenado + " " + Integer.toString(arr[i]) + " ";
                    }
                    areaTexto2.setText(ordenado);
                    textoSeg.setText(Objects.toString(tiempo));
                    break;
                    
            case 3: tiempo = System.currentTimeMillis();
                    Sort.Burbblesort(arr, arr.length);
                    tiempo = (System.currentTimeMillis() - tiempo)/1000;
                    for(int i = 0; i < arr.length; i++){
                        ordenado = ordenado + " " + Integer.toString(arr[i]) + " ";
                    }
                    areaTexto2.setText(ordenado);
                    textoSeg.setText(Objects.toString(tiempo));
                    break;
                    
            default: break;
        }
    }//GEN-LAST:event_botonOrdenarActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        try{
            File archivoResult = new File("src/Data/result.txt");
            FileWriter fwResult = new FileWriter(archivoResult);
            PrintWriter pwResult = new PrintWriter(fwResult);
            
            for(int i = 0; i < elemento.size(); i++){
                pwResult.print(arr[i] + " ");
            }
            pwResult.println(" ");
            pwResult.print("Seg: " + tiempo);
            fwResult.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        System.exit(0);
    }//GEN-LAST:event_botonRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(IData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto1;
    private javax.swing.JTextArea areaTexto2;
    private javax.swing.JButton botonCargarArreglo;
    private javax.swing.JButton botonOrdenar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mensaje1;
    private javax.swing.JLabel mensaje2;
    private javax.swing.JLabel mensaje3;
    private javax.swing.JTextField textoSeg;
    // End of variables declaration//GEN-END:variables
}
