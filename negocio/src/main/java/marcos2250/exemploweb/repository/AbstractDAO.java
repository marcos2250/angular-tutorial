package marcos2250.exemploweb.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import marcos2250.exemploweb.dominio.ObjetoPersistente;

@Repository
public abstract class AbstractDAO<T extends ObjetoPersistente> {

    @Autowired
    private SessionFactory hibernate;

    protected abstract Class<T> getClasse();

    protected Session getCurrentSession() {
        return hibernate.getCurrentSession();
    }

    @Transactional
    public void save(T obj) {
        getCurrentSession().saveOrUpdate(obj);
    }

    @Transactional
    public void update(T obj) {
        getCurrentSession().update(obj);
    }

    @Transactional(readOnly = true)
    public T load(long id) {
        return getClasse().cast(getCurrentSession().get(getClasse(), id));
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<T> list() {
        return getCurrentSession().createCriteria(getClasse()).list();
    }

    @Transactional
    public void delete(T obj) {
        getCurrentSession().delete(obj);
    }

    @Transactional(readOnly = true)
    public T get(Long id) {
        return (T) getCurrentSession().get(getClasse(), id);
    }

}