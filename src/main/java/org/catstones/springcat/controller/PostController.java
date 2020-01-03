package org.catstones.springcat.controller;

import org.catstones.springcat.repository.PostRepository;
import org.catstones.springcat.response.BaseResult;
import org.catstones.springcat.response.ListResult;
import org.catstones.springcat.response.SingleResult;
import org.catstones.springcat.service.ResponseService;
import org.catstones.springcat.PostParams;
import org.catstones.springcat.entity.Post;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * Post REST API Controller
 *
 * @author An Nyeong
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/post")
@Api(tags = {"Post"})
public class PostController {

    private final ResponseService response;
    private final PostRepository postRepo;

    @ApiOperation(value = "모든 포스트 보기", notes = "모든 포스트를 불러온다")
    @GetMapping
    public ListResult<Post> all() {
        Iterable<Post> iter = postRepo.findAll();
        return response.getListResultFromIterable(iter);
    }

    @PostMapping
    public SingleResult<Post> create(@RequestBody PostParams params) {
        Post post = Post.builder().author(params.getAuthor()).content(params.getContent())
                .title(params.getTitle()).build();

        return response.getSingleResult(postRepo.save(post));
    }


    @GetMapping(value = "/{id}")
    public SingleResult<Post> findById(@PathVariable Long id) throws Exception {
        Post post = postRepo.findById(id).orElseThrow(Exception::new);
        return response.getSingleResult(post);
    }

    @PutMapping(value = "/{id}")
    public SingleResult<Post> update(@PathVariable Long id, @RequestBody PostParams params)
            throws Exception {
        Post post = postRepo.findById(id).orElseThrow(Exception::new);
        post.update(params.getAuthor(), params.getTitle(), params.getContent());
        return response.getSingleResult(post);
    }

    @DeleteMapping(value = "/{id}")
    public BaseResult deleteById(@PathVariable Long id) {
        postRepo.deleteById(id);
        return response.getSuccessResult();
    }
}
