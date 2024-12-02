/**
 * 자바스크립트 비동기 처리 학습 2: Promise
 * 
 * Promise는 비동기 작업의 최종 완료(또는 실패)와 그 결과값을 나타내는 객체입니다.
 * 콜백 지옥을 해결하고 비동기 작업을 더 깔끔하게 처리할 수 있습니다.
 */

console.log("Promise 실행 시작 ----------  1");

const simplePromise = new Promise((resolve, reject) => {
    // Promise의 생성자 내부는 동기로 실행
    console.log("Promise 내부 로직 실행 중... ----------  2");

    // 비동기 작업 시뮬레이션
    setTimeout(() => {
        const randomNum = Math.random();
        console.log("생성된 난수:", randomNum);
        
        if (randomNum > 0.5) {
            resolve(`성공: ${randomNum}`);
        } else {
            reject(`실패: ${randomNum}`);
        }
    }, 1000);

    console.log("비동기 작업하는 동안 실행되는 콘솔 ----------  3");
});

console.log("Promise 객체 생성 완료, 결과 대기 중... ----------  4");

simplePromise
    .then(result => {
        console.log("Promise 성공:", result + " ----------  6");
    })
    .catch(error => {
        console.log("Promise 실패:", error + " ----------  6");
    })
    .finally(() => {
        console.log("Promise 처리 완료 ----------  7");
    });

console.log("프로그램 종료 ----------  5");

/* 실행 결과 예시 (성공 시):
Promise 실행 시작
Promise 내부 로직 실행 중...
비동기 작업하는 동안 실행되는 콘솔
Promise 객체 생성 완료, 결과 대기 중...
프로그램 종료
생성된 난수: 0.7523421789
Promise 성공: 성공: 0.7523421789
Promise 처리 완료

실행 결과 예시 (실패 시):
Promise 실행 시작
Promise 내부 로직 실행 중...
비동기 작업하는 동안 실행되는 콘솔
Promise 객체 생성 완료, 결과 대기 중...
프로그램 종료
생성된 난수: 0.2341567890
Promise 실패: 실패: 0.2341567890
Promise 처리 완료
*/ 


