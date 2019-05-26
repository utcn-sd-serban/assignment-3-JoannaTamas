import modelUser from "../model/modelUser";


class CreateUserPresenter {

    onLogin() {

      for (let i=0; i<modelUser.state.users.length; i++) {
        if( modelUser.state.users[i].username === modelUser.state.currentUser.username)
                window.location.assign("#/user-operations");
          
               
  }

    }

    onCheck(property, value) {
        modelUser.changeNewUserProperty(property, value);
    }

}

const loginUserPresenter = new CreateUserPresenter();

export default loginUserPresenter;