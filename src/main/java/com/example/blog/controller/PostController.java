package com.example.blog.controller;

import com.example.blog.entity.Post;
import com.example.blog.entity.PostResponse;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@CrossOrigin("http://localhost:3000")
public class PostController {

    @Autowired
    PostService postService;

    //get all post data with pagination
    @GetMapping("/post")
    public ResponseEntity<PostResponse> getAllPostPages(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {

        return ResponseEntity.ok(postService.getAllPostPages(pageNumber, pageSize));
    }

    //create post data
    @PostMapping("/user/{userId}/category/{categoryId}/post")
    public ResponseEntity<Post> addPost(
            @RequestBody Post post,
            @PathVariable Long userId,
            @PathVariable Long categoryId
    ) {
        return ResponseEntity.ok(postService.addPost(post, userId, categoryId));
    }

    //get post by id
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    //upload post image
    @PostMapping("/upload/{postId}")
    public ResponseEntity<String> uploadPostImage(@RequestParam("postImage") MultipartFile postImage,@PathVariable Long postId ) {
        try {
            postService.uploadImage(postImage,postId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("successful");
    }

    //get the post image
    @GetMapping(value = "/post/{postId}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getPostImage(@PathVariable Long postId, HttpServletResponse response) throws IOException {

        InputStream postImage = postService.getPostImage(postId);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(postImage,response.getOutputStream());

    }
}
