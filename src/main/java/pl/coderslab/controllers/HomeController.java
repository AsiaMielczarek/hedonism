package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.PlaceRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlaceRepository placeRepository;

    //------------------------------------------------------------------------------------------------------------//

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email != null) {
            User user = userRepository.findFirstByEmail(email);
            model.addAttribute("user", user);
        }
        return "hello";
    }

    @PostMapping("/")
    public String whatsNext(@RequestParam String city){
        return "redirect:/"+city;
    }
}
