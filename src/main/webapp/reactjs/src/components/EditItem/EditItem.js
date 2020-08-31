import React from "react";
import {Link} from "react-router-dom"
import "../../css/edit-item.css"
import "../../css/add-item.css"
import "../../css/header-and-body.css"

function EditItem() {
    return (
    <div class="container">
        <h1 id="lets-get-started">Here you can edit your item</h1>
        <div class="inputs">
            <h4>Item name</h4>
            <input class="item-name" placeholder="Current item name"/>

            <h2>Item Info</h2>
            <h4><label htmlFor="quest-type">Category</label></h4>
            <select class="type-selector" id="quest-type" name="quest-type">
            </select>

            <h4>Description:</h4>
            <input class="item-description" type="text" placeholder="Describe your item..."/>

            <h2>Price</h2>

            <h4>Price (PLN/per day):</h4>
            <input class="item-price" placeholder="Current price per day"/>

            <h2>Address</h2>
            <h4>City:</h4>
            <input class="item-details" placeholder="Enter your city"/>
            <h4>Street with household number:</h4>
            <input class="item-details" placeholder="What is the address?"/>
            <h4>Post-code:</h4>
            <input class="item-details" placeholder="Post-code"/>
            <h4>Manage item's images</h4>
            <div class="input-image-grid">
                <div class="item-photo-container" type="button" href="#">

                </div>
                <div class="item-photo-container">

                </div>
                <div class="item-photo-container">

                </div>
                <div class="item-photo-container 4">

                </div>
                <div class="item-photo-container 5">

                </div>
                <div class="item-photo-container 6">

                </div>
                <div class="add-item-photo-container 7">

                </div>
            </div>
        </div>
        <div class="submit-button">
            <button class="button" type="submit">Update Item</button>
        </div>

    </div>
    );
}

export default EditItem;
