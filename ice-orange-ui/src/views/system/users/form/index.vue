<template>
  <el-drawer
  :title="drawerTitle"
  :before-close="handleCancel"
  :visible.sync="drawerVisible"
  direction="rtl"
  ref="drawer"
  >
<div class="ice-drawer__content">
      <el-form :ref="dataFormRef" :rules="rules" :model="dataForm" label-position="top">
        <el-form-item label="用户登陆名:" prop="username">
          <el-input v-model="dataForm.userName"/>
        </el-form-item>
<!--        <el-form-item label="性别:" prop="sex">-->
<!--          <el-select v-model="dataForm.sex" clearable style="width:100%" placeholder="请选择">-->
<!--            <el-option key="0" label="男" value="0"/>-->
<!--            <el-option key="1" label="女" value="1"/>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="邮箱" prop="email">-->
<!--          <el-input v-model="dataForm.email"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="电话">-->
<!--          <el-input v-model="dataForm.phone"/>-->
<!--        </el-form-item>-->
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
        moudle: 'users',
        drawerTitle: '',
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
          userName: null
        }
      },
      handleCreate() {
        this.drawerVisible = true
        this.drawerTitle = '创建用户'
        this.resetForm()
      },
      handleUpdate(row) {
        this.drawerVisible = true
        this.drawerTitle = '更新用户'
        this.formStatus = 'update'
        this.resetForm()
        this.dataForm = row
      },
      createData() {
        this.$refs[this.dataFormRef].validate(validate => {
          if (validate) {
            create(this.moudle, this.dataForm).then(() => {
              this.handleCancel()
            })
          } else {
            return false
          }
        })
      },
      updateData() {
        this.$refs[this.dataFormRef].validate(validate => {
          if (validate) {
            update(this.moudle, this.dataForm).then(() => {
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
        this.$emit('refreshList')
      }
    }
  }
</script>

<style>
</style>
