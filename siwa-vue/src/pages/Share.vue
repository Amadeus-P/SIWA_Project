<template>
    <header>
        <h1>공유페이지</h1>
        <section style="
                  margin: 20px 10px;
                  display: flex; justify-content: space-between;">
          <h1>상단 메뉴</h1>
          <button class="icon:arrow-back text-hidden btn">뒤로가기</button>
          <ul class="icon:more-big">
            <li>
              <a class="btn-style:default" href="share.html">공유</a>
            </li>
            <li>
              <a class="btn-style:default" href="report.html">신고</a>
            </li>
          </ul>
        </section>
      </header>
    <main>
        <section class="box-shadow" style="position: relative; display: flex; justify-content: center; margin: 10px; padding: 10px;">
            <h1>공유</h1>
            <div style="position: absolute; top: 0; right: 0;">
                <a href="" class="icon:close btn text-hidden">닫기</a>
            </div>
            <div>
                <button type="button" class="icon:copy btn-style:default icon:text-left">
                    <div class="">https://sinny13.com</div>
                </button>
            </div>
        </section>
    </main>
</template>

<style>
.icon\:close::before{
    width: var(--icon-width-3);
    height: var(--icon-height-3);
    mask-size: var(--icon-width-3) var(--icon-height-3);
}
</style>