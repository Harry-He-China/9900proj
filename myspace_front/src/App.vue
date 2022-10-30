<template>
  <div v-if="$route.fullPath === '/'" class="homeview">
    <div class="video">    
      <video controls="controls" autoplay loop muted>
        <source src="./assets/video/home.mp4" type="video/mp4" />
      </video>
    </div>
    <NavBar_home />
    <HomeView :key="$route.fullPath" />
  </div>
  <div v-if="$route.fullPath !== '/'">
    <NavBar />
    <router-view :key="$route.fullPath" />
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';
import NavBar from './components/NavBar.vue';
import NavBar_home from './components/NavBar_home.vue';
import HomeView from './views/HomeView.vue';

export default {
  name: 'App',
  components: { // import components from other script files
    NavBar,
    NavBar_home,
    HomeView,
  }
}
</script>

<style scoped>
  NavBar_home {
    z-index: 1;
  }

  HomeView {
    z-index: 1;
  }

  div.video {
    position: absolute;
    padding: 0;
    margin: 0;
    z-index: 0;
    width: 100%;
    height: 100vh;
    overflow-x: hidden;
    overflow-y: hidden;
  }

  video {
    width: 100%;
    pointer-events: none;
    overflow-x: hidden;
    overflow-y: hidden;
    filter: brightness(50%);
  }

  video::-webkit-media-controls-enclosure{ 
    display: none;
  }

  .homeview {
    overflow-x: hidden;
    overflow-y: hidden;
  }
</style>
