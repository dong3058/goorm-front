/*function f1(limit, list) {
    let acc = 0;
    for (const item of list) {
      if (item % 2) {
        const square = item * item;
        acc += square;
        if (--limit === 0) break;
      }
    }
    console.log(acc);
  } */

  const { L, C } = window._;
 
  


//if는 filter 어떤값을 연산해서 쓴다면 map break는 take  값의 누적은 reduce
//이렇게 치환해서생각해보자.
function f1(limit,list){
   console.log(_.reduce((acc,el)=>acc+=el
   ,L.take(limit,L.map(el=>el*el,L.filter(el=>el%2,list)))))
    /*
    _.go(
    list,
    L.filter((a) => a % 2),
    L.map((a) => a * a),
    L.take(limit),
    _.reduce(add),
    console.log
  );
    
     이런식으로 원래의 filter 같은 메서드들이 가지는 순서대로쓸수도있다.*/


}

f1(3,[1,2,3,4,5,6,7,8,9])


console.log([1,2,3].reduce((acc,el)=>acc+=el))


/*function f3(end){
    let i=0;
    while(i<end){
        console.log(i);
        ++i;
    }
}*/
let y=_.range(1,10);//_를 붙이면 1~9인 배열을 돌려준다.
let w=_.map(el=>_.range(el),y)

let l=_.map(_.map(el=>"*"),w)
console.log("l:",l,"w:",w)

let k=_.range([1,2,3])


console.log("y:",y,k)



_.go(
    L.range(1,6),
    L.map(_.range),
    L.map(_.map(el=>{
        console.log("check")
        return "*"})),
    L.map(_.reduce((a,b)=>{ 
        console.log("누적치:",a,"현재값:",b)
        return`${a}${b}`})),
    _.reduce((a,b)=>`${a}\n${b}`),
    console.log

)
//별찍기
/*_.go(
    _.range(2,10),
    _.map(el=>_.go(_.range(1,10),
    _.map(b=>`${el}*${b}=${el*b}`),
    _.reduce((a,b)=>`${a}\n${b}`)
    )),
    _.reduce((a,b)=>`${a}\n${b}`),
    console.log
)*/

//구구단



const users = [
    { name: "AA", age: 35 },
    { name: "BB", age: 26 },
    { name: "CC", age: 28 },
    { name: "DD", age: 34 },
    { name: "EE", age: 23 },
  ];

console.log(_.reduce((a,b)=>a+b,0,_.map(el=>el.age,users)))


console.log(_.reduce((a,b)=>a+b,0,_.map(el=>el.age,_.filter(el=>30>el.age,users))))
//if조건도 구현해준아이다.

//하나의 리듀스보단 map과 연결해서 쓰는것이좋다. a+b도 const add=(a+b)->a+b이렇게바꿔줘도좋다.

const obj1 = {
    a: 1,
    b: undefined,
    c: "CC",
    d: "DD",
  };

  function query1(obj) {
    let res = "";
    for (const key in obj) {
      const v = obj[key];
      if (v === undefined) continue;
      if (res !== "") res += "&";
      res += key + "=" + v;
    }
    return res;
  }


  
   console.log(
   
 _.reduce((a,b)=>`${a}&${b}`,
 _.map(el=>`${el[0]}=${el[1]}`
 ,_.filter(el=>el[1]!==undefined,Object.entries(obj1))))

   )


let x="sex"


let obj3={[x]:1}

console.log(obj3)//변수는 []써줘서 오브젝트 키값으로



let sen="a=1&c=CC&d=DD"
let obj2={}
_.go(
    sen.split("&"),
    _.map(el=>el.split("=")),
    _.map(([k,v])=>({[k] : v})),
    _.reduce((a,b)=>Object.assign(a,b)),
    console.log

)


_.go(
    _.filter(el=>el.name=="BB"),
    _.take(1),
    console.log
)//find를 넣으면 ""읜경우에대해서 if가필요하나 이런건 필요가업다.

   //위에걸 간단히한것. reudce문과 기타등등의 조황다.


_.go(
    _.range(1,5),
    L.map(el=>{
        console.log(el)
        return el
    }),
    _.reduce((a,b)=>{
        console.log(a,b)
        return a+=b
    }),
    console.log
)// L과 _의 차이를 보여주는것으로 L은 제너레이터로 봐도 무방해보인다.



  


/*function f3(end){
    _.each(console.log, L.range(end));*/
    //파이썬 range와 매우 비슷한다range(start,end,간격)이런골.
    //start~end-1까지 ㅇ
//}
//each(console.log,[1,2,3])은 각각 1,2,3 을 출력하나 돌려준ㄴ 값은 [1,2,3]과같다.
//즉 each를 통해서 console.log라는 효과가 일어날거라고 구분을 짓는것이다.
//range의경우 초기값을 즉 start를 설정하지않으면 0임.

//pipe와 curry를 알아볼것.