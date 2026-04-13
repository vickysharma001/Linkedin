package com.building.linkedin.posts_service.controller;


import com.building.linkedin.posts_service.dto.PostCreateRequestDto;
import com.building.linkedin.posts_service.dto.PostDto;
import com.building.linkedin.posts_service.service.PostsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequestDto postDto, HttpServletRequest httpServletRequest){
     //   Long userId = Long.valueOf(httpServletRequest.getHeader("X-User-Id")); //  extract userId
        PostDto createPost = postsService.createPost(postDto,1L);         //  pass userId
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }
}
