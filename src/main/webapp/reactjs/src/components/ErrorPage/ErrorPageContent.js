import React from "react";
import { Link } from "react-router-dom";
import "../../css/header-and-body.css";
import "../../css/about.css";
import logoImg from "../../assets/logo.svg";

function ErrorPageContent() {
  return (
    <div>
      <div className="header">
        <Link to="">
          <img id="logo" src={logoImg}></img>
        </Link>
      </div>
      <div className="page-content wrapper">
        <div className="main-container">
            <div className="description"></div>
                <h1>Error page</h1>
                <h3>
                Something went wrong, or the page you're looking for doesn't exist.
                </h3>
                <h4>
                  Click on the logo to go back.
                </h4>
        </div>
      </div>
    </div>
  );
}

export default ErrorPageContent;










