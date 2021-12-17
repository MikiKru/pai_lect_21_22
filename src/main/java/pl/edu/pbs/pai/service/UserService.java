package pl.edu.pbs.pai.service;

import org.springframework.stereotype.Service;
import pl.edu.pbs.pai.model.entities.User;
import pl.edu.pbs.pai.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service    // klasa o specjalnym znaczeniu - implementacja logiki biznesowej aplikacji
public class UserService {
    public User registerUser(String login, String password){
        if(!login.isEmpty() && !password.isEmpty()){
            User user = new User();
            UserRepository.users.add(user);     // dodanie użytkownika do listy
            return user;
        }
        return null;
    }
    public Optional<User> getUserByLogin(String login){
        return UserRepository.users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }
    public User updateUserPassword(String login, String password){
        getUserByLogin(login).ifPresent(user -> user.setPassword(password));
        return getUserByLogin(login).orElseGet(User::new);
    }
    public void deleteUserById(int userId){
        UserRepository.users.remove(userId);
    }
    public List<User> getAllUsers(){
        return UserRepository.users;
    }
}
