import React from "react";
import 'bootstrap/dist/css/bootstrap.css';


const FilterQuestions = ({questions,title , onFilter,onFilterButton}) => (
    <div>
    <div class="jumbotron jumbotron-fluid">  
   
   <div class="container "> 
   <h1 >Filter by title</h1>
            
            <div class="form-group">
             <label>Title: </label>
              <input type="title" class="form-control" id="tit"value={title} 
                onChange={ e => onFilter("title", e.target.value) } />
             </div>
             <button type="button" class="btn btn-warning btn-lg " onClick={onFilterButton}>Filter!</button>
            <br />
            <br />
            
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
                        <tr class="table-light"  key={index}>
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
        
        </div>
    </div>
    </div>

    
);


export default  FilterQuestions;

