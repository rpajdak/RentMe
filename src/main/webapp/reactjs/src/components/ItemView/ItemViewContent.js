import React, {useState, useEffect} from "react";
import {useForm} from "react-hook-form";
import "../../css/item-view.css";
import "../../css/header-and-body.css"
import drill from "../../assets/drill.jpg";



function ItemViewContent(id) {

    const [itemId, setItemID] = useState(id.value);
    const [item, setItem] = useState([]);
    const [user, setUser] = useState([]);

    useEffect(() => {
        fetchItemDetails(itemId);
        fetchUserName(itemId)
    }, []);

    const fetchItemDetails = async (itemId) => {
        const response = await fetch(`http://localhost:8080/api/items/${itemId}`);
        const item = await response.json();
        setItem(item);
    }

    const fetchUserName = async (itemId) => {
        const response = await fetch(`http://localhost:8080/users/find-by/item/${itemId}`);
        const user = await response.json();
        setUser(user);
    }


    return(

    <div className="wrapper">

    <form className="search-form">
        <input type="text" className="item-search-field" placeholder="driller"/>
        <h4 className="search-nav">in</h4>
        <input type="text" className="distance-inputs" placeholder="Brussels"/>
            <h4 className="search-nav">within</h4>
            <select className="sorting-option-inputs-list"  required>
                <option value="1km">1km</option>
                <option value="3km">3km</option>
                <option value="5km">5km</option>
                <option value="10km">10km</option>
                <option value="30km">30km</option>
                <option value="100km">100km</option>
                <option value=">100km">>100km</option>
            </select>
    </form>

    <div className="item-view-container">
        <div id="photos-name-price-container">
            <div className="main-item-photo-area">
                <div className="main-item-photo-container">
                    <div className="slideshow-container">
                        <div className="slides-container" >
                            <div className="mySlides1">
                                <img src={drill} />
                            </div>
                        </div>
                        <a className="prev" onclick="plusSlides(-1, 0)">&#10094;</a>
                        <a className="next" onclick="plusSlides(1, 0)">&#10095;</a>
                    </div>
                </div>
            </div>
            <div id="item-name-price" >
                <p className="item-heading">{item.name}</p>
                <p className="item-heading-2">Price: {item.price} pln/day</p>
                <div className="calendar">
                    <p className="form-label">From :</p><input type="date" className="input-field start-date"/>

                    <p className="form-label">Until :</p><input type="date" className="input-field start-date"/>
                    <p className="price-estimation">Estimated price: 50 pln</p>
                </div>
            </div>
            <div className="description-renter-name">
                <button className="see-renter" type="submit">{user.firstName} {user.lastName}</button>
                <p className="item-heading-2 item-heading-description">Description</p>

                <p className="item-normal-text">{item.description}</p>
            </div>
            <div>
                <button className="button book-now" type="submit">Book now!</button>
            </div>
        </div>
    </div>
    </div>
    )
}

export default ItemViewContent;