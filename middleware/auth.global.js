export default defineNuxtRouteMiddleware((to, from)=>{
    console.log(to);
    const userDetails = useUserDetails();
    
    // 인증했는지 확인(인증정보를 가지고 있는지 로그인 유무로 확인)
    // 안했으면 로그인 페이지로.
    //  했으면 다음 단계 진행
    if(to.path.startsWith("/member")) { // 회원 페이지로 가려 할 때
        // if(userDetails.username == null) // 로그인 안 했으면
        if(userDetails.isGhost()){
            // return navigateTo("/signin"); // nuxt 고유 기능
            return navigateTo(`/signin?returnURL=${to.fullPath}`); // 다시 되돌아갈 페이지의 절대경로
        }
        if(!userDetails.hasRole("ROLE_MEMBER")){
            return navigateTo("/error403"); 
        }
    }
    // 관리자면 
    //  아니라면 404 에러
});