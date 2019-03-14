package org.sid.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.ProfileOperations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LinkedinResource controller
 */
@RestController
@RequestMapping("/api/linkedin")
public class LinkedInController {

    private LinkedIn linkedIn;
    private ConnectionRepository connectionRepository;

    public LinkedInController() {

    }

    public LinkedInController(LinkedIn linkedIn, ConnectionRepository connectionRepository) {
        this.linkedIn = linkedIn;

        this.connectionRepository = connectionRepository;
    }


    @GetMapping
    public String hello(Model model) {
        if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) {
            return "redirect:/connect/linkedinconnect";

        }
        ProfileOperations user = linkedIn.profileOperations();
        System.out.println(user);
        model.addAttribute("linkedInProfile", linkedIn.profileOperations().getUserProfileFull());


        return "linkedin";
    }


}
