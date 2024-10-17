<template>
    <header>
        <h1>내 페이지</h1>
        <section style="
                margin: 20px 10px;
                display: flex; justify-content: space-between;">
            <h1>상단 메뉴</h1>
            <button class="icon:arrow-back text-hidden btn">뒤로가기</button>
        </section>
            <nav style="margin-top: 10px; flex-basis: 100%; justify-content: space-evenly;">
                <h1>슬라이드 메뉴</h1>
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
                            ">내 정보</RouterLink>
                    </li>
                    <li style="display: flex; justify-content: center; flex-basis: 50%; flex-shrink: 1; flex-grow: 1;">
                        <RouterLink to="website" style="
                                height: 24px;

                                display: flex;
                                flex-shrink: 0;
                                flex-grow: 1;
                                justify-content: center;
                            ">웹사이트</RouterLink>
                    </li>
                    <li style="display: flex; justify-content: center; flex-basis: 50%; flex-shrink: 1; flex-grow: 1;">
                        <RouterLink to="comment" style="
                                height: 24px;

                                display: flex;
                                flex-shrink: 0;
                                flex-grow: 1;
                                justify-content: center;
                            ">댓글</RouterLink>
                    </li>
                </ul>
            </nav>
    </header>
    <main>
        <header>
            <h1>프로필 페이지</h1>
            <section class="box-shadow"
                        style="
                        margin: 10px; padding: 10px;
                        display: flex; flex-wrap: wrap;">
                <h1>내 프로필</h1>
                    <div style="margin: 0 20px 20px 0;">
                        <img class="icon:profile"
                        style="--icon-width-4: 64px; --icon-height-4: 64px;
                        width: var(--icon-width-4); height: var(--icon-height-4);"
                            src="/img/member/ico_ep2_01.png" alt="프로필 사진">
                        </div>
                    <div  style="display: flex; flex-direction: column; gap: 4px;">
                        <label>
                            <span style="font-size: var(--font-size-1); color: var(--base-color-3);">프로필 이름</span>
                            <input type="text" value="시니" readonly
                            style="width: 100%;">
                        </label>
                        <label>
                            <span style="font-size: var(--font-size-1); color: var(--base-color-3);">아이디</span>
                            <input type="text" value="sinny13@gmail.com" readonly style="width: 100%;">
                        </label>
                        <label>
                            <span style="font-size: var(--font-size-1); color: var(--base-color-3);">가입일</span>
                            <input type="text" value="2022.08.14" readonly style="width: 100%;">
                        </label>
                    </div>
                    <div style="display: flex; flex-basis: 100%; gap: 4px; justify-content: end; margin-top: 10pxs;">
                        <RouterLink class="btn-style:small" to="">프로필 사진 변경</RouterLink>
                        <RouterLink class="btn-style:small" to="">프로필 이름 변경</RouterLink>
                        <button class="btn-style:small">로그아웃</button>
                        <button class="btn-style:small">회원탈퇴</button >
                    </div>
            </section>
        </header>
        <section>
            <h1>내 활동</h1>
            <!-- 최근 본 -->
            <div style="display: flex; flex-basis: 100%; justify-content:space-between;  align-items: center; padding: 10px;">
                <h2 style="display: flex; font-size: var(--font-size-4); font-weight: var(--font-weight-6);">최근 본</h2>
                <RouterLink to="history" class="btn-style:default">모두 보기</RouterLink>
            </div>
            <nav class="website-list" style="">
                <h1>웹사이트 목록</h1>
                <div class="website-card">
                    <RouterLink to="detail">
                        <img class="website-img" src="/img/website/google.png" alt="웹사이트 이미지">
                    </RouterLink>
                        <ul class=""
                                style="display: flex; flex-basis: 100%; gap: 2px; flex-direction: column; padding: 5px; ">
                            <li style="display: flex; justify-content: space-between; position: relative;">
                                <span class="text-overflow" style="font-size: var(--font-size-3); font-weight: var(--font-weight-6)">네이버</span>
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
            <nav class="website-list" style="">
                <h1>웹사이트 목록</h1>
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
        <footer style="margin-bottom: 60px;">

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
                <RouterLink to="index" class="icon:profile icon:text-bottom icon:font-1">
                    <span>내 페이지</span>
                </RouterLink>
            </li>
        </ul>
    </nav>
</footer>
</template>