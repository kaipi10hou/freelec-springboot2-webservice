package com.springboot.book.startspringbootwebservice.service.posts;

import com.springboot.book.startspringbootwebservice.domain.posts.PostsRepository;
import com.springboot.book.startspringbootwebservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}