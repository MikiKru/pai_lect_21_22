package pl.edu.pbs.pai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.pai.model.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
