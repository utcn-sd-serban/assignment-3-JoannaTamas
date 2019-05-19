import React from "react";
import 'bootstrap/dist/css/bootstrap.css';


const UserOperations = ({title1, onAddQuestion, onListQuestions,onFilterQuestions}) => (
    <div class="jumbotron jumbotron-fluid">  

   
    <div class="container ">   
    <div class="alert alert-success ">
   
            Login successfully
    </div>
    <div class="btn-group-vertical">
   
        <br />
        <br />
        <h2>{ title1 || "Choose Operation" }</h2>
       
        <button type="button" class="btn btn-warning" onClick={onAddQuestion}>Add new Question</button> 
        <br />
        <br />
        <button type="button" class="btn btn-warning" onClick={onListQuestions}>Display Questions</button>
        <br />
        <br />
        <button type="button" class="btn btn-warning" onClick={onFilterQuestions}>Filter Questions</button>
    </div>
    </div>
    </div>
);

export default UserOperations;