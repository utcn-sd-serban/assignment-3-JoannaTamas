import modelQuestion from "../model/modelQuestion";


class CreateQuestionPresenter {

    onCreate() {
        modelQuestion.addQuestion(modelQuestion.state.newQuestion.author,
                                  modelQuestion.state.newQuestion.title,
                                   modelQuestion.state.newQuestion.text,
                                   modelQuestion.state.newQuestion.date,
                                   modelQuestion.state.newQuestion.tag
                                   );
        modelQuestion.changeNewQuestionProperty("author", "");
        modelQuestion.changeNewQuestionProperty("title ",  "");
        modelQuestion.changeNewQuestionProperty("text  ",   "");
        modelQuestion.changeNewQuestionProperty("date  ",   "");
        modelQuestion.changeNewQuestionProperty("tag   ",    "");
        window.location.assign("#/questions-list");
    }

    onChange(property, value) {
        modelQuestion.changeNewQuestionProperty(property, value);
    }

}

const createQuestionPresenter = new CreateQuestionPresenter();

export default createQuestionPresenter;