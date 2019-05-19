import React, { Component } from "react";
import  modelQuestion from "../model/modelQuestion";
import FilterQuestions from "./FilterQuestions";
import filterQuestionsPresenter from "../presenter/filterQuestionsPresenter";


const mapModelStateToComponentState = modelState => ({
    questions: modelState.questions
});

export default class SmartFilterQuestions extends Component {
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
            <FilterQuestions
              
                onFilter={filterQuestionsPresenter.onFilter}
                onFilterButton={filterQuestionsPresenter.onFilterButton}
                questions={this.state.questions} 
              
                 />
        );
    }
}