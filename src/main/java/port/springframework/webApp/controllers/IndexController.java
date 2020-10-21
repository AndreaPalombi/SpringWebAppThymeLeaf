package port.springframework.webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Andrea Palombi
 * on 19/10/2020
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
