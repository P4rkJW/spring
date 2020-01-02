package org.catstones.springcat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Post REST API Controller
 *
 * @author An Nyeong
 */
@RestController
@RequestMapping(value = "/post")
public class PostController {

    private final PostRepository posts;

    @Autowired
    public PostController(PostRepository postRepo) {
        this.posts = postRepo;
    }


    @GetMapping
    public Iterable<Post> all() {
        return posts.findAll();
    }

    @GetMapping(value = "/{id}")
    public Post findById(@PathVariable Long id) {
        return posts.findById(id).get();
    }
}
