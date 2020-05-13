/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LMS;

import Data_Access_Object.DataBase;
import Data_Access_Object.CheckOutDao;
import Data_Access_Object.CheckInDao;
import Model.BookCategorie;
import Util.InitalConn;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Model.BookCategorie;
import Model.ReturnedBook;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author root
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transtaction = session.beginTransaction();
//        
//        BookCategorie categorie = new BookCategorie();
//        categorie.setCategorieId("1111");
//        categorie.setCategorieName("Universtu");
//        
//        session.save(categorie);
//        transtaction.commit();
//        session.close();
//        System.out.println("Categorie Saved");
//        transtaction = null;
       
//        
//        List<BookCategorie> cat = new ArrayList<>();
//        String HQL = "FROM bookCategorie";
//        Query query = session.createQuery(HQL);
//
//        BookCategorie bookCategorie = (BookCategorie)query.list();
//
//        cat.add(bookCategorie);
//       
//        for(BookCategorie bok :  cat){
//            System.out.println(bok.getCategorieId() + ","+ bok.getCategorieName());
//        }
//        
//        
//        transtaction.commit();
//        session.close();
//        
//        transtaction = null;
        
//        WithDrowBook with = new WithDrowBook();
//        with.setBookName("1234");
//        with.setClientName("Denyse");
//        with.setStatus("Student");
//        with.setDates("2020-01-01");
//        CheckOutDao outs = new CheckOutDao();
//        outs.save(with);
        
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(System.currentTimeMillis());
//        
//        SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(fomat.format(cal.getTime()));
//        WithDrowBook with = new WithDrowBook();
//        with.setBookName("1234");
//        with.setClientName("Denyse");
//        with.setStatus("Student");
//        with.setDates(fomat.format(cal.getTime()));
//        CheckOutDao outs = new CheckOutDao();
//        outs.save(with);
        
        ReturnedBook ret = new ReturnedBook("Kinya", "Emmanuel", "Student", "2020-01-01");
        CheckInDao che = new CheckInDao();
        che.save(ret);
        
    }
    
}
