package com.javadevjournal.springbooth2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "POKEMON")
public class Pokemon {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "user_sequence"),
        // start id at 6 b/c we initialize h2 db with 1-5 ids on startup
        @Parameter(name = "initial_value", value = "6"),
        @Parameter(name = "increment_size", value = "1")
      }
    )
    Integer id;
    String name;

    @OneToMany(mappedBy = "pokemon", fetch = FetchType.EAGER)
	@JsonManagedReference
	List<Type> identity = new ArrayList<>();

    // Sprite sprite;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    // public Sprite getSprite() {
    //     return sprite;
    // }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    // public void setSprite(Sprite sprite) {
    //     this.sprite = sprite;
    // }
}