CREATE TABLE IF NOT EXISTS users(
   id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL


);

CREATE TABLE IF NOT EXISTS question(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(32) NOT NULL,
    text VARCHAR(64) NOT NULL,
    author_id INT,
    FOREIGN KEY(author_id) REFERENCES users(id) ON DELETE CASCADE ,
    date_time TIMESTAMP

);

CREATE TABLE IF NOT EXISTS answer (
          id INT PRIMARY KEY AUTO_INCREMENT,
          question_id INT,
          author_id INT,
          text VARCHAR(500),
          date_time TIMESTAMP,
          FOREIGN KEY(author_id) REFERENCES users(id) ON DELETE CASCADE,
          FOREIGN KEY(question_id) REFERENCES question(id) ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS tag(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tag_name VARCHAR(32) NOT NULL

);

CREATE TABLE IF NOT EXISTS users(
   id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL


);

CREATE TABLE IF NOT EXISTS question_tag(
    question_id INT,
    tag_id INT,
   FOREIGN KEY(question_id) REFERENCES question(id) ON DELETE CASCADE ,
   FOREIGN KEY(tag_id) REFERENCES tag(id) ON DELETE CASCADE
);

