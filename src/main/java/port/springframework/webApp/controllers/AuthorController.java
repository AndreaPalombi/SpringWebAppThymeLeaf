package port.springframework.webApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import port.springframework.webApp.model.Author;
import port.springframework.webApp.repositories.AuthorRepository;

/**
 * Created by Andrea Palombi
 * on 19/10/2020
 */

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAutor(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "Authorlist"; //HTML template file

    }
}
