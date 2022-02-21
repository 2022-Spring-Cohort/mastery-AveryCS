package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue

    private long hashtagId;
    private String hashtag;
}
