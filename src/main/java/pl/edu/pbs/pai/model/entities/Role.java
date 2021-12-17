package pl.edu.pbs.pai.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.pbs.pai.model.enums.RoleName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    private RoleName roleName;
}
