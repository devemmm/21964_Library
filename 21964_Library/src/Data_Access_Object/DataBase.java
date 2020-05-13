/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Util.InitalConn;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class DataBase extends InitalConn{

    public DataBase() {
        connect();
        try {
            st = conn.createStatement();
            String createBookTable = "CREATE TABLE if not exists book("
                    + "bookId varchar(5) NOT NULL PRIMARY KEY,"
                    + "title varchar(20) NOT NULL,"
                    + "publicationHouse varchar(10) NOT NULL,"
                    + "dateOfPublication date not NULL,"
                    + "author varchar(10),"
                    + "page int,"
                    + "bookcategorie varchar(10));";
            
            
            
            String createBookCategorieTable = "CREATE TABLE if not exists bookCategorie ("
                    + "categorieId varchar(5) PRIMARY Key,"
                    + "categorieName varchar(15) NOT NULL);";
            
            
            String createClientTable = "CREATE TABLE if not exists Client("
                    + "regNo varchar(5) PRIMARY KEY,"
                    + "firstName varchar(15) NOT NULL,"
                    + "lastName varchar(10) NOT NULL,"
                    + "phoneNo varchar(10),"
                    + "Email varchar(29),"
                    + "status varchar(10) NOT NULL,"
                    + "photo varchar(40));";
            
            
            String createReturnedBookTable = "CREATE TABLE if not exists ReturnedBook("
                    + "clientName varchar(25) NOT NULL,"
                    + "bookName varchar(10) NOT NULL,"
                    + "status varchar(8) NOT NULL,"
                    + "dates varchar(10));";
            
            
            
            String createWithrowBookTable = "CREATE TABLE if not exists WithDrowBook("
                    + "clientName varchar(25) NOT NULL,"
                    + "bookName varchar(10) PRIMARY KEY,"
                    + "status varchar(8) NOT NULL,"
                    + "dates varchar(10));";
            
            String createUserTable = "CREATE TABLE if not exists Users ("
                    + "username varchar(10) PRIMARY KEY,"
                    + "password varchar(15) NOT NULL);";
            
            st.executeUpdate(createBookTable);
            st.executeUpdate(createBookCategorieTable);
            st.executeUpdate(createClientTable);
            st.executeUpdate(createReturnedBookTable);
            st.executeUpdate(createWithrowBookTable);
            st.executeUpdate(createUserTable);
            
            System.out.println("All Table Created");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

}
