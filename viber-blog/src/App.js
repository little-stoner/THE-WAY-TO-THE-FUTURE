import React from 'react';
import logo from './kobe.jpg';
import './App.css';
import './Vi.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

import VI from './components/vi.js'
import SHELF from './components/shelf.js'
import COOK from './components/cook.js'

function App() {
    return (
        <Router>                
          <div className="App">
            <nav className="App-nav">
              <ul>
                <li><Link to="/vi">VI</Link></li>
                <li><Link to="/shelf">Shelf</Link></li>
                <li><Link to="/cook">Cook</Link></li>
              </ul>
            </nav>
            <Switch>
              <Route exact path="/">
                <header className="App-header">
                  <img src={logo} className="App-logo" alt="logo" />
                  <p>GIVE ALL YOU HAVE</p>
                </header>
              </Route>              
              <Route path="/vi">
                <VI />
              </Route>
              <Route path="/shelf">
                <SHELF />
              </Route>
              <Route path="/cook">
                <COOK />
              </Route>          
            </Switch>
          </div>
        </Router>                      
  );
}

export default App;
