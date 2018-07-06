package pl.coderslab.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Controller
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    RateRepository rateRepository;

    @ModelAttribute("places")
    public Collection<Place> getAllPlaces(){
        return placeRepository.findAll();
    }

    @ModelAttribute("categories")
    public Collection<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @ModelAttribute("types")
    public Collection<Type> getAllTypes(){
        return typeRepository.findAll();
    }

    @ModelAttribute("users")
    public Collection<User> getAllUsers(){
        return userRepository.findAll();
    }

    @ModelAttribute("city")
    public Collection<Place> findByCity(String city){
        return placeRepository.findAllByCity(city);
    }


    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/all")
    public String showAllPlaces(){
        return "place/all";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/add")
    public String addPlace(Model model, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("place", new Place());
        return "place/add";
    }

    @PostMapping("/add")
    public String savePlace(@Valid Place place, BindingResult result, HttpSession session, HttpServletRequest request){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        System.out.println(user.getEmail());
        if(result.hasErrors()){
            return "place/add";
        }
        place.setUser(user);
        placeRepository.save(place);
        return "redirect:"+ request.getContextPath() +"/you/added";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/edit/{name}")
    public String editPlace(Model model, @PathVariable String name, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        Place edited = placeRepository.findByName(name);
        model.addAttribute("editedplace", edited);
        return "place/edit";
    }

    @PostMapping("/edit/{name}")
    public String updatePlace(Model model, @Valid Place place, BindingResult result, HttpSession session, HttpServletRequest request){
        if(result.hasErrors()){
            return "place/edit";
        }

        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);

//        place.setUser(user);
        placeRepository.save(place);
        return "redirect:"+ request.getContextPath() +"/you/added";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/delete/{name}")
    public String deletePlace(Model model, @PathVariable String name, HttpSession session, HttpServletRequest request){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        Place place = placeRepository.findByName(name);
        placeRepository.delete(place.getId());
        return "redirect:"+ request.getContextPath() +"/you/added";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/{city}")
    public String chooseType(@PathVariable String city, Model model, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("city", city);
        return "place/type";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/{city}/breakfast")
    public String breakfast(@PathVariable String city, Model model, HttpSession session, HttpServletRequest request){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("city", city);
        Type type = typeRepository.findFirstByName("breakfast");
        if(placeRepository.findAllByTypeAndCity(type, city) == null || placeRepository.findAllByTypeAndCity(type, city).isEmpty()){
            return "forward:/";
        }
        List<Place> breakfastPlaces = placeRepository.findAllByTypeAndCity(type, city);
        model.addAttribute("breakfastPlaces", breakfastPlaces);

        List<Place> places = placeRepository.findAll();
        List<Long> pId = new ArrayList<>();
        for (Place p: places){
            pId.add(p.getId());
        }
        Random r = new Random();

        return "place/breakfast";
    }

    @GetMapping("/{city}/dinner&supper")
    public String dinner(@PathVariable String city, Model model, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("city", city);
        Type type = typeRepository.findFirstByName("dinner&supper");
        if(placeRepository.findAllByTypeAndCity(type, city)==null||placeRepository.findAllByTypeAndCity(type, city).isEmpty()){
            return "forward:/";
        }
        List<Place> dinnerPlaces = placeRepository.findAllByTypeAndCity(type, city);
        model.addAttribute("dinnerPlaces", dinnerPlaces);

        Random r = new Random();
        int randomId = r.nextInt(dinnerPlaces.size())+1;
        Long rId = (long) randomId;
        for (Place d: dinnerPlaces){
            if(d.getId() == rId){
                model.addAttribute("randomPlace", d);
            }
        }
        return "place/dinner";
    }

    @GetMapping("/{city}/coffee&sweet")
    public String coffee(@PathVariable String city, Model model, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("city", city);
        Type type = typeRepository.findFirstByName("coffee&sweet");
        if(placeRepository.findAllByTypeAndCity(type, city)==null||placeRepository.findAllByTypeAndCity(type, city).isEmpty()){
            return "forward:/";
        }
        List<Place> coffeePlaces = placeRepository.findAllByTypeAndCity(type, city);
        model.addAttribute("coffeePlaces", coffeePlaces);

        Random r = new Random();
        int randomId = r.nextInt(coffeePlaces.size())+1;
        Long rId = (long) randomId;
        return "place/coffee";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/{city}/breakfast/{name}")
    public String breakfastPlace(Model model, @PathVariable String city, @PathVariable String name, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("city", city);
        Place place = placeRepository.findByName(name);
        model.addAttribute("place", place);
        Double rating = rateRepository.GetAvgRating(place.getId());
        model.addAttribute("rating", rating);
        List<Comment> comments = commentRepository.findAllByPlaceId(place.getId());
        model.addAttribute("comments", comments);
        return "place/site";
    }

    @PostMapping("/{city}/breakfast/{name}")
    public String breakfastPlace(Model model, @PathVariable String city, @PathVariable String name,
                                 @RequestParam double rate, @RequestParam String comment, HttpSession session, HttpServletRequest request){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);

        if (rate > 0) {
            Rate r = new Rate();
            r.setRate(rate);
            r.setPlace(placeRepository.findByName(name));
            r.setUser(user);
            rateRepository.save(r);
        } else {
            Rate r = new Rate();
            r.setRate(null);
            r.setPlace(placeRepository.findByName(name));
            r.setUser(user);
            rateRepository.save(r);
        }

        if (comment != null && !comment.isEmpty()) {
            Comment c = new Comment();
            c.setComment(comment);
            c.setPlace(placeRepository.findByName(name));
            c.setUser(user);
            commentRepository.save(c);
        } else {
            Comment c = new Comment();
            c.setComment(null);
            c.setPlace(placeRepository.findByName(name));
            c.setUser(user);
            commentRepository.save(c);
        }
        return "redirect:" + request.getContextPath() +name;
    }

    @GetMapping("/{city}/dinner&supper/{name}")
    public String dinnerPlace(Model model, @PathVariable String city, @PathVariable String name, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("city", city);
        Place place = placeRepository.findByName(name);
        model.addAttribute("place", place);
        Double rating = rateRepository.GetAvgRating(place.getId());
        model.addAttribute("rating", rating);
        List<Comment> comments = commentRepository.findAllByPlaceId(place.getId());
        model.addAttribute("comments", comments);
        return "place/site";
    }

    @PostMapping("/{city}/dinner&supper/{name}")
    public String dinnerPlace(Model model, @PathVariable String city, @PathVariable String name,
                                 @RequestParam double rate, @RequestParam String comment, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);

        if (rate > 0) {
            Rate r = new Rate();
            r.setRate(rate);
            r.setPlace(placeRepository.findByName(name));
            r.setUser(user);
            rateRepository.save(r);
        } else {
            Rate r = new Rate();
            r.setRate(null);
            r.setPlace(placeRepository.findByName(name));
            r.setUser(user);
            rateRepository.save(r);
        }

        if (comment != null && !comment.isEmpty()) {
            Comment c = new Comment();
            c.setComment(comment);
            c.setPlace(placeRepository.findByName(name));
            c.setUser(user);
            commentRepository.save(c);
        } else {
            Comment c = new Comment();
            c.setComment(null);
            c.setPlace(placeRepository.findByName(name));
            c.setUser(user);
            commentRepository.save(c);
        }
        return "redirect:"+name;
    }

    @GetMapping("/{city}/coffee&sweet/{name}")
    public String coffeePlace(Model model, @PathVariable String city, @PathVariable String name, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("city", city);
        Place place = placeRepository.findByName(name);
        model.addAttribute("place", place);
        Double rating = rateRepository.GetAvgRating(place.getId());
        model.addAttribute("rating", rating);
        List<Comment> comments = commentRepository.findAllByPlaceId(place.getId());
        model.addAttribute("comments", comments);
        return "place/site";
    }

    @PostMapping("/{city}/coffee&sweet/{name}")
    public String coffeePlace(Model model, @PathVariable String city, @PathVariable String name,
                                 @RequestParam double rate, @RequestParam String comment, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);

        if (rate > 0) {
            Rate r = new Rate();
            r.setRate(rate);
            r.setPlace(placeRepository.findByName(name));
            r.setUser(user);
            rateRepository.save(r);
        } else {
            Rate r = new Rate();
            r.setRate(null);
            r.setPlace(placeRepository.findByName(name));
            r.setUser(user);
            rateRepository.save(r);
        }

        if (comment != null && !comment.isEmpty()) {
            Comment c = new Comment();
            c.setComment(comment);
            c.setPlace(placeRepository.findByName(name));
            c.setUser(user);
            commentRepository.save(c);
        } else {
            Comment c = new Comment();
            c.setComment(null);
            c.setPlace(placeRepository.findByName(name));
            c.setUser(user);
            commentRepository.save(c);
        }
        return "redirect:"+name;
    }





}
