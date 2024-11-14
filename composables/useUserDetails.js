export default () => {
    const id = useState('id', ()=>null);
    const username = useState('username', ()=>null);
    const profileName = useState('profileName', ()=>null);
    const profileImage = useState('profileImage', ()=>null);
    const roles = useState('roles', ()=>[]);
    const token = useState('token', ()=>[]);

    const isGhost = ()=> {
        return username.value === null;
    };

    const signin = (loginInfo) => {
        id.value = loginInfo.id;
        username.value = loginInfo.username;
        profileName.value = loginInfo.profileName;
        profileImage.value = loginInfo.profileImage;
        roles.value = loginInfo.roles;
        token.value = loginInfo.token;

        // loginInfo를 하나의 문자열로 담아보기
        //  새로고침할 때 인증 정보 날라가는거 방지
        if(!import.meta.env.SSR) { // nuxt hidration 오류 방지
            localStorage.setItem('id', loginInfo.id);
            localStorage.setItem('username', loginInfo.username);
            localStorage.setItem('profileName', loginInfo.profileName);
            localStorage.setItem('profileImage', loginInfo.profileImage);
            localStorage.setItem('roles', JSON.stringify(loginInfo.roles)); // []은 "[]" 문자열로 바꿔야 저장가능
            localStorage.setItem('token', loginInfo.token);
        }
    };

    const signout = () => {
        id.value = null;
        username.value = null;
        profileName.value = null;
        profileImage.value = null;
        roles.value = [];
        token.value = null;
            // 로컬 스토리지에서 데이터 제거
        if (!import.meta.env.SSR) { // 클라이언트 측에서만 수행
            localStorage.removeItem('id');
            localStorage.removeItem('username');
            localStorage.removeItem('profileName');
            localStorage.removeItem('profileImage');
            localStorage.removeItem('roles');
            localStorage.removeItem('token');
        }

        // 로그아웃 후 이동할 페이지 (로그인 페이지나 홈 페이지로 이동)
        navigateTo('/');
    }

    //  브라우저가 가진 저장소에 저장소에서 데이터를 가져옴
    // 모든 페이지에다 이 함수를 사용하기 싫으니 플로그인에다 넣어 사용
        const loadUserFromStorage = () => {
            if(!import.meta.env.SSR) {
                if(!localStorage.getItem('username')) return;
    
                id.value = localStorage.getItem('id');
                username.value = localStorage.getItem('username');
                roles.value = JSON.parse(localStorage.getItem('roles')); // 배열로 변환
                token.value = localStorage.getItem('token');
                profileName.value = localStorage.getItem('profileName');
                profileImage.value = localStorage.getItem('profileImage');
            }
        }

    // includes 배열이 가지고 있는 함수, 인자를 포함하는지
    const hasRole = (role) =>  roles.value.includes(role);

    return {id, username, profileName, profileImage, roles,token, isGhost, signin, signout, hasRole, loadUserFromStorage };


}