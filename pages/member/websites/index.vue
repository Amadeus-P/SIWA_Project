<script setup>
import { onBeforeMount, onBeforeUpdate, onMounted, onUpdated, ref, watchEffect  } from 'vue';
// import { slide } from '../../../public/js';


const hasPreviousPage = ref(false);
const hasNextPage = ref(false);
const pageNumbers = ref([1,2,3,4,5]);

const websites = ref([]);
const categories = ref([]);
const subCategories = ref([]);
const detailCategories = ref([]);

const config = useRuntimeConfig();

const { data: websiteData} = await useFetch("member/websites", {
    baseURL: config.public.apiBase
});

const { data: categoryData} = await useFetch("categories", {
    baseURL: config.public.apiBase
});

watchEffect(()=>{
    if(websiteData) {
        websites.value = websiteData.value; // dto
        console.log(websiteData.value);
        hasPreviousPage.value = websiteData.hasPreviousPage;
        hasNextPage.value = websiteData.hasNextPage;

    };
    if(categoryData.value) {
        categories.value = categoryData.value;
        // console.log(data);
        if (Array.isArray(categoryData.value)) {
            categories.value = categoryData.value;
            // subCategories 처리
            // 각 카테고리의 subCategories를 모두 합치기
            subCategories.value = categories.value
                .filter(category => category.subCategories) // subCategories가 있는 항목만 필터링
                .flatMap(category => category.subCategories || []); // 각 카테고리의 subCategories를 하나의 배열로 합치기
            detailCategories.value = subCategories.value.filter(category => category.subCategories);
        }
    }
});

// const fetchWebsites = async()=>{
//     // 서버에서 데이터 가져오고
//     const response = await fetch(`http://localhost:8081/member/websites`);
//     const data = await response.json();

//     // console.log(data);
//     websites.value = data.websiteListDtos; // dto
//     // console.log(websites.value);
//     hasPreviousPage.value = data.hasPreviousPage;
//     hasNextPage.value = data.hasNextPage;
// };
// const fetchCategories = async() => {
    // const response =  fetch(`http://localhost:8081/categories`); // admin/categories
    // const data = await response.json();
    // categories.value = data;
    // console.log(data);
    
    // categories.value = data.flatMap(category => category);
    // console.log(categories.value);

    // subCategories.value = data.subCategories.flatMap(category => category);
    // console.log(subCategories);


    // // 중분류
    // subCategories.value =  data.flatMap(category => category.subCategories);
    
    // // 소분류
    // detailCategories.value =  data.flatMap(category => category.subCategories?.flatMap(sub => sub.subCategory ? sub.subCategory : sub));
    // console.log(detailCategories.value);

    // subCategories.value = [...data.subCategories]; // 스프레드
    // console.log(data.flatMap(c => c)); // 배열안의 배열을 순회하고 결과값으로 중첩된 배열이 아니라 그냥 단일 배열로 반환함 [ [ 1 ], [ 2 ], [ 3 ] ] -> [ 1 ], [ 2 ], [ 3 ]
    // console.log(data.map(category => category.subCategories))
    // console.log(data.map(c => c)); // 배열을 다른 타입으로 바꾸고 싶을때
    // console.log(data.splice()); // 배열을 원하는 만큼 자르고 싶을 때
    // console.log(...data, data); // 요소를 나열하기만함 > 이후 배열로 감싸는 작업 필요
// };

onBeforeMount(()=>{
    console.log("onBeforeMount"); 
});
onMounted(()=>{
    console.log("onMounted");
    // fetchWebsites();
    // fetchCategories();
    // slide();
});
onBeforeUpdate(()=>{
    console.log("onBeforeUpdate");
});
onUpdated(()=>{
    console.log("onUpdated");
});


// const showCategories = (id) => {
//     const selectedCategory = categories.value.find(item => item.id === id);
//     subCategories.value = selectedCategory?.subCategories || [];
//     detailCategories.value = [];
// };

// const showDetailCategories = (id) => {
//     const selectedSubCategory = subCategories.value.find(item => item.id === id);
//     detailCategories.value = selectedSubCategory?.subCategory || [];
// };
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
            <RouterLink to="websites">
                <h1 class="text-hidden" style="display: flex; flex-shrink: 0;">
                    <img style="width: 60px; " src="/img/logo/watercolor-4116932_1280.png" alt="로고">
                </h1>
            </RouterLink>
            <nav>
                <h1>사이드 메뉴</h1>
                <ul style="
                        display: flex; flex-wrap: wrap; gap: 10px; align-items: center;">
                    <li>
                        <RouterLink class="btn-sign" to="admin-sign-in">관리자 로그인</RouterLink>
                    </li>
                </ul>
            </nav>
        </section>
        <section style="display: flex; justify-content: end; flex-basis: 100%; margin: 0 10px 10px;">
            <h1>검색 페이지로 이동</h1>
            <div style="display: flex;
                    padding: 5px 10px; width: 100%;
                    border: 1px solid var(--main-color-1); border-radius: var(--border-radius-px-3)">
                <RouterLink to="search" class="icon:search text-hidden" style="width: 100%;">
                    <span class="">검색</span>
                </RouterLink>
            </div>
        </section>
    </header>

    <main>
        <header class="main-header" style="margin: 120px 0 10px; overflow: hidden;">
            <!-- <ul class="slide-box" style="transition: transform 0.5s; display: flex; width: 300vw;">
                <li v-for="w in websites" :key="w.id">
                    <RouterLink v-bind:to="`websites/${w.id}/`" style="min-width: 100vw;">
                    <div class="slide" style="">
                        <img class="website-img" style="" src="/img/website/mushroom-8313142_1280.jpg" alt="웹사이트 이미지">
                    </div>
                </RouterLink>
                </li>
                <li>
                    <RouterLink v-bind:to="`websites/${w.id}/`" style="min-width: 100vw;">
                        <div class="slide">
                            <img class="website-img" src="/img/website/japan-contest-9083822_1280.jpg" alt="웹사이트 이미지">
                        </div>
                    </RouterLink>
                </li>
                <li>
                    <RouterLink v-bind:to="`websites/${w.id}/`" style="min-width: 100vw;">
                        <div class="slide" style="">
                            <img class="website-img" src="/img/website/fish-8673535_1280.jpg" alt="웹사이트 이미지">
                        </div>
                    </RouterLink>
                </li>
            </ul>
                <button class="slide-btn-1">1</button>
                <button class="slide-btn-2">2</button>
                <button class="slide-btn-3">3</button> -->
        </header>

        <section>
            <h1>웹사이트 목록 페이지</h1>
            <nav style="margin-top: 10px; flex-basis: 100%; justify-content: space-evenly;">
                <h1>대분류 카테고리</h1>
                <ul class="main-category">
                    <li v-for="(c, index) in categories" :key="c.id">
                                <label v-bind:class="['icon:font-2', 'icon:text-bottom', c.iconName ]">
                                    <input type="radio" name="main-category"  
                                    v-bind:value="c.id">{{c.name}}
                                </label>
                        </li>
                </ul>
            </nav>
            <nav>
                <h1>중분류 카테고리</h1>
                <ul class="sub-category">
                    <li v-for="(c, index) in subCategories" :key="c.id">
                        <label class="btn-style:square">
                            <input type="checkbox" name="sub-category" 
                            v-bind:value="c.id">{{ c.name }}
                        </label>
                   </li>
                </ul>
            </nav>
            <section style="margin: 5px 0;">
                <h1>소분류 카테고리</h1>
                <ul class="detail-category dot">
                    <li v-for="(c, index) in detailCategories" :key="c.id">
                        <label>
                            <input type="radio" name="detail-category-languege" 
                            v-bind:value="c.id" v-bind:checked="index === 0">{{ c.name }}
                        </label>
                    </li>
                </ul>
            </section>
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
            <nav class="website-list" style="overflow: hidden;">
                <h1>웹사이트 목록</h1>
                <!--  여기서 json 데이터를 가져와서 반복 -->
                  <!-- v-for="website in websites" :key="website.id" -->
                   <!-- v-for="(value, key) in websites" :key="key" -->
                <div v-for="w in websiteData.websiteListDtos" :key="w.id" class="website-card" style="position: relative;">
                    <RouterLink v-bind:to="`websites/${w.id}/`">
                        <!-- {{ website.imgId }} -->
                          <!-- {{  key }}: {{ value -->
                        <img class="website-img" src="/img/website/rland.png" alt="웹사이트 이미지">
                    </RouterLink>
                    <span class="icon:like icon:font-1 text-hidden">좋아요</span>
                    <ul class="website-content">
                        <li style="display: flex; justify-content: space-between;">
                            <span class="text-overflow" style="width: 80%; font-size: var(--font-size-4); font-weight: var(--font-weight-6);">{{ w.name }}</span>
                            <span class="icon:more text-hidden"
                                    style="position: absolute; top: 0; right: 0;">더보기</span>
                        </li>
                        <li style="display: flex; gap: 2px;">
                            <div class="btn-style:square">
                                3시간 전 등록
                            </div>
                            <div class="btn-style:square">
                                인기 #10
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
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

    <footer class="footer">
        <nav class="footer-card">
            <h1>하단메뉴</h1>
            <ul class="footer-menu">
                <li>
                    <RouterLink to="" class="icon:home icon:text-bottom icon:font-1">
                        <span class="text">홈</span>
                    </RouterLink>
                </li>
                <li>
                    <RouterLink to="new" class="icon:add icon:text-bottom icon:font-1" >
                        <span class="">사이트 등록</span>
                    </RouterLink>
                </li>
                <li>
                    <a href="mypage" class="icon:profile icon:text-bottom icon:font-1">
                        <span>내 페이지</span>
                    </a>
                </li>
            </ul>
        </nav>
    </footer>
</template>
<style scoped>

</style>