
function showLogin(){
    document.getElementById("sign-in").addEventListener("click", function () {
        fadeOut("wrapper", 15)
        document.querySelector(".wrapper").style.display="none";
        document.querySelector(".login-popup").style.display="flex";
        fadeIn("login-popup", 35)
    })}

function hideLogin(){
    document.querySelector(".close-login" ).addEventListener("click", function () {
        document.querySelector(".wrapper").style.display="block";
        fadeIn("wrapper", 75)
        document.querySelector(".login-popup").style.display="none";
    })}

function forgotPass(){
    document.getElementById("forg").addEventListener("click", function () {
        document.querySelector(".wrapper").style.opacity="0";
        fadeOut("login-popup", 15)
        document.querySelector(".login-popup").style.display="none";
        document.querySelector(".forgot-password-popup").style.display="flex";
        fadeIn("forgot-password-popup", 15)
    })}

function forgotPassHide(){
    document.querySelector(".close-password-recovery" ).addEventListener("click", function () {
        fadeOut("forgot-password-popup", 15)
        document.querySelector(".forgot-password-popup").style.display="none";
        document.querySelector(".wrapper").style.display="block";
        fadeIn("wrapper", 75)
/*        document.querySelector(".login-popup").style.display="none";*/


    })}

 function fadeOut(element, duration) {
     var i = 10;
     var wrapper = document.getElementsByClassName(element)[0];
     wrapper.style.opacity = 1;
     var k = window.setInterval(function () {
         if (i <= 0) {
             clearInterval(k)
             wrapper.style.opacity = 0;
         } else {
             wrapper.style.opacity = i / 10;
             i--;
         }
     }, duration);
 }

 function fadeIn(element, duration) {
     var i = 0;
     var wrapper = document.getElementsByClassName(element)[0];
     wrapper.style.opacity = 0;
     var k = window.setInterval(function() {
         if (i >= 10) {
             clearInterval(k)
             wrapper.style.opacity = 1;
         } else {
             wrapper.style.opacity = i / 10;
             i++;
         }
     }, duration);
 }