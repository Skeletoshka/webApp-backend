package biz.itcompany.controller;

import biz.itcompany.model.Post;
import biz.itcompany.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value ="/getlist")
    @CrossOrigin
    public List<Post> getList(){
        return postService.getAll();
    }

    @PostMapping(value ="/get")
    @CrossOrigin
    public Post get(@RequestBody String id){
        return postService.getOne(Integer.parseInt(id));
    }

    @PutMapping("/update")
    @CrossOrigin
    public Post updateClient(@RequestBody Post client) {
        postService.save(client);
        return client;
    }

    @DeleteMapping("/delete")
    @CrossOrigin
    public void deleteClient(@RequestBody String id) {
        postService.deleteById(Integer.parseInt(id));
    }

}