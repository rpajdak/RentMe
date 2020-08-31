import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

import About from '../About/About'
import FetchCategories from "../item-details/FetchCategories";
import EditItem from "../Edit-Item/EditItem";


function App() {
   return (
     <Router>
       <div className="App">
         <Switch>
           <Route path="/about" component={About}/>
         </Switch>
       </div>

         <div>
             <Route path="/edit/item" component={EditItem}/>
         </div>
     </Router>
   );
}

export default App;