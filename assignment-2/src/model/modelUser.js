import { EventEmitter } from "events";

class Model extends EventEmitter {
    constructor() {
        super();
        this.state = {
            users: [{ 
                username:"joanna",
                password:"poop"
            }],
                currentUser: {
                username: "",
                password: ""
             },
 
        };
    }


  /*//new user
  //change new user property 
  //cand fac login fac for.uyrl is care verifica 

    loginUser(username,password) {
        this.state = {
                if(this.state.username==username)
              
        
        };
        this.emit("change", this.state);
    }
    */
  
   changeNewUserProperty(property, value) {
    this.state = {
        ...this.state,
        currentUser: {
            ...this.state.currentUser,
            [property]: value
        }
    };
    this.emit("change", this.state);
}

}

const modelUser = new Model();

export default modelUser;