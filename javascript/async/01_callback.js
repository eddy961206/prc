/**
 * 자바스크립트 비동기 처리 학습 1: 콜백 함수
 * 
 * 콜백 함수는 다른 함수에 인자로 전달되어 나중에 실행되는 함수입니다.
 * 주로 비동기 작업의 결과를 처리하는 데 사용됩니다.
 */

// 1. 간단한 콜백 함수 예제
console.log("1. 기본 콜백 함수 예제");
function greeting(name, callback) {
    console.log(`안녕하세요 ${name}님`);
    callback();
}

greeting("홍길동", function() {
    console.log("콜백 함수가 실행되었습니다.");
});

// 2. setTimeout을 사용한 비동기 콜백
console.log("\n2. setTimeout 비동기 콜백 예제");
console.log("타이머 시작");
setTimeout(function() {
    console.log("3초 후에 실행됩니다.");
}, 3000);
console.log("타이머 설정 완료");

// 3. 실제 사용 예제: 파일 시스템 작업 시뮬레이션
console.log("\n3. 가상의 파일 시스템 작업 예제");
function readFile(filename, callback) {
    console.log(`${filename} 파일 읽기 시작...`);
    // 파일 읽기를 시뮬레이션하기 위한 setTimeout
    setTimeout(function() {
        let fileData = "파일의 내용입니다.";
        callback(fileData);
    }, 2000);
}

function processFileData(data) {
    console.log("파일 내용 처리:", data);
}

readFile("example.txt", processFileData);

// 4. 콜백 지옥 예제
console.log("\n4. 콜백 지옥 예제");
function step1(callback) {
    setTimeout(function() {
        console.log("1단계 완료");
        callback();
    }, 1000);
}

function step2(callback) {
    setTimeout(function() {
        console.log("2단계 완료");
        callback();
    }, 1000);
}

function step3(callback) {
    setTimeout(function() {
        console.log("3단계 완료");
        callback();
    }, 1000);
}

// 콜백 지옥 발생
step1(function() {
    step2(function() {
        step3(function() {
            console.log("모든 단계 완료!");
        });
    });
});

console.log("프로그램 종료"); 



/* 
출력 순서대로 : 
-----------------------------------
1. 기본 콜백 함수 예제
안녕하세요 홍길동님
콜백 함수가 실행되었습니다.

2. setTimeout 비동기 콜백 예제
타이머 시작
타이머 설정 완료

3. 가상의 파일 시스템 작업 예제
example.txt 파일 읽기 시작...

4. 콜백 지옥 예제
프로그램 종료
1단계 완료
파일 내용 처리: 파일의 내용입니다.
2단계 완료
3초 후에 실행됩니다.
3단계 완료
모든 단계 완료!
-----------------------------------
*/