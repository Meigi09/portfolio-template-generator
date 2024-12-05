package com.templates.backend;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Title is required")
    private String title;

    @Column(length = 1000)
    private String summary;

    private String template; // Template type (e.g., "professional", "creative", "minimal")

    @Column(length = 2000)
    private String skills;

    @Column(length = 2000)
    private String projects;

    @Column(length = 1000)
    private String education;

    @Column(length = 1000)
    private String workExperience;

    private String contactEmail;

    private String linkedinProfile;

    private String githubProfile;
}
