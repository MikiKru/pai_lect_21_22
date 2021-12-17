package pl.edu.pbs.pai.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.DeclareAnnotation;
import pl.edu.pbs.pai.model.enums.Category;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    private String title;
    private String content;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private LocalDateTime dateAdded;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
}
