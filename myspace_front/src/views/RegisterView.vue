<template>
    <ContentBase>
        <div class="row justify-content-md-center">
            <div class="col-3">
                <form @submit.prevent="register">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input v-model="username" type="text" class="form-control" id="username">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input v-model="password" type="password" class="form-control" id="password">
                    </div>
                    <div class="mb-3">
                        <label for="password_confirm" class="form-label">Confirm password</label>
                        <input v-model="password_confirm" type="password" class="form-control" id="password">
                    </div>
                    <div class="error-message">{{ error_message }}</div>
                    <button type="submit" class="btn btn-primary">Register</button>
                </form>
            </div>
        </div>
    </ContentBase>
</template>

<script>
import ContentBase from '../components/ContentBase.vue';
import { ref } from 'vue';
import { useStore } from 'vuex';
import router from '@/router/index';
import $ from 'jquery';

export default {
    name: 'RegisterView',
    components: {
        ContentBase,
        },
    setup() {
        const store = useStore();
        let username = ref('');
        let password = ref('');
        let password_confirm = ref('');
        let error_message = ref('');

        const register = () => {
            error_message.value = '';
            if (password_confirm.value === password.value) {
              var user = {
                username: username.value,
                password: password.value,
              }

              $.ajax({
                url: 'http://127.0.0.1:8083/api/user/register',
                type: 'POST',
                dataType : "json",
                contentType: 'application/json',
                data: JSON.stringify({user: user}),
                success(resp) {
                  if (resp.code === '0000') {
                    //缺个重定向
                    store.dispatch()
                    router.push({name: 'home'})
                  } else {
                      error_message.value = resp.result;
                  }
                },
            });
            }
        }

        return {
            username,
            password,
            password_confirm,
            error_message,
            register,
        }
    }
}
</script>

<style scoped>
    button {
        width: 100%;
    }

    .error-message {
        color: red;
    }
</style>
