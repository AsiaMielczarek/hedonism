package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comments")
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 140)
    private String comment;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Place place;


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Place getPlace() { return place; }

    public void setPlace(Place place) { this.place = place; }
}
