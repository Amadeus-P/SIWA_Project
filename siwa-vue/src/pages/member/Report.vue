<template>
    <main>
    <h1>신고 페이지</h1>
    <section style="margin: 10px;">
        <h1>신고하기</h1>
        <form action="" method="post">
            <legend>이미지 또는 제목 신고</legend>
            <ul class="report-content" style="display: flex; flex-wrap: wrap;">
                <li>
                    <label>
                        <input type="radio" name="report">
                        <span>성적인 콘텐츠</span>
                    </label>
                </li>
                <li>
                    <label>
                        <input type="radio" name="report">
                        <span>폭력적 또는 혐오스러운 콘텐츠</span>
                    </label>
                </li>
                <li>
                    <label>
                        <input type="radio" name="report">
                        <span>증오 또는 학대하는 콘텐츠</span>
                    </label>
                </li>
                <li>
                    <label>
                        <input type="radio" name="report">
                        <span>유해하거나 위험한 행위</span>
                    </label>
                </li>
                <li>
                    <label>
                        <input type="radio" name="report">
                        <span>스팸 또는 혼동을 야기하는 콘텐츠</span>
                    </label>
                </li>
                <li>
                    <label>
                        <input type="radio" name="report">
                        <span>아동 학대</span>
                    </label>
                </li>
            </ul>
            <ul style="display: flex; justify-content: end; gap: 10px;">
                <li style="">
                    <a href="detail.html" class="btn-style:default">취소</a>
                </li>
                <li style="display: flex;">
                    <button class="btn-accent:default">신고</button>
                </li>
            </ul>
        </form>
    </section>
</main>
</template>
<style>
ul.report-content>li{
    flex-basis: 100%;
}
</style>