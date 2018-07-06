package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="rates")
public class Rate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rate;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Place place;


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getRate() { return rate; }

    public void setRate(Double rate) { this.rate = rate; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Place getPlace() { return place; }

    public void setPlace(Place place) { this.place = place; }
}
