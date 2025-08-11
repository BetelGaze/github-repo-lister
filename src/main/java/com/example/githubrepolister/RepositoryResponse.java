

package com.example.githubrepolister;

import java.util.List;

public class RepositoryResponse {
    private String name;
    private String ownerLogin;
    private List<BranchResponse> branches;

    
    public RepositoryResponse() {}

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public List<BranchResponse> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchResponse> branches) {
        this.branches = branches;
    }
}
