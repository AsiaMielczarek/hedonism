package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.PlaceRepository;
import pl.coderslab.repository.UserRepository;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PlaceRepository placeRepository;

    @ModelAttribute("categories")
    public Collection<Category> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signUp(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/signup";
        }
        User existingUser = userRepository.findFirstByEmail(user.getEmail());
        if (existingUser != null) {
            FieldError error = new FieldError("user", "email", "Email musi być unikalny");
            result.addError(error);
            return "user/signup";
        }
        userRepository.save(user);
        return "redirect:/";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/signin")
    public String signIn(Model model){
        model.addAttribute("user", new User());
        return "user/signin";
    }

    @PostMapping("/signin")
    public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User existingUser = userRepository.findFirstByEmail(user.getEmail());
        if (existingUser != null && existingUser.getEmail().equals(user.getEmail()) && existingUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("email", existingUser.getEmail());
        } else {
            model.addAttribute("loginError", "Nieprawidłowy login lub hasło");
        }
        return "redirect:/";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("email");
        return "redirect:/";
    }

    //------------------------------------------------------------------------------------------------------------//

    @RequestMapping("/you")
    public String userPanel(Model model, HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        return "user/you";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("you/edit")
    public String editUser(Model model,  HttpSession session){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("you/edit")
    public String saveUser(Model model, HttpSession session, @RequestParam String name, @RequestParam String password){
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        user.setId(user.getId());
        user.setEmail(email);

        if (name != null && !name.isEmpty() && password != null && !password.isEmpty()) {
            user.setName(name);
            user.setPassword(password);
        } else {
            user.setName(user.getName());
            user.setPassword(user.getPassword());
        }

        userRepository.save(user);
        return "redirect:/you";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("you/delete")
    public String deleteAnswer(Model model,  HttpSession session) {
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        return "user/delete";
    }

    @GetMapping("you/delete/{id}")
    public String deleteAnymore(@PathVariable Long id, HttpServletRequest request) {
        userRepository.delete(id);
        return "redirect:/";
    }

    //------------------------------------------------------------------------------------------------------------//

    @GetMapping("you/added")
    public String addedPlaces(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        User user = userRepository.findFirstByEmail(email);
        model.addAttribute("user", user);
        List<Place> places = placeRepository.findAllByUserId(user.getId());
        model.addAttribute("places", places);
        return "user/addedlist";
    }


}
