package org.example;

import org.example.entity.Alien;
import org.example.entity.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HQLMain {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.entity.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        // select * from laptop where ram = 32 -> SQL
        // from Laptop where ram = 32 -> HQL

        String brand = "Asus";

        Query query = session.createQuery("select brand,model from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Object[]> laptops = query.getResultList();

//        Laptop l1 = session.get(Laptop.class, 3);

        for (Object[] data : laptops) {
            System.out.println((String) data[0] +" "+ (String)data[1]);
        }

        System.out.println(laptops);

        session.close();

        sf.close();
    }
}
