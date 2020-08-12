package com.jgdodson.LinkShortener;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LinkMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String link;

    // Default constructor, used by JPA
    protected LinkMapping() {}

    // Constructor
    public LinkMapping(String link) {
        this.link = link;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter for link
    public String getLink() {
        return link;
    }
}
