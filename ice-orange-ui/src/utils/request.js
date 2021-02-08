import axios from 'axios'
import { MessageBox, Message } from 'element-ui'
import store from '@/store'
import { getToken } from '@/utils/auth'

const service = axios.create({
  // withCredentials: true, // send cookies when cross-domain requests
  baseURL: 'http://localhost:8080',
  timeout: 30000 // request timeout
})
service.interceptors.request.use(
  config => {
    const isToken = (config.headers || {}).isToken === false
    const token = store.getters.token
    console.log(token)
    console.log(isToken)
    if (token && !isToken) {
      config.headers['Authorization'] = 'Bearer ' + getToken() // token
    }
    return config
  },
  error => {
    console.log('-'+error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
service.interceptors.response.use(
  response => {
    console.log(response)
    // if the custom code is not 20000, it is judged as an error.
    if(response.status== 200) {
        return response.data
    }
    // if (response.status != 200) {
    //   Message({
    //     message: res.message || 'Error',
    //     type: 'error',
    //     duration: 5 * 1000
    //   }
    //
    //   // 50008: Illegal token; 50012: Other clients logged in; 50014: Token expired;
    //   if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
    //     // to re-login
    //     MessageBox.confirm('You have been logged out, you can cancel to stay on this page, or log in again', 'Confirm logout', {
    //       confirmButtonText: 'Re-Login',
    //       cancelButtonText: 'Cancel',
    //       type: 'warning'
    //     }).then(() => {
    //       store.dispatch('user/resetToken').then(() => {
    //         location.reload()
    //       })
    //     })
    //   }
    //   return Promise.reject(new Error(res.message || 'Error'))
    // } else {
    //   return res
    // }
  },
  error => {
    console.log('err' + error) // for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default service
