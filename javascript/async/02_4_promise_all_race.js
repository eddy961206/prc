/**
 * Promise.all과 Promise.race 예제
 *
 * Promise.all: 여러 Promise를 동시에 실행하고 모든 결과를 기다립니다.
 * Promise.race: 여러 Promise 중 가장 먼저 완료되는 결과만 반환합니다.
 */

// 지연 시간을 시뮬레이션하는 헬퍼 함수
function delay(ms, value) {
    return new Promise(resolve => {
        console.log(`${value} 작업 시작 (${ms}ms 소요 예정)`);
        setTimeout(() => {
            console.log(`${value} 작업 완료 (${ms}ms 소요)`);
            resolve(value);
        }, ms);
    });
}

console.log("1. Promise.all 예제 시작");
console.log("------------------------");

// Promise.all 예제
const promises = [
    delay(1000, "작업 1"),  // 1초 소요
    delay(2000, "작업 2"),  // 2초 소요
    delay(1500, "작업 3")   // 1.5초 소요
];

let startTime = Date.now(); // 시작 시간 기록

Promise.all(promises)
    .then(results => {
        let endTime = Date.now(); // promises 안의 promise들 수행하는데 걸린 시간 기록
        let elapsedTime = (endTime - startTime) / 1000; // 경과 시간 계산 (초)

        console.log(`\nPromise.all 결과:`, results);    // [ '작업 1', '작업 2', '작업 3' ]
        console.log(`모든 작업이 완료되었습니다. (총 ${elapsedTime}초 소요)`);
    })
    .catch(error => {
        console.log("에러 발생:", error);
    });


    
// 3초 후에 Promise.race 예제 실행
setTimeout(() => {
    console.log("\n\n2. Promise.race 예제 시작");
    console.log("------------------------");

    const racePromises = [
        delay(2000, "빠른 작업"),    // 2초 소요
        delay(1000, "더 빠른 작업"),  // 1초 소요
        delay(3000, "느린 작업")      // 3초 소요
    ];

    startTime = Date.now(); // 시작 시간 기록

    Promise.race(racePromises)
        .then(result => {
            endTime = Date.now();
            elapsedTime = (endTime - startTime) / 1000;

            console.log("\nPromise.race 결과:", result);    // '더 빠른 작업'
            console.log(`가장 빠른 작업이 완료되었습니다. (총 ${elapsedTime}초 소요)`);
        })
        .catch(error => {
            console.log("에러 발생:", error);
        });
}, 3000);

/* 실행 결과:
1. Promise.all 예제 시작
------------------------
작업 1 작업 시작 (1000ms 소요 예정)
작업 2 작업 시작 (2000ms 소요 예정)
작업 3 작업 시작 (1500ms 소요 예정)
작업 1 작업 완료 (1000ms 소요)
작업 3 작업 완료 (1500ms 소요)
작업 2 작업 완료 (2000ms 소요)

Promise.all 결과: [ '작업 1', '작업 2', '작업 3' ]
모든 작업이 완료되었습니다. (총 2.015초 소요)


2. Promise.race 예제 시작
------------------------
빠른 작업 작업 시작 (2000ms 소요 예정)
더 빠른 작업 작업 시작 (1000ms 소요 예정)
느린 작업 작업 시작 (3000ms 소요 예정)
더 빠른 작업 작업 완료 (1000ms 소요)

Promise.race 결과: 더 빠른 작업
가장 빠른 작업이 완료되었습니다. (총 1.01초 소요)
빠른 작업 작업 완료 (2000ms 소요)
느린 작업 작업 완료 (3000ms 소요)
*/ 