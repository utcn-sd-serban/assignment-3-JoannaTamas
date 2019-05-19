import React from "react";
import 'bootstrap/dist/css/bootstrap.css';

const CreateQuestion = ({author, title, text,date,tag, onCreate, onChange }) => (
    <div>
         <div class="jumbotron jumbotron-fluid">  
        
        <div class="container "> 
        <h1 >Add Question</h1>

        <div class="form-group">
            <label for="aut">Author:</label>
             <input type="author" class="form-control" id="aut" value={author} 
                onChange={ e => onChange("author", e.target.value) } />
        </div>

        <div class="form-group">
              <label for="tit">Title:</label>
              <input type="title" class="form-control" id="tit"value={title} 
                onChange={ e => onChange("title", e.target.value) } />
        </div>
        <div class="form-group">
              <label for="tex">Text:</label>
              <input type="title" class="form-control" id="tex" value={text} 
                onChange={ e => onChange("text", e.target.value) } />
        </div>

        <div class="form-group">
              <label for="dat">Date:</label>
              <input type="date" class="form-control" id="dat" value={date} 
                onChange={ e => onChange("date", e.target.value) } />
        </div>

        <div class="form-group">
              <label for="ta">Tag:</label>
              <input type="tag" class="form-control" id="ta" value={tag} 
                onChange={ e => onChange("tag", e.target.value) } />
        </div>
        
            <button type="button" class="btn btn-warning" onClick={onCreate}>Create!</button>
        </div>
    </div>
    </div>
);

export default CreateQuestion;