<template>
  <div id="app">
    <!--<div class="game">-->
      <!--<el-row class="tac">-->
        <!--<el-col :span="12">-->
          <!--<el-menu-->
            <!--default-active="2"-->
            <!--class="el-menu-vertical-demo"-->
            <!--background-color="#545c64"-->
            <!--text-color="#fff"-->
            <!--active-text-color="#ffd04b">-->
            <!--<el-submenu index="1">-->
              <!--<template slot="title">-->
                <!--<span><router-link to="/game">游戏信息</router-link></span>-->
              <!--</template>-->
            <!--</el-submenu>-->
          <!--</el-menu>-->
        <!--</el-col>-->
      <!--</el-row>-->
    <!--</div>-->
    <div class="game">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>

export default {
  name: 'app'
}
</script>

<style>
</style>
