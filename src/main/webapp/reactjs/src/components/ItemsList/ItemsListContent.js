import React, {useState, useEffect} from "react";
import "../../css/edit-item.css"
import "../../css/add-item.css"
import "../../css/header-and-body.css"
import "../../css/map.css"
import "../../css/items-list.css"

import HeaderWithLogoAndSearchBar from "../Header/HeaderWithLogoAndSearchBar";
import Item from "./ItemsListComponents/Item"
import SortingOptions from "./ItemsListComponents/SortingOptions"

import Plane from "./plane.jpg"

function ItemsListContent(searchPhrase) {

    const [searchPhraseContent, setSearchPhrase] = useState(searchPhrase.phrase);

    const [fetchedItems, setItems] = useState([]);

    useEffect(() => {fetchItems(searchPhrase)}, []);

    const fetchItems = async () => {
        if (searchPhraseContent.startsWith("category:")) {
            const categoryToBrowse = searchPhraseContent.slice(9)
            const response = await fetch(`http://localhost:8080/api/items/list/ofCategory/${searchPhraseContent}`);
            const items = await response.json();
            setItems(items);
        }
        else{
            const response = await fetch(`http://localhost:8080/api/items/list/${searchPhraseContent}`);
            const items = await response.json();
            setItems(items);
        }



    }

//    function map () {
//
//        src="https://maps.googleapis.com/maps/api/js?key=&callback=initMap"
//
//        var responsiveZoom = (window.innerWidth < 768) ? 6.75 : 7.75;
//
//            function initMap() {
//                var myLatlng = new google.maps.LatLng(50.7974444, 4.48544);
//                var mapOptions = {
//                    styles: [
//                        {
//                            "elementType": "geometry",
//                            "stylers": [
//                                {
//                                    "color": "#f5f5f5"
//                                }
//                            ]
//                        },
//                        {
//                            "elementType": "labels.icon",
//                            "stylers": [
//                                {
//                                    "color": "#f5f5f5"
//                                }
//                            ]
//                        },
//                        {
//                            "elementType": "labels.text.fill",
//                            "stylers": [
//                                {
//                                    "color": "#616161"
//                                }
//                            ]
//                        },
//                        {
//                            "elementType": "labels.text.stroke",
//                            "stylers": [
//                                {
//                                    "color": "#f5f5f5"
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "administrative.country",
//                            "elementType": "geometry.stroke",
//                            "stylers": [
//                                {
//                                    "color": "#00338D"
//                                },
//                                {
//                                    "visibility": "on"
//                                },
//                                {
//                                    "weight": 2
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "administrative.land_parcel",
//                            "elementType": "labels.text.fill",
//                            "stylers": [
//                                {
//                                    "color": "#bdbdbd"
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "poi",
//                            "elementType": "labels",
//                            "stylers": [
//                                {
//                                    "visibility": "off"
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "road",
//                            "elementType": "geometry",
//                            "stylers": [
//                                {
//                                    "color": "#ffffff"
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "road.arterial",
//                            "elementType": "labels.text.fill",
//                            "stylers": [
//                                {
//                                    "color": "#757575"
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "road.highway",
//                            "elementType": "geometry",
//                            "stylers": [
//                                {
//                                    "color": "#dadada"
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "road.highway",
//                            "elementType": "labels.text.fill",
//                            "stylers": [
//                                {
//                                    "color": "#616161"
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "road.local",
//                            "elementType": "labels.text.fill",
//                            "stylers": [
//                                {
//                                    "color": "#9e9e9e"
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "water",
//                            "elementType": "geometry.fill",
//                            "stylers": [
//                                {
//                                    "color": "#bbdefb"
//                                }
//                            ]
//                        },
//                        {
//                            "featureType": "water",
//                            "elementType": "labels.text.fill",
//                            "stylers": [
//                                {
//                                    "color": "#9e9e9e"
//                                }
//                            ]
//                        }
//                    ],
//                    zoom: responsiveZoom,
//                    minZoom: 6,
//                    maxZoom: 17,
//                    zoomControl: true,
//                    zoomControlOptions: {
//                        style: google.maps.ZoomControlStyle.DEFAULT
//                    },
//                    center: myLatlng,
//                    mapTypeId: google.maps.MapTypeId.ROADMAP,
//                    scrollwheel: false,
//                    panControl: false,
//                    mapTypeControl: false,
//                    scaleControl: false,
//                    streetViewControl: false,
//                    overviewMapControl: false,
//                    rotateControl: false
//                };
//                var map = new google.maps.Map(
//                    document.getElementById("map-canvas"),
//                    mapOptions
//                );
//
//                // BRUSSELS
//                var markerGPBrussels = new google.maps.Marker({
//                    position: new google.maps.LatLng(50.846759, 4.352446),
//                    map: map,
//                    title: "Click here for Brussels Grand-Place details",
//                    icon: "http://maps.google.com/mapfiles/ms/icons/blue-dot.png"
//                });
//                google.maps.event.addListener(markerGPBrussels, "click", function() {
//                    hideInfo();
//                    showInfo(".brussels");
//                    map.panTo(this.getPosition());
//                    map.setZoom(16);
//                });
//
//                // ANTWERP
//                var markerGPAntwerp = new google.maps.Marker({
//                    position: new google.maps.LatLng(51.221296, 4.399885),
//                    map: map,
//                    title: "Click here for Antwerp Grand-Place details",
//                    icon: "http://maps.google.com/mapfiles/ms/icons/blue-dot.png"
//                });
//                google.maps.event.addListener(markerGPAntwerp, "click", function() {
//                    hideInfo();
//                    showInfo(".antwerp");
//                    map.panTo(this.getPosition());
//                    map.setZoom(16);
//                });
//
//                // NAMUR
//                var markerGPNamur = new google.maps.Marker({
//                    position: new google.maps.LatLng(50.463110, 4.867437),
//                    map: map,
//                    title: "Click here for Namur Grand-Place details",
//                    icon: "http://maps.google.com/mapfiles/ms/icons/blue-dot.png"
//                });
//                google.maps.event.addListener(markerGPNamur, "click", function() {
//                    hideInfo();
//                    showInfo(".namur");
//                    map.panTo(this.getPosition());
//                    map.setZoom(16);
//                });
//
//                // back to offices overview
//                document.querySelector("#map-overview").addEventListener("click", function() {
//                    map.panTo(myLatlng);
//                    map.setZoom(responsiveZoom);
//                    hideInfo();
//                });
//
//                window.addEventListener("resize", function() {
//                    if (window.innerWidth < 768) responsiveZoom = 6.75
//                    else if (window.innerWidth > 768) responsiveZoom = 7.75
//                    map.setZoom(responsiveZoom);
//                });
//            }
//
//            function showInfo(selector) {
//                document.querySelector(selector).classList.add("shown");
//                document.querySelector("#map-canvas").classList.add("zoomed");
//                document.querySelector("#map-overview").classList.remove("hidden");
//            }
//
//            function hideInfo() {
//                if (document.querySelector(".shown")) {
//                    document.querySelector(".shown").classList.remove("shown");
//                }
//                document.querySelector("#map-canvas").classList.remove("zoomed");
//                document.querySelector("#map-overview").classList.add("hidden");
//            }
//
//            //----- popup login window ------
//            document.getElementById("sign-in").addEventListener("click", function () {
//                document.querySelector(".popup").style.display="flex";
//            })
//
//            document.querySelector(".close" ).addEventListener("click", function () {
//                document.querySelector(".popup").style.display="none";
//            })
//        }

    return (
        <div>
                <HeaderWithLogoAndSearchBar SearchPhrasePassedToHeader={searchPhraseContent}/>
                <div id="items-area">
                    <SortingOptions/>
                    <div className="items-list">
                        {fetchedItems.map(theItem => <Item item={theItem} />)}
                    </div>
                </div>
                <div className="map-wrapper">
                    <div className="sub-map-wrapper">
                        <div className="map-container">
                        {/*<div id="map-overview" class="hidden">Back to map</div>*/}
                        {/*<div id="map-canvas"></div>*/}

                        {/*<div id="map-info">*/}
                        {/*    <div class="gp brussels">*/}
                        {/*        <h2>Brussels Grand Place</h2>*/}
                        {/*        <img class="marker-photo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Grand-Place%2C_Brussels_-_panorama%2C_June_2018.jpg/800px-Grand-Place%2C_Brussels_-_panorama%2C_June_2018.jpg" alt="Grand Place Brussels"/>*/}
                        {/*        <p>The Grand Place or Grote Markt is the central square of Brussels. It is surrounded by opulent guildhalls and two larger edifices, the city's Town Hall, and the King's House or Breadhouse building containing the Brussels City Museum.</p>*/}
                        {/*        <p>The Grand Place is the most important tourist destination and most memorable landmark in Brussels. It is also considered as one of the most beautiful squares in Europe, and has been a UNESCO World Heritage Site since 1998.</p>*/}
                        {/*        <p><a href="https://fr.wikipedia.org/wiki/Place_d%27Armes_(Namur)" targe="_blank">More info</a></p>*/}
                        {/*    </div>*/}

                        {/*    <div class="gp antwerp">*/}
                        {/*        <h2>Antwerp Grand Place</h2>*/}
                        {/*        <img class="marker-photo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Grote_Markt_%28Antwerpen%29.jpg/800px-Grote_Markt_%28Antwerpen%29.jpg" alt="Grand Place Antwerp"/>*/}
                        {/*        <p>The Grote Markt ("Great Market Square") of Antwerp is a town square situated in the heart of the old city quarter. It is filled with an extravagant city hall, numerous elaborate 16th century guildhalls, many restaurants and cafés. Lying within walking distance of the Scheldt river, it hosts a Christmas market and ice rink in winter.</p>*/}
                        {/*        <p><a href="https://en.wikipedia.org/wiki/Grote_Markt_(Antwerp)" target="_blank">More info</a></p>*/}
                        {/*    </div>*/}

                        {/*    <div class="gp namur">*/}
                        {/*        <h2>Namur Grand Place</h2>*/}
                        {/*        <img class="marker-photo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Namur_2007_04.JPG/800px-Namur_2007_04.JPG" alt="Grand Place Namur"/>*/}
                        {/*        <p>The Place d'Armes, formerly Grand Place is a cobbled square located in Namur in Belgium. Located in the center of a fortification, a place of arms is the gathering place of a small troop and a central space hosting important ceremonies of military life.</p>*/}
                        {/*        <p><a href="https://fr.wikipedia.org/wiki/Place_d%27Armes_(Namur)" targe="_blank">More info</a></p>*/}
                        {/*    </div>*/}
                        {/*</div>*/}

                        </div>
                    </div>
                </div>
        </div>
    );
}

export default ItemsListContent;
