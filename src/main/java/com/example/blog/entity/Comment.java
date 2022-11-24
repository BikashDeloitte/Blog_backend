package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data @AllArgsConstructor
@NoArgsConstructor
@ToString @Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @Size(max = 100000)
    private String Comment;
    @OneToOne
    private UserData userData;
    @ManyToOne
    private Post post;
    private LocalDate commentDate;

    public Comment(Long id, String comment, LocalDate commentDate) {
        this.id = id;
        Comment = comment;
        this.commentDate = commentDate;
    }
}
