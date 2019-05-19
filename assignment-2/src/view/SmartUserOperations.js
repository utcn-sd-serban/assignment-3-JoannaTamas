import UserOperations from "./UserOperations";
import userOperationsPresenter from "../presenter/userOperationsPresenter";
import React, { Component } from "react";
//import  modelQuestion from "../model/modelQuestion";




export default class SmartUserOperations extends Component {
  

    render() {
        return (
            <UserOperations
                onAddQuestion    ={userOperationsPresenter.onAddQuestion}
                onListQuestions  ={userOperationsPresenter.onListQuestions}
                onFilterQuestions={userOperationsPresenter.onFilterQuestions}
                
                 />
        );
    }
}