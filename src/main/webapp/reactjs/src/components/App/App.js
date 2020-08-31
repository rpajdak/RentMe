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


function App() {
   return (
     <Router>
       <div className="App">
         <Switch>
           <Route path="/about" component={About}/>
         </Switch>
         <Switch>
           <Route path="/login" component={SignIn}/>
         </Switch>
         <Switch>
           <Route path="/account/recover" component={RecoverAcc}/>
         </Switch>
           <Switch>
               <Route path="/item/edit" component={ItemDetails}/>
           </Switch>
       </div>
     </Router>


   );
}

export default App;