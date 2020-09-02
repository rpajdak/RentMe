import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

import About from '../About/About'
import LandingPage from '../LandingPage/LandingPage'


function App() {
   return (
     <Router>
       <div className="App">
         <Switch>
           <Route path="/about" component={About}/>
           <Route path="/index" component={LandingPage}/>
         </Switch>
       </div>
     </Router>
   );
}

export default App;