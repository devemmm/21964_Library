/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.WithDrowBook;
import Util.InitalConn;
import Util.connect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class CheckOutDao extends InitalConn {

    public void save(WithDrowBook w) {
        Session session = connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            WithDrowBook with = new WithDrowBook();
            with.setBookName(w.getBookName());
            with.setClientName(w.getClientName());
            with.setDates(w.getDates());
            with.setStatus(w.getStatus());
            session.save(with);
            transaction.commit();
        } finally {
            session.close();
        }
    }
    
    public void delete(String id){
        Session session = connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            WithDrowBook book = new WithDrowBook();
            book = (WithDrowBook) session.load(WithDrowBook.class, id);
            session.delete(book);
            transaction.commit();
        }finally{
            session.close();
        }
    }

    public List<WithDrowBook> listofwithdrowBook() {
        List<WithDrowBook> withdrowBook = new ArrayList<>();
        connect();
        try {
            st = conn.createStatement();
            String list = "SELECT * FROM WithDrowBook;";
            rs = st.executeQuery(list);
            while (rs.next()) {
                WithDrowBook obj = new WithDrowBook();
                obj.setClientName(rs.getString(1));
                obj.setBookName(rs.getString(2));
                obj.setStatus(rs.getString(3));
                obj.setDates(rs.getString(4));
                withdrowBook.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return withdrowBook;
    }
}
