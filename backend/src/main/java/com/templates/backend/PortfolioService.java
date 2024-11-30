package com.templates.backend;

import com.portfoliogenerator.model.Portfolio;
import com.portfoliogenerator.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    public Optional<Portfolio> getPortfolioById(Long id) {
        return portfolioRepository.findById(id);
    }

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Portfolio updatePortfolio(Long id, Portfolio portfolioDetails) {
        Portfolio portfolio = portfolioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Portfolio not found"));
        
        // Update fields
        portfolio.setName(portfolioDetails.getName());
        portfolio.setTitle(portfolioDetails.getTitle());
        portfolio.setSummary(portfolioDetails.getSummary());
        portfolio.setTemplate(portfolioDetails.getTemplate());
        portfolio.setSkills(portfolioDetails.getSkills());
        portfolio.setProjects(portfolioDetails.getProjects());
        portfolio.setEducation(portfolioDetails.getEducation());
        portfolio.setWorkExperience(portfolioDetails.getWorkExperience());
        portfolio.setContactEmail(portfolioDetails.getContactEmail());
        portfolio.setLinkedinProfile(portfolioDetails.getLinkedinProfile());
        portfolio.setGithubProfile(portfolioDetails.getGithubProfile());

        return portfolioRepository.save(portfolio);
    }

    public void deletePortfolio(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Portfolio not found"));
        
        portfolioRepository.delete(portfolio);
    }
}
