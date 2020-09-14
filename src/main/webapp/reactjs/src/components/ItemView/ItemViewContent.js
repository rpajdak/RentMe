import React, {useState, useEffect} from "react";
import {useForm} from "react-hook-form";
import "../../css/item-view.css";
import "../../css/header-and-body.css"

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

    <div className="item-view-container">
        <div id="photos-name-price-container">
            <div className="main-item-photo-area">
                <div className="main-item-photo-container">
                    <div className="slideshow-container">
                        <div className="slides-container" >
                            <div className="mySlides1">
                                <img src={item.picUrl} />
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