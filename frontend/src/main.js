// src/main.js
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

// Configure axios as a global property
const app = createApp(App)
app.config.globalProperties.$axios = axios
app.use(router)
app.mount('#app')