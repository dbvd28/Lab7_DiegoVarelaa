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
public class admincarpetas  {
     private ArrayList<Carpetas> listacarpetas = new ArrayList();
    private File archivo = null;

    public admincarpetas(String path) {
         archivo = new File(path);
    }

    public ArrayList<Carpetas> getListacarpetas() {
        return listacarpetas;
    }

    public void setListacarpetas(ArrayList<Carpetas> listacarpetas) {
        this.listacarpetas = listacarpetas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return   "listacarpetas=" + listacarpetas + '}';
    }
      public void cargarArchivo() {
        try {
            listacarpetas = new ArrayList();
            Carpetas temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Carpetas) objeto.readObject()) != null) {
                        listacarpetas.add(temp);
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
            for (Carpetas t : listacarpetas) {
                bw.writeObject(t);
            }
            bw.flush();
            fw.close();
            bw.close();

        } catch (Exception e) {

        }
    }
    
}
