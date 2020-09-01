import React, {useState, useEffect} from "react";
import Header from '../Header/Header'
import EditItem from "./EditItem";

function ItemDetails({match}) {

    const [itemIdValue, setItemID] = useState(match.params.id);

    return (
        <React.Fragment>
            <Header/>
            <EditItem value={itemIdValue}/>
        </React.Fragment>
    );
}

export default ItemDetails;