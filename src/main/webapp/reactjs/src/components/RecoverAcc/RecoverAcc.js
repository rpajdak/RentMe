import React from "react";
import {Link} from "react-router-dom";
import "../../css/header-and-body.css";
import closeIcon from "../../assets/close-window.svg"
import {useForm} from "react-hook-form";

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

    const {register, handleSubmit, errors} = useForm();

    const onSubmit = (data) => {
        console.log(data)
    };

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <div className="popup2">
                <div className="popup-content2">
                    <h3>Enter your e-mail</h3>
                    <img className="close2" onClick={forgotPassHide} src={closeIcon}/>
                    <h4>If you have forgotten your account password please enter your e-mail
                        and we will send you a password change code.</h4>
                    <h4 className="description">E-mail:</h4>
                    <input className="login-data-input2" type="text" placeholder="Enter your e-mail" name="email"
                           ref={register({
                               required: "Required",
                               pattern: {
                                   value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                                   message: "invalid email address"
                               }
                           })}/>
                    {errors.email && <p>You need to enter valid email address.</p>}
                    <button className="loginRecBtn"> Send me new password</button>
                </div>
            </div>
        </form>
    );
}

export default RecoverAcc;