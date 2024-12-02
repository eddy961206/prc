/**
 * 자바스크립트 비동기 처리 학습 3-2: async/await를 사용한 데이터 가져오기
 */

// 사용자 데이터 가져오기 시뮬레이션 (1초 지연)
async function fetchUserData(id) {
    return new Promise((resolve) => {
        console.log('사용자 정보 가져오는 중...  -------------------  2 ')
        setTimeout(() => {
            resolve({
                id: id,
                name: "홍길동",
                email: "hong@example.com"
            });
        }, 2000);
        console.log('사용자 정보 가져오는거 기다리는 중 딴 거 하는 중  -------------------  3 ')
    });
}

// 사용자 게시물 가져오기 시뮬레이션 (1초 지연)
async function fetchUserPosts(userId) {
    return new Promise((resolve) => {
        console.log('사용자 게시물 가져오는 중...  -------------------  8 ')
        setTimeout(() => {
            resolve([
                { id: 1, title: "첫 번째 게시물" },
                { id: 2, title: "두 번째 게시물" }
            ]);
        }, 1000);
        console.log('게시물 가져오는거 기다리는 중 딴 거 하는 중  -------------------  9 ');
    });
}

async function getUserInfo(id) {
    try {
        console.log("사용자 정보 요청 시작...  -------------------  1 ");
        const user = await fetchUserData(id);
        console.log("사용자 정보:", user, ' -------------------  6 ');
        
        console.log("사용자의 게시물 요청 시작...  -------------------  7 ");
        const posts = await fetchUserPosts(user.id);
        console.log("사용자의 게시물:", posts, ' -------------------  10 ');
        
        return { user, posts };
    } catch (error) {
        console.error("에러 발생:", error);
    }
}

const data = getUserInfo(1);
console.log(data, ' -------------------  4 ');  //  'Promise { <pending> }'
console.log("프로그램 종료  -------------------  5 ");


/*  실행결과 : 
사용자 정보 요청 시작...  -------------------  1 
사용자 정보 가져오는 중...  -------------------  2 
사용자 정보 가져오는거 기다리는 중 딴 거 하는 중  -------------------  3 
Promise { <pending> }  -------------------  4 
프로그램 종료  -------------------  5 
사용자 정보: { id: 1, name: '홍길동', email: 'hong@example.com' }  -------------------  6 
사용자의 게시물 요청 시작...  -------------------  7 
사용자 게시물 가져오는 중...  -------------------  8 
게시물 가져오는거 기다리는 중 딴 거 하는 중  -------------------  9 
사용자의 게시물: [ { id: 1, title: '첫 번째 게시물' }, { id: 2, title: '두 번째 게시물' } ]  -------------------  10
*/

/* 
const data = await getUserInfo(1); 이렇게 하면 에러. 
await 키워드는 async 함수 내부에서만 사용 가능하기 때문.
다 기다린 후 결과 가져오려면 
getUserInfo(1).then(data => {console.log(data)}); 이렇게 .then 을 사용.
*/

// CommonJS 방식 export
module.exports = {
    fetchUserData,
    fetchUserPosts
}

// ESmodule 방식 export
// export { fetchUserData, fetchUserPosts };