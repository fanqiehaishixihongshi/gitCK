import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './plugins/element.js'
import axios from 'axios'
import VueAxios from 'vue-axios'
import qs from 'qs'
// 配置请求的跟路径
Vue.prototype.$qs = qs
axios.defaults.baseURL = 'http://localhost:8083/'
Vue.prototype.HOST = 'http://localhost:8083/'
Vue.prototype.$http = axios
Vue.config.productionTip = false
Vue.use(VueAxios)
Vue.use(ElementUI)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
