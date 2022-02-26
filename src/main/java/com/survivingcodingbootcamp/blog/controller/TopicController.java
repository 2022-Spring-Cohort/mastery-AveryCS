package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicRepository topicRepo;
    private PostRepository postRepo;

    public TopicController(TopicRepository topicRepo, PostRepository postRepo) {

        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
    }
    @GetMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicRepo.findById(id).get());
        return "single-topic-template";
    }

    @PostMapping("/SubmitPostTemplate/{topicId}")
    public String showSubmitPostemplate(@PathVariable long topicId, @RequestParam String title, @RequestParam String topic, @RequestParam String content,
                                        @RequestParam String author, Model model){
//        model.addAttribute("topic", postRepo.findById(topicId).get());
        Topic theTopic = topicRepo.findById(topicId).get();
        Post thePost = new Post(title, theTopic,content, author);
        postRepo.save(thePost);


        return "redirect:/topics/"+topicId;
    }

    //Need to add the submission of a new post to the topic controller. I will start here
//     model.addAttribute("post", postRepo.findById(id).get() );
}
