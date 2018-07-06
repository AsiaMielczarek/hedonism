package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Place> places = new ArrayList<>();

    @ManyToMany(mappedBy = "categories")
    private List<User> users = new ArrayList<>();

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Place> getPlaces() { return places; }

    public void setPlaces(List<Place> places) { this.places = places; }

    public List<User> getUsers() { return users; }

    public void setUsers(List<User> users) { this.users = users; }

}
