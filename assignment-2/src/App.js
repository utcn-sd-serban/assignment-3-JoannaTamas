    
import React from 'react';
import './App.css';

import { HashRouter, Switch, Route } from "react-router-dom";
import SmartQuestionsList from './view/SmartQuestionsList';
import SmartCreateQuestion from './view/SmartCreateQuestion';
import SmartLoginUser from './view/SmartLoginUser';
import SmartUserOperations from './view/SmartUserOperations';
import SmartFilterQuestions from './view/SmartFilterQuestions';


const App = () => (
  <div className="App">
    <HashRouter>
      <Switch>
        <Route exact={true} component={SmartLoginUser} path="/" />
        <Route exact={true} component={SmartUserOperations} path="/user-operations" />
        <Route exact={true} component={SmartQuestionsList} path="/questions-list" />
        <Route exact={true} component={SmartFilterQuestions} path="/filter-questions" />
        <Route exact={true} component={SmartCreateQuestion} path="/create-question" />
      
      </Switch>
    </HashRouter>
  </div>
);


export default App;