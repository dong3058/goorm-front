
        
let y=document.querySelector(".main-movie");
let z=document.querySelectorAll(".origin-movie")
let w=["moviefoster/earth.jpg","moviefoster/darkknight.jpg","moviefoster/jurassicpark.jpg"
,"moviefoster/joker.jpg","moviefoster/monster.jpg","moviefoster/insect.jpg","moviefoster/orange.jpg","moviefoster/shining.jpg"]
for(let k=0;k<8;k++){

z[k].addEventListener("mouseover",()=>{
    y.style.backgroundImage=`url(${w[k]})`
    console.log("check");
})
}
