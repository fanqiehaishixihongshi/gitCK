<template>
  <div class="game">
    <el-select v-model="value2" placeholder="请选择">
      <el-option
        v-for="item in options2"
        :key="item.value"
        :label="item.label"
        :value="item.value"
        :disabled="item.disabled">
      </el-option>
    </el-select>
    <el-table
      :data="list"
      style="width: 100%">
      <el-table-column
        prop="name"
        label="游戏名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="price"
        label="游戏余额"
        width="180">
      </el-table-column>
      <el-table-column
        prop="account"
        label="登陆账号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="showTime"
        label="登陆时间"
        width="180"
        :formatter="formatDate">
      </el-table-column>
      <el-table-column
        label="操作"
        width="280">
        <template slot-scope="scope">
          <!--添加按钮-->
          <el-button type="success" icon="el-icon-edit" size="mini" @click="toAdd">添加</el-button>
          <!--修改按钮-->
          <el-button type="primary" icon="el-icon-edit" size="mini" @click="toUpdate (scope.row)">修改</el-button>
          <!--删除按钮-->
          <el-button type="danger" icon="el-icon-edit" size="mini" @click="deleteA (scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div v-if="addModel">
      <el-form :inline="true" :model="addForm" class="demo-form-inline">
        <el-form-item label="游戏名称">
          <el-input v-model="addForm.name" placeholder="游戏名称"></el-input>
        </el-form-item>
        <el-form-item label="游戏余额">
          <el-input v-model="addForm.price" placeholder="游戏余额"></el-input>
        </el-form-item>
        <el-form-item label="登录账号">
          <el-input v-model="addForm.account" placeholder="登录账号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addA()">提交</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div  v-if="updateModel">
      <el-form :inline="true" :model="addForm" class="demo-form-inline">
        <el-input type="hidden" v-model="addForm.id"></el-input>
        <el-input type="hidden" v-model="addForm.showTime"></el-input>
        <el-form-item label="游戏名称">
          <el-input v-model="addForm.name" placeholder="游戏名称"></el-input>
        </el-form-item>
        <el-form-item label="游戏余额">
          <el-input v-model="addForm.price" placeholder="游戏余额"></el-input>
        </el-form-item>
        <el-form-item label="登录账号">
          <el-input v-model="addForm.account" placeholder="登录账号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updateA()">修改</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'game',
  created () {
    this.queryList()
  },
  data () {
    return {
      list: [],
      addModel: false,
      updateModel: false,
      addForm: {
        // id: '',
        // name: '',
        // price: '',
        // account: ''
      },
      options2: [{
        value: '选项1',
        label: '黄金糕'
      }, {
        value: '选项2',
        label: '双皮奶',
        disabled: true
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }, {
        value: '选项4',
        label: '龙须面'
      }, {
        value: '选项5',
        label: '北京烤鸭'
      }],
      value2: ''
    }
  },
  methods: {
    formatDate (row, column) {
      const time = new Date(row.showTime)
      const year = time.getFullYear()
      const month = time.getMonth() + 1
      const day = time.getDate()
      const hh = time.getHours()
      const mm = time.getMinutes()
      const ss = time.getSeconds()
      const timeFormat = year + '/' + month + '/' + day + ' ' + hh + ':' + mm + ':' + ss
      return timeFormat
    },
    async queryList () {
      const { data: res } = await this.$http.get('game/queryList')
      if (res.status === 200) {
        this.list = res.data
      } else {
        alert(res.msg())
      }
    },
    toAdd () {
      this.addModel = true
      this.updateModel = false
    },
    async addA () {
      console.log(this.addForm)
      const { data: res } = await this.$http.post('game/addGame', this.$qs.stringify(this.addForm))
      if (res.status === 200) {
        this.addModel = false
        this.addForm.name = ''
        this.addForm.price = ''
        this.addForm.account = ''
        this.queryList()
      } else {
        alert(res.msg())
      }
    },
    toUpdate (data) {
      this.addModel = false
      this.updateModel = true
      this.addForm.id = data.id
      this.addForm.name = data.name
      this.addForm.price = data.price
      this.addForm.account = data.account
    },
    async updateA () {
      const { data: res } = await this.$http.post('game/updateGame', this.$qs.stringify(this.addForm))
      if (res.status === 200) {
        this.addForm.id = ''
        this.addForm.name = ''
        this.addForm.price = ''
        this.addForm.account = ''
        this.updateModel = false
        this.queryList()
      } else {
        alert(res.msg())
      }
    },
    async deleteA (id) {
      const { data: res } = await this.$http.post('game/deleteGame?id=' + id)
      if (res.status === 200) {
        this.queryList()
      } else {
        alert(res.msg())
      }
    }

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="less" scoped>

</style>
