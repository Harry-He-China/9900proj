<template>
    <div class="container">
      <div class="input-group mb-3">
        <p class="header">Yummy Zone, Yummy Day!</p>
      </div>
      <div class="input-group mb-3">
        <p class="intro">Yummy Zone is a wonderful community where you can learn and share cooking!
          <br>Just register and surfing on it...
        </p>
      </div>
    </div>
</template>

<script>
// import ContentBase from '../components/ContentBase.vue';

export default {
  name: 'HomeView',
  components: {
    // ContentBase,
  }
}
</script>

<style scoped>
  .container {
    margin-top: 12%;
    background: transparent;
  }

  .card {
    background-color: transparent;
  }

  p.header {
    color: white;
    font-size: 32px;
    font-weight: 1000;
  }

  p.intro {
    color: #d4cdc6;
    font-size: 16px;
  }
  
</style>