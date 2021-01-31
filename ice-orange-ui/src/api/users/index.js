import request from '@/utils/request'



export function list(params) {
  return request({
    url: '/api/system/v1/users',
    method: 'get',
    params: params
  })
}
