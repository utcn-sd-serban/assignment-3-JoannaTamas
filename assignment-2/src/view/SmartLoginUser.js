import React, { Component } from "react";
import modelUser from "../model/modelUser";

import LoginUser from "./LoginUser";
import loginUserPresenter from "../presenter/loginUserPresenter";

const mapModelStateToComponentState = modelState => ({
    username: modelState.currentUser.username,
    password: modelState.currentUser.password
});

export default class SmartLoginUser extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState( modelUser.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        modelUser.addListener("change", this.listener);
    }

    componentWillUnmount() {
        modelUser.removeListener("change", this.listener);
    }

    render() {
        return (
            <LoginUser
                onLogin={loginUserPresenter.onLogin}
                onCheck={loginUserPresenter.onCheck}
               

               
                />
        );
    }
}