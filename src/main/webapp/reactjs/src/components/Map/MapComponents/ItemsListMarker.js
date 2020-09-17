import React from 'react';
import Pointer from "../../../assets/pointer-price.svg"

const ItemsListMarker = ({price}) => {
    return (
        <div style={{ height: '50px', width: '50px'}}>
            <p style={{ height: '40px', width: '40px', position: 'absolute', left: '17px'}}> {price} </p>
            <img src={Pointer}/>
        </div>
    );
};

export default ItemsListMarker;