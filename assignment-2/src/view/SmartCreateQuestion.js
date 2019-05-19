import React, { Component } from "react";
import modelQuestion from "../model/modelQuestion";

import CreateQuestion from "./CreateQuestion";
import createQuestionPresenter from "../presenter/createQuestionPresenter";

const mapModelStateToComponentState = modelState => ({
    author: modelState.newQuestion.author,
    title: modelState.newQuestion.title,
    text: modelState.newQuestion.text,
    date: modelState.newQuestion.date,
    tag: modelState.newQuestion.tag
});

export default class SmartCreateQuestion extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState( modelQuestion.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        modelQuestion.addListener("change", this.listener);
    }

    componentWillUnmount() {
        modelQuestion.removeListener("change", this.listener);
    }

    render() {
        return (
            <CreateQuestion
                onCreate={createQuestionPresenter.onCreate}
                onChange={createQuestionPresenter.onChange}
                author={this.state.author}
                title={this.state.title}
                text={this.state.text}
                date={this.state.date}
                tag={this.state.tag}
                 />
        );
    }
}