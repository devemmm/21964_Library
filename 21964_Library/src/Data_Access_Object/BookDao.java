/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.Book;
import Util.InitalConn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class BookDao extends InitalConn {

    Book book;

    public void save(Book b) {
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        try {
            session.save(b);
            transation.commit();
        } finally {
            session.close();
        }
    }

    public void delete(String id) {
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        try {
            book = (Book) session.load(Book.class, id);
            session.delete(book);
            transation.commit();
        } finally {
            session.close();
        }
    }

    public void update(Book b) {
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        try {
            book = (Book) session.load(Book.class, b.getBookId());

            book.setTitle(b.getTitle());
            book.setPublicationHouse(b.getPublicationHouse());
            book.setDateOfPublication(b.getDateOfPublication());
            book.setAuthor(b.getAuthor());
            book.setPage(b.getPage());
            book.setBookcategorie(b.getBookcategorie());

            session.update(book);
            transation.commit();
        } finally {
            session.close();
        }
    }

    public List<Book> listBook() {
        List<Book> book = new ArrayList<>();
        connect();
        try {
            st = conn.createStatement();
            String list = "SELECT * FROM book;";
            rs = st.executeQuery(list);
            while (rs.next()) {
                Book obj = new Book();
                obj.setBookId(rs.getString(1));
                obj.setTitle(rs.getString(2));
                obj.setPublicationHouse(rs.getString(3));
                obj.setDateOfPublication(rs.getDate(4));
                obj.setAuthor(rs.getString(5));
                obj.setPage(rs.getInt(6));
                obj.setBookcategorie(rs.getString(7));

                book.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return book;
    }
}
