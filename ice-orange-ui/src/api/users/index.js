import request from '@/utils/request'



export function list(params) {
  return request({
    url: '/ice/system/v1/users',
    method: 'get',
    params: params
  })
}
