package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   @Transactional
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   @Transactional(readOnly = true)
   public User getUserByModelAndSeries(String model, int series) {
      return userDao.getUserByModelAndSeries(model, series);
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> getUsersByModelAndSeries(String model, int series) {
      return userDao.getUsersByModelAndSeries(model, series);
   }
}
