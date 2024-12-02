/**
 * 자바스크립트 비동기 처리 학습 3-3: 병렬 처리
 */

// 03_2_data_fetching.js 파일의 fetchUserData, fetchUserPosts 함수를 사용한다고 가정

// CommonJS 방식 import
const { fetchUserData, fetchUserPosts } = require('./03_2_data_fetching');
// ESmodule 방식 import
// import { fetchUserData, fetchUserPosts } from './03_2_data_fetching.js';


async function parallel() {
    try {
        console.log("병렬 처리 시작");

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
console.log("프로그램 종료");
