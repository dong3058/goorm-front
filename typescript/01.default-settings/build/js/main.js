"use strict";
let integer = 6;
let strng = "doe";
let booleans = true;
let names1 = ['john', "kim"];
let names2 = ["john", "kim"];
let array1 = ["j", 1];
let array2 = ["john", 1];
let someArray = ["1", 1, [], {}, false];
let stringarr = ["a", "b"];
let numberarr = [1, 2];
//push를 못쓰게 즉 읽기만 가능.
let tuple1;
tuple1 = ["a", 1];
//tuple=["a",1,2]는에러 왜냐 2개까지마넛으니까
let users;
users = [[1, "john"], [2, "doe"]];
let tuple2;
tuple2 = ["a", 1];
tuple2.push(2); //메서드 이용으로 넣은건된다.즉 [~~]이런식으론 불가.
console.log(tuple2); //단 정의에없던 내용은 넣지못한다.
let any = "Abc";
any = 1;
any = []; //any는 뭐든 가능.
let unknown = []; //애도 any처럼 뭐든 다할수있는대 다른 변수의 값으로는 못쓴다.
//let arr:boolean=unknown 타입 단언을 쓰면 unknown도 가능하다고함.
let obj = {};
let arrs = [];
//let nulls:object=null; 스트릭에선 오브젝트ㅔ에 ull은 불가하다. js에서
//널의 타입이 오브젝트로 나오는대 사실 널은 널로나와야된다. 잘못된것.
let obj1 = {
    id: 1,
    title: "title1",
    //descrpition:"X" 없는 애 넣는건 불가.
};
let union;
//union=[] 숫자 문자열외에는 할당 불가.
let func1;
func1 = function (x, y) {
    return x * y;
}; //함수가 받을 인수,반환값을 다명시해야된다.
let func2;
func2 = function () {
    console.log("hi");
};
//let num1:number=undefined//설정에 strictnullchecks false하면 오류 x.
//let stringss:string=null;//애도마찬가지. 즉 저걸 끄면은 어디다가는 언디파인드 널을 넣어도
//오류가안난다.
//단 스트릭 널쳌이 true여도
let void2 = undefined; //이건 가능하다.
//let void3:void=null//ㅇ것도 가능 단 널쳌이 false일떄만.
function greeting() {
    console.log('hi');
}
//void가 return 하는값은 undefined임.그러나 undefind로 리턴을 지정하면 error
const hi = greeting(); //변수에 할당시에도 이렇게 추력값을 맞춰주자.
function throws() {
    throw new Error("error"); //항상 에러를 줌을 확신할떄 never.
} //보통never는 함수에쓰이는대 이는 리턴값이 없음을 의미한다.
function keep() {
    //아닌 그냥 return 자체가 안되므로 never
    while (true) {
        console.log("hi");
    }
}
const never = []; //배열이없이게 실제로는 never[]로 선언된꼴
let f = {};
f.bar = 123;
f.bas = "zz"; //이렇게 한다. 즉 인터페이스의 구현??? ㅇ란거랄까나.
const body = document.querySelector("body"); //사실
body.innerText = "zzzz";
//퀄셀렉터로 골라도 애는 html에 body가잇을수도 잇고 없는 상황을 고래혀서
//htmlbodyelement 혹은 null두개를 가정하는대 지금여기선 htmlbodyele이라고 선언을 해준것.
//혹은 뒤의것 없이 body!.textConent 이런식이면 !로 인해서 null,undefind이 아니게됨.즉 절대 nullundefuned이아니라하는것.
//혹은 타입가드라고 if(bdoy)를 통해서 즉 조건문을 토앻서 body가있을떄만 실행되게하면된ㄷ나.
//!는 typescript에게 null이나 undefined이 아니라고 말해주는것.
function testing(arg) {
    if (arg) {
        return arg.toLowerCase();
    }
}
testing(null);
const bear1 = {
    name: "honeybear",
    honey: true
};
const bbbbb = {
    hello: "zzz",
    h: true,
    hell: "yes"
}; //타입은 불가능하다.
//단 다입으로 union을 만들든 인터페이스든 간에 선언할 새변수는 항상 type으로 해줘야된다.
const bear12 = {
    name: "zz",
    honey: false
}; //대충 이런꼴로 새타입은 애니멀 혹은 베어가 혹은 둘다 이다.
