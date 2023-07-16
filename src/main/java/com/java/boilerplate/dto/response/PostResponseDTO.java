package com.java.boilerplate.dto.response;

import com.java.boilerplate.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDTO {
    private Long id;
    private String title;
    private String text;

    public PostResponseDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.text = post.getText();
    }
}
