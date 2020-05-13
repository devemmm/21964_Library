/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import javax.swing.*;
import java.io.*;
import javax.swing.table.TableModel;

/**
 *
 * @author root
 */
public class ExportExcel {

    ClientForm forms = new ClientForm();

    public void exortTable(JTable table,File file) throws IOException {
        TableModel model = forms.TableClient.getModel();
        FileWriter out = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(out);

        for (int i = 0; i <model.getColumnCount(); i++) {
            bw.write(model.getColumnName(i) + "\t");
        }
        bw.write("\n");
        for (int i = 0; i <model.getColumnCount(); i++) {
            for (int j = 0; j <model.getColumnCount(); j++) {
                bw.write(model.getValueAt(i, j) + "\t");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
