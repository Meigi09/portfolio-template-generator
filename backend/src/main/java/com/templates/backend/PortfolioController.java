package com.templates.backend;

import com.portfoliogenerator.model.Portfolio;
import com.portfoliogenerator.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@CrossOrigin(origins = "http://localhost:8080") // Vue.js frontend URL
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Portfolio createPortfolio(@Valid @RequestBody Portfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(
        @PathVariable Long id, 
        @Valid @RequestBody Portfolio portfolioDetails
    ) {
        Portfolio updatedPortfolio = portfolioService.updatePortfolio(id, portfolioDetails);
        return ResponseEntity.ok(updatedPortfolio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
        return ResponseEntity.ok().build();
    }
}
