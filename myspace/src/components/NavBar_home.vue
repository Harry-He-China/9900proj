<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-transparent" style="background-color: blue">
        <div class="container">
            <router-link class="navbar-brand" :to="{name: 'home', parmas: {}}">Yummy Zone</router-link>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'home'}">Home</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'community'}">Community</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'userlist'}">Friends</router-link>
                    </li>
                </ul>
                <ui class="navbar-nav me-2 mb-2 mb-lg-0">
                    <li class="nav-item">
                        <input type="text" class="form-control bg-transparent" placeholder="Look for what :)">
                        <!-- <input type="text" class="form-control bg-transparent" placeholder="Look for what :)" aria-label="Recipient's username" aria-describedby="basic-addon2"> -->
                    </li>
                    <li class="nav-item space">x</li>
                    <li class="nav-item">
                        <button type="submit" class="form-control bg-transparent" style="color: #d4cdc6">Search</button>
                    </li>
                </ui>
                <ul class="navbar-nav" v-if="!$store.state.user.is_login">
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'login'}">Login</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'register'}">Register</router-link>
                    </li>
                </ul>
                <ul class="navbar-nav" v-else>
                    <li class="nav-item">
                        <router-link
                            class="nav-link"
                            :to="{name: 'userprofile', params: {userId: $store.state.user.id}}"
                        >
                            {{ $store.state.user.username }}
                        </router-link>
                    </li>
                    <li class="nav-item">
                        <a k class="nav-link" style="cursor: pointer" @click="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
import { useStore } from 'vuex';

export default {
    name: 'NavBar_home',
    setup() {
        const store = useStore();
        const logout = () => {
            store.commit('logout');
        };

        return {
            logout,
        }
    }
}
</script>

<style scoped>
    input::-webkit-input-placeholder {
        color: #d4cdc6;
    }

    input {
        border: 1px solid #d4cdc6;
    }

    input:focus {
        border: 1px solid #d4cdc6;
        outline: none;
        box-shadow:unset;
        background: white;
        color: white;
    }

    .nav-link {
        color: #d4cdc6;
    }

    .space {
        color: transparent;
        font-size: 20px;
    }
</style>