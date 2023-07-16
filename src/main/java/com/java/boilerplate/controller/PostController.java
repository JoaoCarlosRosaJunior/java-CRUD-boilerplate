package com.java.boilerplate.controller;

import com.java.boilerplate.dto.request.PostRequestDTO;
import com.java.boilerplate.dto.response.PostResponseDTO;
import com.java.boilerplate.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> findAll() {
        return ResponseEntity.ok().body(postService.findAll());
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> makePost(@RequestBody PostRequestDTO postRequestDTO, UriComponentsBuilder uriBuilder) {
        PostResponseDTO postResponseDTO = postService.register(postRequestDTO);

        URI uri = uriBuilder.path("/post/{id}").buildAndExpand(postResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(postResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostResponseDTO> update(@RequestBody PostRequestDTO postDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(postService.update(id, postDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(postService.delete(id));
    }
}
