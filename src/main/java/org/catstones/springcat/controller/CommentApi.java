package org.catstones.springcat.controller;

import org.catstones.springcat.repository.CommentRepository;
import org.catstones.springcat.repository.PostRepository;
import org.catstones.springcat.response.BaseResult;
import org.catstones.springcat.response.ListResult;
import org.catstones.springcat.response.SingleResult;
import org.catstones.springcat.service.ResponseService;

import java.util.Optional;

import org.catstones.springcat.CommentParams;
import org.catstones.springcat.entity.Comment;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

/**
 * Post REST API Controller
 *
 * @author An Nyeong
 */
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/comment")
public class CommentApi {
    private final ResponseService response;
    private final CommentRepository postRepo;

    @GetMapping()
    public ListResult<Comment> all() {
        Iterable<Comment> iter = postRepo.findAll();
        return response.getListResultFromIterable(iter);
    }

    @GetMapping("/{boardseq}")
    public SingleResult<Iterable<Comment>> selectById(@PathVariable long boardseq) {
        Iterable<Comment> user = postRepo.findAllByBoardseq(boardseq);
        return response.getSingleResult(user);
    }

    @DeleteMapping("/{seq}")
    public BaseResult deleteById(@PathVariable long seq) {
        postRepo.deleteById(seq);
        return response.getSuccessResult();
    }

    @PostMapping()
    public SingleResult<Comment> create(@RequestBody CommentParams params) {
        Comment post = Comment.builder().seq(params.getSeq()).boardseq(params.getBoardseq())
                .nickname(params.getNickname()).text(params.getText()).updatetime(params.getUpdatetime()).build();
        return response.getSingleResult(postRepo.save(post));
    }

    // @PutMapping("/{seq}")
    // public SingleResult<Post> update(@PathVariable long seq, @RequestBody
    // PostParams params){
    // Post post = postRepo.findById(seq);
    //
    // }

}
