package com.example.githubrepolister;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// I've removed the Hamcrest imports, as they are not standard in every project.
// We will check the JSON response manually instead.

@SpringBootTest
@AutoConfigureMockMvc
class GithubRepoListerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void givenValidUser_whenGetRepos_thenReturnsCorrectJsonStructure() throws Exception {
		// Arrange
		String username = "octocat";

		// Act
		MvcResult result = mockMvc.perform(get("/users/{username}/repos", username))
				.andExpect(status().isOk())
				.andReturn();

		// Assert
		String jsonResponse = result.getResponse().getContentAsString();
		Assertions.assertNotNull(jsonResponse);
		Assertions.assertTrue(jsonResponse.startsWith("["));
		Assertions.assertTrue(jsonResponse.contains("\"name\":\""));
		Assertions.assertTrue(jsonResponse.contains("\"ownerLogin\":\"octocat\""));
		Assertions.assertTrue(jsonResponse.contains("\"branches\":["));
	}
}