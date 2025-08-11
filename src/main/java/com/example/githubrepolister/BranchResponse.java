package com.example.githubrepolister;

public class BranchResponse {
    private String name;
    private String lastCommitSha;

    
    public BranchResponse() {}

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastCommitSha() {
        return lastCommitSha;
    }

    public void setLastCommitSha(String lastCommitSha) {
        this.lastCommitSha = lastCommitSha;
    }
}
