package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.User;
import org.launchcode.neighborgoods.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    UserRepository userRepository;
    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    @GetMapping(value = "/profile")
    public String profile(){ return "profile"; }

//    @GetMapping("change")
//    public String displayChangeInfoForm(Model model){
//        model.addAttribute(new Business());
//        model.addAttribute("ownerTag", OwnerTag.values());
//        model.addAttribute("categories", Categories.values());
//        model.addAttribute("subcategories", SubCategories.values());
//        return "business/add";
//    }
//
//    @PostMapping("add")
//    public String processAddBusinessForm(@ModelAttribute @Valid Business newBusiness, Errors errors, Model model){
//        if (errors.hasErrors()){
//            return "business/add";
//        }
//
//        userRepository.save(newBusiness);
//        return "redirect:";
//    }
}
