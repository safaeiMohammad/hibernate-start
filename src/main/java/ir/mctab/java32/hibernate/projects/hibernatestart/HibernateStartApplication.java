package ir.mctab.java32.hibernate.projects.hibernatestart;

import ir.mctab.java32.hibernate.projects.hibernatestart.config.hibenate.HibernateUtil;
import org.hibernate.SessionFactory;

public class HibernateStartApplication {

    public static void main(String[] args) {
        SessionFactory session = HibernateUtil.getSession();
    }
}
