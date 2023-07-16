package com.java.boilerplate.util;

import com.java.boilerplate.dto.request.PostRequestDTO;
import com.java.boilerplate.dto.response.PostResponseDTO;
import com.java.boilerplate.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {
    public Post toPost(PostRequestDTO postDTO) {
        return Post.builder()
                .title(postDTO.getTitle())
                .text(postDTO.getText())
                .build();

    }

    public PostResponseDTO toPostDTO(Post post) {
        return new PostResponseDTO(post);
    }

    public List<PostResponseDTO> toPostsDTO(List<Post> postList) {
        return postList.stream().map(PostResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePostData(Post post, PostRequestDTO postDTO) {
        post.setTitle(postDTO.getTitle());
        post.setText(postDTO.getText());
    }
}
