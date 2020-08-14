
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

function forgotPass(){
    document.getElementById("forg").addEventListener("click", function () {
        document.querySelector(".wrapper").style.opacity="0";
        document.querySelector(".popup").style.display="none";
        document.querySelector(".popup2").style.display="flex";
    })}

function forgotPassHide(){
    document.querySelector(".close2" ).addEventListener("click", function () {
        document.querySelector(".wrapper").style.opacity="1";
        document.querySelector(".popup").style.display="none";
        document.querySelector(".popup2").style.display="none";

    })}

