import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/pages/Home'
import Champions from '@/pages/Champions'


Vue.use(Router)

export default new Router({
    mode: 'history',
    
    routes: [
        {
            path: '/home',
            component: Home
        },
        {
            path: 'champions',
            component: Champions
        }
    ]
})