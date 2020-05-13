/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.ReturnedBook;
import Util.InitalConn;
import Util.connect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class CheckInDao extends InitalConn {

    public void save(ReturnedBook r) {
        Session session = connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            ReturnedBook ret = new ReturnedBook();
            ret.setBookName(r.getBookName());
            ret.setClientName(r.getClientName());
            ret.setDates(r.getDates());
            ret.setStatus(r.getStatus());
            session.save(ret);
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public void searClient(String name) {
        Session session = connect.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            ReturnedBook ret = new ReturnedBook();
            ret.setClientName(name);
            Query q = session.createQuery("From ReturnedBook where clientName =" + ret.getClientName());
            ReturnedBook stu = (ReturnedBook) q.uniqueResult();
            transaction.commit();
        } finally {
            session.close();
        }
    }

    public List<ReturnedBook> listofReturnedBook() {
        List<ReturnedBook> returnedBook = new ArrayList<>();
        connect();
        try {
            st = conn.createStatement();
            String list = "SELECT * FROM ReturnedBook;";
            rs = st.executeQuery(list);
            while (rs.next()) {
                ReturnedBook obj = new ReturnedBook();
                obj.setClientName(rs.getString(1));
                obj.setBookName(rs.getString(2));
                obj.setStatus(rs.getString(3));
                obj.setDates(rs.getString(4));
                returnedBook.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return returnedBook;
    }
}
