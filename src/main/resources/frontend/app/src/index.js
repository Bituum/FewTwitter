import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/app/App';
import Feed from './components/feed/Feed';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import AllUsersService from './services/AllUsersService';

const allUsersService = new AllUsersService();
allUsersService.getAllUsers().then(res => console.log(res));

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

