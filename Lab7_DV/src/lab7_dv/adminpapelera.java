/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_dv;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class adminpapelera {

    private ArrayList papelera = new ArrayList();
    private File archivo = null;

    public adminpapelera(String path) {
        this.archivo = new File(path);
    }

    public ArrayList getPapelera() {
        return papelera;
    }

    public void setPapelera(ArrayList papelera) {
        this.papelera = papelera;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "adminpapelera{" + "papelera=" + papelera + '}';
    }

    public void cargarArchivo() {
        try {
            papelera= new ArrayList();
            Object temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = objeto.readObject()) != null) {
                       papelera.add(temp);
                    }
                } catch (EOFException E) {

                }
                entrada.close();
                objeto.close();
            }
        } catch (Exception e) {
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Object t : papelera) {
                bw.writeObject(t);
            }
            bw.flush();
            fw.close();
            bw.close();

        } catch (Exception e) {

        }
    }

}
