<script setup>
    const props = defineProps({
        home: {
            type: String,
            default: '/'  // 기본값은 루트 경로
        }
    });

    const userDetails = useUserDetails();
</script>

<template>
    <footer class="footer">
        <nav class="footer-card">
            <h1>하단메뉴</h1>
            <ul class="footer-menu">
                <li>
                    <NuxtLink v-bind:to="home" class="icon:home icon:text-bottom icon:font-1">
                        <span class="text">홈</span>
                    </NuxtLink>
                </li>
                <li>
                    <NuxtLink v-if="userDetails.isGhost()" to="signin" class="icon:add icon:text-bottom icon:font-1" >
                        <span class="">사이트 등록</span>
                    </NuxtLink>
                    <NuxtLink v-else to="member/new" class="icon:add icon:text-bottom icon:font-1" >
                        <span class="">사이트 등록</span>
                    </NuxtLink>
                    
                </li>
                <li>
                    <NuxtLink v-if="userDetails.isGhost()" to="signin" class="icon:profile icon:text-bottom icon:font-1">
                        <span>내 페이지</span>
                    </NuxtLink>
                    <NuxtLink v-else to="member/mypage" class="icon:profile icon:text-bottom icon:font-1">
                        <span>내 페이지</span>
                    </NuxtLink>
                </li>
            </ul>
        </nav>
    </footer>
</template>