package pl.edu.pbs.pai.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

// klasa modelu - determinuje model danych
//@Getter
//@Setter
//@ToString
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // pola są prywatne
    @Id             // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // A_I
    private int user_id;
    private String login;
    private String password;
    private boolean status;
    private LocalDateTime registrationDateTime;
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_to_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    // metody dostępowe get/set     -> adnotacja @Getter @Setter        -> @Data
    // toString                     -> adnotacja @ToString              ->
    // konstruktor/y                -> adnotacja @AllArgsConstructor @NoArgsContructor
}
