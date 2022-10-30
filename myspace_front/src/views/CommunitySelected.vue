<template>
  <ContentBase>
    <div class="row row-cols-3 row-cols-md-4 g-4">
      <div class="col">
        <router-link class="card h-100 nav-link" :to="{name: 'recipe'}">
          <img src="../assets/community/c1.jpg" class="card-img-top" alt="Recipe 1">
          <div class="card-body">
            <h5 class="card-title">Dry Potato Slices</h5>
            <p class="card-text">A traditional Sichuan and Chongqing dish made from sliced potatoes, green peppers and red peppers, seasoned with salad oil, spring onions, ginger and garlic, with a spicy flavour.</p>
          </div>
          <div class="card-footer">
            <small class="text-muted">Dishes: potato, chili</small>
          </div>
        </router-link>
      </div>
      <div class="col">
        <router-link class="card h-100 nav-link" :to="{name: 'recipe'}">
          <img src="../assets/community/c2.jpg" class="card-img-top" alt="Recipe 2">
          <div class="card-body">
            <h5 class="card-title">Braised Prawns in Fish Sauce</h5>
            <p class="card-text">A gourmet dish made from mainly large prawns, sharp peppers, soy sauce, ginger and spring onions. After putting the prawns into the pot, boil the water for about a minute or two, the freshness of the prawns will be lost if blanched for too long.</p>
          </div>
          <div class="card-footer">
            <small class="text-muted">Dishes: shrimp, seafood sauce</small>
          </div>
        </router-link>
      </div>
      <div class="col">
        <router-link class="card h-100 nav-link" :to="{name: 'recipe'}">
          <img src="../assets/community/c3.jpg" class="card-img-top" alt="Recipe 3">
          <div class="card-body">
            <h5 class="card-title">Hollow Sugar Cookies</h5>
            <p class="card-text">A noodle dish with flour, yeast and brown sugar as the main ingredients and milk, peanuts and sesame seeds as the toppings.</p>
          </div>
          <div class="card-footer">
            <small class="text-muted">Pastry: brown sugar</small>
          </div>
        </router-link>
      </div>
      <div class="col">
        <router-link class="card h-100 nav-link" :to="{name: 'recipe'}">
          <img src="../assets/community/c4.jpg" class="card-img-top" alt="Recipe 4">
          <div class="card-body">
            <h5 class="card-title">Sweet Potato Crystal Cakes</h5>
            <p class="card-text">A traditional local dish belonging to the Hunan cuisine family.</p>
          </div>
          <div class="card-footer">
            <small class="text-muted">Pastry: sweet potato</small>
          </div>
        </router-link>
      </div>
      <div class="col">
        <router-link class="card h-100 nav-link" :to="{name: 'recipe'}">
          <img src="../assets/community/c5.jpg" class="card-img-top" alt="Recipe 1">
          <div class="card-body">
            <h5 class="card-title">Hand-held Grilled Cakes</h5>
            <p class="card-text">The hand-held biscuit evolved from the onion biscuit and originated in Taiwan, China. When freshly baked, the layers are as thin as paper, and when grasped with the hand, the pasta is a thousand times more crispy and golden on the outside and soft and white on the inside.</p>
          </div>
          <div class="card-footer">
            <small class="text-muted">Pastry: beef, sesame seed</small>
          </div>
        </router-link>
      </div>
      <div class="col">
        <router-link class="card h-100 nav-link" :to="{name: 'recipe'}">
          <img src="../assets/community/c6.jpg" class="card-img-top" alt="Recipe 2">
          <div class="card-body">
            <h5 class="card-title">Fresh Vegetable Chicken Roll</h5>
            <p class="card-text">This delicacy is made with chicken thighs and is a very tasty cold meat dish that can be served with wine or as a side dish. This dish can be made ahead of time for a banquet, which is classy and saves time in cooking and avoids the hustle and bustle. It's delicious.</p>
          </div>
          <div class="card-footer">
            <small class="text-muted">Snacks: chicken, cucumber, carrot</small>
          </div>
        </router-link>
      </div>
      <div class="col">
        <router-link class="card h-100 nav-link" :to="{name: 'recipe'}">
          <img src="../assets/community/c7.jpg" class="card-img-top" alt="Recipe 3">
          <div class="card-body">
            <h5 class="card-title">Spicy Beef Sauce</h5>
            <p class="card-text">Beef sauce is a beef-based condiment. The beef sauce is stir-fried using traditional techniques and a clever combination of imperial recipes. With its pure flavour, it is an indispensable condiment for the people's family table and can also be eaten directly.</p>
          </div>
          <div class="card-footer">
            <small class="text-muted">Sauces: beef, chili</small>
          </div>
        </router-link>
      </div>
      <div class="col">
        <router-link class="card h-100 nav-link" :to="{name: 'recipe'}">
          <img src="../assets/community/c8.jpg" class="card-img-top" alt="Recipe 4">
          <div class="card-body">
            <h5 class="card-title">Pumpkin Golden Pie</h5>
            <p class="card-text">A medicinal dish with pumpkin as the main ingredient. The beneficial components of pumpkin for the human body are: polysaccharides, amino acids, active proteins, carotenoids and many trace elements.</p>
          </div>
          <div class="card-footer">
            <small class="text-muted">Pastry: pumpkin</small>
          </div>
        </router-link>
      </div>
    </div>
    <router-link class="nav-link d-grid gap-2 col-6 mx-auto" :to="{name: 'login'}">
      <button class="btn btn-primary" style="margin-top:20px" type="button">For more delicious recipes, please login :)</button>
    </router-link>
  </ContentBase>

</template>
  
  <script>
  import ContentBase from '../components/ContentBase.vue';
  
  export default {
    name: 'CommunitySelected',
    components: {
      ContentBase,
    }
  }
  </script>
  
  <style scoped>
  </style>