package org.catstones.springcat.controller;

import org.catstones.springcat.repository.CommentRepository;
import org.catstones.springcat.repository.PostRepository;
import org.catstones.springcat.repository.ReplyCommentRepository;
import org.catstones.springcat.response.BaseResult;
import org.catstones.springcat.response.ListResult;
import org.catstones.springcat.response.SingleResult;
import org.catstones.springcat.service.ResponseService;

import java.util.List;

import org.catstones.springcat.ReplyCommentParams;
import org.catstones.springcat.entity.ReplyComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
@RequestMapping(value = "/api/v1/replycomment")
public class ReplyCommentApi {
    private final ResponseService response;
    private final ReplyCommentRepository postRepo;

    @GetMapping()
    public ListResult<ReplyComment> all() {
        // Iterable<ReplyComment> iter = postRepo.findAll(seq);
        Iterable<ReplyComment> iter = postRepo.findTop5ByOrderBySeqAsc();
        // return postRepo.find
        return response.getListResultFromIterable(iter);
    }

    @GetMapping("/{seq}")
    public SingleResult<java.util.Optional<ReplyComment>> selectById(@PathVariable long seq) {
        java.util.Optional<ReplyComment> user = postRepo.findById(seq);
        return response.getSingleResult(user);
    }

    @DeleteMapping("/{seq}")
    public BaseResult deleteById(@PathVariable long seq) {
        postRepo.deleteById(seq);
        return response.getSuccessResult();
    }

    // @PostMapping()
    // public SingleResult<ReplyComment> create(@RequestBody ReplyCommentParams
    // params){
    // ReplyComment post =
    // ReplyComment.builder().seq(params.getSeq()).comment_seq(params.getComment_seq()).nickname(params.getNickname()).text(params.getText()).update_time(params.getUpdate_time()).build();
    // return response.getSingleResult(postRepo.save(post));
    // }

    // @PutMapping("/{seq}")
    // public SingleResult<Post> update(@PathVariable long seq, @RequestBody
    // PostParams params){
    // Post post = postRepo.findById(seq);
    //
    // }

}
