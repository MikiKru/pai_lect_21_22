package pl.edu.pbs.pai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pbs.pai.model.entities.Role;
import pl.edu.pbs.pai.model.entities.User;
import pl.edu.pbs.pai.repository.RoleRepository;
import pl.edu.pbs.pai.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service    // klasa o specjalnym znaczeniu - implementacja logiki biznesowej aplikacji
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User registerUser(String login, String password){
        if(!login.isEmpty() && !password.isEmpty()){
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setRegistrationDateTime(LocalDateTime.now());
            user.setStatus(true);
            user.setRoles(new HashSet<>(Arrays.asList(roleRepository.getById(2))));
            // zapis do bazy danych
            userRepository.save(user);
            return user;
        }
        return null;
    }
    public Optional<User> getUserByLogin(String login){
        return userRepository.findFirstByLogin(login);
    }
    public User updateUserPassword(String login, String password){
        Optional<User> userOptional = getUserByLogin(login);
        if(userOptional.isPresent()){
            User user= userOptional.get();
            user.setPassword(password);
            // update istniejącego użytkownika
            userRepository.save(user);
            return user;
        }
        return new User();
    }
    public void deleteUserById(int userId){
        Optional<User> userOptional = userRepository.findById(userId);
        userOptional.ifPresent(user -> userRepository.delete(user));
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
