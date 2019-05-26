import modelQuestion from "../model/modelQuestion";



class QuestionsListPresenter {
    onCreateQuestion() {
      window.location.assign("#/create-question");
    }
    onInit(){
      modelQuestion.loadQuestions();
    }
 

}

const questionsListPresenter = new QuestionsListPresenter();

export default questionsListPresenter;