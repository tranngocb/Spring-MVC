package com.codeup.models;

import javax.persistence.*;


/**
 * Created by bichtran on 6/19/17.
 */
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,columnDefinition = "Text")
    private String body;

    @OneToOne
    private User owner;

    public Post(String title,String body) {
        this.title = title;
        this.body = body;
    }
    //Empty model needed by form in create.html
    public Post(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
