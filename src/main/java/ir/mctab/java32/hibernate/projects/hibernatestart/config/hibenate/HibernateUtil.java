package ir.mctab.java32.hibernate.projects.hibernatestart.config.hibenate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSession() {
        return sessionFactory;
    }
}
