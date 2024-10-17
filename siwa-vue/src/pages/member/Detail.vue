<template>
      <header>
        <h1>상세 페이지</h1>
        <section style="
                  margin: 20px 10px;
                  display: flex; justify-content: space-between;">
          <h1>상세 페이지 상단 메뉴</h1>
          <button class="icon:arrow-back text-hidden btn" style="">뒤로가기</button>
        </section>
      </header>
    <main layout:fragment="main">
        <nav>
            <h1>이미지 슬라이드</h1>
            <ul style="
                display: flex;
                gap: 10px;
                overflow: hidden;
            ">
                <li style="flex-shrink: 0;"><img style="width: 100vw; height: auto; aspect-ratio: 16/9;
                    object-fit: cover;"
                                                 src="/img/website/rland.png" alt="스크린샷"></li>
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
            <ul class="website-detail" style="
                margin: 5px;
                display: flex;
                flex-direction: column;
                flex-basis: 100%;
             ">
                <li style="height: 50px;">
                    <RouterLink to="">
                        <span style="font-size: var(--font-size-4); font-weight: var(--font-weight-6);">네이버</span>
                    </RouterLink>
                </li>
                <li style="display: flex; align-items: center;">
                    <img class="profile-img" src="/img/member/ico_ep2_01.png" alt="프로필사진">
                    <span style="margin-left: 5px; margin-right: auto; font-size: var(--font-size-3); font-weight: var(--font-weight-5);">회원명</span>
                    <RouterLink class="btn-submit:default" style=" font-size: var(--font-size-3);" to="">방문하기</RouterLink>
                </li>
            </ul>
            <nav>
                <h1>사용자 버튼 목록</h1>
                <ul style="
                display: flex; justify-content: end; flex-basis: 100%; gap: 10px; margin: 10px 10px;">
                    <li>
                        <span class="icon:views btn-style:default">
                              <span style="margin-left: 5px; font-size: var(--font-size-3); color: var(--base-color-1);">100</span>
                        </span>
                    </li>
                    <li>
                        <RouterLink class="icon:recommended btn-style:default" style="" to="">
                        <span style="margin-left: 5px;">10</span>
                        </RouterLink>
                    </li>
                    <li>
                        <RouterLink class="icon:dislike text-hidden btn-style:default" to="">싫어요</RouterLink>
                    </li>
                    <li>
                        <RouterLink to="" class="icon:like btn-style:default">
                            <span style="margin-left: 5px;">52</span>
                        </RouterLink>
                    </li>
                    <li>
                  <RouterLink class="btn-style:default" style=" font-size: var(--font-size-3); color: var(--base-color-1);" to="share">공유</RouterLink>
                </li>
                <li>
                  <RouterLink class="btn-style:default" style=" font-size: var(--font-size-3); color: var(--base-color-1);" to="report">신고</RouterLink>
                </li>
                </ul>
            </nav>
            <nav style="display: flex; justify-content: start; align-items: center; flex-basis: 100%;">
                <h1>카테고리 목록</h1>
                <ul style="display: flex; justify-content: start; align-items: center; flex-basis: 100%; gap: 10px;
                margin: 4px 10px; overflow: hidden; text-wrap: nowrap;">
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
        </section>

        <!-- 댓글 더보기 -->
        <RouterLink id="comment-more" to="#comment-more" class="btn-style:default" style="display: flex; justify-content: center; align-items: center;
        margin: 20px 10px; height: 48px; ">
            <data class="icon:arrow-down" value="100">댓글 100개</data>
        </RouterLink>

        <!-- 광고 -->
        <section>

        </section>

        <!-- 추천 웹사이트 목록 -->
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

        <!-- 모달 시트 -->
<!--        <lazy-list>지연로딩: 데이터가 필요할 때 불러옴</lazy-list>-->
        <!-- <section style="
            margin: 10px;
            display:flex;">
            <h1>등록한 댓글</h1>
            <div style="display:flex; height: 100px;">
                <img  class="profile-img" src="/img/member/ico_ep2_01.png" alt="프로필사진">
            </div>
            <div style="display: flex; flex-wrap: wrap; flex-basis: 100%; align-items: center;">
                                        <span style="
                        font-size: var(--font-size-1);
                        color: var(--base-color-3); padding: 2px;
                        ">회원명</span>

                <span style="
                                                font-size: var(--font-size-1);
                        color: var(--base-color-3); padding: 2px;">등록일</span>
                <div class="icon:more-small" style="position: relative; margin-left: auto; display: flex; flex-direction: column;">
                    <div style="position: absolute; top: -4px; right: 20px; display: flex; flex-direction: column; gap: 5px;">
                        <button type="button" class="btn-style:small">수정</button>
                        <button class="btn-accent:small">삭제</button>
                    </div>
                </div>
                <textarea name="reply" class="text-overflow" placeholder="등록한 댓글"
                          style="
                          resize:none;
                          font-size: var(--font-size-2);
                          font-weight: var(--font-weight-6);
                          border: none;
                          width: 100%;
                          height: 20px;
                          display: -webkit-box;
                          -webkit-box-orient: vertical;
                          -webkit-line-clamp: 3;
                          overflow: hidden;
                        "></textarea>

                <ul style="display: flex; gap: 20px; margin-right: auto;">
                    <li>
                        <button type="button" class="icon:recommended btn">
                            <data style="margin-left: 5px; font-size: var(--font-size-1);">1천</data>
                        </button>

                    </li>
                    <li>
                        <button type="button" class="icon:dislike text-hidden btn">아니오</button>
                    </li>
                </ul>
                <div style="display: flex; flex-basis: 100%;">
                    <span style="
                    font-size: var(--font-size-1);
                    color: var(--base-color-3)">10명이 이 리뷰가 유용하다고 평가함</span>
                    <RouterLink to="" class="icon:comment icon:text-left" style="margin-left: auto; ">
                        <data style="margin-right: 5px; font-size: var(--font-size-1);">17</data>
                    </RouterLink>
                </div>
            </div>
        </section> -->

        <!-- <form action="detail" method="post">
            <section style="
            margin: 10px;
            display:flex;">
                <h1>수정할 댓글</h1>
                <div style="display:flex; height: 100px;">
                    <img  class="profile-img" src="/img/member/ico_ep2_01.png" alt="프로필사진">
                </div>
                <div style="display: flex; flex-wrap: wrap; flex-basis: 100%; align-items: center;">
                                        <span style="
                        font-size: var(--font-size-1);
                        color: var(--base-color-3); padding: 2px;
                        ">회원명</span>
                    <textarea name="reply" class="text-overflow" placeholder="내가 수정할 댓글"
                              style="
                          resize:none;
                          font-size: var(--font-size-2);
                          font-weight: var(--font-weight-6);
                          border: none;
                          width: 100%;
                          height: 20px;
                          display: -webkit-box;
                          -webkit-box-orient: vertical;
                          -webkit-line-clamp: 3;
                          overflow: hidden;
                        "></textarea>
                    <ul style="display: flex; gap: 5px; margin-left: auto;">
                        <li>
                            <button type="reset" class="btn-style:small">취소</button>
                        </li>
                        <li>
                            <button class="btn-submit:small">저장</button>
                        </li>
                    </ul>
                </div>
            </section>
        </form> -->

        <!-- <section style="
            margin: 10px;
            display:flex;">
            <h1>희원이 등록한 댓글</h1>
            <div style="display:flex; height: 100px;">
                <img  class="profile-img" src="/img/member/ico_ep2_01.png" alt="프로필사진">
            </div>
            <div style="display: flex; flex-wrap: wrap; flex-basis: 100%; align-items: center;">
                                        <span style="
                        font-size: var(--font-size-1);
                        color: var(--base-color-3); padding: 2px;
                        ">회원명</span>
                <span style="
                            font-size: var(--font-size-1);
                            color: var(--base-color-3); padding: 2px;">등록일</span>
                <div class="icon:more-small" style="position: relative; margin-left: auto; display: flex; flex-direction: column;">
                    <div style="position: absolute; top: -4px; right: 20px; z-index: var(--z-index-middle)">
                        <RouterLink to="report" class="btn-style:small">부적절한 리뷰로 신고</RouterLink>
                    </div>
                </div> -->

                <!-- <textarea name="reply" class="text-overflow" placeholder="회원이 등록한 댓글"
                          style="
                          resize:none;
                          font-size: var(--font-size-2);
                          font-weight: var(--font-weight-6);
                          border: none;
                          width: 100%;
                          height: 20px;
                          display: -webkit-box;
                          -webkit-box-orient: vertical;
                          -webkit-line-clamp: 3;
                          overflow: hidden;
                        "></textarea> -->
                <!--                <div style="">-->
                <!--                    <button type="button" class="icon:arrow-down icon:text-left btn">자세히 보기</button>-->
                <!--                </div>-->
                <!-- <ul style="display: flex; flex-wrap: wrap; flex-basis: 100%; gap: 20px;">
                    <li>
                        <span>리뷰가 유용했나요?</span>
                    </li>
                    <li>
                        <button type="button" class="icon:recommended text-hidden btn">네</button>
                    </li>
                    <li>
                        <button type="button" class="icon:dislike text-hidden btn">아니오</button>
                    </li>
                </ul>
                <div style="display: flex; flex-basis: 100%;">
                    <span style="
                    font-size: var(--font-size-1);
                    color: var(--base-color-3)">10명이 이 리뷰가 유용하다고 평가함</span>
                    <RouterLink to="" class="icon:comment icon:text-left" style="margin-left: auto; ">
                        <data style="margin-right: 5px; font-size: var(--font-size-1);">17</data>
                    </RouterLink>
                </div>
            </div>
        </section> -->


        <!-- <form action="detail" method="post">
            <section style="
            margin: 10px;
            display:flex;">
                <h1>수정할 댓글</h1>
                <div style="display:flex; height: 100px;">
                    <img  class="profile-img" src="/img/member/ico_ep2_01.png" alt="프로필사진">
                </div>
                <div style="display: flex; flex-wrap: wrap; flex-basis: 100%; align-items: center;">
                                        <span style="
                        font-size: var(--font-size-1);
                        color: var(--base-color-3); padding: 2px;
                        ">회원명</span>
                    <textarea name="reply" class="text-overflow" placeholder="리뷰를 작성해주세요."
                              style="
                          resize:none;
                          font-size: var(--font-size-2);
                          font-weight: var(--font-weight-6);
                          border: none;
                          width: 100%;
                          height: 20px;
                          display: -webkit-box;
                          -webkit-box-orient: vertical;
                          -webkit-line-clamp: 3;
                          overflow: hidden;
                        "></textarea>
                    <ul style="display: flex; gap: 5px; margin-left: auto;">
                        <li>
                            <button type="reset" class="btn-style:small">취소</button>
                        </li>
                        <li>

                            <button class="btn-submit:small">등록</button>
                        </li>
                    </ul>
                </div>
            </section>
        </form> -->
    </main>
</template>
<style>
.comment-box {
    font-size: 12px;
}
.profile-img {
    --icon-width-4: 32px;
    --icon-height-4: 32px;
    width: var(--icon-width-4); height: var(--icon-height-4);
}
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