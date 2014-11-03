
import com.nar.model.Barang;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class MainHibernate 
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

//        Barang b = new Barang();
//        b.setKodeBarang("brng001");
//        b.setNamaBarang("Baygon");
//        b.setDeskripsi("Pembasmi nyamuk");
//        b.setHargaJual(10000);
//        b.setSatuan("pcs");
//        b.setStock(100);
//
//        Session session = sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            session.save(b);
//            session.getTransaction().commit();
//        } catch (HibernateException hibernateException) {
//            session.getTransaction().rollback();
//        }
//        session.close();
//
//        session = sessionFactory.openSession();
//        Query query = session.createQuery("from Barang");
//        List<Barang> barangs = query.list();
//        for (Barang person : barangs) {
//            System.out.println("Kode Barang : " + b.getKodeBarang());
//            System.out.println("Nama Barang : " + b.getNamaBarang());
//            System.out.println("Deskripsi : " + b.getDeskripsi());
//        }
//
//        session.close();
//        sessionFactory.close();
    }
}
