/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kino;

import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;


/**
 *
 * @author PAWEL
 */
public class kinoHQL {
    
    Session session = null;
    
      public kinoHQL() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
      
       public List getFilmTitles(int startID, int endID) {
    List<Film> filmList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Film as film where film.idFilm between '"+startID+"' and '"+endID+"'");
        filmList = (List<Film>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return filmList;
}
    
       /////////////////////////////////////
       
       
       public List getSeanse() {
           
           List<Seans> seansList = null;
           try {
            org.hibernate.Transaction tx2 = session.beginTransaction();
            Query q2 = session.createQuery ("from Seans as seans where seans.film = :idFilm ");
            q2.setParameter("idFilm", "1");
            seansList = (List<Seans>) q2.list();

            
           }catch (Exception e) {
               e.printStackTrace();
               
           
           }
           return seansList;
       }
       
       
    
}
