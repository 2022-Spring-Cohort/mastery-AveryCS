package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue

    private long hashtagId;
    private String hashtag;

    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    public Hashtag(long hashtagId, String hashtag) {
        this.hashtagId = hashtagId;
        this.hashtag = hashtag;
    }

    public Hashtag (){
    }

    public long getHashtagId() {
        return hashtagId;
    }

    public String getHashtag() {
        return hashtag;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
}

