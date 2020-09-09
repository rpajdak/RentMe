import React from "react";
import {Link} from "react-router-dom";
import "../../css/header-and-body.css";
import logoImg from "../../assets/logo.svg";
import Login from "../Login/Login";

function Header() {


    function renderForm() {
        return (
            <Login/>
        )
    }

    function showLogin() {
        fadeOut("wrapper", 15)
        document.querySelector(".wrapper").style.display = "none";
        document.querySelector(".popup").style.display = "flex";
        fadeIn("popup", 35)
    }

    // function hideLogin() {
    //     document.querySelector(".close").addEventListener("click", function () {
    //         document.querySelector(".wrapper").style.display = "block";
    //         fadeIn("wrapper", 75)
    //         document.querySelector(".popup").style.display = "none";
    //
    //
    //     })
    // }

    function forgotPass() {
        document.getElementById("forg").addEventListener("click", function () {
            document.querySelector(".wrapper").style.opacity = "0";
            document.querySelector(".popup").style.display = "none";
            document.querySelector(".popup2").style.display = "flex";
        })
    }

    function forgotPassHide() {
        document.querySelector(".close2").addEventListener("click", function () {
            document.querySelector(".wrapper").style.display = "flex";
            fadeIn("wrapper", 75)
            document.querySelector(".popup").style.display = "none";
            document.querySelector(".popup2").style.display = "none";

        })
    }

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

    return (
        <React.Fragment>
            <Login/>
            <div className="header">
                <Link to="">
                    <img id="logo" src={logoImg}></img>
                </Link>

                <div className="menu">
                    <ul>

                        <li>
                            <Link to="/about">About</Link>
                        </li>

                        <li>
                            <Link to="/login">
                                <button type="text">Sign up</button>
                            </Link>
                        </li>

                        <li>
                            <button onClick={showLogin}>Sign in</button>
                        </li>
                    </ul>
                </div>
            </div>
        </React.Fragment>
    );

import Menu from "./HeaderComponents/Menu";

function Header() {
  return (
    <div className="header">
        <Menu />
    </div>
  );
}

export default Header;