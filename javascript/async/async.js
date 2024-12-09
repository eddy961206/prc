

// async 는 !항상! Promise 반환
// async : 비동기함수
async function getData() {
    return "Data loaded";
}

async function processWithAwait() {
    // await 키워드 있으면 getData()에서 반환되는 Promise가 해결(resolve)될 때까지 기다림.
    const data = await getData();
    console.log(data + " with await");  // 위에 await 가 있기 때문에 getData() 의 결과를 기다린 후 순차적으로 실행됨.
}

async function processWithoutAwait() {
    // await 키워드 없으면 비동기 함수인 getData() 가 반환하는 Promise가 해결(resolve) 되기를 기다리지 않고 다음 코드를 바로 실행.
    getData().then(data => console.log(data + " without await"));
    console.log("after processWithoutAwait");
}

///////////////////////////////////////////////////

const promiseWithAsync = processWithAwait();
console.log("await 있을 때 : ")
console.log(promiseWithAsync);

const promiseWithoutAsync = processWithoutAwait();
console.log("await 없을 때 : ")
console.log(promiseWithoutAsync);

// 작동 순서 :
// 1. a쓰레드에서 비동기함수인 processWithAwait가 호출됨
// 비동기함수기 때문에 processWithAwait의 결과가 나올때까지 기다리지 않고 b라는 새로운 쓰레드를 만들어 b쓰레드에서 바로 다음줄인 console.log("await 있을 때 : "); 가 실행됨 ==> 1번째 출력 : "await 있을 때 : "
// 2. 1번에서 processWithAwait 가 호출되면서 processWithAwait 내부의 또다른 비동기함수인 getData가 호출된 상태.
// getData 앞에 await 키워드가 있기 때문에 비동기함수인 getData가 반환하는 Promise가 해결(resolve) 될 때까지 기다리며 대기(pending) 상태로 됨.
// console.log(promiseWithAsync); 가 실행되면서 현재 대기(pending) 상태인 Promise 객체가 콘솔에 출력됨 ==> 2번째 출력 : Promise { <pending> }





// -> await 로 getData 호출 -> data 변수에 pending 상태의 Promise 담김.
// 2. 그러나 그 다음줄인 console.log(data + " with await"); 는 실행되지 않음. getData 앞에 await 라는 키워드가 있어서 getData 가 반환하는 Promise 가 해결(resolve) 될 때까지 기다리기 때문.
// 3. processWithAwait 이 호출된 동안 인터프리터는 이게 비동기함수인걸 알고 바로 다음줄인 console.log("await 있을 때 : "); 로 넘어가버림.
// 1. console.log("await 있을 때 : ") 실행 -> "await 있을 때 : "
// 2.


array = [2, 32, 3, 644, 21];

array.sort((a, b) => a - b);

console.log(array);

