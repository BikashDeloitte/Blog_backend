package com.example.blog.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

}
