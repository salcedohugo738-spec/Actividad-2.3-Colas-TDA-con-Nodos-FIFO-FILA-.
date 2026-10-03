/*
Morales Escobar Juan Adrian
Salcedo Alvarez Hugo Emmanuel
 */
package front_end;
import Nodos.Nodo;
import Nodos.PilaPagina;
import back_end.Pagina;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class GUI_Historial extends javax.swing.JFrame {
    private PilaPagina pilaPaginas;
private boolean estaCreada = false;
private void aplicarValidacionSoloNumeros(java.awt.event.KeyEvent evt) {
    char caracter = evt.getKeyChar();
    if (!Character.isDigit(caracter) && caracter != java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume(); 
        java.awt.Toolkit.getDefaultToolkit().beep();
    }
}


private void renderizarPilaGrafica() {
    panelContenedorPila.removeAll();

    if (estaCreada && pilaPaginas != null && !pilaPaginas.estaVacia()) {
        // Almacenamos temporalmente para invertir el orden visual
        java.util.List<Pagina> listaTemporal = new java.util.ArrayList<>();
        Nodo actual = pilaPaginas.getNodoTope();
        
        while (actual != null) {
            listaTemporal.add(actual.getDato());
            actual = actual.getSiguiente();
        }

        // Invertimos el orden (FIFO)
        java.util.Collections.reverse(listaTemporal);

        // Renderizamos
        for (int i = 0; i < listaTemporal.size(); i++) {
            Pagina pagina = listaTemporal.get(i);
            
            // Etiquetamos visualmente
            boolean esTope = (i == listaTemporal.size() - 1); 

            javax.swing.JPanel itemPanel = new javax.swing.JPanel();
            itemPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(esTope ? "ÚLTIMO (LIFO)" : "ELEMENTO FIFO #" + (i + 1)));
            itemPanel.add(new javax.swing.JLabel(pagina.getTitulo() + " - " + pagina.getUrl()));
            
            panelContenedorPila.add(itemPanel);
        }
    }

    panelContenedorPila.revalidate();
    panelContenedorPila.repaint();
}


private boolean validarCamposFormulario() {
    if (txtTitulo.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo 'Título' es obligatorio.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
        txtTitulo.requestFocus();
        return false;
    }
    if (txtURL.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo 'URL' es obligatorio.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
        txtURL.requestFocus();
        return false;
    }
    return true;
}
private void registrarOperacion(String mensaje) {
    java.time.LocalTime horaActual = java.time.LocalTime.now();
    String horaFormateada = horaActual.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
    txtLog.append("[" + horaFormateada + "] " + mensaje + "\n");
    txtLog.setCaretPosition(txtLog.getDocument().getLength());
}
private void limpiarFormulario() {
    txtURL.setText("");
    txtTitulo.setText("");
    txtURL.requestFocus();
}



    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUI_Historial.class.getName());

   
    public GUI_Historial() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelFormulario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        panelLog = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        panelBotones = new javax.swing.JPanel();
        btnCrearPila = new javax.swing.JButton();
        btnPush = new javax.swing.JButton();
        btnPop = new javax.swing.JButton();
        btnPeek = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnDestruirPila = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        scrollEstructura = new javax.swing.JScrollPane();
        panelContenedorPila = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sistema de gestion de historial de navegacion--- Pilas");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(panelTitulo, java.awt.BorderLayout.PAGE_START);

        panelFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Captura de datos"));

        jLabel2.setText("URL:");

        txtURL.addActionListener(this::txtURLActionPerformed);

        jLabel3.setText("Titulo:");

        txtTitulo.addActionListener(this::txtTituloActionPerformed);

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(txtURL, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTitulo)))
                .addContainerGap())
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        getContentPane().add(panelFormulario, java.awt.BorderLayout.LINE_START);

        panelLog.setBorder(javax.swing.BorderFactory.createTitledBorder("Bitacora"));

        txtLog.setEditable(false);
        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout panelLogLayout = new javax.swing.GroupLayout(panelLog);
        panelLog.setLayout(panelLogLayout);
        panelLogLayout.setHorizontalGroup(
            panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelLogLayout.setVerticalGroup(
            panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelLog, java.awt.BorderLayout.PAGE_END);

        panelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones de la pila"));

        btnCrearPila.setText("Crear fila");
        btnCrearPila.addActionListener(this::btnCrearPilaActionPerformed);

        btnPush.setText("Push(Encolar)");
        btnPush.addActionListener(this::btnPushActionPerformed);

        btnPop.setText("Desencolar");
        btnPop.addActionListener(this::btnPopActionPerformed);

        btnPeek.setText("ver tope");
        btnPeek.addActionListener(this::btnPeekActionPerformed);

        btnLimpiar.setText("Limpiar Formulario");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnDestruirPila.setText("Destruir fila");
        btnDestruirPila.addActionListener(this::btnDestruirPilaActionPerformed);

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrearPila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPush, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPeek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(btnDestruirPila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addComponent(btnCrearPila)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPush)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPeek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDestruirPila)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(panelBotones, java.awt.BorderLayout.LINE_END);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Panel visualizacion"));

        panelContenedorPila.setLayout(new javax.swing.BoxLayout(panelContenedorPila, javax.swing.BoxLayout.Y_AXIS));
        scrollEstructura.setViewportView(panelContenedorPila);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollEstructura)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollEstructura, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtURLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtURLActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnCrearPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPilaActionPerformed
 if (estaCreada && !pilaPaginas.estaVacia()) {
        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "La fila contiene elementos activos. ¿Desea reiniciar la pila? Se perderán los libros acumulados.",
            "Confirmar Reinicio",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }
    }

    this.pilaPaginas = new PilaPagina();
    this.estaCreada = true;

    renderizarPilaGrafica();
    registrarOperacion("Estructura TDA fila inicializada correctamente.");
    JOptionPane.showMessageDialog(this, "fila de libros lista para operar.", "Estructura Creada", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCrearPilaActionPerformed

    private void btnPushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPushActionPerformed
        if (!estaCreada || pilaPaginas == null) {
        JOptionPane.showMessageDialog(this, "Debe crear la fila antes de encolar elementos.", "fila no Inicializada", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!validarCamposFormulario()) return;

    try {
        String url = txtURL.getText().trim();
        String titulo = txtTitulo.getText().trim();
        java.time.LocalTime horaActual = java.time.LocalTime.now();

        Pagina nuevaPagina = new Pagina(url, titulo, horaActual);

        
        pilaPaginas.apilar(nuevaPagina);

        renderizarPilaGrafica();
        registrarOperacion("PUSH: Se encoló la página '" + nuevaPagina.getTitulo() + "' en el TOPE de la fila.");
        JOptionPane.showMessageDialog(this, "Página agregada exitosamente al TOPE.", "Éxito (Push)", JOptionPane.INFORMATION_MESSAGE);

        txtURL.setText("");
        txtTitulo.setText("");
        txtURL.requestFocus();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado al encolar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnPushActionPerformed

    private void btnPopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPopActionPerformed
        if (!estaCreada || pilaPaginas == null) {
        JOptionPane.showMessageDialog(this, "La fila no ha sido inicializada.", "Estructura Ausente", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (pilaPaginas.estaVacia()) {
        JOptionPane.showMessageDialog(this, "No es posible desencolar: La fila se encuentra VACÍA.", "fila Vacía (Underflow)", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Pagina paginaEnTope = pilaPaginas.obtenerTope();

    int confirmacion = JOptionPane.showConfirmDialog(
        this,
        "¿Confirma desencolar la página del TOPE?\n\nTítulo: " + paginaEnTope.getTitulo() + "\nURL: " + paginaEnTope.getUrl(),
        "Confirmar POP",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    if (confirmacion == JOptionPane.YES_OPTION) {
        // Invocación del método desapilar del TDA
        Pagina paginaExtraida = pilaPaginas.desapilar();

        renderizarPilaGrafica();
        registrarOperacion("POP: Se desencoló la página '" + paginaExtraida.getTitulo() + "' del TOPE de la fila.");
        JOptionPane.showMessageDialog(this, "Página '" + paginaExtraida.getTitulo() + "' desencolada correctamente.", "POP Exitoso", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnPopActionPerformed

    private void btnPeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeekActionPerformed
if (!estaCreada || pilaPaginas == null) {
        JOptionPane.showMessageDialog(this, "La fila no está inicializada.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (pilaPaginas.estaVacia()) {
        JOptionPane.showMessageDialog(this, "La fila está VACÍA. No hay elementos.", "fila Vacía", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Buscamos el primer elemento (el fondo de la pila) usando el NodoTope
    Nodo actual = pilaPaginas.getNodoTope();
    while (actual != null && actual.getSiguiente() != null) {
        actual = actual.getSiguiente();
    }

    Pagina paginaPrimero = actual.getDato();
    
    txtURL.setText(paginaPrimero.getUrl());
    txtTitulo.setText(paginaPrimero.getTitulo());

    registrarOperacion("CONSULTA FIFO: Inspección del primer elemento agregado: '" + paginaPrimero.getTitulo() + "'.");
    JOptionPane.showMessageDialog(this, "Mostrando datos del PRIMER elemento agregado (FIFO).", "Consulta FIFO", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnPeekActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
     limpiarFormulario();
    registrarOperacion("Formulario de captura limpiado.");  
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnDestruirPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestruirPilaActionPerformed
        if (!estaCreada || pilaPaginas == null || pilaPaginas.estaVacia()) {
        JOptionPane.showMessageDialog(this, "La fila ya se encuentra vacía o no ha sido creada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    int opcion = JOptionPane.showConfirmDialog(
        this,
        "¿Está seguro de vaciar totalmente la pila? Esta acción eliminará todas las páginas apiladas.",
        "Confirmar Vaciado de fila",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
    );

    if (opcion == JOptionPane.YES_OPTION) {
        pilaPaginas.limpiar();
        renderizarPilaGrafica();
        limpiarFormulario();
        registrarOperacion("VACIAR: Todos los elementos de la fila han sido removidos.");
        JOptionPane.showMessageDialog(this, "La fila ha sido vaciada por completo.", "fila Vacía", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnDestruirPilaActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GUI_Historial().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPila;
    private javax.swing.JButton btnDestruirPila;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPeek;
    private javax.swing.JButton btnPop;
    private javax.swing.JButton btnPush;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelContenedorPila;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelLog;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollEstructura;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables

}
