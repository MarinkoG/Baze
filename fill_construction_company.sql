use construction_company;

INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Banjaluka', 'Srpska', '78000', '60');
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Banjaluka', 'Alekse Santica', '78000', '10');
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Prijedor', 'Petra Kocica', '79521', '1');
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Mrkonjic', 'Branka Radicevica', '56987', '89');
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Doboj', 'Prva', '51287', '89');

INSERT INTO `construction_company`.`privilege` (`Name`, `Description`) VALUES ('Administrator', 'Database administrator');
INSERT INTO `construction_company`.`privilege` (`Name`, `Description`) VALUES ('User', 'Regular user');
INSERT INTO `construction_company`.`privilege` (`Name`, `Description`) VALUES ('Guest', 'Temporary guest user');

INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`) VALUES ('1234567891011', 'Marinko', 'Grubljesic', '1987-09-18', '1', '057/156-456', 'grubljesic.marinko@gmail.com');
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`) VALUES ('1111111111111', 'Marko', 'Markovic', '1990-01-01', '2', '051/466-451', 'marko@gmail.com');
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`) VALUES ('2222222222222', 'Petar', ' Petrovic', '1991-02-02', '3', '051-126-569', 'petar@gmial.cm');
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`) VALUES ('3333333333333', 'Bob', 'Graditelj', '1998-03-03', '4', '055-459-856', 'bob@gmail.com');
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`) VALUES ('5555555555555', 'Han', 'Solo', '1973-05-06', '5', '055', 'hans@yahoo.com');

INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Bank_account`, `Profession`, `Hourly_rate`) VALUES ('1234567891011', '0', '4512684558841', 'Engineer', '10');
INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Bank_account`, `Profession`, `Hourly_rate`) VALUES ('1111111111111', '0', '8545484545454', 'Worker', '5');
INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Bank_account`, `Profession`, `Hourly_rate`) VALUES ('2222222222222', '0', '4975124612545', 'Bricklayer', '6');
INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Bank_account`, `Profession`, `Hourly_rate`) VALUES ('3333333333333', '0', '2342472383753', 'Driver', '5');

INSERT INTO `construction_company`.`material` (`Name`, `Description`, `Unit`) VALUES ('Brick20x40x20', 'Brick dimensions 20x40x20', 'units');
INSERT INTO `construction_company`.`material` (`Name`, `Description`, `Unit`) VALUES ('Brick 10x20x5', 'Brick dimensions 10x20x5', 'units');
INSERT INTO `construction_company`.`material` (`Name`, `Description`, `Unit`) VALUES ('Gravel 10', 'Gravel fine grade 10', 'm3');
INSERT INTO `construction_company`.`material` (`Name`, `Description`, `Unit`) VALUES ('Beam 5x10x200', 'Iron beam 5x10x200', 'units');
INSERT INTO `construction_company`.`material` (`Name`, `Description`, `Unit`) VALUES ('Nails 7', 'Nails 7cm', 'kg');

INSERT INTO `construction_company`.`tools` (`Name`, `Description`, `Amount`) VALUES ('Hammer smal', 'Basic small hammer', '10');
INSERT INTO `construction_company`.`tools` (`Name`, `Description`, `Amount`) VALUES ('Chainsaw Stihll', 'Stihl Chainsaw', '2');
INSERT INTO `construction_company`.`tools` (`Name`, `Amount`) VALUES ('Shovel', '5');

INSERT INTO `construction_company`.`user_account` (`Username`, `Password`, `Privilege`, `Personal_id_Number`) VALUES ('admin', 'admin', 'Administrator', '1234567891011');
INSERT INTO `construction_company`.`user_account` (`Username`, `Password`, `Privilege`, `Personal_id_Number`) VALUES ('marko', 'marko', 'User', '1111111111111');
INSERT INTO `construction_company`.`user_account` (`Username`, `Password`, `Privilege`, `Personal_id_Number`) VALUES ('bob', 'bob', 'User', '3333333333333');

INSERT INTO `construction_company`.`department` (`Name`, `Description`, `Phone_number`, `E_mail`) VALUES ('Planiranje', 'Planiranje projekata', '025/456-856', 'planiranje@gmil.com');

INSERT INTO `construction_company`.`project` (`Name`, `Description`, `Start_date`, `Completion_date`, `Price`, `Project_manager`, `Address_id`) VALUES ('Zgrada1', 'Izgradnja stambenog objekata', '2019-01-01', '2021-02-02', '50000', '1234567891011', '5');

create view show_users as SELECT person.Personal_id_Number,First_Name, Last_Name, Username, Password, Privilege  FROM user_account inner join person on user_account.Personal_id_Number=person.Personal_id_Number;
create view employees_without_account as SELECT employee.Personal_id_Number,First_Name, Last_Name FROM employee  left join person on employee.Personal_id_Number=person.Personal_id_Number where employee.Personal_id_Number not in(select user_account.Personal_id_Number from user_account);
create view show_employees as SELECT Profession, Hourly_rate, Salary, Bank_account, Username, Password, Privilege, First_Name, Last_Name, person.Personal_id_Number, Date_of_birth, Address, Phone_number, E_mail  FROM employee left join person on employee.Personal_id_Number=person.Personal_id_Number left join user_account on employee.Personal_id_Number=user_account.Personal_id_Number;
