/**
 * 자바스크립트 비동기 처리 학습 2: Promise
 * 
 * Promise는 비동기 작업의 최종 완료(또는 실패)와 그 결과값을 나타내는 객체입니다.
 * 콜백 지옥을 해결하고 비동기 작업을 더 깔끔하게 처리할 수 있습니다.
 */

// 1. 기본 Promise 생성과 사용
console.log("1. 기본 Promise 예제");
const simplePromise = new Promise((resolve, reject) => {
    // 비동기 작업 시뮬레이션
    setTimeout(() => {
        const randomNum = Math.random();
        if (randomNum > 0.5) {
            resolve(`성공: ${randomNum}`);
        } else {
            reject(`실패: ${randomNum}`);
        }
    }, 1000);
});

simplePromise
    .then(result => console.log("Promise 성공:", result))
    .catch(error => console.log("Promise 실패:", error));

// 2. Promise를 반환하는 함수
console.log("\n2. Promise 함수 예제");
function fetchUser(id) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const user = {
                id: id,
                name: "홍길동",
                email: "hong@example.com"
            };
            resolve(user);
        }, 1000);
    });
}

fetchUser(1)
    .then(user => console.log("사용자 정보:", user))
    .catch(error => console.log("에러 발생:", error));

// 3. Promise 체이닝
console.log("\n3. Promise 체이닝 예제");
function getUser(id) {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve({ id: id, name: "홍길동" });
        }, 1000);
    });
}

function getUserPosts(user) {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve([
                { userId: user.id, post: "안녕하세요" },
                { userId: user.id, post: "반갑습니다" }
            ]);
        }, 1000);
    });
}

getUser(1)
    .then(user => {
        console.log("사용자:", user);
        return getUserPosts(user);
    })
    .then(posts => {
        console.log("작성글:", posts);
    })
    .catch(error => console.log("에러:", error));

// 4. Promise.all 사용 예제
console.log("\n4. Promise.all 예제");
const promise1 = Promise.resolve(3);
const promise2 = new Promise(resolve => setTimeout(() => resolve("foo"), 2000));
const promise3 = new Promise(resolve => setTimeout(() => resolve({ bar: "baz" }), 1000));

Promise.all([promise1, promise2, promise3])
    .then(values => {
        console.log("모든 Promise 완료:", values);
    })
    .catch(error => console.log("Promise.all 에러:", error));

// 5. Promise.race 사용 예제
console.log("\n5. Promise.race 예제");
const promise4 = new Promise(resolve => setTimeout(() => resolve("빠른 Promise"), 1000));
const promise5 = new Promise(resolve => setTimeout(() => resolve("느린 Promise"), 2000));

Promise.race([promise4, promise5])
    .then(result => console.log("가장 빨리 완료된 Promise:", result))
    .catch(error => console.log("Promise.race 에러:", error));

console.log("프로그램 종료"); 