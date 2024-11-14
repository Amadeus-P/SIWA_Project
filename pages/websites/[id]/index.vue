<script setup>
</script>

<template>
    <HeaderMenu />
    <main layout:fragment="main">
        <h1>상세 페이지</h1>
        <nav>
            <h1>이미지 슬라이드</h1>
            <ul style="display: flex; gap: 10px; overflow: hidden;">
                <li style="flex-shrink: 0;"><img style="width: 100vw; height: auto; aspect-ratio: 16/9;
                  object-fit: cover;" src="/img/website/rland.png" alt="스크린샷"></li>
                <li style="flex-shrink: 0;"><img style="width: 100vw; height: auto; aspect-ratio: 16/9;
                  object-fit: cover;
                              " src="/img/website/rland.png" alt="스크린샷"></li>
            </ul>
        </nav>
        <section style="
          display: flex;
          flex-basis: 100%;
          flex-wrap: wrap;
          margin: 10px;">
            <h1>사이트 상세 정보</h1>
            <ul class="website-detail" style="margin: 5px; display: flex; flex-direction: column; flex-basis: 100%;">
                <li style="height: 50px;">
                    <RouterLink to="">
                        <span style="font-size: var(--font-size-4); font-weight: var(--font-weight-6);">네이버</span>
                    </RouterLink>
                </li>
                <li style="display: flex; align-items: center;">
                    <RouterLink class="btn btn-submit btn:round" style=" font-size: var(--font-size-3);" to="">방문하기
                    </RouterLink>
                </li>
            </ul>
            <nav style="overflow: hidden;">
                <h1>사용자 버튼 목록</h1>
                <ul
                    style="scrollbar-width: none; overflow-x: auto;  display: flex; flex-basis: 100%; gap: 10px; margin: 10px 10px;">
                    <li>
                        <img class="profile-img" src="/img/member/ico_ep2_01.png" alt="프로필사진">
                        <span
                            style="margin-left: 5px; margin-right: auto; font-size: var(--font-size-3); font-weight: var(--font-weight-5);">회원명</span>
                    </li>
                    <li>
                        <span class="icon:views btn-style:round">
                            <span
                                style="margin-left: 5px; font-size: var(--font-size-3); color: var(--base-color-1);">100</span>
                        </span>
                    </li>
                    <li>
                        <RouterLink class="icon:recommended btn-style:round" style="" to="">
                            <span style="margin-left: 5px;">10</span>
                        </RouterLink>
                    </li>
                    <li>
                        <RouterLink class="icon:dislike text-hidden btn-style:round" to="">싫어요</RouterLink>
                    </li>
                    <li>
                        <RouterLink to="" class="icon:like btn-style:round">
                            <span style="margin-left: 5px;">52</span>
                        </RouterLink>
                    </li>
                    <li>
                        <RouterLink class="btn-style:round"
                            style=" font-size: var(--font-size-3); color: var(--base-color-1);" to="share">공유
                        </RouterLink>
                    </li>
                    <li>
                        <RouterLink class="btn-style:round"
                            style=" font-size: var(--font-size-3); color: var(--base-color-1);" to="report">신고
                        </RouterLink>
                    </li>
                </ul>
            </nav>
        </section>

        <!-- 댓글 더보기 -->
        <RouterLink id="comment-more" to="#comment-more" class="btn-style:square" style="display: flex; justify-content: center; align-items: center;
      margin: 20px 10px; height: 48px; ">
            <data class="icon:arrow-down" value="100">댓글 100개</data>
        </RouterLink>

        <!-- 광고 -->
        <section>

        </section>

        <!-- 추천 웹사이트 목록 -->
        <section class="website-list" style="overflow: hidden;">
            <h1>웹사이트 목록</h1>
            <!--  여기서 json 데이터를 가져와서 반복 -->
            <!-- v-for="website in websites" :key="website.id" -->
            <!-- v-for="(value, key) in websites" :key="key" -->
            <div class="website-card" style="position: relative;">
                <RouterLink to="detail">
                    <!-- {{ website.imgId }} -->
                    <!-- {{  key }}: {{ value -->
                    <img class="website-img" src="/img/website/japan-contest-9083822_1280.jpg" alt="웹사이트 이미지">
                </RouterLink>
                <div class="icon:like icon:font-1" style="
                      position: absolute; top: 5px; right: 5px;
                      margin-left: auto;
                      font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                      color: var(--base-color-1);">
                </div>
                <ul class=""
                    style="position: relative; display: flex; flex-basis: 100%; gap: 2px; flex-direction: column; margin: 5px 10px 0 ; ">
                    <li style="display: flex; justify-content: space-between;">
                        <span class="text-overflow"
                            style="width: 80%; font-size: var(--font-size-4); font-weight: var(--font-weight-6);">이십자이내로이름짓기</span>
                        <span class="icon:more text-hidden" style="position: absolute; top: 0; right: 0;">더보기</span>
                    </li>
                    <li style="display: flex; flex-direction: row; gap: 2px;">
                        <div class="btn-style:square" style="">
                            3시간 전 등록
                        </div>
                        <div class="btn-style:square" style="">
                            지금 가장 인기 있는 #10
                        </div>
                    </li>
                </ul>
                <nav
                    style="margin: 5px 10px 0; overflow: hidden; display: flex; justify-content: start; align-items: center; flex-basis: 100%;">
                    <h1>카테고리 목록</h1>
                    <ul style="scrollbar-width: none; overflow-x: auto;  display: flex; justify-content: start; align-items: center; flex-basis: 100%; gap: 2px;
                   text-wrap: nowrap;">
                        <li>
                            <a class="btn-style:square"
                                style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">디자인</a>
                        </li>
                        <li>
                            <a class="btn-style:square"
                                style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">다이어리</a>
                        </li>
                        <li>
                            <a class="btn-style:square"
                                style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">우주</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="website-card" style="position: relative;">
                <RouterLink to="detail">
                    <!-- {{ website.imgId }} -->
                    <!-- {{  key }}: {{ value -->
                    <img class="website-img" src="/img/website/mushroom-8313142_1280.jpg" alt="웹사이트 이미지">
                </RouterLink>
                <div class="icon:like icon:font-1" style="
                          position: absolute; top: 5px; right: 5px;
                          margin-left: auto;
                          font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                          color: var(--base-color-1);">
                </div>
                <ul class=""
                    style="position: relative; display: flex; flex-basis: 100%; gap: 2px; flex-direction: column; margin: 5px 10px 0 ; ">
                    <li style="display: flex; justify-content: space-between;">
                        <span class="text-overflow"
                            style="width: 80%; font-size: var(--font-size-4); font-weight: var(--font-weight-6);">이십자이내로이름짓기</span>
                        <span class="icon:more text-hidden" style="position: absolute; top: 0; right: 0;">더보기</span>
                    </li>
                    <li style="display: flex; flex-direction: row; gap: 2px;">
                        <div class="btn-style:square" style="">
                            3시간 전 등록
                        </div>
                        <div class="btn-style:square" style="">
                            지금 가장 인기 있는 #10
                        </div>
                    </li>
                </ul>
                <nav
                    style="margin: 5px 10px 0; overflow: hidden; display: flex; justify-content: start; align-items: center; flex-basis: 100%;">
                    <h1>카테고리 목록</h1>
                    <ul style="display: flex; justify-content: start; align-items: center; flex-basis: 100%; gap: 2px;
                   overflow: hidden; text-wrap: nowrap;">
                        <li>
                            <a class="btn-style:square"
                                style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">디자인</a>
                        </li>
                        <li>
                            <a class="btn-style:square"
                                style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">다이어리</a>
                        </li>
                        <li>
                            <a class="btn-style:square"
                                style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">우주</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="website-card" style="position: relative;">
                <RouterLink to="detail">
                    <!-- {{ website.imgId }} -->
                    <!-- {{  key }}: {{ value -->
                    <img class="website-img" src="/img/website/fish-8673535_1280.jpg" alt="웹사이트 이미지">
                </RouterLink>
                <div class="icon:like icon:font-1" style="
                          position: absolute; top: 5px; right: 5px;
                          margin-left: auto;
                          font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                          color: var(--base-color-1);">
                </div>
                <ul class=""
                    style="position: relative; display: flex; flex-basis: 100%; gap: 2px; flex-direction: column; margin: 5px 10px 0 ; ">
                    <li style="display: flex; justify-content: space-between;">
                        <span class="text-overflow"
                            style="width: 80%; font-size: var(--font-size-4); font-weight: var(--font-weight-6);">이십자이내로이름짓기</span>
                        <span class="icon:more text-hidden" style="position: absolute; top: 0; right: 0;">더보기</span>
                    </li>
                    <li style="display: flex; flex-direction: row; gap: 2px;">
                        <div class="btn-style:square" style="">
                            3시간 전 등록
                        </div>
                        <div class="btn-style:square" style="">
                            지금 가장 인기 있는 #10
                        </div>
                    </li>
                </ul>
                <nav
                    style="margin: 5px 10px 0; overflow: hidden; display: flex; justify-content: start; align-items: center; flex-basis: 100%;">
                    <h1>카테고리 목록</h1>
                    <ul style="display: flex; justify-content: start; align-items: center; flex-basis: 100%; gap: 2px;
                   overflow: hidden; text-wrap: nowrap;">
                        <li>
                            <a class="btn-style:square"
                                style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">디자인</a>
                        </li>
                        <li>
                            <a class="btn-style:square"
                                style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">다이어리</a>
                        </li>
                        <li>
                            <a class="btn-style:square"
                                style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">우주</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </section>
    </main>
</template>
<style scoped>
.comment-box {
    font-size: 12px;
}

.profile-img {
    --icon-width-4: 32px;
    --icon-height-4: 32px;
    width: var(--icon-width-4);
    height: var(--icon-height-4);
}

@media screen and (width <=768px) {
    .website-card {
        width: calc(100%);
    }
}

@media screen and (768px < width) {
    .website-card {
        width: calc(50%);
    }
}
</style>