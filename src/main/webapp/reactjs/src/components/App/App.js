import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
  Link,
} from "react-router-dom";

import About from '../About/About'
import ItemDetails from "../EditItem/ItemDetails";
import Login from '../Login/Login'
import RecoverAcc from '../RecoverAcc/RecoverAcc'
import LandingPage from '../LandingPage/LandingPage'
import AddItemStructure from "../AddItem/AddItemStructure";
import ErrorPage from '../ErrorPage/ErrorPage'
import ItemsList from '../ItemsList/ItemsList'
import ItemView from "../ItemView/ItemView";

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
           <Route path="/item" exact component={AddItemStructure}/>
           <Route path="/item/view/:id" exact component={ItemView}/>
           <Route path="/login" component={Login}/>
           <Route path="/items-list/:searchPhrase" component={ItemsList}/>
           <Route path="*" component={ErrorPage} />
         </Switch>
       </div>
     </Router>
   );
}

export default App;