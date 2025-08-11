
package com.example.githubrepolister;

public class GithubBranch {
    private String name;
    private Commit commit;

    // Default constructor
    public GithubBranch() {}

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public static class Commit {
        private String sha;

        
        public Commit() {}

        
        public String getSha() {
            return sha;
        }

        public void setSha(String sha) {
            this.sha = sha;
        }
    }
}
