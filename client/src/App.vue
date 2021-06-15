<template>
  <div id="app">
    <Home/>
  </div>
</template>

<script>
import Home from './pages/Home.vue'

export default {
  name: 'App',
  components: {
    Home
  }
}
</script>

<style>
body {
  background-image: url("./assets/background.jpg");
  background-repeat: no-repeat;
  background-size: cover; 
  width: 100vw;
  height: 100vh;
  overflow: hidden;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 300px;
}

</style>
