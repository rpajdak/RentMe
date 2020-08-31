import React from "react";
import { Link } from "react-router-dom";
import "../../css/header-and-body.css";
import logoImg from "../../assets/logo.svg";
function Header() {
  return (
    <div className="header">
      <Link to="">
        <img id="logo" src={logoImg}></img>
      </Link>
      <div className="menu">
        <ul>

          <li>
            About
            <Link to="/about"></Link>
          </li>

          <li>
            <Link to="/login">
              <button type="text">Sign up</button>
            </Link>
          </li>

          <li>
            <Link to="/login">Sign in</Link>
          </li>
        </ul>
      </div>
    </div>
  );
}

export default Header;