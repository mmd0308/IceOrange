import request from '@/utils/request'



export function page(params) {
  return request({
    url: '/api/system/v1/users/page/' + params.pageNum + '/' + params.pageSize,
    method: 'get',
    params: params
  })
}
