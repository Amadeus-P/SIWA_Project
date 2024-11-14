<script setup>

const {data: categoryData} = await useAuthFetch("categories");

const selectedMainCategoryId = ref(null);
const selectedSubCategoryId = ref(null);
const selectedDetailCategoryId = ref(null);

const categories = ref([]);



if(categoryData.value){
    categories.value = categoryData.value;
}
const mainCategories = computed(() => {
    const filteredCategory = categories.value.filter(c => c.parentId == null);
    console.log("등록페이지 대분류: ",  filteredCategory);
    return filteredCategory;
});
const subCategories = computed(() => {
    const filteredCategory = mainCategories.value.filter(c => c.subCategories)
    .flatMap(c => c.subCategories || []);
    console.log("등록페이지 중분류",  filteredCategory);
    return filteredCategory;
    
});

const detailCategories = computed(() => {
    const filteredCategory = subCategories.value.filter(c => c.subCategories)
    .flatMap(c => c.subCategories || []);
    console.log("등록페이지 소분류", filteredCategory);
    
    return filteredCategory;
});

    const submitHandler = async (e) => {
        e.preventDefault();
        const formElement = e.target;
        const formData = new FormData(e.target);
        try {
            // 데이터 전송 (Fetch API 사용)
            let response = await useAuthFetch("member/websites", {
                method: "POST",
                body: formData
            });
            if (!response.ok) {
                throw new Error('사이트 등록에 실패했습니다.');
            }
            const result = await response.json();
            console.log('사이트 등록 성공:', result);
            // 성공적으로 등록된 후 다른 페이지로 이동하거나 상태 초기화할 수 있음
        } catch (error) {
            console.error('에러 발생:', error);
        }

    }



</script>
<template>
    
    <HeaderMenu/>
    
    <main>
        <h1>웹사이트 등록 페이지</h1>
        <section style="display: flex; justify-content: space-evenly;">
            <h1>사이트 정보 입력</h1>
            <!-- ajax사용시 form태그의 속성은 필요가 없어지지만 HTML의 기본 구조를 따라서 태그를 남기고 속성만 지움 -->
            <form class="form-edit-box" enctype="multipart/form-data" @submit.prevent="submitHandler">
                <fieldset>
                    <legend class="legend">사이트 정보 입력</legend>

                    <section class="mainCategoryList">
                        <h2>아코디언 대분류 메뉴</h2>
                        <label v-for="c in mainCategories" :key="c.id">
                            <span>{{ c.name }}</span>
                            <input type="radio" name="mainCategory" :value="c.id" v-model="selectedMainCategoryId"/>
                            <button type="button" class="btn icon:arrow-down icon:text-right text-hidden" style="margin-left: auto;">메뉴 여닫이</button>
                        </label>
                    </section>

                    <section class="subCategoryList">
                        <h2>아코디언 중분류 메뉴</h2>
                        <label v-for="c in subCategories" :key="c.id">
                            <span>{{ c.name }}</span>
                            <input type="radio" name="subCategory" :value="c.id" v-model="selectedSubCategoryId"/>
                            <button type="button" class="btn icon:arrow-down icon:text-right text-hidden" style="margin-left: auto;">메뉴 여닫이</button>
                        </label>
                    </section>

                    <section class="detailCategoryList">
                        <h2>아코디언 소분류 메뉴</h2>
                        <label v-for="c in detailCategories" :key="c.id">
                            <span>{{ c.name }}</span>
                            <input type="radio" name="detailCategory" :value="c.id" v-model="selectedDetailCategoryId"/>
                        </label>
                    </section>

                    <section class="" style="margin-top: 50px; display: flex; gap: 10px; flex-direction: column;">
                        <h2>사이트 정보</h2>
                        <label class="">
                            <span>URL</span>
                            <strong><span style="color: var(--accent-color-1);" aria-label="필수입력">*</span></strong>
                            <input type="url" id="url-prefix" name="url" pattern="https:(//)?.*" required>
                        </label>
                        <label class="">
                            <span>타이틀</span>
                            <strong><span style="color: var(--accent-color-1);" aria-label="필수입력">*</span></strong>
                            <input type="text" name="title" required autofocus autocomplete="on">
                        </label>
                        <label class="">
                            <span>이미지 업로드</span>
                            <span style="font-size: var(--font-size-2); font-weight: var(--font-weight-6);  color: var(--base-color-3);">웹사이트와 관련된 이미지나 스크린샷을 올려주세요.</span>
                            <input type="file" name="img" style="">
                        </label>
                    </section>

                </fieldset>
                <div style="margin: 100px 0;">
                    <button class="btn btn-submit btn:round">사이트 등록하기</button>
                </div>
            </form>
        </section>
    </main>
</template>

<style scoped>

/* 아코디언 메뉴 숨기기 */
.subCategoryList, .detailCategoryList{
    height: 0;
    overflow: hidden;
    transition: max-height 0.3s ease;
}
/* 중분류 메뉴 보이기 */
.mainCategoryList:has(input[name="mainCategory"]:checked) + .subCategoryList{
    height: auto;
    transition: max-height 0.3s ease;
}
/* 소분류 메뉴 보이기 */
.subCategoryList:has(input[name="subCategory"]:checked) + .detailCategoryList{
    height: auto;
    transition: max-height 0.3s ease;
}

.mainCategoryList{
    label{
        border-top: 2px solid var(--base-color-1);
    }
}
.subCategoryList{
    label{
        background-color: var(--base-color-4);
    }
}
.detailCategoryList{
    label{
        background-color: var(--base-color-3);
        
        &:last-child{
            border-bottom: 3px solid var(--base-color-1);
        }
    }
}

label:has(input[type="radio"]:checked){
    background-color: var(--main-color-1);
}

.mainCategoryList label, .subCategoryList label, .detailCategoryList label{
    display: flex;
    padding: 10px;
    &:hover{
        background-color: var(--main-color-1);
        transition: background-color 0.1s ease;
    }
}

section label span{
    font-size: var(--font-size-4);
    font-weight: var(--font-weight-6);
    color: var(--base-color-black);
}
section label{
        display: flex;
        width: auto;
        flex-wrap: wrap;
        >input{
            line-height: 20px;
            border: 1px solid var(--base-color-4);
            border-radius: 5px;
            width: 100%;
            height: 40px;
            padding: 5px 10px;
            font-size: var(--font-size-3);
            font-weight: var(--font-weight-4);
            &:focus{
                border: 1px solid var(--base-color-1);
            }
        }
    }



    .icon\:arrow-down::before{
        width: 36px;
        height: 36px;
        mask-size: 36px 36px;
        background-color: var(--base-color-1);
        transition: transform 0.3s ease;
    }
    .icon\:arrow-down:has(input[type="radio"]:checked)::before {
        transition: transform 0.3s ease;
        transform: rotate(180deg);
    }
</style>