import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

import About from '../About/About'

import ItemDetails from "../EditItem/ItemDetails";
import Login from '../Login/Login'
import RecoverAcc from '../RecoverAcc/RecoverAcc'
import LandingPage from '../LandingPage/LandingPage'


function App() {
   return (
     <Router>
       <div className="App">
         <Switch>
           <Route path="/about" component={About}/>
           <Route path="/" exact component={LandingPage}/>
           <Route path="/index" component={LandingPage}/>
           <Route path="/account/recover" component={RecoverAcc}/>
           <Route path="/item/:id" exact component={ItemDetails}/>
           <Route path="/login" component={Login}/>
         </Switch>
       </div>
     </Router>
   );
}

export default App;