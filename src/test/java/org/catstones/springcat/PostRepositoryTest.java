//package org.catstones.springcat;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.catstones.springcat.repository.*;
//import org.catstones.springcat.entity.*;
//
//@SpringBootTest
//public class PostRepositoryTest {
//
//    @Autowired
//    PostRepository postRepo;
//
//    @AfterEach
//    public void cleanup() {
//        postRepo.deleteAll();
//    }
//
//    @Test
//    public void loadAllPosts() {
//        postRepo.save(Post.builder().title("안녕").author("An Nyeong")
//                .content("이게 본문입니다 이게 엄청 길어진다고 하면 안되는데 말이야").build());
//
//        List<Post> posts = new ArrayList<>();
//        postRepo.findAll().forEach(posts::add);
//
//        Post post = posts.get(0);
//        assertEquals("안녕", post.getTitle());
//    }
//
//}
