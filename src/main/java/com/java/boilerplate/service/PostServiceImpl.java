package com.java.boilerplate.service;

import com.java.boilerplate.dto.request.PostRequestDTO;
import com.java.boilerplate.dto.response.PostResponseDTO;
import com.java.boilerplate.entity.Post;
import com.java.boilerplate.repository.PostRepository;
import com.java.boilerplate.util.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    private final PostMapper postMapper;


    @Override
    public PostResponseDTO findById(Long id) {
        return postMapper.toPostDTO(returnPost(id));
    }

    @Override
    public List<PostResponseDTO> findAll() {
        return postMapper.toPostsDTO(postRepository.findAll());
    }

    @Override
    public PostResponseDTO register(PostRequestDTO postDTO) {

        Post post = postMapper.toPost(postDTO);

        return postMapper.toPostDTO(postRepository.save(post));
    }

    @Override
    public PostResponseDTO update(Long id, PostRequestDTO postDTO) {

        Post post = returnPost(id);

        postMapper.updatePostData(post,postDTO);

        return postMapper.toPostDTO(postRepository.save(post));
    }

    @Override
    public String delete(Long id) {
        postRepository.deleteById(id);
        return "Post id: "+id+" deleted";
    }

    private Post returnPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Post wasn't fount on database"));
    }
}
