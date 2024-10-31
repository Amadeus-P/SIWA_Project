
<script setup>
    const router = useRouter();
    const back = () => {
        router.back();
    };
</script>
<template>
        <header>
        <section style="
            margin: 20px 10px;
            display: flex; justify-content: space-between;">
            <h1>상단 메뉴</h1>
            <button class="icon:arrow-back text-hidden btn" @click="back">뒤로가기</button>
            <!-- <ul class="icon:more-big">
                <li>
                    <RouterLink class="btn-style:default" to="report">신고</RouterLink>
                </li>
            </ul> -->
        </section>
    </header>
</template>