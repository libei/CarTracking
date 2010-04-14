
DROP DATABASE IF EXISTS CarTracking;
CREATE DATABASE CarTracking;

USE CarTracking;

CREATE TABLE CarRecord
(
    id INT(11) NOT NULL auto_increment,
    PRIMARY KEY (id)
)