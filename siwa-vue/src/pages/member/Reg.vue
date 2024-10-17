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
                            <label class="label-card">
                                <span>사이트 이름</span>
                                <strong><span style="color: var(--accent-color-1);" aria-label="필수입력">*</span></strong>
                                <input type="text" name="site-name" required autofocus autocomplete="on">
                            </label>
                        </li>
                        <li>
                            <label class="label-card">
                                <span>사이트 URL</span>
                                <strong><span style="color: var(--accent-color-1);" aria-label="필수입력">*</span></strong>
                                <input type="url" id="url-prefix" name="address" pattern="https:(//)?.*" required>
                            </label>
                        </li>
                        <li>
                            <label class="label-card">
                                <span>카테고리</span>
                                <input type="text" name="tag">
                            </label>
                        </li>
                        <li>
                            <label class="label-card" style="height: 100px; justify-content: center; align-items: center;">
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
                </ul>
                <nav style="display: flex; justify-content: start; align-items: center; flex-basis: 100%;">
                    <h1>카테고리 목록</h1>
                    <ul style="display: flex; justify-content: start; align-items: center; flex-basis: 100%; gap: 10px; margin: 4px 10px; overflow: hidden; text-wrap: nowrap;">
                        <li>
                            <a class="btn-style:default" style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">디자인</a>
                        </li>
                        <li>
                            <a class="btn-style:default" style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">다이어리</a>
                        </li>
                        <li>
                            <a class="btn-style:default" style=" font-size: var(--font-size-3); color: var(--base-color-1);" href="">우주</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </article>
    </main>
</template>

<style>
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