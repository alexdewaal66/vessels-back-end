package nl.alexdewaal66.novi.vessels.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Subdivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 2)
    private String alpha_2_code;

    @Size(max = 3)
    private String code;

    @Size(max = 150)
    @Column(name = "subdivision_name")
    private String name;

    @Size(max = 100)
    @Column(name = "subdivision_type")
    private String type;

}
