import React from 'react';
import "../../css/header-and-body.css";
import "../../css/index.css";
import logo from "../../assets/logo-with-slogan.svg"
import scrollDownArrows from "../../assets/scroll-down-arrows.svg"
import cameraJpg from "../../assets/camera.jpg"
import homeEquipmentJpg from "../../assets/home-equipment.jpg"
import adventureJpg from "../../assets/adventure.jpg"
import scooterJpg from "../../assets/scooter.jpg"
import instrumentsJpg from "../../assets/instruments.png"


function LandingPageContent() {
    return (
        <div>
            <div className="landing-page-header">
                <div className="menu">
                    <ul>using javascript 
                        <li><a href="about.html">About us</a></li>
                        <li><a href="sign-up.html"><button type="button">Sign up</button></a></li>
                        <li><a href="#" id="sign-in">Sign in</a></li>
                    </ul>
                </div>
            </div>
            <div className="area-of-logo-with-options">
                <img id="logo-with-slogan" src={logo}/>
                <div id="options">
                    <form id="search-form">
                        <input type="text" id="search-field" placeholder="browse items..."/>
                    </form>
                    <p className="or">or</p>
                    <a href="add-item.html"><button id="list-item-button">LIST ITEM</button></a>
                </div>
            </div>

            <div id="see-categories-sign">
                <p id="see-categories"><a href="#categories-area">see categories</a></p>
                <img id="scroll-down-arrows" src={scrollDownArrows}/>
            </div>

            <div id="categories-area">
                <div className="categories">
                <div className="category">
                        <div className="category-image-container">
                            <a href="#"> <img className="category-image" src={cameraJpg}/></a>
                        </div>
                        <div className="category-name">
                            CAMERAS
                        </div>
                    </div>
                    <div className="category">
                        <div className="category-image-container">
                            <a href="#"><img className="category-image" src={homeEquipmentJpg}/></a>
                        </div>
                        <div className="category-name">
                            HOME EQUIPMENT
                        </div>
                    </div>
                    <div className="category">
                        <div className="category-image-container">
                            <a href="#"> <img className="category-image" src={adventureJpg}/></a>
                        </div>
                        <div className="category-name">
                            ADVENTURE
                        </div>
                    </div>
                    <div className="category">
                        <div className="category-image-container">
                            <a href="#">   <img className="category-image" src={scooterJpg}/></a>
                        </div>
                        <div className="category-name">
                            SCOOTERS
                        </div>
                    </div>
                    <div className="category">
                        <div className="category-image-container">
                            <a href="#">  <img className="category-image" src={instrumentsJpg}/></a>
                        </div>
                        <div className="category-name">
                            INSTRUMENTS
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default LandingPageContent;