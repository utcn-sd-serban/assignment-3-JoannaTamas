import React, { Component } from "react";
import  modelQuestion from "../model/modelQuestion";
import QuestionsList from "./QuestionsList";
import questionsListPresenter from "../presenter/questionsListPresenter";



const mapModelStateToComponentState = modelState => ({
    questions: modelState.questions
});

export default class SmartQuestionsList extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState( modelQuestion.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        modelQuestion.addListener("change", this.listener);
        questionsListPresenter.onInit();
    }

    componentWillUnmount() {
        modelQuestion.removeListener("change", this.listener);
    }

    render() {
        return (
            <QuestionsList 
               // onViewDetails={questionsListPresenter.onViewDetails}
                onCreateQuestion={questionsListPresenter.onCreateQuestion}
                questions={this.state.questions} />
        );
    }
}