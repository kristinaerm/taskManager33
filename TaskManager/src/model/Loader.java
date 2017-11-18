/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//ED3ED3ED3ED3ED3D3ED3ED
/**
 *
 * @author USER
 */
public class Loader {
    
    //тут устраивай, как тебе удобнее, потом скажешь
    //, User user
    public static void addUser(Document document,User us) throws FileNotFoundException, TransformerException {
    
   for(int i=0;i<us.getTaskLog().getRecords().size();i++)
   {
       //Получаем корневой элемент
      Node root = document.getDocumentElement();
      //создам новую задачу по элементно
      Element user1=document.createElement("user");
      //<name>
       Element id=document.createElement("id");
       id.setTextContent(us.getId());
      Element name=document.createElement("name");
      //установка значения текста внутри тегов
      name.setTextContent("Название:");
      
      Element name1=document.createElement("name1");
      name1.setTextContent(us.getTaskLog().getRecord(i).getName());
      Element description=document.createElement("description");
      description.setTextContent("Описание:");
      
      Element description1=document.createElement("description1");
       description1.setTextContent(us.getTaskLog().getRecord(i).getDescription());
      Element timedate=document.createElement("timedate");
      timedate.setTextContent("время(дата)оповещения:");
     
        
      Element timedate1=document.createElement("timedate1");
      timedate1.setTextContent(us.getTaskLog().getRecord(i).getTimeString());
      Element contacts=document.createElement("contacts");
      contacts.setTextContent("Контакты:");
      
     Element contacts1=document.createElement("contacts1");
     contacts1.setTextContent(us.getTaskLog().getRecord(i).getContacts());
     //добавление внутренних элементов в элемент <Info>
     user1.appendChild(id);
     user1.appendChild(name);
     user1.appendChild(name1);
     user1.appendChild(description);
     user1.appendChild(description1);
     user1.appendChild(timedate);
     user1.appendChild(timedate1);
     user1.appendChild(contacts);
     user1.appendChild(contacts1);
   
     //добаляем инфо в корневой элемент
     root.appendChild(user1);
     
     // Записываем XML в файл
        writeDocument(document);
   }   
    }

    public static User readDocument(Document document) {
        String id=null;
        String name1=null;
        String description1=null;
        String timedate1=null;
        String contacts1=null;
       
         LinkedList<Record> list=new LinkedList<Record>();
           
         NodeList nodeList = document.getElementsByTagName("user");
         
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Выводим информацию по каждому из найденных элементов
                Node node = nodeList.item(i);
                  
                //System.out.println("Текущий элемент: " + node.getNodeName());
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                id=element.getElementsByTagName("id").item(0).getTextContent();
                    name1=element.getElementsByTagName("name1").item(0).getTextContent();
                    description1=element.getElementsByTagName("description1").item(0).getTextContent();
                  timedate1=element.getElementsByTagName("timedate1").item(0).getTextContent();
                 contacts1=element.getElementsByTagName("contacts1").item(0).getTextContent();
                       
                }
            
            Record rec=new Record(name1,description1,timedate1,contacts1);
            list.add(rec);
            }
         return new User(id, null, null, list);
    }
    
    public static void writeDocument(Document document) throws TransformerConfigurationException, FileNotFoundException, TransformerException {
         Transformer tr=TransformerFactory.newInstance().newTransformer();
    DOMSource source=new DOMSource(document);
    FileOutputStream fos = new FileOutputStream("other.xml");
    StreamResult result = new StreamResult(fos);
    tr.transform(source, result);
    }

    public static void clearDocument(Document document) {
        try {
           Node root = document.getDocumentElement();
            document.removeChild(root);
            writeDocument(document);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
