import React from "react";

const QuestionsList = ({ questions, title1 }) => (
    
    <div>
        <div class="jumbotron jumbotron-fluid">  
   
        <div class="container "> 
         <h1 >All the questions</h1>

       
         <table class="table table-bordered">
         <thead>
            <tr class="table-warning">
                    <th>Author</th>
                    <th>Title</th>
                    <th>Text</th>
                    <th>Date</th>
                    <th>Tag</th>
                    
                </tr>
            </thead>
            <tbody>
                {
                    questions.map((question, index) => (
                        <tr class="table-light" key={index}>
                            <td>{question.author}</td>
                            <td>{question.title}</td>
                            <td>{question.text}</td>
                            <td>{question.date}</td>
                            <td>{question.tag}</td>
                          
                        </tr>
                    ))
                }
            </tbody>
        </table>
        <br />
       
    </div>
    </div>
    </div>
    
);

export default QuestionsList;