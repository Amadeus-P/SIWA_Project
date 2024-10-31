<template>
    <header>
        <h1>웹사이트 등록 페이지</h1>
        <section style="
            margin: 20px 10px;
            display: flex; justify-content: space-between;">
            <h1>상단 메뉴</h1>
            <button class="icon:arrow-back text-hidden btn">뒤로가기</button>
            <ul class="icon:more-big">
                <li>
                    <RouterLink class="btn-style:default" to="report">신고</RouterLink>
                </li>
            </ul>
        </section>
    </header>
    <main>
        <section style="display: flex; justify-content: space-evenly;">
            <h1>사이트 정보 입력</h1>
            <form action="" method="post" enctype="multipart/form-data">
                <fieldset>
                    <legend class="legend">사이트 정보 입력</legend>
                    <ul style="display: flex; gap: 10px; flex-direction: column;">
                        <li>
                            <label class="">
                                <span>카테고리</span>
                                <strong><span style="color: var(--accent-color-1);" aria-label="필수입력">*</span></strong>
                                <input type="text" name="tag">
                            </label>
                            <div class="dropdown-menu">
                                <button   type="button">대분류</button>
                                <ul class="dropdown-content">
                                    <li>프로그래밍</li>
                                    <li>커뮤니티</li>
                                    <li>패션</li>
                                    <li>요리</li>
                                    <li>디자인</li>
                                    <li>AI</li>
                                    <li>음악</li>
                                    <li>게임</li>
                                    <li>반려동물</li>
                                    <li>뷰티</li>
                                    <li>기타</li>
                                </ul>
                            </div>
                            <div>
                                <button type="button">중분류</button>
                                <ul>
                                    <li></li>
                                    <li></li>
                                    <li></li>
                                    <li>기타</li>
                                </ul>
                            </div>
                            <div>
                                <button type="button">소분류</button>
                                <ul >
                                    <li></li>
                                    <li></li>
                                    <li></li>
                                    <li>기타</li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <span>사이트 URL</span>
                            <strong><span style="color: var(--accent-color-1);" aria-label="필수입력">*</span></strong>
                            <label class="" style="display: flex; height: 30px; border: 1px solid var(--base-color-3); border-radius: 3px;">
                                <input type="url" id="url-prefix" name="address" pattern="https:(//)?.*" required>
                            </label>
                        </li>
                        <li>
                            <span>사이트 명</span>
                            <strong><span style="color: var(--accent-color-1);" aria-label="필수입력">*</span></strong>
                            <label class="" style="display: flex; height: 30px; border: 1px solid var(--base-color-3); border-radius: 3px;">
                                <input type="text" name="site-name" required autofocus autocomplete="on">
                            </label>
                        </li>
                        <li>
                            <label class="" style="height: 100px; justify-content: center; align-items: center;">
                                <span>이미지 업로드</span>
                                <input type="file" name="img" style="">
                            </label>
                        </li>
                    </ul>
                    <span style=" font-size: var(--font-size-2); font-weight: var(--font-weight-6);  color: var(--base-color-3);">웹사이트와 관련된 이미지나 스크린샷을 올려주세요.</span>
                </fieldset>
                <div style="margin: 40px 0;">
                    <button class="submit-btn">사이트 등록하기</button>
                </div>
            </form>
        </section>
        <article style="margin-bottom: 60px;">
            <h1>미리보기</h1>
            <div class="website-card" style="position: relative;">
                    <div>
                        <!-- {{ website.imgId }} -->
                          <!-- {{  key }}: {{ value -->
                        <img class="website-img" src="/img/website/mushroom-8313142_1280.jpg" alt="웹사이트 이미지">
                    </div>
                    <div class="icon:like icon:font-1" style="
                            position: absolute; top: 5px; right: 5px;
                            margin-left: auto;
                            font-size: var(--font-size-3); font-weight: var(--font-weight-4);
                            color: var(--base-color-1);">
                    </div>
                    <ul class=""
                            style="position: relative; display: flex; flex-basis: 100%; gap: 2px; flex-direction: column; margin: 5px 10px 0 ; ">
                        <li style="display: flex; justify-content: space-between;">
                            <span class="text-overflow" style="width: 80%; font-size: var(--font-size-4); font-weight: var(--font-weight-6);">이십자이내로이름짓기</span>
                            <span class="icon:more text-hidden"
                                    style="position: absolute; top: 0; right: 0;">더보기</span>
                        </li>
                    </ul>
                    <nav style="margin: 5px 10px 0; overflow: hidden; display: flex; justify-content: start; align-items: center; flex-basis: 100%;">
                        <h1>카테고리 목록</h1>
                        <ul style="display: flex; justify-content: start; align-items: center; flex-basis: 100%; gap: 2px;
                        overflow: hidden; text-wrap: nowrap;">
                            <li>
                                <div class="btn-style:square" style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">디자인</div>
                            </li>
                            <li>
                                <div class="btn-style:square" style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">다이어리</div>
                            </li>
                            <li>
                                <div class="btn-style:square" style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">우주</div>
                            </li>
                        </ul>
                     </nav>
                </div>
        </article>
    </main>
</template>

<style scoped>

.dropdown-menu{
    
    cursor: pointer;
}
.dropdown-content{
    display: none;
    z-index: 10;
}
.dropdown-content li{
    height: 20px;
    margin: 5px 0;
    
    display: block;
}
.dropdown-content li:hover{
    background-color: var(--base-color-4);
}

.dropdown-menu:hover .dropdown-content{
    display: block;
    background-color: var(--base-color-5);
}


.submit-btn {
    width: 100%;
    padding: 5px 24px;
    margin: 0;
    font-size: 16px;
    border: none;
    border-radius: 30px;
    color: rgb(255, 255, 255);
    background-color: rgb(0, 148, 116);
    transition: all 0.4s;

}
.submit-btn:hover {
    color: rgb(255, 255, 255);
    background-color: rgb(1, 121, 87);
}
input::placeholder, textarea::placeholder{
    font-size:var(--font-size-1);
    color: var(--base-color-3);
}
</style>