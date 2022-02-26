package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue

    private long hashtagId;
    private String hashtag;

    @ManyToMany
    private Collection<Post> posts;


    public Hashtag(String hashtag, Post...posts) {
        this.hashtag = hashtag;
        this.posts = Arrays.asList(posts);
    }

    public Hashtag (){
    }
    public void addPost(Post post) {
        posts.add(post);
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

    public boolean containsPost(Post post){
            return posts.contains(post);
        }






}

