package com.example.githubrepolister;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/users")
public class GithubController {

    private final GithubService githubService;

    @Autowired
    public GithubController(GithubService githubService){
        this.githubService = githubService;
    }

    @GetMapping("/{username}/repos")
    public List<RepositoryResponse>listUserRepos(@PathVariable String username){

    return githubService.getReposForUser(username);

    }
}
