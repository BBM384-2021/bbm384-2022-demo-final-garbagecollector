import Home from './compenents/Home/Home';
import User from './compenents/User/User';
import Navbar from './compenents/Navbar/Navbar';

import './App.css';
import { BrowserRouter, Switch, Route } from "react-router-dom";
function App() {
 
    
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar></Navbar>
        <Switch>
          <Route exact path='/' component={Home}></Route>
          <Route exact path='/users/:userId' component={User}></Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
