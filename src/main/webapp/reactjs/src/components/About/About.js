import React from 'react';
import Header from '../Header/Header'
import AboutUsContent from '../AboutUsContent/AboutUsContent'
import Login from "../Login/Login";
import "../../css/header-and-body.css";
import "../../css/about.css";


function About() {
    return (
        <div>
            <Login />
            <div className="wrapper">
                <Header />
                <AboutUsContent />
            </div>
        </div>
    );
}

export default About;