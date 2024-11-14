<script setup>
import { onBeforeMount, onBeforeUpdate, onMounted, onUpdated, ref, watchEffect  } from 'vue';
// import { index } from '../../../public/js';
// Category 컴포넌트 import 추가
import Category from '~/components/Category.vue';

const userDetails = useUserDetails();

let startNum = 0;
let totalPages = 0;
let hasPreviousPage = false;
let hasNextPage = false;
const pageNumbers = ref([1,2,3,4,5]);
const keyword = ref({});

// 카테고리
const mainCategories = ref([]);
const subCategories = ref([]);
const detailCategories = ref([]);
const filteredWebsite = ref([]);

//  데이터 fetch 저장 객체
const websites = ref([]);
const categories = ref([]);

// SSR {response}
// const {data: websiteData} = await useAuthFetch("websites");
// const {data: categoryData} = await useAuthFetch("categories");
const {data: categoryData} = await useAuthFetch("categories", {
        params: {
            parentId: null
        }
    });

// api 데이터 감시
watchEffect(() => {
    // if(websiteData.value) {
    //     websites.value = websiteData.value.websiteListDtos;
        
    //     console.log("웹사이트: ",websites.value);
        
    //     startNum = websiteData.value.pages[0];
    //     hasPreviousPage = websiteData.value.hasPreviousPage;
    //     hasNextPage = websiteData.value.hasNextPage;
        
    //     console.log("startNum: ", startNum, "hasPreviousPage: ", hasPreviousPage, "hasNextPage: ", hasNextPage);
    // }
    if(categoryData.value) {
        categories.value = categoryData.value;
        console.log("최신 카테고리: ", categories.value);
    }
    mainCategories.value = categories.value.categoryListDtos;
    console.log("대분류", mainCategories.value);
});


const fetchCategory = async(categoryId, type) => {
    try{
        // CRS response 
        const categoryResponse = await useDataFetch("categories", {
            params: {
                parentId: categoryId
            }
        });
        if (!categoryResponse || !categoryResponse.categoryListDtos) {
            console.error("카테고리 데이터가 비어있습니다.");
            return;
        }
        if (type === 'sub') {
                subCategories.value = categoryResponse.categoryListDtos;
                console.log("중분류 데이터: ", subCategories.value);

            } else if (type === 'detail') {
                detailCategories.value = categoryResponse.categoryListDtos;
                console.log("소분류 데이터: ", detailCategories.value);
            } else {
                console.error("유효하지 않은 type: ", type);
            }
        } catch (error) {
            console.error("데이터 가져오기 중 오류 발생: ", error);
        }
    };

    const fetchWebsites = async (detailCategoryId, keyword) => {
    try {
        const websiteResponse = await useDataFetch("websites", {
            params: { 
                categoryId: detailCategoryId ,
                keyWord: keyword
            }
        });

        if (!websiteResponse || !websiteResponse.websiteListDtos) {
            console.error("웹사이트 데이터가 비어있습니다.");
            return;
        }

        filteredWebsite.value = websiteResponse.websiteListDtos;
        console.log(`소분류 ID ${detailCategoryId}의 웹사이트 데이터:`, filteredWebsite.value);
    } catch (error) {
        console.error("웹사이트 데이터 가져오기 중 오류 발생: ", error);
    }
};

const selectAllMainHandler = (mainCategoryId) => {
}

const pageClickHandler = (page)=>{
        console.log("page", page, totalPages);
        if(page < 1) {
            alert("이전 페이지가 없습니다.");
            return;
        }
        if(totalPages < page ) {
            alert("다음 페이지가 없습니다");
            return;
        }
        // if(page == null) {
        //     delete keyword.page;
        // }
        keyword.page = page;
    }
       // favicon URL 가져오기
   const getFavicon = (url) => {
     return `https://www.google.com/s2/favicons?domain=${url}&sz=64`;
     // 또는
     // return `https://favicon.io/favicon/${url}`;
   }

onBeforeMount(()=>{
    console.log("onBeforeMount"); 
});
onMounted(()=>{
    console.log("onMounted");
    // if (mainCategories.value.length > 0) {
        // "전체" 카테고리를 자동으로 선택하도록 설정
        // selectedMainCategoryId.value = mainCategories.value[0].id;
        // selectAllMainHandler(mainCategories.value[0].id);
    // }
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
    
    <form enctype="multipart/form-data"></form>
    <header class="header">
        <h1>상단 메뉴</h1>
        <section class="" style="margin: 10px; display: flex; align-items: center; justify-content: space-between; flex-basis: 100%;">
            <NuxtLink to="/websites">
                <h1 class="text-hidden" style="display: flex; flex-shrink: 0;">
                    <img style="width: 60px; " src="/img/logo/watercolor-4116932_1280.png" alt="로고">
                </h1>
            </NuxtLink>
            <nav>
                <h1>사이드 메뉴</h1>
                <ul style="
                        display: flex; flex-wrap: wrap; gap: 10px; align-items: center;">
                    <li>
                        <NuxtLink v-if="userDetails.isGhost()" class="btn btn:round" to="/signin">로그인</NuxtLink>
                        <!-- <span v-else class="btn btn:round">{{ userDetails.profileName }}</span> -->
                        <button v-else class="btn btn:round" @click="userDetails.signout()">{{ userDetails.profileName }} 로그아웃</button>
                    </li>
                </ul>
            </nav>
        </section>
        <section style="display: flex; justify-content: end; flex-basis: 100%; margin: 0 10px 10px;">
            <h1>검색</h1>
            <div style="display: flex; padding: 5px 10px; width: 100%; border: 1px solid var(--base-color-1); border-radius: var(--border-radius-px-1)">
            <!--     <NuxtLink to="/search" class="icon:search text-hidden" style="width: 100%;">
                    <span class="">검색</span>
                </NuxtLink> -->
            <form role="search">
                <label class="" style="width: calc(100% - 40px); position: relative;">
                    <input type="search" name="keyword" placeholder="이름 또는 카테고리로 검색" autocomplete="off"
                        style="margin-left: 40px;">
                </label>
                <span class="icon:search text-hidden" style="position: absolute; left: 20px;">검색</span>
            </form>
            </div>
        </section>

    </header>

    <main>
        <header class="main-header" style="margin: 120px 0 10px; overflow: hidden;">
         
        </header>
        <section>
            <h1>메인 페이지</h1>
            
        <nav style="margin-top: 10px;">
            <h1>대분류 카테고리</h1>
            <ul class="main-category">
                <li style="display: flex; align-items:center; justify-content: space-evenly; ">
                    <label class="icon:font-2 icon:text-bottom"
                    v-for="c in mainCategories" :key="c.id" v-bind:class="`icon:${c.iconName}`" @click="fetchCategory(c.id, 'sub')">
                        <span>{{ c.name }}</span>
                        <!-- 선택한 카테고리의 아이디가 동적으로 변함-->
                            <input type="radio" name="main-category" :value="c.id">
                    </label>
                </li>
            </ul>
        </nav>
        <nav  style="margin: 10px 0;">
            <h1>중분류 카테고리</h1>
            <ul class="sub-category">
                <li style="display: flex;">
                    <label class="btn btn:square" v-for="c in subCategories" :key="c.id" @click="fetchCategory(c.id, 'detail')">
                        <span>{{ c.name }}</span>
                        <input type="radio" name="sub-category">
                    </label>
                </li>
            </ul>
        </nav>
        <nav style="margin: 10px 0;">
            <h1>소분류 카테고리</h1>
            <ul class="detail-category">
                <li style="display: flex;">
                    <label class="btn btn:round" v-for="c in detailCategories" :key="c.id" @click="fetchWebsites(c.id)">
                        <span>{{ c.name }}</span>
                        <input type="radio" name="detail-category-languege">
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
            <section class="website-list" style="overflow: hidden;">
                <h1>웹사이트 목록</h1>
                <div v-for="w in  filteredWebsite" :key="w.id" class="website-card" style="position: relative;">
                    <NuxtLink :to="`websites/${w.id}`">
                        <img class="website-img" :src="w.images?.length ? w.images[0].src : '/img/website/default.png'" alt="웹사이트 이미지">
                    </NuxtLink>
                    <span class="icon:like icon:font-1 text-hidden">좋아요</span>
                    <ul class="website-content">
                        <li style="display: flex; justify-content: space-between;">
                            <span class="text-overflow" style="width: 80%; font-size: var(--font-size-4); font-weight: var(--font-weight-6);">{{ w.title }}</span>
                            <span class="icon:more text-hidden"
                                    style="position: absolute; top: 0; right: 0;">더보기</span>
                        </li>
                        <li style="display: flex; gap: 2px;">
                            <div class="btn btn:square">
                                {{ w.regDate }}
                            </div>
                            <div class="btn btn:square">
                                인기 #10
                            </div>
                        </li>
                    </ul>
                </div>
            </section>
        </section>
    </main>

    <!-- 무한 스크롤 api 호출-->
    <section class="main-footer" style="margin-bottom: 60px;">
        <ul class="pagination" style="display: flex; justify-content: center; gap: 15px;">
            <li v-for="p in pageNumbers" :key="p">
                <NuxtLink class="pager"   :class="{'activePager' : p ==  useRoute().query.p}" :to="`./?page=${p}`" @Click="pageClickHandler">{{ p }}</NuxtLink>
            </li>
        </ul>
    </section>

    <FooterMenu home="/websites"/>
    
</template>

<style scoped>
    .pagination{
        display: flex; 
        justify-content: center; 
        gap: 15px;
        .pager{
            display: flex; align-items: center;
            justify-content: center; 

            border: 1px solid var(--base-color-3);
            border-radius: 5px;

            width: 44px;
            height: 25px;
            &:active, &.activePager{
                border: none;
                color: var(--base-color-white);
                background-color: var(--base-color-1);
                transition: 0.3s;
            }
        }
    }

</style>