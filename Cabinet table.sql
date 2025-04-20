create table cabinet
(CabinetID int (100) Primary key,
CabinetName VARCHAR(20),
DateOfCreation date,
CabinetLocked boolean,
Password Varchar(20),
Owner Varchar(20),
FilePath LONGTEXT
);