import React, { Component } from 'react';
import {useState, useEffect} from "react";
import GoogleMapReact from 'google-map-react';

function SimpleMap (props) {

    const AnyReactComponent = ({ text }) => <div>{text}</div>;

      const defaultProps = {
        zoom: 4
      };

      const japierdole = props.lat + props.lat;

      console.log(japierdole);


  return (
      // Important! Always set the container height explicitly

      <div style={{ height: '500px', width: '900px'}}>
        <GoogleMapReact
          bootstrapURLKeys={{ key: ""}}
          defaultCenter={{lat:100, lng:20}}
          defaultZoom={defaultProps.zoom}
        >
          <AnyReactComponent
            lat={props.lat}
            lng={props.lon}
            text="My Marker"
          />
        </GoogleMapReact>
      </div>
    );
  }


export default SimpleMap;