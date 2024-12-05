// src/components/PortfolioList.vue
<template>
  <div class="portfolio-list">
    <h2>My Portfolios</h2>
    <div v-if="portfolios.length === 0">No portfolios found</div>
    <div v-else class="portfolio-grid">
      <div v-for="portfolio in portfolios" :key="portfolio.id" class="portfolio-card">
        <h3>{{ portfolio.name }}</h3>
        <p>{{ portfolio.title }}</p>
        <div class="portfolio-actions">
          <button @click="viewPortfolio(portfolio.id)">View</button>
          <button @click="editPortfolio(portfolio.id)">Edit</button>
          <button @click="deletePortfolio(portfolio.id)">Delete</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      portfolios: []
    }
  },
  created() {
    this.fetchPortfolios()
  },
  methods: {
    async fetchPortfolios() {
      try {
        const response = await axios.get('http://localhost:8081/api/portfolios')
        this.portfolios = response.data
      } catch (error) {
        console.error('Error fetching portfolios:', error)
      }
    },
    viewPortfolio(id) {
      this.$router.push(`/view/${id}`)
    },
    editPortfolio(id) {
      this.$router.push(`/edit/${id}`)
    },
    async deletePortfolio(id) {
      if (confirm('Are you sure you want to delete this portfolio?')) {
        try {
          await axios.delete(`http://localhost:8081/api/portfolios/${id}`)
          this.portfolios = this.portfolios.filter(p => p.id !== id)
        } catch (error) {
          console.error('Error deleting portfolio:', error)
        }
      }
    }
  }
}
</script>

<style scoped>
.portfolio-list {
  text-align: center;
}

.portfolio-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 20px;
}

.portfolio-card {
  border: 1px solid #ddd;
  padding: 15px;
  border-radius: 8px;
  background-color: #f9f9f9;
}

.portfolio-actions {
  display: flex;
  justify-content: space-between;
  margin-top: 15px;
}

button {
  padding: 8px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:first-child {
  background-color: #4CAF50;
  color: white;
}

button:nth-child(2) {
  background-color: #2196F3;
  color: white;
}

button:last-child {
  background-color: #f44336;
  color: white;
}
</style>