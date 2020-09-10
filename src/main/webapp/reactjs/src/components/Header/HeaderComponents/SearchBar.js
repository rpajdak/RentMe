import React, {useState} from "react";
import "../../../css/header-and-body.css";



function SearchBar(props) {

    let [phrase, setPhrase] = useState();



    function redirect(){
        return window.location.redirect('localhost:8080/items-list/dupa');
    }

    function handleChange(event) {
        setPhrase(event.target.value);
    }

  return (
    <form className="search-form" onSubmit={redirect}>
        <input type="search"
               className="item-search-field"
               placeholder={props.SearchPhrasePassedToSearchBar}
               onChange={handleChange}/>
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
        <input className="searchbar-hidden-submit-button" type="submit"/>
    </form>
  );
}

export default SearchBar;