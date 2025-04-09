package hiber.service;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    @Transactional(readOnly = true)
    User getUserByModelAndSeries(String model, int series);


    @Transactional(readOnly = true)
    List <User> getUsersByModelAndSeries(String model, int series);

}
