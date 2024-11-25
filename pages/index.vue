<script setup>

</script>

<template>
    <!-- 프로젝트 안의 파일 경로 불러오기 -->
    <Head>
        <!-- <Link rel="" href="/js/ball.js"/> -->
        
    </Head>
    <main>
        <NuxtLink to="/websites">웹사이트 목록</NuxtLink>
        <NuxtLink to="/dev">연습장</NuxtLink>
    </main>
</template>

<style scoped>
* {
  margin: 0;
  padding: 0;
}

html {
  width: 100%;
  height: 100%;
}

body {
  width: 100%;
  height: 100%;
  overflow: hidden;
}

canvas {
  /* 블랙홀 차콜 */
  /* background-color: #1C2833; */
  /* 인터스텔라 블루 */
  /* background-color: #2C3E50; */
  width: 100%;
  height: 100%;
  /* border: 1px solid grey; */
}
</style>
