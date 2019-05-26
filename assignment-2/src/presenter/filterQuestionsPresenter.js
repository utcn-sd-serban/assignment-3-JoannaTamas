
import  modelQuestion from "../model/modelQuestion";

class FilterQuestionsPresenter {
    onFilter(value) {
        modelQuestion.changeTitleFilter( value);
    }

    onFilterButton(){
       

      //  modelQuestion.newQuestionList(questionsList);

    }
  
    
}

const filterQuestionsPresenter = new FilterQuestionsPresenter ();

export default filterQuestionsPresenter;