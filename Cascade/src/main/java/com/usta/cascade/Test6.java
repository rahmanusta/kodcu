package com.usta.cascade;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Enterprise Application Client main class.
 *
 */
public class Test6 {
    
    public static void main( String[] args ) throws InterruptedException {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("Cascading_PU");
        EntityManager em=emf.createEntityManager();     
        EntityTransaction trx=em.getTransaction();
        
        Kategori kategori=new Kategori();
        kategori.setKategori("Notebook");
        
        Urun urun=new Urun();
        urun.setUrunAdi("Lenovo abc");
        urun.setKategori(kategori);
        
        Urun urun2=new Urun();
        urun2.setUrunAdi("Toshiba def");
        urun2.setKategori(kategori);
          
        
        Saglayici saglayici=new Saglayici();
        saglayici.setSirketAdi("Marmara Bilişim");
        
        Set<Urun> torba=new HashSet<Urun>();
        torba.add(urun);
        torba.add(urun2);
        saglayici.setUrunler(torba);
        
        
      
            trx.begin();
            em.persist(saglayici); // Kaydetmeden önce
            trx.commit(); // Kaydettikten sonra   
            
        em.clear();
        
        em.refresh(saglayici);
    
    }
}
