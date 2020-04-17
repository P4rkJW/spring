package org.catstones.springcat.controller;

import org.catstones.springcat.repository.PostRepository;
import org.catstones.springcat.response.BaseResult;
import org.catstones.springcat.response.ListResult;
import org.catstones.springcat.response.SingleResult;
import org.catstones.springcat.service.ResponseService;

//import com.google.api.client.repackaged.com.google.common.base.Optional;

import org.catstones.springcat.PostParams;
import org.catstones.springcat.entity.Post;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Parameter;
import java.util.Optional;

/**
 * Post REST API Controller
 *
 * @author An Nyeong
 */
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/board")
public class ContestApi {
    private final ResponseService response;
    private final PostRepository postRepo;

    @GetMapping()
    public ListResult<Post> all() {
        Iterable<Post> iter = postRepo.findAll();
        return response.getListResultFromIterable(iter);
    }

    @GetMapping("/{authorSeq}")
    public SingleResult<Iterable<Post>> selectById(@PathVariable String authorSeq) {
        Iterable<Post> user = postRepo.findAllByAuthorSeq(authorSeq);
        return response.getSingleResult(user);
    }

    @DeleteMapping("/{seq}")
    public BaseResult deleteById(@PathVariable long seq) {
        postRepo.deleteById(seq);
        return response.getSuccessResult();
    }

    @PostMapping()
    public SingleResult<Post> create(@RequestBody PostParams params) {
        Post post = Post.builder().seq(params.getSeq()).authorSeq(params.getAuthorSeq()).imgurl(params.getImgurl()).title(params.getTitle()).like(params.getLike()).subscribe(params.getSubscribe()).content(params.getContent()).nickname(params.getNickname()).party(params.getParty()).deletecheck(params.getDeletecheck()).build();
        return response.getSingleResult(postRepo.save(post));
    }

    // @PutMapping("/{seq}")
    // public SingleResult<Post> update(@PathVariable long seq, @RequestBody
    // PostParams params){
    // Post post = postRepo.findById(seq);
    //
    // }

}
