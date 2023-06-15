package com.springboot.book.startspringbootwebservice.web.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class HelloResponseDto {
    //기본생성자와 필요 필드 생성자 같이 쓰려면 NonNull필요 final이면 기본생성자 쓸 때 초기화 필요
    @NonNull
    private String name;
    @NonNull
    private int amount;
}
