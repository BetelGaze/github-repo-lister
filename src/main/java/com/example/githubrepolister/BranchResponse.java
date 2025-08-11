package com.example.githubrepolister;

public class BranchResponse {
    private String name;
    private String lastCommitSha;

    // Default constructor
    public BranchResponse() {}

    // Getters and Setters
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