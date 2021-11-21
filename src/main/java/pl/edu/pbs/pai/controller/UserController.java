package pl.edu.pbs.pai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pbs.pai.model.User;
import pl.edu.pbs.pai.service.UserService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
//@Controller       // klasa o specjalnym znaczeniu - mapowanie adresów - zwraca widok
@RestController     // klasa o specjalnym znaczeniu - mapowanie adresów - zwraca dane -> uniform interface
public class UserController {
    @Autowired               // wstrzykiwanie zależności klasy UserService do UserController
    UserService userService;
    @GetMapping("/user/login={login}")     // mapuje żądanie typu get dla adresu: localhost:8080/api/users
    public User getUserByLogin(@PathVariable("login") String login){
        return userService.getUserByLogin(login).orElseGet(User::new);
    }
    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PutMapping("/user/login={login}")
    public User updateUserPassword(
            @PathVariable("login") String login, @RequestParam("password") String password
    ){
        return userService.updateUserPassword(login,password);
    }
    @DeleteMapping("/user/{user_id}")
    public void deleteById(@PathVariable("user_id") int userId){
        userService.deleteUserById(userId);
    }
    @PostMapping("/user")
    public String registerUser(
            @RequestParam("login") String login,
            @RequestParam("password") String password
    ){
       if(userService.registerUser(login,password) != null){
           return "ZAREJESTROWANO";
       }
       return "BŁĄD REJESTRACJI";
    }


}
