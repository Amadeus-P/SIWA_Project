import { createApp } from 'vue'
// import router from './router'

// VUE에 적용할 페이지
import App from './App.vue'

// 비회원
import Index from './pages/Index.vue'
import Detail from './pages/Detail.vue'
import SignIn from './pages/SignIn.vue'
import SignUp from './pages/SignUp.vue'
import Search from './pages/Search.vue'
import Share from './pages/Share.vue'

// 회원
import Member from './pages/member/Index.vue'
import MemberIndex from './pages/member/Index.vue'
import MemberDetail from './pages/member/Detail.vue'
import MemberReg from './pages/member/Reg.vue'
import MemberReport from './pages/member/Report.vue'
import MemberSearch from './pages/member/Search.vue'
import MemberShare from './pages/member/Share.vue'

import AdminSignIn from './pages/member/AdminSignIn.vue'

//회원 내 페이지
import MemberMypage from './pages/member/mypage/Index.vue'
import MypageIndex from './pages/member/mypage/Index.vue'


import { createMemoryHistory, createRouter,createWebHistory } from 'vue-router'
const routes = [
    {
        path:'/',
        component: Index, redirect: '/index'
    },
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
    },
    // {
        // path:'/member', children: [
            {
                path:'/member/index',
                component: MemberIndex
            },
            {
                path:'/member/detail',
                component: MemberDetail
            },
            {
                path:'/member/reg',
                component: MemberReg
            },
            {
                path:'/member/report',
                component: MemberReport
            },
            {
                path:'/member/share',
                component: MemberShare
            },
            {
                path:'/member/search',
                component: MemberSearch
            },
            {
                path:'/member/admin-sign-in',
                component: AdminSignIn
            },
        // ], component: Member
    // }
    // {
    //     path:'/member/mypage', children: [
            {
                path:'/member/mypage/index',
                component: MypageIndex
            }

    //     ], component: MemberMypage
    // }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

createApp(App).use(router).mount('#app')
