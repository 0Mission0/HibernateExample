package idv.mission.example;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CatTest {

    public static void main(String[] args) {
        Cat parent = new Cat();
        parent.setName("Mary White");
        parent.setDescription("This is mama cat");
        parent.setCreatedTime(new Date());

        Cat child1 = new Cat();
        child1.setParent(parent);
        child1.setName("Chip");
        child1.setDescription("The older one");
        child1.setCreatedTime(new Date());

        Cat child2 = new Cat();
        child2.setParent(parent);
        child2.setName("Dale");
        child2.setDescription("The young one");
        child2.setCreatedTime(new Date());

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(parent);
        session.persist(child1);
        session.persist(child2);

        transaction.commit();
        session.close();
    }
}
