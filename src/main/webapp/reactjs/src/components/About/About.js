import React from 'react';
import Header from '../Header/Header'
import AboutUsContent from '../AboutUsContent/AboutUsContent'
import "../../css/header-and-body.css";
import "../../css/about.css";

function About() {
    return (
        <React.Fragment>
            <Header />
            <AboutUsContent />
        </React.Fragment>
    );
}

export default About;