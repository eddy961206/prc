/**
 * Promise 체이닝 예제
 * 
 * 이 예제는 여러 Promise를 연결하여 순차적으로 실행하는 방법을 보여줍니다.
 * 사용자 정보를 가져온 후, 해당 사용자의 게시물을 가져오는 과정을 시뮬레이션합니다.
 */

function getUser(id) {
    console.log(`사용자 ID ${id} 조회 중...  -------------------  2 `);
    return new Promise((resolve, reject) => {
        console.log("getUser 프로미스 안  -------------------  3 ");
        setTimeout(() => {
            const user = { id: id, name: "홍길동" };
            console.log("사용자 정보 조회 완료  -------------------  5 ");
            resolve(user);
        }, 1000);
    });
}

function getUserPosts(user) {
    console.log(`사용자 ${user.name}의 게시물 조회 중...  -------------------  7 `);
    return new Promise(resolve => {
        setTimeout(() => {
            console.log("getUserPosts 프로미스 안  -------------------  8 ");
            const posts = [
                { userId: user.id, post: "안녕하세요" },
                { userId: user.id, post: "반갑습니다" }
            ];
            console.log("게시물 조회 완료  -------------------  9 ");
            resolve(posts);
        }, 1500);
    });
}

console.log("프로그램 시작  -------------------  1 ");

// Promise 체이닝 시작
getUser(1)
    .then(user => {
        console.log("조회된 사용자:" + user.name + "  -------------------  6 ");
        return getUserPosts(user);  // 새로운 Promise 반환
    })
    .then(posts => {
        console.log("조회된 게시물:" + posts.map(post => post.post) + "  -------------------  10 ");
    })
    .catch(error => {
        console.log("에러 발생:", error);
    })
    .finally(() => {
        console.log("모든 작업 완료  -------------------  11 ");
    });

console.log("다른 작업 진행 중...  -------------------  4 ");

/* 실행 결과:
프로그램 시작  -------------------  1 
사용자 ID 1 조회 중...  -------------------  2
getUser 프로미스 안  -------------------  3
다른 작업 진행 중...  -------------------  4
사용자 정보 조회 완료  -------------------  5 
조회된 사용자:홍길동  -------------------  6
사용자 홍길동의 게시물 조회 중...  -------------------  7
getUserPosts 프로미스 안  -------------------  8 
게시물 조회 완료  -------------------  9
조회된 게시물:안녕하세요,반갑습니다  -------------------  10
모든 작업 완료  -------------------  11
*/ 