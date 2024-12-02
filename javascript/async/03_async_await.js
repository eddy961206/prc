/**
 * 자바스크립트 비동기 처리 학습 3: async/await
 * 
 * async/await는 Promise를 더 쉽게 사용할 수 있게 해주는 문법적 설탕(Syntactic sugar)입니다.
 * 비동기 코드를 동기 코드처럼 작성할 수 있게 해줍니다.
 */

// 1. 기본 async/await 사용
console.log("1. 기본 async/await 예제");
async function basicExample() {
    console.log("시작");
    
    // Promise를 반환하는 함수
    const delay = (ms) => new Promise(resolve => setTimeout(resolve, ms));
    
    try {
        await delay(1000);
        console.log("1초 후");
        await delay(1000);
        console.log("2초 후");
    } catch (error) {
        console.error("에러 발생:", error);
    }
    
    console.log("완료");
}

basicExample();

// 2. async/await를 사용한 데이터 가져오기
console.log("\n2. 데이터 가져오기 예제");
async function fetchUserData(id) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({
                id: id,
                name: "홍길동",
                email: "hong@example.com"
            });
        }, 1000);
    });
}

async function fetchUserPosts(userId) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve([
                { id: 1, title: "첫 번째 게시물" },
                { id: 2, title: "두 번째 게시물" }
            ]);
        }, 1000);
    });
}

async function getUserInfo(id) {
    try {
        console.log("사용자 정보 요청 시작...");
        const user = await fetchUserData(id);
        console.log("사용자 정보:", user);
        
        console.log("사용자의 게시물 요청 시작...");
        const posts = await fetchUserPosts(user.id);
        console.log("사용자의 게시물:", posts);
        
        return { user, posts };
    } catch (error) {
        console.error("에러 발생:", error);
    }
}

getUserInfo(1);

// 3. 병렬 처리 예제
console.log("\n3. 병렬 처리 예제");
async function parallel() {
    try {
        console.log("병렬 처리 시작");
        
        // Promise.all을 사용한 병렬 처리
        const [user, posts] = await Promise.all([
            fetchUserData(1),
            fetchUserPosts(1)
        ]);
        
        console.log("병렬 처리 결과:");
        console.log("사용자:", user);
        console.log("게시물:", posts);
    } catch (error) {
        console.error("병렬 처리 중 에러:", error);
    }
}

parallel();

// 4. 에러 처리 예제
console.log("\n4. 에러 처리 예제");
async function errorHandling() {
    try {
        const failingPromise = new Promise((resolve, reject) => {
            setTimeout(() => {
                reject(new Error("의도적인 에러 발생"));
            }, 1000);
        });
        
        console.log("에러 발생 전");
        await failingPromise;
        console.log("이 줄은 실행되지 않습니다");
    } catch (error) {
        console.error("에러를 잡았습니다:", error.message);
    } finally {
        console.log("finally 블록은 항상 실행됩니다");
    }
}

errorHandling();

console.log("프로그램 종료"); 