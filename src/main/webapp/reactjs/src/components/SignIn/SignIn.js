import React from "react";
import { Link } from "react-router-dom";
import "../../css/header-and-body.css";
import closeIcon from "../../assets/close-window.svg"


function SignIn() {
  return (
    <div className ="popup">
    <div className="popup-content">
        <h3>Sign in</h3>
       
        <Link className="close" to="">
        <img className="close" src={closeIcon}/>
        </Link>
        <h4>E-mail:</h4>
        <input className="login-data-input" type="text" placeholder="Enter your e-mail"/>
        <h4>Password:</h4>
        <input className="login-data-input"  type="password" placeholder="Enter your password"/>
        <h5>
            <Link to="account/recover" id="forg">
                forgot your password?
            </Link>
        </h5>
        <a href="#" className="button1">Login</a>
    </div>
</div>
  );
}

export default SignIn;