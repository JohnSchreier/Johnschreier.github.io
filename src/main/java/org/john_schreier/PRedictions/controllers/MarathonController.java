package org.john_schreier.PRedictions.controllers;

import org.john_schreier.PRedictions.exceptions.PRException;
import org.john_schreier.PRedictions.model.PRedictions;
import org.john_schreier.PRedictions.model.User;
import org.john_schreier.PRedictions.services.PRedictionService;
import org.john_schreier.PRedictions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MarathonController {

    @Qualifier("PRedictionServiceImpl")
    @Autowired
    PRedictionService predictionService;
    @Autowired
    UserService userService;

    //  Maps marathon predictor page
    @GetMapping("/Marathon_Predictor")
    public String showMarathonPredictorPage(Model model) throws PRException {
        User user = new User();
        user = userService.getLoggedUser();

        PRedictions predic = predictionService.getPredictionByUser(user);
        if (predic != null) {
            model.addAttribute("predictions", predic);
        } else {
            model.addAttribute("predictions", new PRedictions());
        }
        model.addAttribute("exists", predictionService.existsPRedictionsByUser(user));
        return "Marathon_Predictor";
    }

    //    Create new marathon prediction:
    @PostMapping("/Marathon_Predictor")
    public String saveMarCalculateRaceTime(@ModelAttribute("predictions") PRedictions predictions, Model model) throws PRException {

        User user = userService.getLoggedUser();
        predictions.setUser(user);
        predictionService.savePrediction(predictions);
        System.out.println("~~~~this is the saveMarCalculateRaceTime method~~~~");
        System.out.println(predictions);
        return "redirect:/Profile_Page";
    }

    //    Updates existing set of predictions with a new marathon prediction:
    @RequestMapping(value = "/Add_Marathon_Predictor/{predictions}", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveMarathonTimeWhereHalfExists(@PathVariable("predictions") String predictions) throws PRException {
        User user = new User();
        user = userService.getLoggedUser();
        predictionService.savePredictionHalfExists(predictions, user.getEmail());

        System.out.println("~~~~this is the saveMarathonTimeWhereHalfExists method~~~~");
        return "redirect:/Profile_Page";

    }
}
