import { createRouter, createWebHistory } from 'vue-router' // url不想要#，可将createWebHashHistory改为createWebHistory
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import NotFound from '../views/NotFound.vue'
import RegisterView from '../views/RegisterView.vue'
import UserList from '../views/UserList.vue'
import UserProfile from '../views/UserProfile.vue'
import CommunitySelected from '../views/CommunitySelected.vue';
import SearchView from '../views/SearchView.vue';
import ShopView from '../views/ShopView.vue';
import RecipeView from '../views/RecipeView.vue';
import EditRecipe from '../views/EditRecipe.vue';


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/404/',
    name: 'notfound',
    component: NotFound
  },
  {
    path: '/register/',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/userlist/',
    name: 'userlist',
    component: UserList
  },
  {
    path: '/userprofile/:userId/',
    name: 'userprofile',
    component: UserProfile
  },
  {
    path: '/community/',
    name: 'community',
    component: CommunitySelected
  },
  {
    path: '/search/',
    name: 'search',
    component: SearchView
  },
  {
    path: '/shop/',
    name: 'shop',
    component: ShopView
  },
  {
    path: '/post/',
    name: 'post',
    component: EditRecipe
  },
  {
    path: '/recipe/1/',
    name: 'recipe',
    component: RecipeView
  },
  {
    path: '/:catchAll(.*)',
    redirect:'/404',
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
