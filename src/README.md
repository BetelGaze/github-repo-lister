# GitHub Repository Lister API

This is a Spring Boot application that exposes a REST API to list all non-fork GitHub repositories for a given user, including their branches and last commit SHA.

## Acceptance Criteria

- As an API consumer, I would like to list all his GitHub repositories which are not forks.
- The response should include the repository name, owner login, and for each branch, its name and the last commit SHA.
- As an API consumer, given a non-existent GitHub user, I would like to receive a `404 Not Found` response in the format `{"status": ${responseCode}, "message": ${whyHasItHappened}}`.

## Technology Stack

- Java 21
- Spring Boot 3.5.4
- Maven
- Lombok

## How to Run the Project

1.  **Clone the repository:**
    ```bash
    git clone [your_repo_url]
    cd github-repo-lister
    ```

2.  **Run the application:**
    Open the project in IntelliJ IDEA. The application can be run by executing the `main` method in the `GithubRepoListerApplication.java` class.

    Alternatively, you can run it from the command line using Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

## API Endpoints

### 1. List Repositories for a User

- **Endpoint:** `GET /users/{username}/repos`
- **Description:** Fetches a list of non-fork repositories for the specified GitHub user.
- **Example:**
    - **Request:** `GET http://localhost:8080/users/octocat/repos`
    - **Successful Response (200 OK):**
      ```json
      [
        {
          "name": "Spoon-Knife",
          "ownerLogin": "octocat",
          "branches": [
            {
              "name": "main",
              "lastCommitSha": "d0dd1f61b33d64e29d8bc1372a94ef6a2fee76a9"
            }
          ]
        }
        // ... more repositories
      ]
      ```

### 2. User Not Found

- **Endpoint:** `GET /users/{username}/repos`
- **Description:** Returns a 404 response if the user does not exist.
- **Example:**
    - **Request:** `GET http://localhost:8080/users/nonexistentuser1234/repos`
    - **Error Response (404 Not Found):**
      ```json
      {
        "status": 404,
        "message": "User 'nonexistentuser1234' not found."
      }
      ```

## Testing

The project includes an integration test (`GithubRepoListerApplicationTests.java`) that verifies the happy path for a valid user, ensuring the API returns non-fork repositories with their branches.

To run the tests:
```bash
./mvnw test