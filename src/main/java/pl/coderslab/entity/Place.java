package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "places")
public class Place {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    private String city;

    @NotBlank
    private String address;

    private String website;

    @Size(max = 300)
    @NotBlank
    private String description;

    @Column(columnDefinition="TEXT")
    private String imageSrc;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    private Type type;

    @OneToMany(mappedBy = "place")
    private List<Rate> rates = new ArrayList<>();

    @OneToMany(mappedBy = "place")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSrc() { return imageSrc; }

    public void setImageSrc(String imageSrc) { this.imageSrc = imageSrc; }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Rate> getRates() { return rates; }

    public void setRates(List<Rate> rates) { this.rates = rates; }

    public List<Comment> getComments() { return comments; }

    public void setComments(List<Comment> comments) { this.comments = comments; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
