<template>
    <header class="header">
        <h1>상단 메뉴</h1>
        <section class="" style="margin: 10px;
            display: flex;
            align-items: center;
            justify-content: space-between; flex-basis: 100%;">
            <RouterLink to="index">
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
                    <!-- <li>
                        <RouterLink to="" class="icon:notification text-hidden">알람</RouterLink>
                    </li> -->
                    <li class="" style="">
                        <button type="button" class="slide-btn btn">
                            <span class="burger-menu">슬라이드 메뉴</span>
                        </button>
                    </li>
                </ul>

                <!--             슬라이드 영역 -->
                <div class="slide-menu">
                    <ul>
                        <li>슬라이드 메뉴</li>
                        <li>슬라이드 메뉴</li>
                        <li>슬라이드 메뉴</li>
                        <li>슬라이드 메뉴</li>
                        <li>슬라이드 메뉴</li>
                        <li>슬라이드 메뉴</li>
                    </ul>
                </div>
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
        <nav style="margin-top: 10px; flex-basis: 100%; justify-content: space-evenly;">
            <h1>자주 찾는 메뉴</h1>
            <ul style="
                display: flex;
                flex-wrap: nowrap;
                justify-content: start;">
                <li style="display: flex; justify-content: center; flex-basis: 50%; flex-shrink: 1; flex-grow: 1;">
                    <RouterLink to="index" style="
                            height: 24px;
                            border-bottom: 2px solid var(--main-color-1);
                            display: flex;
                            flex-basis: 25%;
                            flex-shrink: 0;
                            flex-grow: 1;
                        justify-content: center;
                        ">인기순</RouterLink>
                </li>
                <li style="display: flex; justify-content: center; flex-basis: 50%; flex-shrink: 1; flex-grow: 1;">
                    <RouterLink to="index" style="
                            height: 24px;

                            display: flex;
                            flex-shrink: 0;
                            flex-grow: 1;
                            justify-content: center;
                        ">최신순</RouterLink>
                </li>
                <li style="display: flex; justify-content: center; flex-basis: 50%; flex-shrink: 1; flex-grow: 1;">
                    <RouterLink to="index" style="
                            height: 24px;

                            display: flex;
                            flex-shrink: 0;
                            flex-grow: 1;
                            justify-content: center;
                        ">좋아요</RouterLink>
                </li>
            </ul>
        </nav>
    </header>

    <main>
        <header class="main-header" style="margin: 150px 0 50px;">
        </header>

        <section class="">
            <h1>목록 페이지</h1>
            <!-- 인기 카테고리 20개씩 페이지네이션 무한 스크롤-->
            <nav style="display: flex; justify-content: start; align-items: center; flex-basis: 100%;">
                <h1>카테고리 목록</h1>
                <ul style="display: flex; justify-content: start; align-items: center; flex-basis: 100%; gap: 10px;
                margin: 4px 10px; overflow: hidden; text-wrap: nowrap;">
                    <li>
                        <a class="btn-style:default" href="">전체보기</a>
                    </li>
                    <li>
                        <a class="btn-style:default" href="">디자인</a>
                    </li>
                    <li>
                        <a class="btn-style:default" href="">다이어리</a>
                    </li>
                    <li>
                        <a class="btn-style:default" href="">우주</a>
                    </li>
                    <li>
                        <a href="" style="color: var(--main-color-1)">더 많은 카테고리</a>
                    </li>
                </ul>
            </nav>
            <nav class="website-list">
                <h1>웹사이트 목록</h1>
                <!--  여기서 json 데이터를 가져와서 반복 -->
                  <!-- v-for="website in websites" :key="website.id" -->
                   <!-- v-for="(value, key) in websites" :key="key" -->
                <div class="website-card">
                    <RouterLink to="detail">
                        <!-- {{ website.imgId }} -->
                          <!-- {{  key }}: {{ value -->
                        <img class="website-img" src="/img/website/rland.png" alt="웹사이트 이미지">
                    </RouterLink>
                        <ul class=""
                                style="display: flex; flex-basis: 100%; gap: 2px; flex-direction: column; padding: 5px; ">
                            <li style="display: flex; justify-content: space-between; position: relative;">
                                <span class="text-overflow" style="font-size: var(--font-size-4); font-weight: var(--font-weight-6)">네이버</span>
                                <span class="icon:more text-hidden"
                                      style="position: absolute; top: 0; right: 0;">더보기</span>
                            </li>
                            <li>
                                 <span  class=""
                                        style="height: 16px; font-size: var(--font-size-3); font-weight: var(--font-weight-4);color: var(--base-color-3);">
                                     <span style="">카테고리</span>
                                 </span>
                            </li>
                            <li>
                                <span style="
                                font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-3);">이름</span>
                            </li>
                            <li style="
                            margin-top: auto;
                            display: flex; flex-direction: row; gap: 4px;">
                                <div class="" style=" 
                                 font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-1);">
                                    조회수
                                    <span style="margin-left: 2px;">1천</span>
                                </div>
                                <div class="" style="
                                font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-1);">
                                댓글수
                                    <span style="margin-left: 2px;">999+</span>
                                </div>
                                <div class="icon:like icon:font-1" style="
                                margin-left: auto;
                                font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-1);">
                                    <span style="margin-left: 2px;">10</span>
                                </div>
                            </li>
                        </ul>
                </div>
                <div class="website-card">
                    <RouterLink to="detail">
                        <img class="website-img" src="/img/website/dcep12_pc.png" alt="웹사이트 이미지">
                    </RouterLink>
                        <ul class=""
                                style="display: flex; flex-basis: 100%; gap: 2px; flex-direction: column; padding: 5px; ">
                            <li style="display: flex; justify-content: space-between; position: relative;">
                                <span class="text-overflow" style="font-size: var(--font-size-4); font-weight: var(--font-weight-6)">네이버</span>
                                <span class="icon:more text-hidden"
                                      style="position: absolute; top: 0; right: 0;">더보기</span>
                            </li>
                            <li>
                                 <span  class=""
                                        style="height: 16px; font-size: var(--font-size-3); font-weight: var(--font-weight-4);color: var(--base-color-3);">
                                     <span style="">카테고리</span>
                                 </span>
                            </li>
                            <li>
                                <span style="
                                font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-3);">이름</span>
                            </li>
                            <li style="
                            margin-top: auto;
                            display: flex; flex-direction: row; gap: 4px;">
                                <div class="" style=" 
                                 font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-1);">
                                    조회수
                                    <span style="margin-left: 2px;">1천</span>
                                </div>
                                <div class="" style="
                                font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-1);">
                                댓글수
                                    <span style="margin-left: 2px;">999+</span>
                                </div>
                                <div class="icon:like icon:font-1" style="
                                margin-left: auto;
                                font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-1);">
                                    <span style="margin-left: 2px;">10</span>
                                </div>
                            </li>
                        </ul>
                </div>
                <div class="website-card">
                    <RouterLink to="detail">
                        <img class="website-img" src="/img/website/floral-background-6622475_1280.png" alt="웹사이트 이미지">
                    </RouterLink>
                        <ul class=""
                                style="display: flex; flex-basis: 100%; gap: 2px; flex-direction: column; padding: 5px; ">
                            <li style="display: flex; justify-content: space-between; position: relative;">
                                <span class="text-overflow" style="font-size: var(--font-size-4); font-weight: var(--font-weight-6)">네이버</span>
                                <span class="icon:more text-hidden"
                                      style="position: absolute; top: 0; right: 0;">더보기</span>
                            </li>
                            <li>
                                 <span  class=""
                                        style="height: 16px; font-size: var(--font-size-3); font-weight: var(--font-weight-4);color: var(--base-color-3);">
                                     <span style="">카테고리</span>
                                 </span>
                            </li>
                            <li>
                                <span style="
                                font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-3);">이름</span>
                            </li>
                            <li style="
                            margin-top: auto;
                            display: flex; flex-direction: row; gap: 4px;">
                                <div class="" style=" 
                                 font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-1);">
                                    조회수
                                    <span style="margin-left: 2px;">1천</span>
                                </div>
                                <div class="" style="
                                font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-1);">
                                댓글수
                                    <span style="margin-left: 2px;">999+</span>
                                </div>
                                <div class="icon:like icon:font-1" style="
                                margin-left: auto;
                                font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                                color: var(--base-color-1);">
                                    <span style="margin-left: 2px;">10</span>
                                </div>
                            </li>
                        </ul>
                </div>
            </nav>
        </section>
        <footer class="main-footer" style="margin-bottom: 60px;">
<!--            무한 스크롤 api 호출 하단-->
        </footer>
    </main>

    <footer class="footer">
        <nav class="footer-card">
            <h1>하단메뉴</h1>
            <ul class="footer-menu">
                <li>
                    <RouterLink to="index" class="icon:home icon:text-bottom icon:font-1">
                        <span class="text">홈</span>
                    </RouterLink>
                </li>
                <li>
                    <RouterLink to="reg" class="icon:add icon:text-bottom icon:font-1" >
                        <span class="">사이트 등록</span>
                    </RouterLink>
                </li>
                <li>
                    <a href="mypage/index" class="icon:profile icon:text-bottom icon:font-1">
                        <span>내 페이지</span>
                    </a>
                </li>
            </ul>
        </nav>
    </footer>
</template>
<style>
        @media screen and (width <= 768px){
            .website-card   {
                width: calc(100%);
            }
        }
        @media screen and (768px < width){
            .website-card{
                width: calc(50%);
            }
        }
</style>