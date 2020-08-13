package com.jgdodson.LinkShortener;

import javax.persistence.*;

/**
 * Represents the mapping from short link (id) to long link (url)
 */
@Entity
public class LinkMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String url;

    // Default constructor, used by JPA
    protected LinkMapping() {
    }

    // Constructor
    public LinkMapping(String url) {
        this.url = url;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter for url
    public String getUrl() {
        return url;
    }
}
