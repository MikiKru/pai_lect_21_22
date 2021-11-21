package pl.edu.pbs.pai.repository;

import pl.edu.pbs.pai.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserRepository {
    public static List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User("a@a.pl", "a", true, LocalDateTime.of(2021,1,1,10,10)),
                    new User("b@b.pl", "b", true, LocalDateTime.of(2021,2,14,9,10)),
                    new User("c@c.pl", "c", true, LocalDateTime.of(2020,3,12,10,10)),
                    new User("d@d.pl", "d", true, LocalDateTime.of(2020,12,1,9,10)),
                    new User("e@e.pl", "e", true, LocalDateTime.of(2020,3,11,10,10))
            ));
}
