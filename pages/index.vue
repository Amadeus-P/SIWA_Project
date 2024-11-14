<script setup>
</script>

<template>
    <main>
        <h1>메인 페이지</h1>

        <section class="notice">
            <h1>공지사항</h1>
            <span class="notice-title">공지사항입니다.</span>
            <p class="notice-content" style="">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, quos.
            </p>
        </section>
        <NuxtLink to="/websites">웹사이트 목록</NuxtLink>
    </main>
</template>

<style scoped>
    .notice{
        border: 1px solid var(--base-color-3);
        border-radius: 5px;
        margin: 10px;

        display: flex;
        flex-wrap: wrap;

        >.notice-title{
            font-size: 24px;
            font-weight: var(--font-weight-6);

            width: 100%;
            width: 100%;

            display: flex;
            align-items: center;
            justify-content: center;
        }

        >.notice-content{
            width: 100%;
            font-size: 20px;
            font-weight: var(--font-weight-4);

            display: flex;
            align-items: center;
            justify-content: center;
        }
    }

</style>

