package ir.mctab.java32.hibernate.projects.hibernatestart;

import ir.mctab.java32.hibernate.projects.hibernatestart.config.hibenate.HibernateUtil;
import ir.mctab.java32.hibernate.projects.hibernatestart.entities.Incident;
import ir.mctab.java32.hibernate.projects.hibernatestart.entities.IncidentComment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class HibernateStartApplication {

    public static void main(String[] args) {
        new HibernateStartApplication().step2();
    }

    protected void step2() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // get session
        Session session = sessionFactory.openSession();
        // transaction start
        session.beginTransaction();
        // ----------------------------
        Incident incident = session.load(Incident.class, 7L);
        IncidentComment incidentComment = new IncidentComment();
        incidentComment.setComment("do something ...");
        incidentComment.setIncident(incident);
        session.save(incidentComment);

        // fin by id
        IncidentComment incidentComment1 = session.load(IncidentComment.class, 1L);
        System.out.println("Incident Comment {1}");
        System.out.println(incidentComment1);

        // load incident {id: 8}
        System.out.println("load incident {id: 8}");
        Incident incident8 = session.load(Incident.class, 8L);
        System.out.println(incident8);
        System.out.println(incident8.getIncidentComments().size());



        // ----------------------------
        // transaction commit
        session.getTransaction().commit();
        session.close();
    }

    protected void step1() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // get session
        Session session = sessionFactory.openSession();
        // transaction start
        session.beginTransaction();
        // ----------------------------

        // save
        Incident incident = new Incident("Problem 1", "Some details", new Date());
        Long id = (Long) session.save(incident);
        System.out.println("Incident saved and its id is " + id);
        System.out.println(incident);

        // find by id
        Incident incident2 = session.load(Incident.class, 2L);
        System.out.println(incident2);

        // find all
        Query query = session.createQuery("from Incident ");
        List<Incident> incidentList = query.list();
        incidentList.forEach(System.out::println);

        System.out.println(
                incidentList
                        .stream()
                        .filter(incident1 -> incident1.getId() > 2)
                        .count()
        );

        // remove
        // Incident incident3 = session.load(Incident.class, 3L);
        // session.remove(incident3);

        // update
        Incident incident5 = session.load(Incident.class, 5L);
        incident5.setTitle("My New Updated Title!");
        session.update(incident5);

        // ----------------------------
        // transaction commit
        session.getTransaction().commit();
        session.close();
    }
}
