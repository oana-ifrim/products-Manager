package service;



import java.util.List;
import java.util.Optional;

import model.User;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findUserByName(String name);
    String saveUser(User user);
}
