package tn.esprit.salemzacharia.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Zone  implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private float dimension;
    @ManyToOne
    private Parking parking;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Personnel> personnels;
    @OneToOne(mappedBy = "zoneP")
    private Personnel personnel;
}
