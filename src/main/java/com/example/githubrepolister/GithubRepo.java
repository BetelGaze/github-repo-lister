////package com.example.githubrepolister;
////
////import lombok.Data;
////import lombok.NoArgsConstructor;
////import com.fasterxml.jackson.annotation.JsonProperty;
////
////@Data
////@NoArgsConstructor
////public class GithubRepo {
////    private String name;
////    private Owner owner;
////    @JsonProperty("fork")
////    private boolean fork;
////
////    @Data
////    @NoArgsConstructor
////    public static class Owner {
////        private String login;
////    }
////}
//
//package com.example.githubrepolister;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//public class GithubRepo {
//    private String name;
//    private Owner owner;
//    @JsonProperty("fork")
//    private boolean fork;
//
//    public boolean isFork() {
//        return fork;
//    }
//
//    // Manually add other getters/setters as needed, e.g.:
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Owner getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }
//
//    public void setFork(boolean fork) {
//        this.fork = fork;
//    }
//
//    public static class Owner {
//        private String login;
//
//        public String getLogin() {
//            return login;
//        }
//
//        public void setLogin(String login) {
//            this.login = login;
//        }
//    }
//}


package com.example.githubrepolister;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubRepo {
    private String name;
    private Owner owner;
    @JsonProperty("fork")
    private boolean fork;

    // Default constructor
    public GithubRepo() {}

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public static class Owner {
        private String login;

        // Default constructor
        public Owner() {}

        // Getters and Setters
        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }
    }
}