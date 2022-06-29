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

    // @OneToMany(mappedBy = "POKEMON", fetch = FetchType.EAGER)
	// @JsonManagedReference
	// private List<Pokemon> types = new ArrayList<>();

    // @OneToMany(mappedBy = "pokemon", fetch = FetchType.EAGER)
	// @JsonManagedReference
	// private List<Sprite> party = new ArrayList<>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // public List<String> getTypes() {
    //     return types;
    // }
    // public void setTypes(List<String> types) {
    //     this.types = types;
    // }
    // public Sprite getSprite() {
    //     return sprite;
    // }
    // public void setSprite(Sprite sprite) {
    //     this.sprite = sprite;
    // }
}