


class UserOperationsPresenter {

    onAddQuestion() {
        
        window.location.assign("#/create-question");
    }

    onListQuestions(){
        window.location.assign("#/questions-list");
    }

    onFilterQuestions(){
        window.location.assign("#/filter-questions");
    }

 

}

const userOperationsPresenter  = new UserOperationsPresenter ();

export default userOperationsPresenter ;