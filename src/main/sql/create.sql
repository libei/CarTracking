
DROP DATABASE IF EXISTS CarTracking;
CREATE DATABASE CarTracking;

USE CarTracking;

CREATE TABLE CarRecord
(
    id INT(11) NOT NULL auto_increment,
    PRIMARY KEY (id)
);

CREATE TABLE BluetoothRecord
(
    id INT(11) NOT NULL auto_increment,
    unixTime INT(20),
    macAddress TEXT,
    deviceType TEXT,
    unitSN TEXT,
    PRIMARY KEY (id)
);