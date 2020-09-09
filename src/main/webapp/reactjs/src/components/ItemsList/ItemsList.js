import React, {useState, useEffect} from "react";
import Header from '../Header/Header'
import ItemsListContent from "./ItemsListContent"

function ItemsList({match}) {

    const [searchPhrase, setSearchPhrase] = useState(match.params.searchPhrase);

    return (
        <React.Fragment>
            <Header/>
            <ItemsListContent value={searchPhrase}/>
        </React.Fragment>
    );
}

export default ItemsList;