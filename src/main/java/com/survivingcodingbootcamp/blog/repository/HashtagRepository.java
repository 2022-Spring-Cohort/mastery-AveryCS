package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HashtagRepository extends CrudRepository <Hashtag, Long>{

    public Optional<Hashtag> findByHashtagIgnoreCase (String hashtag);
   public Optional <Hashtag> findByHashtag(String hashtag);
}
