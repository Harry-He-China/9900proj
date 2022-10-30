<template>
    <ContentBase>
        <div class="row justify-content-md-center">
            <div class="col-3">
                <form @submit.prevent="login">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input v-model="username" type="text" class="form-control" id="username">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input v-model="password" type="password" class="form-control" id="password">
                    </div>
                    <div class="error-message">{{ error_message }}</div>
                    <button type="submit" class="btn btn-primary">Login</button>
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
import $ from "jquery";


export default {
    name: 'LoginView',
    components: {
        ContentBase,
        },
    setup() {
        const store = useStore();
        let username = ref('');
        let password = ref('');
        let error_message = ref('');

        const login = () => {
            error_message.value = '';
            var user = {
              username: username.value,
              password: password.value,
            }
            $.ajax({
              url: 'http://127.0.0.1:8083/api/user/login',
              type: 'POST',
              dataType : "json",
              contentType: 'application/json',
              data: JSON.stringify({user: user}),
              success(resp) {
                console.log(resp);
                if (resp.code === '0000') {
                  // var user_login_obj = resp.data;
                  // 上述对象保存在session 中，退出时需将其作为接口参数
                  store.dispatch()
                  router.push({name: 'home'})
                } else {
                  error_message.value = resp.result;
                }
              },
            });
        }

        return {
            username,
            password,
            error_message,
            login
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
