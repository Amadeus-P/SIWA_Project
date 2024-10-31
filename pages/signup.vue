<script setup>

    const callback = (response) => {
    // This callback will be triggered when the user selects or login to
    // his Google account from the popup
    console.log("Handle the response", response)
    }

    const password = ref("");
    const passwordCheck = ref("");
    watchEffect(()=>{
        // password === passwordCheck

        // if(isShowPasswordCheck = "password-retype")

    });

    // 비밀번호 숨기기/보이기
    const isShowPassword = ref(false);
    const showPassword = () => {
        isShowPassword.value = !isShowPassword.value;
    };

    // 비밀번호 확인  숨기기/보이기
    const isShowPasswordCheck = ref(false);
    const showPasswordCheck = () => {
        isShowPasswordCheck.value = !isShowPasswordCheck.value;
    };

</script>

<template>

    <HeaderMenu/>

    <main>
        <section style="display: flex; flex-wrap: wrap; width: auto; margin: 10px;">
            <h1>회원가입 페이지</h1>
            <form action="member" method="post">
                <label style="">
                    <span>이메일</span>
                    <input type="email" name="email" placeholder="예시) wiwst@gmail.com" autofocus autocomplete="off" required/>
                </label>
                
                <label style="position: relative;">
                    <span>비밀번호</span>
                    <input v-bind:type="isShowPassword ? 'text' : 'password'" 
                        v-model="password" name="password" pattern="^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{12,20}$"
                        placeholder="" autocomplete="off" required/>
                    <button type="button" 
                        v-bind:class="isShowPassword? ['icon:hide', 'text-hidden'] : ['icon:show', 'text-hidden']" 
                        style="z-index: 100; position: absolute; right: 10px; top: 50px; transform: translateY(-0%);" 
                        @click="showPassword">
                        {{ isShowPassword ? '숨기기' : '보이기' }}
                    </button>
                </label>
                
                <label style="position: relative;">
                    <span>비밀번호 확인</span>
                    <input v-bind:type="isShowPasswordCheck? 'text' : 'password'" 
                        v-model="passwordCheck" name="password" autocomplete="off" required/>
                    <button type="button" 
                        v-bind:class="isShowPasswordCheck? ['icon:hide', 'text-hidden'] : ['icon:show', 'text-hidden']" 
                        style="z-index: 100; position: absolute; right: 10px; top: 50px;  transform: translateY(-0%);"
                        @click="showPasswordCheck">
                        {{ isShowPasswordCheck ? '숨기기' : '보이기' }}
                    </button>
                </label>
                
                <div style="display: flex; margin-top: 50px;">
                    <button class="submit-btn btn-style:round" style="">회원가입하기</button>
                </div>
    
            </form>
            <div style="position: relative; border: none; border-top: 1px solid var(--base-color-3); margin: 50px 0 10px 0; width: 100%;">
                <div style="position: absolute; top: -0.7em; left: 50%; transform: translateX(-50%); background: white; padding: 0 5px;">다른 계정으로 회원가입</div>
                <GoogleLogin :callback="callback"/>
            </div>
            <div style="display: flex; justify-content: center; margin-top: 20px; width: 100%;">
                <RouterLink class="" style="font-size: var(--font-size-3); font-weight: var(--font-weight-6);" to="/signin">이메일로 로그인</RouterLink>
            </div>

        </section>
    </main>
</template>

<style scoped>
form{
    width: 100%;
    span{
        font-size: var(--font-size-4);
        font-weight: var(--font-weight-6);
        color: var(--base-color-black);
    }
    label{
        display: flex;
        width: auto;
        flex-wrap: wrap;
        margin: 0 10px 10px;
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
            /* &::placeholder{
                font-size: var(--font-size-3);
                font-weight: var(--font-weight-4);
            } */
        }
    }
    label:has(input[type="email"]:valid){
        >input[type="email"]{
            border: 1px solid var(--accent-color-green);
        }
        &::after{
                content: "사용 가능한 이메일입니다.";
                display: flex;
                height: auto;
                color: var(--accent-color-green);
        }
    }
    label:has(input[type="password"]:valid, input[type="text"]:valid){
        >input[type="password"], >input[type="text"]{
            border: 1px solid var(--accent-color-green);
        }
        &::after{
                content: "적합한 비밀번호입니다.";
                display: flex;
                height: auto;
                color: var(--accent-color-green);
        }
    }

    label:has(input[type="email"]:invalid){
        >input[type="email"]{
            border: 1px solid var(--accent-color-red);
        }
        &::after{
                content: "유효하지 않은 이메일입니다.";
                display: flex;
                height: auto;
                color: var(--accent-color-red);
        }
    }
    label:has(input[type="password"]:invalid, input[type="text"]:invalid){
        >input[type="password"], >input[type="text"]{
            border: 1px solid var(--accent-color-red);
        }
        &::after{
                content: "12~20자의 영어, 숫자, 특수문자( - 또는 _ 또는 . )";
                display: flex;
                height: auto;
                color: var(--accent-color-red);
        }
    }
}
.submit-btn{
    display: flex;
    justify-content: center;
    flex-basis: 100%;
    width: 300px;
    height: 40px;
    margin: 10px;
    font-size: var(--font-size-4);
    font-weight: var(--font-weight-6);
    color: var(--base-color-white);
    background-color: var(--base-color-1);
}

.icon\:hide::before{
    mask-image: url("../img/icon/hide.svg");
}
.icon\:show::before{
    mask-image: url("../img/icon/show.svg");
}
:is(
    .icon\:show,
    .icon\:hide
)::before{
    content: "";
    display: flex;
    width: var(--icon-width-3);
    height: var(--icon-height-3);
    mask-repeat: no-repeat;

    mask-size: var(--icon-width-3) var(--icon-height-3);
    background-color: var(--base-color-black);
}
:is(
    .icon\:show,
    .icon\:hide
    ){
    background-color: var(--base-color-white);
    border: none;
}

</style>
