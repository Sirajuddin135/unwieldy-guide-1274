CREATE DATABASE cimsdb;

CREATE TABLE cases 
(
    caseId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    place VARCHAR(25) NOT NULL,
    typeOfCrime VARCHAR(25) NOT NULL,
    victims VARCHAR(25) NOT NULL,
    description VARCHAR(255) NOT NULL,
    suspect VARCHAR(25) NOT NULL
);

CREATE TABLE criminal
(
    criminalId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(25) NOT NULL,
    age SMALLINT NOT NULL,
	gender VARCHAR(25) NOT NULL,
    address VARCHAR(25) NOT NULL,
	identificationMarks VARCHAR(25) NOT NULL,
    areaOfCrime VARCHAR(25) NOT NULL,
    typeOfCrime VARCHAR(25) NOT NULL
);

CREATE TABLE criminal_case_status 
(
    caseId INT NOT NULL,
    criminalId INT NOT NULL,
    status VARCHAR(25),
    FOREIGN KEY (caseId) REFERENCES cases(caseId),
    FOREIGN KEY (criminalId) REFERENCES criminal(criminalId)
);