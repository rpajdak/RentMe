
function showLogin(){
document.getElementById("sign-in").addEventListener("click", function () {
    document.querySelector(".wrapper").style.opacity="0";
    document.querySelector(".popup").style.display="flex";
})}

function hideLogin(){
document.querySelector(".close" ).addEventListener("click", function () {
    document.querySelector(".wrapper").style.opacity="1";
    document.querySelector(".popup").style.display="none";

})}