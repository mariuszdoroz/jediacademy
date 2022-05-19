package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@Controller
@RequestMapping("/")
public class StartController {

    @RequestMapping("/w")
    public String welcome(ModelMap map) {
        map.put("currentDate", new Date());
        return "welcome";
    }
}
