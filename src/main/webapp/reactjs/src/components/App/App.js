import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

import About from '../About/About'
import Login from '../Login/Login'
import RecoverAcc from '../RecoverAcc/RecoverAcc'
import LandingPage from '../LandingPage/LandingPage'


function App() {
   return (
     <Router>
       <div className="App">
         <Switch>
           <Route path="/about" component={About}/>
           <Route path="/index" component={LandingPage}/>
         </Switch>
         <Switch>
           <Route path="/login" component={Login}/>
         </Switch>
         <Switch>
           <Route path="/account/recover" component={RecoverAcc}/>
         </Switch>
       </div>
     </Router>
   );
}

export default App;