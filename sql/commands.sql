CREATE TABLE IF NOT EXISTS QUIZ(id serial PRIMARY KEY, name varchar(255));
CREATE TABLE IF NOT EXISTS ADMIN(UNAME VARCHAR(255), PASSWD VARCHAR(255));
CREATE TABLE IF NOT EXISTS CANDIDATE(NAME VARCHAR(255), UNAME VARCHAR(255), PASSWD VARCHAR(255));
CREATE TABLE IF NOT EXISTS QUESTION(id int,  qid serial, content varchar(255),  topics varchar(255),  difficulty int,
ANSWER varchar(255), CHOICEA varchar(255), CHOICEB varchar(255), CHOICEC varchar(255), CHOICED varchar(255), CONSTRAINT id_fk FOREIGN KEY (id) REFERENCES QUIZ(id));


INSERT INTO QUIZ (name) values ('Java');
INSERT INTO QUIZ (name) values ('Python');
INSERT INTO QUIZ (name) values ('SQL');
INSERT INTO QUIZ (name) values ('SAP');
INSERT INTO QUIZ (name) values ('Angular');
INSERT INTO QUIZ (name) values ('Unix');
INSERT INTO QUIZ (name) values ('Test Quiz');
INSERT INTO ADMIN VALUES('ADM', 'ADM');

INSERT INTO CANDIDATE (name, uname, passwd) values ('Swati', 'Swati', 'Swati');

INSERT INTO QUESTION(id,"content",topics,difficulty,answer,choicea,choiceb,choicec,choiced) VALUES
	 (1,'Which component is used to compile, debug and execute the java programs?','Java',1,'JDK','JRE','JIT','JDK','JVM'),
	 (1,'What is the extension of java code files?','Java',2,'.java','.js','.txt','.class','.java'),
	 (1,'Which one of the following is not a Java feature?','Java',3,'Use of pointers','Object-oriented','Use of pointers','Portable','Dynamic and Extensible'),
	 (2,'Who developed Python Programming Language?','Python',1,'Guido van Rossum','Wick van Rossum','Rasmus Lerdorf','Guido van Rossum','Niene Stom'),
	 (2,'Which type of Programming does Python support?','Python',2,'all of the mentioned','object-oriented programming','structured programming','functional programming','all of the mentioned'),
	 (2,'Which of the following is the correct extension of the Python file?','Python',3,'.py','.python','.pl','.py','.p');