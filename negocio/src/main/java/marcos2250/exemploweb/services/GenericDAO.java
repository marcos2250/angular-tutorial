package marcos2250.exemploweb.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericDAO {

    @Autowired
    private SessionFactory hibernate;

    protected Session getCurrentSession() {
        return hibernate.getCurrentSession();
    }

    @Transactional
    public <T> void save(T obj) {
        getCurrentSession().saveOrUpdate(obj);
    }

    @Transactional
    public <T> void update(T obj) {
        getCurrentSession().update(obj);
    }

    @Transactional(readOnly = true)
    public <T> T load(Class<T> clazz, long id) {
        return clazz.cast(getCurrentSession().get(clazz, id));
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> clazz) {
        return getCurrentSession().createCriteria(clazz).list();
    }

    @Transactional
    public <T> void delete(T obj) {
        getCurrentSession().delete(obj);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> class1, Long id) {
        return (T) getCurrentSession().get(class1, id);
    }

}
