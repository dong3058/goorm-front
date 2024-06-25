let integer:number=6;

let strng:string="doe";


let booleans:boolean=true;

let names1:string[]=['john',"kim"]


let names2:Array<string>=["john","kim"];


let array1:(string|number)[]=["j",1,"b",2,"3"]

let array2:Array<string|number>=["john",1];

let someArray:any[]=["1",1,[],{},false]

let stringarr:readonly string[]=["a","b"]

let numberarr:ReadonlyArray<number>=[1,2]
//push를 못쓰게 즉 읽기만 가능.

let tuple1:[string,number];
tuple1=["a",1]
//tuple=["a",1,2]는에러 왜냐 2개까지마넛으니까

let users:[number,string][]
users=[[1,"john"],[2,"doe"],[2,"doe"],[2,"doe"],[2,"doe"]]


let tuple2:[string,number]

tuple2=["a",1]
tuple2.push(2);//메서드 이용으로 넣은건된다.즉 [~~]이런식으론 불가.
console.log(tuple2)//단 정의에없던 내용은 넣지못한다.
let any:any="Abc"
any=1;
any=[];//any는 뭐든 가능.



let unknown:unknown=[];//애도 any처럼 뭐든 다할수있는대 다른 변수의 값으로는 못쓴다.
//let arr:boolean=unknown 타입 단언을 쓰면 unknown도 가능하다고함.

let obj:Object={};
let arrs:Object=[];
//let nulls:object=null; 스트릭에선 오브젝트ㅔ에 ull은 불가하다. js에서
//널의 타입이 오브젝트로 나오는대 사실 널은 널로나와야된다. 잘못된것.

let obj1:{id:number,title:string}={
    id:1,
    title:"title1",
    //descrpition:"X" 없는 애 넣는건 불가.
}


let union:(string|number)

//union=[] 숫자 문자열외에는 할당 불가.


let func1:(arg1:number,arg2:number)=>number

func1=function(x,y){
    return x*y
}//함수가 받을 인수,반환값을 다명시해야된다.

let func2:()=>void;
func2=function(){
    console.log("hi");
}


//let num1:number=undefined//설정에 strictnullchecks false하면 오류 x.
//let stringss:string=null;//애도마찬가지. 즉 저걸 끄면은 어디다가는 언디파인드 널을 넣어도
//오류가안난다.
//단 스트릭 널쳌이 true여도
let void2:void=undefined //이건 가능하다.
//let void3:void=null//ㅇ것도 가능 단 널쳌이 false일떄만.

function greeting():void{
    console.log('hi')
}
//void가 return 하는값은 undefined임.그러나 undefind로 리턴을 지정하면 error
const hi:void=greeting()//변수에 할당시에도 이렇게 추력값을 맞춰주자.

function throws():never{
    throw new Error("error")//항상 에러를 줌을 확신할떄 never.
    
}//보통never는 함수에쓰이는대 이는 리턴값이 없음을 의미한다.

function keep():never{//내부의 루프가 끝나지않아서 리턴값이 없으므로 즉undefined가
    //아닌 그냥 return 자체가 안되므로 never
    while(true){
        console.log("hi")
    }
}

const never:[]=[]//배열이없이게 실제로는 never[]로 선언된꼴
//즉 그어떤것도 들어갈수가잆다.

//타입단언. 내가 말하는게 맞다고 주장하늑너임

//let foo={} foo.bar=123 foo.x="zz"는 불가하나

interface Foo{
    bar:number;
    bas:string
}

let f={} as Foo;
f.bar=123
f.bas="zz"//이렇게 한다. 즉 인터페이스의 구현??? ㅇ란거랄까나.


const body=document.querySelector("body") //사실
body!.innerText="zzzz"
//퀄셀렉터로 골라도 애는 html에 body가잇을수도 잇고 없는 상황을 고래혀서
//htmlbodyelement 혹은 null두개를 가정하는대 지금여기선 htmlbodyele이라고 선언을 해준것.
//혹은 뒤의것 없이 body!.textConent 이런식이면 !로 인해서 null,undefind이 아니게됨.즉 절대 nullundefuned이아니라하는것.
//혹은 타입가드라고 if(bdoy)를 통해서 즉 조건문을 토앻서 body가있을떄만 실행되게하면된ㄷ나.
//!는 typescript에게 null이나 undefined이 아니라고 말해주는것.

function testing(arg:string|null){
    if(arg){
    return arg.toLowerCase();}
}
testing(null)
//testing(null)은 에러가 발생함. 이떄에는 타입가드 즉 if(arg){~~}이런식으로 해주자.

//type 과interface는 거의비슷하나 차이가존재.둘다 타입의 이름을 지정하는 방법이다.
//인터페이스는 extends 를 통해서하고 타입은 &연산자를 통해서 실행한다.
interface Animal{
    name:string;
}
interface Bear extends Animal{
    honey:boolean;
}


const bear1:Bear={
    name:"honeybear",
    honey:true
}
//bear1:animal은 오류 왜냐 honey가 없기떄문.

type Animals={
    name:string;
}
type bears =Animals &{
    honey:boolean;
}//이렇게 하면 인터페이스와 같이 작동.


//인터페이스는 선언병합이단되다.

//즉 같은 이름으로 두번 선언시 개내는 합쳐짐.
interface Animals1{
    hello:string
}
interface Animals1{
    hell:string
}

interface bb extends Animals1{
    h:boolean;
}

const bbbbb:bb={
    hello:"zzz",
    h:true,
    hell:"yes"
}//타입은 불가능하다.

//타입과 인터페이스모두 implements가 가능.



interface Animal12{
    name:string;
}
interface Bear12{
    honey:boolean;
}

type newt=Animal12|Bear12; // union을쓰면 a,b가될수있는 새로운 "type"을 선언가능. 타입도 가능한대
//단 타입으로 union을 만들든 인터페이스든 간에 선언할 새변수는 항상 type으로 해줘야된다.
const bear12:newt={
    name:"zz",
    honey:false
}//대충 이런꼴로 새타입은 애니멀 혹은 베어가 혹은 둘다 이다.



interface getLikeNumber{
    (like:number):number;
    //위의 것이 호출 시그니처란것인대 일조으이 인터페이스의 구현해야할 메서드라고 보면된다.
    //소괄호에 매개변수,뒤에 리턴값.

}


interface Post{
    id:number;
    title:string;
    getLikeNumber:getLikeNumber//(like:number)=>number;
    //(like:number)=>number; 이타입의 함수의 재활용을 위해서
    //위에서 인터페이스를 선언, 재사용한것이다.
    //인터페이스에 구현하는 함수를 넣어주고 써주면 된다.
}

const post1:Post={
    id:1,
    title:"pst1",
    getLikeNumber(like:number){
         return like}//정확한 구현을 여기서한다. 애초에 인터페이스자체가 구현을 다로뗴니까.
}

post1.getLikeNumber(1)


interface Post2{
    [key:string]:unknown;//인덱스 시그니처 any여도 딱히 상관은 없는듯
    id:number;
    title:string;
}


const post2:Post2={
    id:1,
    title:"post1",
    a:1234
}

post2["description"]="zzz"//위의 인덱스 시그니처를 이용한
//Post2에 정의된값이 없어도 값을 추가할수있게 만들어준것.


interface Names{
    [item:number]:string;
}

const usernames:Names=["j","b","c"]//배열에 대한 인덱스 시그니처이다.
//일종의 defaultdict이랑 조금 비슷한느낌?


function add(a:string,b:string):string
function add(a:number,b:number):number//타입선언
function add(a:any,b:any):any{
    return a+b;//함수의 구현.
}//자바의 메서드 오버로딩.

function saysomthing(word:string|string[]): string{
    if(typeof word==="string"){
        return word;
    }
    else if(Array.isArray(word)){
        return word.join(" ");
    }
    // 저거 둘다 아닐떄의 return값
    //즉 지금은 return이없이게 undefined를 주는대 이는 우리가 정의한 strng값이 아니므로 오류가발생 그러므로
    throw new  Error("unable to say somthing")//그래서 에러를 던져주면된다.
    //혹은 function saysomthing(word:any):any{ samelogic}이렇게 설계해주도록하자.
    // 유니온 타입 2개를 분해해서 다로만들고.
}
saysomthing(["hello","wrold"]);



class Posts{
    public id:number=0;
    private title:string="";
    //타입 스크립트는 this로 접근하는애들을 이렇게 저의 해줘야된다. 이렇게 초기값 설정도가능.
    //접근 제어자도 설정이 가능.
    constructor(id:number,title:string){
        this.id=id;
        this.title=title;
    }
    //위 생성자,변수 선을 constructor(public id:number=0){} 이렇게 작성을 해주면된다.
    //이경우 public도 설정할려면 생략이아닌 선언을 해줘야됨.
    //java 와 다르게 protectec속성은 해당 클래스 혹은 하위클래스만 접근이가능. 인스턴스는 불가.
    gePost(){

        return `postid:${this.id}`
    }

}

const post22:Posts=new Posts(1,"title")
post22.gePost()


/*function getarrlength(arr:number[]|string[]):number{
    return arr.length;
}*/

function getarrlength<T>(arr:T[]){
    return arr.length;
}//제네릭 

const arr1=[1,2,3];
const arr2=["a","b","c"];
/*getarrlength(arr1);
getarrlength(arr2);*/
getarrlength<string>(arr2)

interface vehicle<T>{
    name:string;
    color:string;
    option:T;
}

const car:vehicle<{price:number}>={
    name:"car",
    color:"red",
    option:{
        price:100
    }
}
const ca2:vehicle<boolean>={
    name:"car",
    color:"red",
    option:true
}
//제네릭을 클래스에


const makearr=<T,Y>(x:T,y:Y):[T,Y]=>{//<x,y=string>이렇게 default를 줄수도있음.
    //이러먄 makearr(string)("Ab","c")이런꼴.
    return [x,y];
}

const array22=makearr<number,number>(1,2)//제네릭 사용법2.

const makefullname=<T extends {firstname:string,lastname:string}>(obj:T)=>{
    //이렇게하면 obj의 매개변수로 extends 이하가 항상 들어간다. 즉 저거에다가 추가적으로도
    //더넣을수있다는말이다.
    return{
        ...obj,
        fullname:obj.firstname+""+obj.lastname
    }
}

makefullname({firstname:"john",lastname:"doe",location:"seoul"})



interface Address{
    email:string
    address:string
    ss:string
}


const me:Partial<Address>={email:"Zzzz"}//partial로 인해서 부분적으로만 만족해도됨.

type picktest=Pick<Address,"email"|"ss">;
// address 로부터 몇개의 속성만가지고 새롭게 타입을 만드는것. 여기선 2개를 가져옴

type moitstset=Omit<Address,"address">;// adresss를 제외한 나머지를 가져오는것.



//exclude도 존재함


type excludes="a"|"b"|"c"

// let y=Exclude<excludes,"b"|"c">==>b하고 c제거 즉 a만 남음.

type uuu={
    lastname?:string//lastname이란게 잇어도 되고 없어도되는것.
}

let firuuu:Required<uuu>={
    lastname:"zzzz"//required 가 들어가면 ?로 표시된게 항상 있어야만한다.
}


interface catinfo{
    age:number;
    breed:string;
}


type catname="miffy"|"bbb"|"zzzz"



const cats:Record<catname,catinfo>={
    miffy:{age:1,breed:"pppp"},
    bbb:{age:1,breed:"pppp"},
    zzzz:{age:1,breed:"pppp"}
    //자바의 그 레코드와 매우 흡사하다.

}

type T0=ReturnType<()=>string>//반환하는 타입으로 구성된 타입
//즉 T0는 스트링

type T1=ReturnType<(s:string)=>void>
//T1은 VOID를 반환.

function fn(str:string){
    return str;
}

const a:ReturnType<typeof fn>="hello"
//fn의 리턴타입이미로 스트링.
//const b: ReturnType<typeof fn>=true 에러 불리안은 쓰는게불가하다.

//implemetns는 새로운 클래스의 타입체크 에 이용되는것.
//해당 클래스의 모양을 정의할떄 쓰는걸로 부모클래스의 프로퍼티,메소드를
//상속받아 쓰는게 아니다.

class Car{
    mileage=0;
    price=100;
    color="white"
    drive(){
        return "drive"
    }

    break(){
        return "break"
    }

}

class ford implements Car{
    mileage=10;
    price=50;
    color="black"

    drive(){
        return "Zzz"
    }
    break(){
        return "sss"
    }


}
//에러 왜냐 상속이아니라 포드의전체적인 형태를 car로 잡아주는것이기ㅣ떄문.
//즉 상속처럼 가져다쓰는게 아니라 그틀내에서 우리가 구혀늘 해주면된다.
//자바의 인터페이스를 구현하는것과 비슷하다.
//여러개를 IMPLREMENTS 할수있으먀 그떄마다 모든걸 구현해줄필요가있다.


const mycar=new ford();



interface iuser{
    name:string;
    age:number;
    address:string
}


type userkeys=keyof iuser//이러면 "name"|"age"|"address"가 반환됨.
//즉 키를 뽑아와서 union으로 반환 하는애가 keyof이다.

const user={name:"j",age:10,address:"ss"}

type userkeys2= keyof typeof user//객체의 키로 유니온 타입 만들기.
//key of 자체가 interface에 주춫ㄹ하므로 객체를 typeoㄹ 로 ㅠ바꾸고 keyof 로 키를 추출하면된다.

enum userrole{
    admin,
    manager
}


type userolekey=keyof typeof userrole//"admin"|"manager"이런꼴.
//즉 간단하게 타이벵서 key추출시 쓴다고 생각하자


type testusers="john"|"han"|"kim";

/*type userfirnames={[k in testusers]:string};


const userfirstnames:userfirnames={
    john:"doe",
    han:"ho",
    kim:"jun"

}*/

type userfirnames={[k in testusers]:number};
//js 맵 함수처럼 각각의 것들을 number 타입으로 바꾼것.

const userfirstnames:userfirnames={
    john:10,
    han:20,
    kim:3

}


type deviceformatter<t>={
    [k in keyof t]:t[k];
    //keyof로 t의 유니온 형태로 가져오고 그걸 순회.
}

type device={
    manafacturer:string;
    price:number;
}

const iphone:deviceformatter<device>={manafacturer:"apple",price:100}
// devicefor matter의 manfacturer:string price:number 를 가지게된다.

type deviceformatters<t>={
    [k in keyof t]?:t[k]; //이렇게 ?를붙여주면 없어도 그냥 통과됨

    
}

const priceonly:deviceformatters<device>={price:200}//이렇게된다!


//조건부 타입.
type sometype=string;
type conditionaltype=sometype extends string ? string:null
//3항 연산자 넣은건대 sometype이string에 속하면 tring을 아니면 null을 준다는말.


function fn11<t>(value:t){
    const fn22=(arg:t extends boolean?"a":"B")=>{};

    return fn22
}

const result=fn11("");//타입이 b 왜냐 ""은 strinㅎ 타입이므로 false 이미르 "B"를준다.

type stringornot<t>=t extends string ? string:never;
type aunion=string|boolean|never;


const abb:stringornot<string>="string";//number 를 주면 바로 never가나옴.


type atype<t>=t extends string|number ? t:never;

type myresult=atype<string|number|boolean>;//string|number가 union으로 들어옴,
//각각 타입을 비교한다 distributively 라고한다. 만약 일괄적으로 비교하고싶다면
//type atype<t>=(()=>t) extends()=>string|number?t:never;
//type myresult=atype<string|number|boolean>;
//이렇게 하면 전체르 비교해서 할당이 안되므로 never나나옴.

//혹은

//type atype<t>=[t] extends [ string|number] ? t:never;
//이렇게 해도 통으로 비교한다!










//infer
type bbb<t>=t extends infer r?r:null;

const infer1:bbb<number>=1;

//이러면 t가 r에 할당될수있게 r을 추론하라는것임.
//즉 위의 결과는 number이다.

type bbbb<t>=t extends {a:infer A;b:1} ? A:any;

type inffer2=bbbb<{a:"hi",b:1}>;
//a가 포함될수있게 A를 "hi"라고 바꾼다.???이게 타입이라고???
type cc<t>=t extends{a:infer A ,b:infer B}? A&B :any;


type inffer3=cc<{a:{someaprops:1};b:{somebprops:2}}> 
//결과체크 ㅇㅇ;


type t0=ReturnType<()=>string>
// 리터타입은 r?extends (..args:any)=>any라는 제약조건이 존재함.
//고로 함수형으로 입력을 해야됨.
//여튼 함수형으로 주도록?하자.

type t1=ReturnType<(s:string)=>void>

function fnnn(str:string){
    return str;
}

type t2=ReturnType<typeof fnnn>





type Colors="red"|"green"|"blue";

type rgb=[red:number,green:number,blue:number];



/*const palette:Record<Colors,string|rgb>={
    red:[255,0,0],
    green:"#00ff00",
    bleu:[0,0,255]//blue가 틀렸다고 바로 오류를 아려줌.
    nokey:"zzz"
}*/


const palette={
    red:[255,0,0],
    green:"#00ff00",
    blue:[0,0,255]

} satisfies Record<Colors,string|rgb> 



const palette2={
    red:[255,0,0],
    green:"#00ff00",
    bleu:[0,0,255]

} satisfies Record<Colors,string|rgb> 




const palette3={
    red:[255,0,0],
    green:"#00ff00",
    bleu:[0,255],//값에대한 에러,
    zzz:"haha"//키가 없는 키임에도 불구하고 값을 우선적으로 본다.

} satisfies Record<string,string|rgb> 

//satisfies Record<string,string|RGB> key에대한 에러가아닌 값에대한에러
//satisfies를 사용하면 string|rgb여도 올바르게 가져오는것이가능.

const redcomponent=palette.red.at(0);
const greens=palette.green.toUpperCase();//string이 아닌
//string|rgb라는 속성에 touppercase가 없으므로 오류가남.


const blues=palette.blue.at(0)


