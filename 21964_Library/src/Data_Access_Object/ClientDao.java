/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.Client;
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
public class ClientDao extends InitalConn{

    Client client;

    public void save(Client c) {
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        try {

            session.save(c);
            transation.commit();
            transation = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(String id) {
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        try {
            client = (Client) session.load(Client.class, id);
            session.delete(client);

            transation.commit();
            transation = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void update(Client c) {
        Session session = Util.connect.getSessionFactory().openSession();
        Transaction transation = session.beginTransaction();
        try {
            client = (Client) session.load(Client.class, c.getRegNo());

            client.setFirstName(c.getFirstName());
            client.setLastName(c.getLastName());
            client.setPhoneNo(c.getPhoneNo());
            client.setEmail(c.getEmail());
            client.setStatus(c.getStatus());
            session.update(client);
            transation.commit();
            transation = null;

        } catch (Exception ex) {
            session.close();
        }
    }
    
    public List<Client> ListClient(){
        List<Client> clients = new ArrayList<>();
        connect();
        try{
            
            st = conn.createStatement();
            String sql = "select * from Client;";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Client client = new Client();
                client.setRegNo(rs.getString(1));
                client.setFirstName(rs.getString(2));
                client.setLastName(rs.getString(3));
                client.setPhoneNo(rs.getString(4));
                client.setEmail(rs.getString(5));
                client.setStatus(rs.getString(6));
                client.setPhoto(rs.getString(7));
                clients.add(client);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            disconnect();
        }
        return clients;
    }
}
