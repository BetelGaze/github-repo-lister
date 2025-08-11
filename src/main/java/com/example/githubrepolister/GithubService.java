

package com.example.githubrepolister;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubService {

    private final RestTemplate restTemplate;
    private static final String GITHUB_API_BASE_URL = "https://api.github.com";


    public GithubService(){
        this.restTemplate = new RestTemplate();
    }


    public List<RepositoryResponse> getReposForUser(String username){
        String url = GITHUB_API_BASE_URL + "/users/" + username + "/repos";


        List<GithubRepo> allRepos = new ArrayList<>();
        try{
        ResponseEntity<List<GithubRepo>> reposResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GithubRepo>>() {}
        );
        allRepos = reposResponse.getBody();
        }

        catch (HttpClientErrorException e){
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new UserNotFoundException("User ' " + username + " ' not found.");
            }
            throw  e;
            }

       if(allRepos == null){
            return new ArrayList<>();
        }

        return allRepos.stream()
                .filter(repo -> !repo.isFork())  // This should work now
                .map(repo -> {
                    List<BranchResponse> branches = getBranchesForRepo(repo.getOwner().getLogin(), repo.getName());

                    RepositoryResponse response = new RepositoryResponse();
                    response.setName(repo.getName());
                    response.setOwnerLogin(repo.getOwner().getLogin());
                    response.setBranches(branches);

                    return response;
                })
                .collect(Collectors.toList());
    }

    private List<BranchResponse> getBranchesForRepo(String owner, String repoName) {
        String url = String.format("%s/repos/%s/%s/branches", GITHUB_API_BASE_URL, owner, repoName);

        ResponseEntity<List<GithubBranch>> branchesResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GithubBranch>>() {}
        );

        List<GithubBranch> allBranches = branchesResponse.getBody();
        if (allBranches == null) {
            return new ArrayList<>();
        }

        return allBranches.stream()
                .map(branch -> {
                    BranchResponse response = new BranchResponse();
                    response.setName(branch.getName());
                    response.setLastCommitSha(branch.getCommit().getSha());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
