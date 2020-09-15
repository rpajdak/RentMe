import React, {useState, useEffect} from "react";
import {useForm} from "react-hook-form";
import "../../css/item-view.css";
import "../../css/header-and-body.css"

function ItemViewContent(id) {

    const [itemId, setItemID] = useState(id.value);
    const [item, setItem] = useState([]);
    const [user, setUser] = useState([]);
    let [estimatedPrice, setEstimatedPrice] = useState(0);


    useEffect(() => {
        fetchItemDetails(itemId);
        fetchUserName(itemId)
    }, []);

    const fetchItemDetails = async (itemId) => {
        const response = await fetch(`http://localhost:8080/api/items/${itemId}`);
        const item = await response.json();
        console.log(item);
        setItem(item);
    }

    const fetchUserName = async (itemId) => {
        const response = await fetch(`http://localhost:8080/users/find-by/item/${itemId}`);
        const user = await response.json();
        setUser(user);
    }

    function getDays() {
        let start = document.querySelector(".start-date").value.split('-');
        let end = document.querySelector(".end-date").value.split('-');

        let startDate = new Date(start[0], start[1] - 1, start[2]);
        let endDate = new Date(end[0], end[1] - 1, end[2]);

        let startDateMiilisec = startDate.getTime();
        let endDateMiilisec = endDate.getTime();

        const oneDayMilisec = 24 * 60 * 60 * 1000;

        let diffInDays = Math.abs((startDateMiilisec - endDateMiilisec) / oneDayMilisec) + 1;
        return diffInDays;
    }

    function calculatePrice() {
        let days = getDays();
        let price = item.price;
        let estimatedPrice = days * price;
        if (!isNaN(estimatedPrice)) {
            setEstimatedPrice(days * price);
        }
    }

    return (

        <div className="wrapper">
            <div className="item-view-container">
                <div id="photos-name-price-container">
                    <div className="main-item-photo-area">
                        <div className="main-item-photo-container">
                            <div className="slideshow-container">
                                <div className="slides-container">
                                    <div className="mySlides1">
                                        <img alt="item-image" src={item.picUrl}/>
                                    </div>
                                </div>
                                <a className="prev" onClick="plusSlides(-1, 0)">&#10094;</a>
                                <a className="next" onClick="plusSlides(1, 0)">&#10095;</a>
                            </div>
                        </div>
                    </div>
                    <div id="item-name-price">
                        <p className="item-heading">{item.name}</p>
                        <p className="item-heading-2">Price: {item.price} pln/day</p>
                        <form onChange={calculatePrice}>
                            <div className="calendar">
                                <p className="form-label">From :</p><input type="date"
                                      className="input-field start-date"/>
                                <p className="form-label">Until :</p><input type="date"
                                      className="input-field end-date"/>
                                <p className="price-estimation">Estimated price: {estimatedPrice} pln</p>
                            </div>
                        </form>
                    </div>
                    <div className="description-renter-name">
                        <button className="see-renter" type="submit">{user.firstName} {user.lastName}</button>
                        <p className="item-heading-2 item-heading-description">Description</p>

                        <p className="item-normal-text">{item.description}</p>
                    </div>
                    <div>
                        <button className="button book-now" type="submit">Rent Me!</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ItemViewContent;