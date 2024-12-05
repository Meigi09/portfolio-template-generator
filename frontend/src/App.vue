
<template>
  <div id="app">
    <nav>
      <router-link to="/">Portfolio List</router-link>
      <router-link to="/create">Create Portfolio</router-link>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

nav {
  display: flex;
  justify-content: space-around;
  margin-bottom: 20px;
}

nav a {
  text-decoration: none;
  color: #333;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

nav a:hover {
  background-color: #f0f0f0;
}
</style>