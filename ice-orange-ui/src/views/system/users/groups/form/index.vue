<template>
  <el-drawer
  :title="drawerTitle"
  :before-close="handleCancel"
  :visible.sync="drawerVisible"
  direction="rtl"
  ref="drawer"
  >
  <div class="ice-drawer__content">
      <el-form :ref="dataFormRef" :rules="rules" :model="dataForm" label-position="top" >
        <el-form-item label="用户组名称:" prop="name">
          <el-input v-model="dataForm.name"/>
        </el-form-item>
        <el-form-item label="显示名称:" prop="showName">
          <el-input v-model="dataForm.showName"/>
        </el-form-item>
        <el-form-item label="备注:" prop="remark">
          <el-input
            type="textarea"
            :rows="2"
            v-model="dataForm.remark">
</el-input>
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
        moudle: 'users/groups',
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
      handleToCreate() {
        this.drawerVisible = true
        this.drawerTitle = '创建用户组'
        this.resetForm()
      },
      handleToUpdate(row) {
        this.drawerVisible = true
        this.drawerTitle = '修改用户组'
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
