import React from "react";
import 'bootstrap/dist/css/bootstrap.css';

const LoginUser = ({ username,password, onLogin, onCheck }) => (

<div class="jumbotron jumbotron-fluid">


        <div class="container">
         <h1 class="display-4">Welcome to StackOverflow!</h1>
         <p class="lead">Stack Overflow is the largest, most trusted online community for anyone that codes to learn, share their knowledge, and build their careers. </p>
   
   
    <div class="alert alert-warning alert-dismissible fade show " role="alert">
        
        <h2>Login to your account</h2>

        
        <div>
        <div class="form-group">
        <label>Username: </label>
              <input type="username" class="form-control" id="user"value={ username} 
                onChange={ e => onCheck("username", e.target.value) } />
        </div>
        <div class="form-group">
        <label>Password: </label>
              <input type="password" class="form-control" id="pasw" value={ password} 
                onChange={ e => onCheck("password", e.target.value) } />
        </div>
            <button type="button" class="btn btn-warning btn-lg " onClick={onLogin}>Log in</button>
          
           
        </div>
    </div>
    </div>
</div>


);

export default LoginUser;
