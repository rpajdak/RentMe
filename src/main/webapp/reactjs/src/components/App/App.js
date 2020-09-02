import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

import About from '../About/About'
import SignIn from '../SignIn/SignIn'
import RecoverAcc from '../RecoverAcc/RecoverAcc'
import ItemDetails from "../EditItem/ItemDetails";

import LandingPage from '../LandingPage/LandingPage'


function App() {
   return (
     <Router>
       <div className="App">
         <Switch>
           <Route path="/about" component={About}/>
           <Route path="/index" component={LandingPage}/>
           <Route path="/login" component={SignIn}/>
           <Route path="/account/recover" component={RecoverAcc}/>
           <Route path="/item/:id" exact component={ItemDetails}/>
           </Switch>
       </div>
     </Router>
   );
}

export default App;