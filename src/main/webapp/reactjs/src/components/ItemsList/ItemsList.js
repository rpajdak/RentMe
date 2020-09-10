import React, {useState, useEffect} from "react";
import Header from '../Header/Header'
import ItemsListContent from "./ItemsListContent"
import Login from "../Login/Login";

function ItemsList({match}) {

    const [searchPhrase, setSearchPhrase] = useState(match.params.searchPhrase);

    return (
        <div>
            <Login />
            <div className="wrapper">
                <Header/>
                <ItemsListContent value={searchPhrase}/>
            </div>
        </div>
    );
}

export default ItemsList;