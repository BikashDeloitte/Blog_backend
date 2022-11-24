package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Size(max = 100000)
    private String content;

    private String postImage;

    @OneToOne
    private PostCategory category;

    @OneToOne
    private UserData userData;

    private LocalDate createdDate;

    public Post(String title, String content, PostCategory category, UserData userData, LocalDate createdDate) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.userData = userData;
        this.createdDate = createdDate;
    }

    public Post(String title, String content, String postImage, PostCategory category, UserData userData, LocalDate createdDate) {
        this.title = title;
        this.content = content;
        this.postImage = postImage;
        this.category = category;
        this.userData = userData;
        this.createdDate = createdDate;
    }
}
