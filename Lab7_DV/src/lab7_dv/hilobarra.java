/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_dv;

import javax.swing.JProgressBar;
import javax.swing.JSpinner;

/**
 *
 * @author diego
 */
public class hilobarra extends Thread {

    private JProgressBar progBar_t;
    private String nombre;
    public hilobarra(JProgressBar progBar_t) {
        this.progBar_t = progBar_t;
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
