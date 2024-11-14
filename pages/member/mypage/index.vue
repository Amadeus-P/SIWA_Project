<script setup>
</script>

<template>
    
    <HeaderMenu/>

    <main>
        <section class="link-box" style="display: flex; flex-wrap: wrap; width: auto; margin: 10px;">
            <ul>
                <li>
                    <NuxtLink class="icon:arrow-foward-small  icon:text-left" to="profile/list">
                        <img src="" alt="">
                        회원명
                    </NuxtLink>
                </li>
                <li>
                    <NuxtLink class="icon:arrow-foward-small  icon:text-left" to="categories/new">내 기록</NuxtLink>
                </li>
            </ul>
        </section>
    </main>

    <FooterMenu/>

</template>

<style scoped>
.icon\:arrow-foward-small::before{
    background-color: var(--base-color-3);
}
</style>