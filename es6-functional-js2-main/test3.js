const { L, C } = window._;



function x(){
    console.log("zzz")



}




(function sum(){
    Promise.all([_.delay(5000,undefined),console.log("hellow")]).then(x)
})()






