/**
 * Promise를 반환하는 함수 예제
 * 
 * 이 예제는 Promise를 반환하는 함수를 만들고 사용하는 방법을 보여줍니다.
 * 실제 API 호출을 시뮬레이션합니다.
 */

function fetchUser(id) {
    console.log(`사용자 ID ${id}의 정보 요청 시작...`);
    
    return new Promise((resolve, reject) => {
        console.log("프로미스 안!");
        setTimeout(() => {
            // 데이터베이스 조회를 시뮬레이션
            const user = {
                id: id,
                name: "홍길동",
                email: "hong@example.com"
            };
            console.log("데이터베이스 조회 완료");
            resolve(user);
        }, 2000);
    });
}

console.log("프로그램 시작");

console.log("사용자 정보 요청 전");
fetchUser(1)
    .then(user => {
        console.log("사용자 정보 수신 완료:");
        console.log(user);
    })
    .catch(error => {
        console.log("에러 발생:", error);
    })
    .finally(() => {
        console.log("작업 완료");
    });

console.log("사용자 정보 요청 후");
console.log("다른 작업 진행 중...");

/* 실행 결과:
프로그램 시작
사용자 정보 요청 전
사용자 ID 1의 정보 요청 시작...
사용자 정보 요청 후
다른 작업 진행 중...
데이터베이스 조회 완료
사용자 정보 수신 완료:
{ id: 1, name: '홍길동', email: 'hong@example.com' }
작업 완료
*/ 