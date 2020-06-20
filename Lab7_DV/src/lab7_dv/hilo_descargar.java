/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_dv;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class hilo_descargar implements Runnable {

    private boolean avanzar;
    private boolean vive;
    private JProgressBar progBar_t;
    private int tam;
    private JTable tabla;
    private Carpetas c;

    public hilo_descargar(JProgressBar progBar_t, int tiempo, JTable tab, Carpetas cap) {
        this.progBar_t = progBar_t;
        this.tam = tiempo;
        avanzar = true;
        vive = true;
        this.tabla = tab;
        this.c = cap;
    }

    @Override
    public void run() {
        while (vive) {
            if (avanzar) {

                if (progBar_t.getValue() < progBar_t.getMaximum()) {
                    progBar_t.setMaximum(tam);
                    this.progBar_t.setValue(this.progBar_t.getValue() + 1);

                } else {
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    for (Archivos a : c.getArchivos()) {
                        Object[] newrow2 = {
                            a.getNombre(),
                            a.getExtension(),
                            a.getLink(), a.getTamaño()
                        };
                        model.addRow(newrow2);
                        tabla.setModel(model);
                    }
                    avanzar = false;
                }
                try {
                    Thread.sleep(1000);

                } catch (Exception ex) {

                }
            }
        }
    }
}
