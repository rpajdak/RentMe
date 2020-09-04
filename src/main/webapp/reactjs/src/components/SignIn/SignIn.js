import React from "react";
import {Link} from "react-router-dom";
import "../../css/header-and-body.css";
import closeIcon from "../../assets/close-window.svg"
import RecoverAcc from "../RecoverAcc/RecoverAcc";


function SignIn() {

    function hideLogin() {
        console.log("asd");
        document.querySelector(".close").addEventListener("click", function () {
            document.querySelector(".wrapper").style.display = "flex";
            fadeIn("wrapper", 75)
            document.querySelector(".popup").style.display = "none";
        })
    }

    function fadeIn(element, duration) {
        var i = 0;
        var wrapper = document.getElementsByClassName(element)[0];
        wrapper.style.opacity = 0;
        var k = window.setInterval(function () {
            if (i >= 10) {
                clearInterval(k)
                wrapper.style.opacity = 1;
            } else {
                wrapper.style.opacity = i / 10;
                i++;
            }
        }, duration);
    }

    function forgotPass() {
        document.querySelector(".wrapper").style.opacity = "0";
        document.querySelector(".popup").style.display = "none";
        console.log(document.querySelector(".popup2"));
        document.querySelector(".popup2").style.display = "flex";
    }
    

    return (

        <React.Fragment>
            <RecoverAcc/>
            <div className="popup">
                <div className="popup-content">
                    <h3>Sign in</h3>
                    <img className="close" src={closeIcon} onClick={hideLogin}/>
                    <h4>E-mail:</h4>
                    <input className="login-data-input" type="text" placeholder="Enter your e-mail"/>
                    <h4>Password:</h4>
                    <input className="login-data-input" type="password" placeholder="Enter your password"/>

                    <button onClick={forgotPass}>forgot your password?</button>

                    <a href="#" className="button1">Login</a>
                </div>
            </div>
        </React.Fragment>
    );
}

export default SignIn;