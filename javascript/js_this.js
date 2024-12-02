/*
*
*   함수 선언식:
    function myFunction(param1, param2) {
      return someValue;
    }
    *
    함수 표현식:
    const myFunction = function(param1, param2) {
      return someValue;
    };
    *
    화살표 함수:
    const myFunction = (param1, param2) => someValue;
*
* */


/*
*
* this : 특정 인스턴스 가리키는 키워드
*
* 화살표 함수 내부의 this는 화살표 함수가 정의된 *주변 코드 (lexical scope)*의 this와 동일한 값을 가진다.
* 일반 함수(선언식, 표현식)는 호출될 때마다 this의 값이 호출 방식에 따라 동적으로 결정됩니다.
* 하지만 화살표 함수는 호출 방식과 관계없이 정의될 당시의 '주변 코드'에서 this가 무엇을 가리키는지를 상속받아 사용
*
* */


const person = {
    name: 'Alice',
    // 1. 일반 함수
    greet: function () {
        // 일반 함수 내부의 this는 호출한 객체(person)를 가리킴
        console.log('Hello, my name is ' + this.name);  // Alice

        // 2. 일반 함수 (콜백 함수)
        setTimeout(function () {
            // 콜백 함수로 사용된 일반 함수 내부의 this는 전역 객체(window 또는 global)를 가리킴
            console.log('일반 함수: ' + this.name); // this 바인딩 문제 발생!    undefined
        }, 1000);

        // 3. 화살표 함수 (콜백 함수)
        setTimeout(() => {
            // 콜백 함수로 사용된 화살표 함수 내부의 this는 주변 코드인 greet 메서드의 this를 상속
            // greet 메서드 내부에서 선언되었기 때문에 person 객체의 this를 상속
            console.log('화살표 함수 (콜백 함수): ' + this.name); // this가 person 객체를 가리킴  Alice.
        }, 1000);
    },

    // 4. 화살표 함수
    greetArrow: () => {
        // greetArrow가 정의될 당시의 주변 코드(전역 범위)의 this를 상속. 따라서 this는 전역 객체(window 또는 global)를 가리킴
        console.log('greetArrow 화살표 함수: ' + this.name);  // this 바인딩 문제 발생! (전역 객체를 가리킴) undefined
    }
}

person.greet();
person.greetArrow();






