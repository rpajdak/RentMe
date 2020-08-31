import React from "react";
import {Link} from "react-router-dom"
import "../../css/header-and-body.css"
import logoImg from "../../assets/logo.svg"
function Header() {

    
    return (
        <div className="header">   

        <Link to="">
        <img id="logo" src={logoImg}></img>
        </Link>
        <div className='menu'>   
        <ul>
        
        <Link to="/about">
            <li>About</li>
        </Link>
        
        <Link to="/signUp">
            <li>
                <button type="text">
            Sign up
                </button>
            </li>
        </Link>
        
        <Link to="/signIn">
            <li>Sign in</li>
        </Link>
        
        </ul>
        </div>
        </div>
    );
}

export default Header;



// {/* <div class="header ">
//     <a  href="index.html"><img id="logo" src="../assets/logo.svg"></a>
//     <div class="menu">
//         <ul>
//             <Link to="/about">
//             <li><a href="#">About</a></li>
//             </Link>
//             <li><a href="sign-up.html"><button type="button">Sign up</button></a></li>
//             <li><a href="#" id="sign-in">Sign in</a></li>
//         </ul>
//     </div>
// </div> */}