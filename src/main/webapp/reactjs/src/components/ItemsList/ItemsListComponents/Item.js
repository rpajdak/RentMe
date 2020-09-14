import React, {useEffect, useState} from "react";
import { Link } from "react-router-dom";
import "../../../css/header-and-body.css";

function Item(props) {

    return (
        <div class="items-list-item">
            <div class="item-photo-container">
                  <img class="items-list-item-photo"  src={props.item.picUrl}/>
            </div>
            <div class="items-list-item-info-area">
                <div class="items-list-item-info">
                    <p class="items-list-item-name">{props.item.name}</p>
                    <p class="items-list-item-price">Price: {props.item.price} pln/day</p>
                    <p class="items-list-item-location">Location: {props.item.location}</p>
                </div>
            </div>
        </div>
    );
}

export default Item;