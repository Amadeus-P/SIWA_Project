<script setup>
import { onBeforeMount, onBeforeUpdate, onMounted, onUpdated, ref, watchEffect  } from 'vue';
// import { slide } from '../../../public/js';


const hasPreviousPage = ref(false);
const hasNextPage = ref(false);
const pageNumbers = ref([1,2,3,4,5]);

const websites = ref([]);
const categories = ref([]);
const mainCategories = ref([]);
const subCategories = ref([]);
const detailCategories = ref([]);

const config = useRuntimeConfig();

const { data: websiteData} = await useFetch("websites", {
    baseURL: config.public.apiBase
});

const { data: categoryData} = await useFetch("categories", {
    baseURL: config.public.apiBase
});

watchEffect(()=>{
    if(websiteData.value) {
        websites.value = websiteData.value; // dto
        console.log("웹사이트: ",websiteData.value);
        hasPreviousPage.value = websiteData.hasPreviousPage;
        hasNextPage.value = websiteData.hasNextPage;
        }
    if(categoryData.value) {
        categories.value = categoryData.value;
        
        // 대분류 [{}, {}, {}]
        if(categoryData.value.filter(c=>c.parentId === null)) {
            mainCategories.value = categories.value.flatMap(c => c);
            console.log("대분류: ", mainCategories.value);
        }
        // 중분류
        subCategories.value = mainCategories.value
            .filter(category => category.subCategories) // subCategories가 있는 항목만 필터링
            .flatMap(category => category.subCategories || []);
        console.log("중분류: ", subCategories.value);
        
        // 소분류
        detailCategories.value = subCategories.value
            .filter(category => category.subCategories)
            .flatMap(category => category.subCategories || []);
            console.log("소분류: ", detailCategories.value);
    }
});

const iconShow = ref(false);

let isSubCategoryShow = ref(false);
let filteredSubCategories = ref([]);

let isDetailCategoryShow = ref(false);
let filteredDetailCategories = ref([]);

// 이벤트 실행 시 대분류에 해당하는 중분류 보여주기 
const showSubCategory = (cid) => {
    // 증분류 초기화
    filteredSubCategories.value = [];
    isSubCategoryShow.value = false;

    // 소분류 초기화
    filteredDetailCategories.value = [];
    isDetailCategoryShow.value = false;
    
// 선택한 카테고리의 parentId에 해당하는 서브 카테고리만 골라내기
filteredSubCategories.value = subCategories.value.filter(c => {
        console.log("id", cid);
        console.log("subCategory.parentId", c.parentId);
        return c.parentId === cid;
    });
    // 필터된 카테고리가 있으면 isSubCategoryShow를 true로 설정
    isSubCategoryShow.value = filteredSubCategories.value.length > 0;
};

const showDetailCategory = (cid) => {
    // 소분류 초기화
    filteredDetailCategories.value = [];
    isDetailCategoryShow.value = false;

    filteredDetailCategories.value = detailCategories.value.filter(c => {
        console.log("id", cid);
        console.log("detailCategory.parentId", c.parentId);
        return c.parentId === cid;
    });
    isDetailCategoryShow.value = filteredDetailCategories.value.length > 0;
};

let isWebsiteShow = ref(true);
let filteredWebsite = ref([]);
// 소분류의 category.id를 매개변수로 받아서 웹사이트의 Category Object가 가진 category.id에 접근해서 같은지 비교해야함
const showWebsite = (cid) => {
        filteredWebsite.value =  websites.value.websiteListDtos.filter(w => cid === w.category.id);
        console.log("cid", cid);
        console.log("필러링된 웹사이트", filteredWebsite.value);
    isWebsiteShow.value = filteredWebsite.value.length > 0;
};

onBeforeMount(()=>{
    console.log("onBeforeMount"); 
});
onMounted(()=>{
    console.log("onMounted");
});
onBeforeUpdate(()=>{
    console.log("onBeforeUpdate");
});
onUpdated(()=>{
    console.log("onUpdated");
});

</script>

<template>
    <Head>
        <Link rel="stylesheet" href="/css/index.css"/>
    </Head>
    <header class="header">
        <h1>상단 메뉴</h1>
        <section class="" style="margin: 10px;
            display: flex;
            align-items: center;
            justify-content: space-between; flex-basis: 100%;">
            <NuxtLink to="">
                <h1 class="text-hidden" style="display: flex; flex-shrink: 0;">
                    <img style="width: 60px; " src="/img/logo/watercolor-4116932_1280.png" alt="로고">
                </h1>
            </NuxtLink>
            <nav>
                <h1>사이드 메뉴</h1>
                <ul style="
                        display: flex; flex-wrap: wrap; gap: 10px; align-items: center;">
                    <li>
                        <NuxtLink v-if="useMemberDetails().isGhost()" class="btn-sign" to="/signin">회원 로그인</NuxtLink>
                        <NuxtLink v-else class="btn-style:round" to="/signout">로그아웃</NuxtLink>
                    </li>
                </ul>
            </nav>
        </section>
        <section style="display: flex; justify-content: end; flex-basis: 100%; margin: 0 10px 10px;">
            <h1>검색 페이지로 이동</h1>
            <div style="display: flex;
                    padding: 5px 10px; width: 100%;
                    border: 1px solid var(--main-color-1); border-radius: var(--border-radius-px-3)">
                <NuxtLink to="/search" class="icon:search text-hidden" style="width: 100%;">
                    <span class="">검색</span>
                </NuxtLink>
            </div>
        </section>
    </header>

    <main>
        <header class="main-header" style="margin: 120px 0 10px; overflow: hidden;">
         
        </header>
        <section>
            <h1>메인 페이지</h1>
            <nav v-if="true" style="margin-top: 10px; flex-basis: 100%; justify-content: space-evenly;">
                <h1>대분류 카테고리</h1>
                <ul class="main-category">
                    <li v-for="c in categories" :key="c.id" @click.prevent="showSubCategory(c.id)">
                                <label 
                                class="icon:font-2 icon:text-bottom"
                                v-bind:class="[`icon:, iconShow? : ${c.iconName} : ''`]">
                                <!-- 동적으로 스타일을 입혀야 함 -->
                                <div>{{'icon:' + c.iconName}}</div>
                                    <input type="radio" name="main-category"  
                                    v-bind:value="c.id">{{c.name}}
                                </label>
                        </li>
                </ul>
            </nav>
            <nav v-show="isSubCategoryShow">
                <h1>중분류 카테고리</h1>
                <ul class="sub-category">
                    <li v-for="c in filteredSubCategories" :key="c.id" @click.prevent="showDetailCategory(c.id)">
                        <label class="btn-style:square">
                            <input type="checkbox" name="sub-category" 
                            v-bind:value="c.id">{{ c.name }}
                        </label>
                   </li>
                </ul>
            </nav>
            <nav v-show="isDetailCategoryShow" style="margin: 5px 0;">
                <h1>소분류 카테고리</h1>
                <ul class="detail-category dot">
                    <li v-for="c in filteredDetailCategories" :key="c.id" @click.prevent="showWebsite(c.id)">
                        <label>
                            <input type="radio" name="detail-category-languege" 
                            v-bind:value="c.id">{{ c.name }}
                        </label>
                    </li>
                </ul>
            </nav>
            <section style="display: flex; justify-content: end; gap: 5px;">
                <h1>필터</h1>
                <ul class="vertical-bar filter-list" style="">
                    <li>
                        <label>
                            <input type="radio" name="filter" value="recommend" checked>추천순
                        </label>
                    </li>
                    <li>
                        <label>
                            <input type="radio" name="filter" value="recommend">인기순
                        </label>
                    </li>
                    <li>
                        <label>
                            <input type="radio" name="filter" value="recommend">최신순
                        </label>
                    </li>
                </ul>
            </section>
            <section v-show="isWebsiteShow" class="website-list" style="overflow: hidden;">
                <h1>웹사이트 목록</h1>
                <div v-for="w in  filteredWebsite" :key="w.id" class="website-card" style="position: relative;">
                    <NuxtLink v-bind:to="`/${w.id}/`">
                        <img class="website-img" src="/img/website/rland.png" alt="웹사이트 이미지">
                    </NuxtLink>
                    <span class="icon:like icon:font-1 text-hidden">좋아요</span>
                    <ul class="website-content">
                        <li style="display: flex; justify-content: space-between;">
                            <span class="text-overflow" style="width: 80%; font-size: var(--font-size-4); font-weight: var(--font-weight-6);">{{ w.name }}</span>
                            <span class="icon:more text-hidden"
                                    style="position: absolute; top: 0; right: 0;">더보기</span>
                        </li>
                        <li style="display: flex; gap: 2px;">
                            <div class="btn-style:square">
                                {{ w.regDate }}
                            </div>
                            <div class="btn-style:square">
                                인기 #10
                            </div>
                        </li>
                    </ul>
                </div>
            </section>
        </section>
        <footer class="main-footer" style="margin-bottom: 60px;">
            <ul>
                <li v-for="p in pageNumbers" :key="p">
                    <a href="">{{ p }}</a>
                </li>
            </ul>
<!--            무한 스크롤 api 호출 하단-->
        </footer>
    </main>

    <FooterMenu/>
    
</template>

<style scoped>

</style>