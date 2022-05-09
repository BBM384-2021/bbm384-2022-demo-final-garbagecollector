import Home from './compenents/Home/Home';
import User from './compenents/User/User';
import Auth from './compenents/Auth/Auth'
import Navbar from './compenents/Navbar/Navbar';
import Register from './compenents/Auth/Register';

import './App.css';
import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom";
function App() {

  return (
    <div className="App">
      <BrowserRouter>
        {localStorage.getItem("currentUser") == null ? null : <Navbar ></Navbar>}
        <Switch>

          <Route exact path="/">
            {localStorage.getItem("currentUser") == null ? <Redirect to="/auth" /> : <Home />}
          </Route>

          <Route exact path='/users'>
            {localStorage.getItem("currentUser") == null ? <Redirect to="http://localhost:8080/auth" /> : <User />}
          </Route>

          <Route exact path="/auth">
            {localStorage.getItem("currentUser") != null ? <Redirect to="/" /> : <Auth />}
          </Route>
          <Route exact path="/register">
            {localStorage.getItem("currentUser") != null ? <Redirect to="/" /> : <Register />}
          </Route>

        </Switch>
      </BrowserRouter>
    </div>
  );
  /* return (
    <Navbar bg="light" expand="lg">
      <Container>
        <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#link">Link</Nav.Link>
            <NavDropdown title="Dropdown" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar> */


}

export default App;
