package by.javatest.task3.controller;

import by.javatest.task3.entity.Login;
import by.javatest.task3.entity.Posting;
import by.javatest.task3.exception_handling.NoSuchPostingException;
import by.javatest.task3.exception_handling.PostingIncorrectData;
import by.javatest.task3.service.LoginService;
import by.javatest.task3.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private LoginService loginService;
    @Autowired
    private PostingService postingService;

    @PostMapping("/logins")
    public void addLogins() throws IOException {
        loginService.saveLogins(loginService.readLoginsFromCSV());

    }

    @GetMapping("/logins")
    public List<Login> showAllLogins() {
        List<Login> allLogins = loginService.getLogins();
        return allLogins;
    }

    @PostMapping("/postings")
    public void addPostings() throws IOException {
        postingService.savePostings(postingService.readPostingsFromCSV());

    }

    @GetMapping("/postings")
    public List<Posting> showPostingsByMonth(@RequestParam(name = "year", required = false) Integer year,
                                             @RequestParam(name = "month", required = false) Integer month,
                                             @RequestParam(name = "day", required = false) Integer day,
                                             @RequestParam(name = "authorizedPosting", required = false)
                                             Boolean authorizedPosting) {
        List<Posting> postings = postingService.findByParameter(year, month, day, authorizedPosting);
        if (postings.isEmpty()) {
            throw new NoSuchPostingException("There is no postings with these parameters");
        }
        return postings;

    }


}
