package com.example.blog.service;

import com.example.blog.entity.Post;
import com.example.blog.entity.PostCategory;
import com.example.blog.entity.PostResponse;
import com.example.blog.entity.UserData;
import com.example.blog.exception.NotFoundException;
import com.example.blog.repository.PostCategoryRespository;
import com.example.blog.repository.PostRespository;
import com.example.blog.repository.UserDataRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    PostRespository postRespository;
    @Autowired
    UserDataRespository userDataRespository;
    @Autowired
    PostCategoryRespository categoryRespository;

    @Value("${image.folderName}")
    private String path;

    //get all post from database
    public List<Post> getAllPost() {
        return postRespository.findAll();
    }

    //create or update post data
    public Post addPost(Post post, Long userId, Long categoryId) {
        //mapping user
        Optional<UserData> userData = userDataRespository.findById(userId);
        userData.ifPresent(post::setUserData);
        //mapping post category
        Optional<PostCategory> category = categoryRespository.findById(categoryId);
        category.ifPresent(post::setCategory);
        //setting post date
        post.setCreatedDate(LocalDate.now());

        return postRespository.save(post);
    }

    //get posts according to page and page details
    public PostResponse getAllPostPages(Integer pageNumber, Integer pageSize) {

        Pageable pagePost = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePostList = postRespository.findAll(pagePost);
        List<Post> posts = pagePostList.getContent();
        return new PostResponse(posts, pageNumber, pageSize,
                pagePostList.getTotalElements(),
                pagePostList.getTotalPages()
                , pagePostList.isLast());
    }

    //get post by id
    public Post getPostById(Long id) {
        Optional<Post> post = postRespository.findById(id);
        return post.orElse(null);
    }

    //upload image
    public String uploadImage(MultipartFile postImage, Long postId) throws IOException {
        Optional<Post> post = postRespository.findById(postId);

        if (!post.isPresent()) {
            throw new NotFoundException("post not found");
        }

        //file name
        String name = postImage.getOriginalFilename();
        //avoid image same name confluent
        String randomName = UUID.randomUUID().toString() + name.substring(name.lastIndexOf('.'));

        //full path
        String filePath = path + File.separator + randomName;

        //create folder if not exist
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        //file copy
        Files.copy(postImage.getInputStream(), Paths.get(filePath));

        post.get().setPostImage(randomName);
        postRespository.save(post.get());
        System.out.println("create full path "+filePath);
        return randomName;
    }


    public InputStream getPostImage(Long postId) throws FileNotFoundException {
        Optional<Post> post = postRespository.findById(postId);

        if (post.isPresent()) {
            String fullPath = path + "/" + post.get().getPostImage();
            InputStream postImage = new FileInputStream(fullPath);
            return postImage;
        }

        return null;
    }
}
