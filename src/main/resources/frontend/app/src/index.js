import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/app/App';
import Feed from './components/feed/Feed';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import axios from "axios";
//const allUsersService = new AllUsersService();
//allUsersService.getAllUsers().then(res => console.log(res));

axios.defaults.headers.common = {};
axios.defaults.headers.common.accept = 'application/json';

ReactDOM.render(
    <React.StrictMode>
        <BrowserRouter>
            <Switch>
                <Route exact path='/' component={App}/>
                <Route path='/feed' component={Feed}/>
            </Switch>
        </BrowserRouter>
    
  </React.StrictMode>,
  document.getElementById('root')
);

