import request from '@/utils/request'

const bastPath = '/api/system/v1/'

export function list(path, params) {
  return request({
    url: bastPath + moudle,
    method: 'get',
    params: params
  })
}

export function page(path, params) {
  return request({
    url: path + '/page/' + params.pageNum + '/' + params.pageSize,
    method: 'get',
    params: params
  })
}

export function create(path, params) {
  return request({
    url: path,
    method: 'post',
    data: params
  })
}

export function update(path, params) {
  return request({
    url: path + '/' + params.id,
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
