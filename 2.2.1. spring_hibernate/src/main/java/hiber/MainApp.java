package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("BMW", 5);
      User user1 = new User("John", "Doe", "john.doe@example.com", car1);

      Car car2 = new Car("Audi", 6);
      User user2 = new User("Jane", "Doe", "jane.doe@example.com", car2);

      userService.add(user1);
      userService.add(user2);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }


      User foundUser = userService.getUserByModelAndSeries("BMW", 5);
      System.out.println("Found User: " + foundUser);
   }
}
