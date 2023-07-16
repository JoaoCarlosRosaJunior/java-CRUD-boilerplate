package com.java.boilerplate.service;

import com.java.boilerplate.dto.request.PostRequestDTO;
import com.java.boilerplate.dto.response.PostResponseDTO;

import java.util.List;

public interface PostService {
    PostResponseDTO findById(Long id);

    List<PostResponseDTO> findAll();

    PostResponseDTO register(PostRequestDTO personDTO);

    PostResponseDTO update(Long id, PostRequestDTO personDTO);

    String delete(Long id);
}
