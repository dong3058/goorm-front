const { L, C } = window._;



const obj1={
    a:1,
    b:2,
    c:3,
    d:4
}


/*  L.values=function *(obj1){
    for const k in obj{
        yield obj[k]
    }
}*/
//이런꼴의함수임.

//let it=L.values(obj1) L.take(2,it),[...it]==>즉시평가해도 2개만꺼낸다.

_.go(
    obj1,
    L.values,
    _.reduce((a,b)=>a+b),
    console.log
)

_.go(
    obj1,
    L.entries,//애도 같은기능.
    _.take(2),
    console.log
)



_.go(
    obj1,
    L.keys,
    _.take(2),
    console.log
)

//뭐든간에 제너레이터와 이터러블을 통해서 다룰수있음.

const g1=function *(stop){
    let i=-1;
    while(i++<stop){


        yield 10;
        if(false) yield 2

        yield 30;
    }
}

_.go(
    g1(10),
    L.take(2),
    _.reduce((a,b)=>{
        
        console.log(a,b)
        
         return a+b}),//yield 10,yield 30 이걸 꺼내가지고 40만든거임.
    console.log
)


const a=[["a",1],["b",2],["c",3]]

const b={a:1,b:2,c:3}


_.go(
    a,
    _.map((el)=>({[el[0]] : el[1]})),
    console.log


)



let m =new Map();

m.set("a",10)
m.set("b",20)
m.set("c",30)

console.log(m)

console.log([...m[Symbol.iterator]()])
//이렇게하면 엔트리 꼴을 돌려줌. m.keys(),m.values()로도 하면 키,값을 분리가능.
//이터러블 에 사용이 가능하다.



_.go(
    m,
    _.map((el)=>({[el[0]] : el[1]})),
    _.reduce((a,b)=>Object.assign(a,b)),
    console.log
    //즉 이런방식은 이터러블만 주어지면 객체를 만드는게 가느아하다.


)
//

_.go(
    L.entries(b),
    _.map(el=>[el[0],el[1]+10]),
    _.map((el)=>({[el[0]]:el[1]})),
    _.reduce((a,b)=>Object.assign(a,b)),
    console.log
)

const obj2={a:1,b:2,c:3,d:4,f:5}



const object= els=>_.go(
    els,
     _.map((el)=>({[el[0]] : el[1]})),
     _.reduce((a,b)=>Object.assign(a,b)))
const pick=(ks,obj)=>_.go(
    ks,
    _.map(k=>[k,obj[k]]),
    _.filter(el=>el[1]!==undefined),
    object,
    console.log
)

pick(["b","c","z"],obj2)





const users =[{
    id:5,name:'AA',age:35
},{
    id:10,name:"BB",age:26
}]


console.log("indexby:",_.indexBy(u=>u.id,users));


const users2=_.indexBy(u=>u.id,users);


//indexBy를한것에 filter를 적용할려면 entries로 바꾸고 적용해야됨.

_.go(
    users2,
    L.entries,
    _.filter(([k,el])=>el.age>=30),
    object,
    console.log
)


//사용자 정의 객체를 이터러블 프로그래밍으로 다루기



let ms=new Map();


ms.set("a",1)

ms.set("b",2)
ms.set("c",3)


_.go(
    ms,
    _.filter(([k,v])=>v%2),
    x=>new Map(x),
    console.log
)


let s=new Set()


s.add(10)
s.add(20)
s.add(30)

_.go(
    s,
    _.reduce((a,b)=>a+b),
    console.log
)
//dom을 통해서얻는노드 리스트도 다루는게 가능함.

class Model{
    constructor(attrs={}){
        this._attrs=attrs;
    }


    get(k){
        return this._attrs[k]
    }


    set(k,v){

        this._attrs[k]=v;
        return this
    }
}



// 이클래스는 어떻게 이터러블화 할것인가 에대한내용.
class Collection{
    constructor(models=[]){
        this._models=models;
    }
    at(idx){
        return this._models[idx]
    }

    add(model){
        this._models.push(model)
        return this;
    }

    //아래는 제너레이터 함수를 선언한다고 보면된다.

/*즉 * fucntion(){
    yield *this._models와 다를게 없다고 생각하면됨.
}*/ 


    *[Symbol.iterator](){
        yield *this._models;//this.models 자체가 배열인지라 다시 
        //개한태 제네레이터를 맡기는게 가능하다.
    }




}

//클래스 내부에서 심볼 이터레이터를 돌려주도록 설정.



const coll=new Collection();

coll.add(new Model({id:1,name:"AA"}))
coll.add(new Model({id:3,name:"BB"}))
coll.add(new Model({id:5,name:"CC"}))


_.go(
    coll,
    L.map(m=>{
        console.log("m:",m)
        return m.get("name")}),
    _.reduce((a,b)=>a+b),
    console.log
)

//이터러블과 객체지향이 어떻게 어우러지는가.
class Product extends Model{}


class Products extends Collection{
    totalPirce(){
        return _.go(
            this,
            L.map(p=>p.get("price")),
            _.reduce((a,b)=>a+b)
        )

    }
}


const products=new Products();
products.add(new Product({id:1,price:10000}))
console.log(products.totalPirce())
products.add(new Product({id:3,price:30000}))
console.log(products.totalPirce())
products.add(new Product({id:5,price:50000}))
console.log(products.totalPirce())



//레인지와 테이크의 재해석.

//_.range(10)===>0~9 까지의 배열
//L.range(10)==>최대 10번일어날일,0~9까지의 이터러블.
//_.take(3)=>3개의값을 잘라옴
//L.take(3)==>최대 3번 실행.
//즉 L_.RANGE,TAKE는 단순한 배열이 아니라 어떠한
//여러개의 일들이 일어날것으로보고 이것들을 배열로 바라보느것.
//어떤 일련의 로직을 만들기위한 도구로써 바라보자는말.
//일종의 문법을 대체하는 언어로 쓰일수가있다.


_.go(
    L.range(1,10),
    L.map(_.delay(1000)),
    L.filter(a=>a%2),
    L.map(_=>new Date()),
    _.take(3),//_.take이므로 3개가 쌓일떄까지 기다렸다가한번에 분출한다.
    //왜냐 l로읺새ㅓ 지연평가가 즉 제너레이터로 작동되기에 기다렸다가 3개쌓이면
    //한번에 따다닥 실행을 한다
    //만약 ㅜL_.TAKE일경ㅇ우 한개가오면 그 한개를 실행하고 바로 그다음으로넘어간다.
    console.log
)





_.go([1,2,3,4,5,6,7,8,0,0,0],
    //_.takeWhile(a=>a),//truethy한값이 나올떄까지만 받는애
    //즉 0 0 0 뒤에 ture값이 잇어도 나오진않음.

    console.log
    
    
    
    )

_.go([0,false,undefined,null,1,2],
    _.takeUntil(a=>a),
    //참값을 만나면 그떄끝남.처음만나는참값까지 포함을 한다는말.
    console.log)


const track=[
{cars:["철수","영희","철희","영수"]},
{cars:["하든","커리","듀란트","찰리"]},
{cars:["승리","영규"]},
{cars:[]}
]


_.go(
    L.range(Infinity),
    L.map(i=>track[i]),
    L.map(_.delay(1000)),
    //L.takeWhile(({cars})=>cars.length==4),//take while이므로 길이4가아닌거나오럐ㄸ까지실행.
    
    L.takeUntil(({cars})=>cars.length<4),//==>승리영규까지만 포함.
    _.each(console.log)
)




const impt={

    payments:{
        1:[{imp_id:1,order_id:1,amount:10000},
            {imp_id:2,order_id:2,amount:20000},
            {imp_id:3,order_id:3,amount:30000}],
        2:[{imp_id:4,order_id:4,amount:40000},
                {imp_id:5,order_id:5,amount:50000},
                {imp_id:6,order_id:6,amount:60000}],
        3:[{imp_id:7,order_id:7,amount:70000},
                    {imp_id:8,order_id:8,amount:80000},
                    ],
        4:[],
        5:[]    
        


    },
    getpayments:page=>{
        console.log(`http:${page}`)
        return _.delay(1000*2,impt.payments[page])
    },
    canclePayment:imp_id=>Promise.resolve(`${imp_id}:취소완료`)
}



const db={

    getOrders:ids=>_.delay(100,[
        {id:1},{id:3},{id:7},{id:100}
    ])


}

//결제 데이터를 가져오되 결제데이터가 있을떄가지 모두 가져온다. 

//단 한번 호출시 가져올수있는 최대 데이터는 3개로 제한한다.
async function job(){
    const payments=await _.go(
        L.range(1,Infinity),
        L.map(impt.getpayments),
        //L.takeWhile(el=>el.length>0),
        L.takeUntil(el=>el.length<3),
        _.flat,//한번에 묶어서 돌려주는애
        
    )
        console.log(payments)
    const orderids=await _.go(
        payments,
        _.map(el=>el.order_id),
        console.log,
        db.getOrders,
        _.map(({id})=>id),
        

    
    )

        console.log(orderids)
   const checks= await  _.go(
        payments,
        L.reject(el=>orderids.includes(el.order_id)),
        L.map(el=>el.imp_id),
        L.map(impt.canclePayment),
        _.each(console.log)
        

    )

    
 



}

(function recur(){
    Promise.all([_.delay(7000,undefined),job()]).then(recur)//콜백함수로 넘길대에는
    //함수의 이름만 적자

//대충 function func(name)에서 name이함수의 이름이라 생각하는것과가은 원리이다.
//아니면 화살표로 정의를 하든가. 규칙임 아니면 익명함수를 쓸것. 지키자 ㅇㅇ
})()//즉시실행 함수를 응용한 회귀구조...ㅇ.ㅇ.///