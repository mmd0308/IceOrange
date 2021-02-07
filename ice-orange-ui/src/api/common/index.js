import request from '@/utils/request'

const bastPath = '/ice/system/v1/'

export function list(moudle, params) {
  return request({
    url: bastPath + moudle,
    method: 'get',
    params: params
  })
}

export function page(path, params) {
  return request({
    url: path + '/page/' + params.pageNum + '/' + params.pageSize,
    method: 'get'
  })
}

export function create(moudle, params) {
  return request({
    url: bastPath + moudle,
    method: 'post',
    data: params
  })
}

export function update(moudle, params) {
  return request({
    url: bastPath + moudle,
    method: 'put',
    data: params
  })
}

export function deleteById(path, id) {
  return request({
    url: path + '/' + id,
    method: 'DELETE'
  })
}
