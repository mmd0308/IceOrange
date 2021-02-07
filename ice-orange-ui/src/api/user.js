import request from '@/utils/request'

export function login(username,password) {
  const grant_type = 'password'
  return request({
    url: '/ice/auth/oauth/token',
    method: 'post',
    headers: {
      Authorization: 'Basic aWNlbWdyLXVpOkljZU1ncl9VSQ=='
    },
    params: {
      username,
      password,
      grant_type: grant_type
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}
