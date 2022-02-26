package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class HashtagController {
    private HashtagRepository hashtagRepo;
    private PostRepository postRepo;
    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagRepository hashtagRepo, PostRepository postRepo) {
        this.hashtagRepo = hashtagRepo;
        this.postRepo = postRepo;
    }


    @GetMapping("/all-hashtags-template")
    public String displaySingleHashtagTemplate(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "/all-hashtags-template";
    }

    @RequestMapping("/single-hashtag-template/{hashtagId}")
    public String showPostTemplate(Model model, @PathVariable long hashtagId) {
        model.addAttribute("hashtag", hashtagRepo.findById(hashtagId).get());
        return "single-hashtag-template";
    }

    @PostMapping("/SubmitHashtag")
    public String addHashtag(@RequestParam String hashtag, @RequestParam Long id) {
        Post thePost = postRepo.findById(id).get();

        Optional<Hashtag> tempHashtag = hashtagRepo.findByHashtagIgnoreCase(hashtag);
        if (tempHashtag.isPresent()) {
            if (!tempHashtag.get().getPosts().contains(thePost)) {
                tempHashtag.get().addPost(thePost);
                hashtagRepo.save(tempHashtag.get());
            }
        } else {
            Hashtag theHashtag = new Hashtag(hashtag, thePost);
            hashtagRepo.save(theHashtag);
//        return "redirect:/SingleHashtagViewTemplate/" + myHashtagId; ""
        }
        return "redirect:/all-hashtags-template";

    }
}

