package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByModelAndSeries(String model, int series) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.car.model = :model AND u.car.series = :series", User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsersByModelAndSeries(String model, int series) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.car.model = :model AND u.car.series = :series", User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .getResultList();
    }
}
