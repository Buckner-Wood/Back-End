package com.javadevjournal.springbooth2.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TYPE")
public class Type {

    @Id
    Integer id;

    @Column
	String name;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonBackReference
    Pokemon pokemon;
}
