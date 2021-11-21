package pl.edu.pbs.pai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.pbs.pai.model.User;

@Controller
public class MainController {

    @ResponseBody               // umożliwia zwrócednie obiektu danych w @Controller
    @GetMapping("/emptyUser")
    public User getUser(){
        return new User();
    }
}
