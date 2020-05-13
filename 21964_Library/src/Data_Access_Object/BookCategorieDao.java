/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.BookCategorie;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.InitalConn;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class BookCategorieDao extends InitalConn {

    BookCategorie bookCategorie;

    public void save(BookCategorie b) {
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        try {
            session.save(b);
            transation.commit();
        }finally {
            session.close();
        }
    }

    public void delete(String id) {
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        try {
            bookCategorie = (BookCategorie) session.load(BookCategorie.class, id);
            session.delete(bookCategorie);
            transation.commit();
        }finally {
            session.close();
        }
    }

    public void update(BookCategorie b) {
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        try {
            bookCategorie = (BookCategorie) session.load(BookCategorie.class, b.getCategorieId());

            bookCategorie.setCategorieName(b.getCategorieName());
            session.update(bookCategorie);
            transation.commit();
        }finally {
            session.close();
        }
    }

    public List<BookCategorie> listCategorie() {

        List<BookCategorie> cat = new ArrayList<>();
        String HQL = "FROM BookCategorie";
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        Query query = session.createQuery(HQL);

        bookCategorie = (BookCategorie) query.list();

        BookCategorie obj = new BookCategorie();
        obj.setCategorieId(bookCategorie.getCategorieId());
        obj.setCategorieName(bookCategorie.getCategorieName());

        cat.add(obj);

        return cat;
    }

    public List<BookCategorie> listBookCategories() {
        List<BookCategorie> bookcategorie = new ArrayList<>();
        connect();
        try {
            st = conn.createStatement();
            String list = "SELECT * FROM bookCategorie;";
            rs = st.executeQuery(list);
            while (rs.next()) {
                BookCategorie obj = new BookCategorie();
                obj.setCategorieId(rs.getString(1));
                obj.setCategorieName(rs.getString(2));
                bookcategorie.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return bookcategorie;
    }
}
