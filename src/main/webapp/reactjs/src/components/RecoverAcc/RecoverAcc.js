import React from "react";
import {Link} from "react-router-dom";
import "../../css/header-and-body.css";
import closeIcon from "../../assets/close-window.svg"

function forgotPassHide() {
    document.querySelector(".wrapper").style.display = "flex";
    fadeIn("wrapper", 75)
    document.querySelector(".popup").style.display = "none";
    document.querySelector(".popup2").style.display = "none";
}

function fadeIn(element, duration) {
    let i = 0;
    let wrapper = document.getElementsByClassName(element)[0];
    wrapper.style.opacity = 0;
    let k = window.setInterval(function () {
        if (i >= 10) {
            clearInterval(k)
            wrapper.style.opacity = 1;
        } else {
            wrapper.style.opacity = i / 10;
            i++;
        }
    }, duration);
}

function RecoverAcc() {
    return (
        <div className="popup2">
            <div className="popup-content2">
                <h3>Enter your e-mail</h3>
                <img className="close2" onClick={forgotPassHide} src={closeIcon}/>
                <h4>If you have forgotten your account password please enter your e-mail
                    and we will send you a password change code.</h4>
                <h4 className="description">E-mail:</h4>
                <input className="login-data-input2" type="text" placeholder="Enter your e-mail"/>
                <button className="loginRecBtn"> Send me new password</button>
            </div>
        </div>
    );
}

export default RecoverAcc;