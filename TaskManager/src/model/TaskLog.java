/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.SimpleTaskManager;
import java.util.LinkedList;
import java.util.UUID;
import javax.swing.JTable;
import org.w3c.dom.Document;
import view.Transfer;

/**
 *
 * @author USER
 */
public class TaskLog {
    
    private static final String[] COLUMN_NAMES = {"№", "Название","Время и дата","Описание","Контакты"};
    private LinkedList<Record> records;
    private final String id;
    
    
    
    public TaskLog (LinkedList<Record> rec){
        id = UUID.randomUUID().toString();
        records = rec;
        sort();
    }
    
    public void updateTable(){
        for (int i=0; i<Transfer.model.getRowCount(); i++){
            Transfer.model.removeRow(i);
        }
        for (int i =0; i< records.size(); i++){
            Transfer.model.addRow(new Object[]{i, getRecord(i).getName(),getRecord(i).getTimeString(), getRecord(i).getDescription(), getRecord(i).getContacts()});
        }
    }
    
    
    public String getId(){
        return id;
    }
    
    public LinkedList<Record> getRecords(){
        return records;
    }
    
    public int getNumberOfRecords(){
        return records.size();
    }
    
    public Object[][] createData() {
        Object[][] data = new Object[records.size()][5];
        for (int i = 0; i < records.size(); i++) {
            data[i][0] = i;
            data[i][1] = this.getRecord(i).getName();
            data[i][2] = this.getRecord(i).getTimeString();
            data[i][3] = this.getRecord(i).getDescription();
            data[i][4] = this.getRecord(i).getContacts();
        }
        return data;
    }
    
    public void changeRecord (int n, String na, String ti, String des, String con){
        Record rec = records.get(n);
        if ((!na.equals(""))) {
            rec.setName(na);
        }
        if ((!ti.equals(""))) {
            rec.setTime(ti);
            sort();
        }
        if ((!des.equals(""))) {
            rec.setDescription(des);
        }
        if ((!con.equals(""))) {
            rec.setContacts(con);
        }
        updateTable();
    }
    
    public Record getRecord (int n){

        return records.get(n);

//        Record rec = records.get(n);
//        return new Record(rec.getName(),rec.getDescription(), rec.getTimeString(), rec.getContacts());

    }
    
    public void addRecord (Record rec){
        records.add(rec);
        sort();
        updateTable();
    }
    
    public void deleteRecord (int n){
        records.remove(n);
        updateTable();
    }  
    
    public void sort (){
        Record temp = null;
        for (int j = 0; j < records.size(); j++) {
            for (int k = 0; k < records.size() - 1; k++) {
                if (records.get(k).compareTo(records.get(k+1))==1) {
                    temp = records.get(k);
                    records.set(k, records.get(k+1));
                    records.set(k+1, temp);
                }
            }
        }
    }
}
