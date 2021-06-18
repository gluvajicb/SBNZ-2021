import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/pages/Home'
import Champions from '@/pages/Champions'
import Build from '@/pages/Build'
import ChampionResults from '@/pages/ChampionResults'


Vue.use(Router)

export default new Router({
    mode: 'history',
    
    routes: [
        {
            path: '/home',
            component: Home
        },
        {
            path: '/recommend-champions',
            component: Champions
        },
        {
            path: '/recommend-build',
            component: Build
        },
        {
            path: '/champion-results',
            component: ChampionResults
        }
    ]
})