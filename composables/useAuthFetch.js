export default  function useAuthFetch(url, options={}) { // 사용자가 전달한URL, 옵션이 없을 땐 빈 객체
    
    const { token } = useUserDetails(); // 토큰을 가져오는 곳

    options.headers = {
        ...options.headers,
        ...(token.value && {Authorization: `Bearer ${token.value}`})
    };

    const config = useRuntimeConfig();
    return useFetch(`${config.public.apiBase}${url}`, options);
    // useFetch()는 서버 데이터를 가져오는 유일한 함수, 나머지는 CSR 함수
}