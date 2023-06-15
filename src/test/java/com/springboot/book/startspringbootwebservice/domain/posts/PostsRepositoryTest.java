package com.springboot.book.startspringbootwebservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest //H2 DataBase 자동실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void postRepositoryTest() {
        //given
        String title = "게시글테스트제목";
        String content = "게시글테스트내용";
        String author = "게시글테스트작성자";

        postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author(author)
                        .build());

        //when
        List<Posts> posts = postsRepository.findAll();

        Posts post = posts.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getAuthor()).isEqualTo(author);
    }
}
