import React from "react";
import { Link } from "react-router-dom";
import "../../css/header-and-body.css";
import closeIcon from "../../assets/close-window.svg"


function RecoverAcc() {
  return (
    <div className="popup2">
    <div className="popup-content2">
        <h3>Enter your e-mail</h3>
        <Link className="close2" to="">
        <img className="close2" src={closeIcon}/>
        </Link>
        <h4>If you have forgotten your account password please enter your e-mail
            and we will send you a password change code.</h4>
        <h4 className="description">E-mail:</h4>
        <input className="login-data-input2" type="text" placeholder="Enter your e-mail"/>
        <a href="#" className="button12">Send me new password</a>
    </div>
   </div>
  );
}

export default RecoverAcc;