package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;

import java.util.Collection;
import java.util.Optional;

// - Create a `HashtagStorage` service class to interact with your JPA repository for hashtags.  It should be able to
//        retrieve a hashtag by the value of its id field and by the value of its name/title field, retrieve all hashtags, and
//        save new and existing hashtags.

public class HashtagStorage {
    private HashtagRepository hashtagRepo;


    public Iterable<Hashtag> findAllHashtags(){
        return hashtagRepo.findAll();
    }

    public void saveNewAndExistingHashtag(Hashtag newHashtag){
        hashtagRepo.save(newHashtag);
    }
    public Optional<Hashtag> findHashtagById(long id){
        return hashtagRepo.findById(id);
    }

    public Optional<Hashtag> findHashtagByName(String hashtag){
        return hashtagRepo.findByHashtagIgnoreCase(hashtag);
    }


}


