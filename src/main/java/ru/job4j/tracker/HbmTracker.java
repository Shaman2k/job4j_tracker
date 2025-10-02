package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    /**
     * Сохранить в базе.
     *
     * @param item заявка.
     * @return заявка с id.
     */
    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().commit();
        }
        return item;
    }

    /**
     * Обновить в базе заявку.
     *
     * @param id id заявки
     * @param item заявка.
     * @return результат
     */
    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.createQuery(
                            "UPDATE Item SET name = :fName, created = :fCreated WHERE id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return result;
    }

    /**
     * Удалить заявку по id.
     *
     * @param id ID
     */
    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    /**
     * Список заявок
     *
     * @return список заявок.
     */
    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        return session.createQuery("FROM Item", Item.class).list();
    }

    /**
     * Список заявок по name LIKE %key%
     *
     * @param key key
     * @return список заявок.
     */
    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery(
                "FROM Item AS i WHERE i.name LIKE :fKey", Item.class);
        query.setParameter("fKey", "%" + key + "%");
        return query.getResultList();
    }

    /**
     * Найти заявку по ID
     *
     * @return заявка.
     */
    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Query<Item> query = session.createQuery(
                "FROM Item AS i WHERE i.id = :fId", Item.class);
        query.setParameter("fId", id);
        return query.uniqueResult();
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
