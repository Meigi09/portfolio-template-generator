// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'
import PortfolioList from '../components/PortfolioList.vue'
import PortfolioForm from '../components/PortfolioForm.vue'

const routes = [
  {
    path: '/',
    name: 'PortfolioList',
    component: PortfolioList
  },
  {
    path: '/create',
    name: 'CreatePortfolio',
    component: PortfolioForm
  },
  {
    path: '/edit/:id',
    name: 'EditPortfolio',
    component: PortfolioForm
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
