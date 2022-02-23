package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagController {
    private HashtagRepository hashtagRepo;

    public HashtagController(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    @GetMapping("/all-hashtags-template")
    public String displaySingleHashtagTemplate( Model model){
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "/all-hashtags-template";
    }

    @RequestMapping("/single-hashtag-template/{hashtagId}")
    public String showPostTemplate(Model model, @PathVariable long hashtagId) {
        System.out.println("------------------------------");
        System.out.println(hashtagRepo.findById(hashtagId).get());
        System.out.println(hashtagRepo.findById(hashtagId).get().getPosts().size());
        model.addAttribute("hashtag", hashtagRepo.findById(hashtagId).get());
        return "single-hashtag-template";
    }

}

