import { createApp } from 'vue'
// import router from './router'

// VUE에 적용할 페이지
import App from './App.vue'
import Index from './pages/Index.vue'
import Detail from './pages/Detail.vue'
import Search from './pages/Search.vue'
import SignIn from './pages/SignIn.vue'
import SignUp from './pages/SignUp.vue'
import Share from './pages/Share.vue'

import { createMemoryHistory, createRouter,createWebHistory } from 'vue-router'
const routes = [
    {
        path:'/index',
        component: Index
    },
    {
        path:'/detail',
        component: Detail
    },
    {
        path:'/search',
        component: Search
    },
    {
        path:'/sign-in',
        component: SignIn
    },
    {
        path:'/sign-up',
        component: SignUp
    },
    {
        path:'/share',
        component: Share
    }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

createApp(App).use(router).mount('#app')
