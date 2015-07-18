package marcos2250.exemploweb.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GenericDAO {

    @Autowired
    private SessionFactory hibernate;

    public <T> void save(T obj) {
        hibernate.getCurrentSession().saveOrUpdate(obj);
    }

    @Transactional(readOnly = true)
    public <T> T load(Class<T> clazz, long id) {
        return clazz.cast(hibernate.getCurrentSession().get(clazz, id));
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> clazz) {
        return hibernate.getCurrentSession().createCriteria(clazz).list();
    }
}
