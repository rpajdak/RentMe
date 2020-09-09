import React, {useState, useEffect} from "react";
import Header from '../Header/Header'
import AddItem from "./AddItem";

function AddItemStructure() {

    return (
        <React.Fragment>
            <Header/>
            <AddItem/>
        </React.Fragment>
    );
}

export default AddItemStructure