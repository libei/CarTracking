
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
    carRecordId INT(11),    
    PRIMARY KEY (id)
);

CREATE TABLE CarRecord_BluetoothRecord
(
    id INT(11) NOT NULL auto_increment,
    CarRecord_id INT(11) NOT NULL,
    bluetoothRecords_id INT(11) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE LicensePlateRecord
(
    id INT(11) NOT NULL auto_increment,
    _date DATE,
    accuracy varchar(100),
    number   varchar(100),
    filename varchar(100),
    carRecordId INT(11),
    PRIMARY KEY (id)
);

CREATE TABLE CarRecord_LicensePlateRecord
(
    id INT(11) NOT NULL auto_increment,
    CarRecord_id INT(11) NOT NULL,
    licensePlateRecords_id INT(11) NOT NULL,
    PRIMARY KEY (id)
);