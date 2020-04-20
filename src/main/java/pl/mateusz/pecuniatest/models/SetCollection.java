package pl.mateusz.pecuniatest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@ToString
//@Entity
//@Table(name = "set_collections")
public class SetCollection extends Many {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "notes_list")
    private String notesList;

}
