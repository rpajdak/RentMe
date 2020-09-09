import React from "react";
import { Link } from "react-router-dom";
import "../../../css/header-and-body.css";
import logoImg from "../../../assets/logo.svg";

function Menu() {
  return (
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
                <Link to="/login">Sign in</Link>
              </li>
        </ul>
     </div>
  );
}

export default Menu;