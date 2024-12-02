/**
 * 자바스크립트 비동기 처리 학습 3-1: 기본 async/await 사용
 * 
 * async/await는 Promise를 더 쉽게 사용할 수 있게 해주는 문법적 설탕입니다.
 * 비동기 코드를 동기 코드처럼 작성할 수 있게 해줍니다.
 */

// Promise를 반환하는 함수 (1초 지연)
const delay = (ms) => new Promise(resolve => setTimeout(resolve, ms));

delay1 = function (ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
}

async function basicExample() {
    console.log("시작 ----------  1 ");
    
    try {
        await delay(2000);
        console.log("2초 후 ----------  2 ");
        await delay(1000);
        console.log("1초 후 ----------  3 ");
    } catch (error) {
        console.error("에러 발생:", error);
    }
    
    console.log("완료 ----------  4 ");
}

basicExample();
console.log("basicExample 실행중에 딴거 진행중... ----------  2 ");



/* 실행 결과 예시 (성공 시):

시작 ----------  1 
basicExample 실행중에 딴거 진행중... ----------  2 
2초 후 ----------  2 
1초 후 ----------  3 
완료 ----------  4

*/ 