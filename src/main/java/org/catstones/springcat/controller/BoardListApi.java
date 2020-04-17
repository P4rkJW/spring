package org.catstones.springcat.controller;

import org.catstones.springcat.repository.BoardListRepository;
import org.catstones.springcat.repository.PostRepository;
import org.catstones.springcat.response.BaseResult;
import org.catstones.springcat.response.ListResult;
import org.catstones.springcat.response.SingleResult;
import org.catstones.springcat.service.ResponseService;
import org.catstones.springcat.BoardListParams;
import org.catstones.springcat.entity.BoardList;
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
@RequestMapping(value = "/api/v1/boardlist")
public class BoardListApi {
    private final ResponseService response;
    private final BoardListRepository postRepo;

    @GetMapping()
    public ListResult<BoardList> all() {
        Iterable<BoardList> iter = postRepo.findAll();
        return response.getListResultFromIterable(iter);
    }

    @GetMapping("/{seq}")
    public SingleResult<java.util.Optional<BoardList>> selectById(@PathVariable long seq) {
    java.util.Optional<BoardList> user = postRepo.findById(seq);
    return response.getSingleResult(user);
    }

    @DeleteMapping("/{seq}")
    public BaseResult deleteById(@PathVariable long seq) {
    postRepo.deleteById(seq);
    return response.getSuccessResult();
    }

    @PostMapping()
    public SingleResult<BoardList> create(@RequestBody BoardListParams params) {
        BoardList post = BoardList.builder().seq(params.getSeq()).boardname(params.getBoardname())
                .author(params.getAuthor()).build();
        return response.getSingleResult(postRepo.save(post));
    }

    // @PutMapping("/{seq}")
    // public SingleResult<Post> update(@PathVariable long seq, @RequestBody
    // PostParams params){
    // Post post = postRepo.findById(seq);
    //
    // }

}
