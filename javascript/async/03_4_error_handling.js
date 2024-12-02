/**
 * 자바스크립트 비동기 처리 학습 3-4: 에러 처리
 */

async function errorHandling() {
    try {
        const failingPromise = new Promise((resolve, reject) => {
            setTimeout(() => {
                reject(new Error("의도적인 에러 발생"));
            }, 1000);
        });
        
        console.log("에러 발생 전");
        await failingPromise; // 에러 발생 예상
        console.log("이 줄은 실행되지 않습니다");
    } catch (error) {
        console.error("에러를 잡았습니다:", error.message);
    } finally {
        console.log("finally 블록은 항상 실행됩니다");
    }
}

errorHandling();
console.log("프로그램 종료");