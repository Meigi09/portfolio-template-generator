// src/components/PortfolioForm.vue
<template>
  <div class="portfolio-form">
    <h2>{{ isEditing ? 'Edit Portfolio' : 'Create Portfolio' }}</h2>
    <form @submit.prevent="submitPortfolio">
      <div class="form-group">
        <label>Name:</label>
        <input v-model="portfolio.name" required />
      </div>
      
      <div class="form-group">
        <label>Title:</label>
        <input v-model="portfolio.title" required />
      </div>
      
      <div class="form-group">
        <label>Template:</label>
        <select v-model="portfolio.template">
          <option value="professional">Professional</option>
          <option value="creative">Creative</option>
          <option value="minimal">Minimal</option>
        </select>
      </div>
      
      <div class="form-group">
        <label>Summary:</label>
        <textarea v-model="portfolio.summary"></textarea>
      </div>
      
      <div class="form-group">
        <label>Skills:</label>
        <textarea v-model="portfolio.skills"></textarea>
      </div>
      
      <div class="form-group">
        <label>Projects:</label>
        <textarea v-model="portfolio.projects"></textarea>
      </div>
      
      <div class="form-group">
        <label>Education:</label>
        <textarea v-model="portfolio.education"></textarea>
      </div>
      
      <div class="form-group">
        <label>Work Experience:</label>
        <textarea v-model="portfolio.workExperience"></textarea>
      </div>
      
      <div class="form-group">
        <label>Contact Email:</label>
        <input
        type="email"
        v-model="portfolio.contactEmail"
        />

        <div class="form-group">
          <label>LinkedIn Profile:</label>
          <input v-model="portfolio.linkedinProfile" />
        </div>

        <div class="form-group">
          <label>GitHub Profile:</label>
          <input v-model="portfolio.githubProfile" />
        </div>

        <button type="submit">{{ isEditing ? 'Update' : 'Create' }} Portfolio</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      portfolio: {
        name: '',
        title: '',
        template: 'professional',
        summary: '',
        skills: '',
        projects: '',
        education: '',
        workExperience: '',
        contactEmail: '',
        linkedinProfile: '',
        githubProfile: ''
      },
      isEditing: false
    }
  },
  created() {
    // Check if we're editing an existing portfolio
    if (this.$route.params.id) {
      this.isEditing = true
      this.fetchPortfolio()
    }
  },
  methods: {
    async fetchPortfolio() {
      try {
        const response = await axios.get(`http://localhost:8081/api/portfolios/${this.$route.params.id}`)
        this.portfolio = response.data
      } catch (error) {
        console.error('Error fetching portfolio:', error)
      }
    },
    async submitPortfolio() {
      try {
        if (this.isEditing) {
          // Update existing portfolio
          await axios.put(`http://localhost:8081/api/portfolios/${this.$route.params.id}`, this.portfolio)
        } else {
          // Create new portfolio
          await axios.post('http://localhost:8081/api/portfolios', this.portfolio)
        }
        // Redirect to portfolio list
        this.$router.push('/')
      } catch (error) {
        console.error('Error saving portfolio:', error)
      }
    }
  }
}
</script>

<style scoped>
.portfolio-form {
  max-width: 600px;
  margin: 0 auto;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
}

.form-group input,
.form-group textarea,
.form-group select {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.form-group textarea {
  min-height: 100px;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>