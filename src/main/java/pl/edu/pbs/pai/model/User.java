package pl.edu.pbs.pai.model;

import lombok.*;

import java.time.LocalDateTime;

// klasa modelu - determinuje model danych
//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // pola są prywatne
    private String login;
    private String password;
    private boolean status;
    private LocalDateTime registrationDateTime;
    // metody dostępowe get/set     -> adnotacja @Getter @Setter        -> @Data
    // toString                     -> adnotacja @ToString              ->
    // konstruktor/y                -> adnotacja @AllArgsConstructor @NoArgsContructor
}
