/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import view.SimpleTaskManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import model.DataCheck;
import model.Loader;
import model.Record;
import model.User;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author USER
 */
public class TaskManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException, SAXException, ParserConfigurationException, IOException, TransformerException {
        SimpleTaskManager frame = new SimpleTaskManager();
        
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //запись и считывание из xml
        // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
           Document document = documentBuilder.parse("Catalog.xml");
           LinkedList<Record>list=new LinkedList<Record>();
           list.add(new Record("task1","tas","2015-10-22 22:10","18486"));
           list.add(new Record("task2","tas","2015-10-22 22:10","18486"));
           
         User u=new User("1",null,null,list);
            // Вызываем метод для добавления 
            Loader.addUser(document,u);
        
            User us=Loader.readDocument(document);
        for(int i=0;i<us.getTaskLog().getNumberOfRecords();i++)
        {
            System.out.println(us.getTaskLog().getRecord(i).getName());
            System.out.println(us.getTaskLog().getRecord(i).getDescription());
            System.out.println(us.getTaskLog().getRecord(i).getTimeString());
            System.out.println(us.getTaskLog().getRecord(i).getContacts());
        }
    
             
}
}
