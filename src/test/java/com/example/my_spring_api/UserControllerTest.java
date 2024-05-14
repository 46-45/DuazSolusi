package com.example.my_spring_api;

import com.example.my_spring_api.entities.Role;
import com.example.my_spring_api.entities.User;
import com.example.my_spring_api.repository.UserRepository;
import com.example.my_spring_api.services.JWTService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private ObjectMapper objectMapper;

    private String adminToken;

    @BeforeEach
    void setUp() {

        User adminUser = new User();
        adminUser.setName("Admin User");
        adminUser.setEmail("admin@gmail.com");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        adminUser.setRole(Role.ADMIN);
        userRepository.save(adminUser);

        adminToken = jwtService.generateToken(adminUser);

        User user1 = new User();
        user1.setName("User One");
        user1.setEmail("user1@example.com");
        user1.setPassword(passwordEncoder.encode("password123"));
        user1.setRole(Role.USER);
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("User Two");
        user2.setEmail("user2@example.com");
        user2.setPassword(passwordEncoder.encode("password123"));
        user2.setRole(Role.USER);
        userRepository.save(user2);
    }

    @Test
    void testGetAllUsers() throws Exception {
        // Perform the GET request for all users
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/all")
                        .header("Authorization", "Bearer " + adminToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].email").value("admin@gmail.com"))
                .andExpect(jsonPath("$[1].email").value("user1@example.com"))
                .andExpect(jsonPath("$[2].email").value("user2@example.com"));
    }
}
