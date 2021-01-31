<template>
  <el-drawer
  :title="drawerTitle"
  :before-close="handleCancel"
  :visible.sync="drawerVisible"
  direction="rtl"
  size="45%"
  ref="drawer"
  >
  <div class="ice-drawer__content">
      <el-form :ref="dataFormRef" :rules="rules" :model="dataForm" label-position="top" >
        <el-form-item label="用户组:" prop="name">
          <el-input v-model="dataForm.name"/>
        </el-form-item>
        <el-form-item label="用户:" prop="showName">
          <el-input v-model="dataForm.showName"/>
        </el-form-item>

      </el-form>
      <div slot="footer" class="ice-drawer__footer">
        <el-button type="primary" size="small" icon="el-icon-check"
                   @click="formStatus==='create'?createData():updateData()">确定
        </el-button>
        <el-button type="info" size="small" icon="el-icon-close" @click="handleCancel">取消</el-button>
      </div>
    </div>
</el-drawer>

</template>
<script>
  import { create, update } from '@/api/common/index'

  export default {
    data() {
      return {
        bathPath: '/api/system/v1/users/groups',
        drawerTitle: '创建用户组',
        drawerVisible: false,
        formStatus: 'create',
        dataFormRef: 'dataFormRef',
        dataForm: this.initForm(),
        rules: {
          userName: [
            { required: true, trigger: 'blur', message: '名称不能唯空!' }
          ]
        }
      }
    },
    methods: {
      initForm() {
        return {
          name: null,
          showName:null,
          remark: null
        }
      },
      handleToBindUsers(row) {
        this.drawerVisible = true
        this.drawerTitle = '添加组成员'
        this.resetForm()
      },
      handleBindUsers() {
        this.$refs[this.dataFormRef].validate(validate => {
          if (validate) {
            create(this.bathPath, this.dataForm).then(() => {
              this.handleCancel()
            })
          } else {
            return false
          }
        })
      },
      resetForm() {
        this.dataForm = this.initForm()
      },
      handleCancel() {
        this.drawerVisible = false
      }
    }
  }
</script>

<style>
</style>
