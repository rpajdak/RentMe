import React from "react";
import { Link, qs } from "react-router-dom";
import "../../../css/header-and-body.css";
import logoImg from "../../../assets/logo.svg";

function SearchBar(props) {

  return (
    <form class="search-form" action="/items-list/">
        <input type="text" class="item-search-field" placeholder={props.SearchPhrasePassedToSearchBar}/>
        <h4>in</h4>
        <input type="text" class="distance-inputs" placeholder="Brussels"/>
        <h4>within</h4>
        <select className="sorting-option-inputs-list" required>
            <option value="1km">1km</option>
            <option value="3km">3km</option>
            <option value="5km">5km</option>
            <option value="10km">10km</option>
            <option value="30km">30km</option>
            <option value="100km">100km</option>
            <option value=">100km">+100km</option>
        </select>
    </form>
  );
}

export default SearchBar;