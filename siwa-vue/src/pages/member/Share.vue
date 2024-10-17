<template>
        <h1>공유페이지</h1>
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