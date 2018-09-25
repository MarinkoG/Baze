use construction_company;

create trigger login_count before insert on login_log
for each row
update person  p
set Login_Success_Count=Login_Success_Count + 1
where Personal_id_Number=new.Personal_id_Number;

create trigger addWage after insert on worktime_record
for each row
update employee  e
set Salary=Salary + Hourly_rate*new.Work_hours
where Personal_id_Number=new.Personal_id_Number;

create trigger deleteWage after delete on worktime_record
for each row
update employee  e
set Salary=Salary - Hourly_rate*old.Work_hours
where Personal_id_Number=old.Personal_id_Number;

create trigger updateWage after update on worktime_record
for each row
update employee  e
set Salary=Salary - Hourly_rate*old.Work_hours+Hourly_rate*new.Work_hours
where Personal_id_Number=new.Personal_id_Number;

INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Banjaluka', 'Srpska', '78000', '60');
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Banjaluka', 'Alekse Santica', '78000', '10');
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Prijedor', 'Petra Kocica', '79521', '1');
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Mrkonjic', 'Branka Radicevica', '56987', '89');
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Doboj', 'Prva', '51287', '89');
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES ('Novi Grad', 'Petra Kocica', '79220', '22');

INSERT INTO `construction_company`.`privilege` (`Name`, `Description`) VALUES ('Administrator', 'Database administrator');
INSERT INTO `construction_company`.`privilege` (`Name`, `Description`) VALUES ('User', 'Regular user');
INSERT INTO `construction_company`.`privilege` (`Name`, `Description`) VALUES ('Guest', 'Temporary guest user');

INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`, `Login_Success_Count`) VALUES ('1234567891011', 'Marinko', 'Grubljesic', '1987-09-18', '1', '057/156-456', 'grubljesic.marinko@gmail.com', 0);
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`, `Login_Success_Count`) VALUES ('1111111111111', 'Marko', 'Markovic', '1990-01-01', '2', '051/466-451', 'marko@gmail.com', 0);
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`, `Login_Success_Count`) VALUES ('2222222222222', 'Petar', ' Petrovic', '1991-02-02', '3', '051-126-569', 'petar@gmial.cm', 0);
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`, `Login_Success_Count`) VALUES ('3333333333333', 'Bob', 'Graditelj', '1998-03-03', '6', '055-459-856', 'bob@gmail.com', 0);
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`, `Login_Success_Count`) VALUES ('5555555555555', 'Han', 'Solo', '1973-05-06', '5', '055', 'hans@yahoo.com', 0);

INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Hourly_rate`) VALUES ('1234567891011', '0', '10');
INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Hourly_rate`) VALUES ('1111111111111', '0', '5');
INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Hourly_rate`) VALUES ('2222222222222', '0', '6');
INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Hourly_rate`) VALUES ('3333333333333', '0', '5');

INSERT INTO `construction_company`.`building` (`Name`, `Description`, `Address_id`) VALUES ('Warehouse1', 'Warehouse 1', '4');

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

INSERT INTO `construction_company`.`worktime_record` (`Work_hours`, `Personal_id_Number`, `Date`) VALUES ('4', '1234567891011', '2000-02-02');
INSERT INTO `construction_company`.`worktime_record` (`Work_hours`, `Personal_id_Number`, `Date`) VALUES ('10', '1234567891011', '2001-05-05');

INSERT INTO `construction_company`.`project` (`Name`, `Start_date`, `Completion_date`, `Price`) VALUES ('Zgrada 1', '2018-02-02', '2020-02-02', '1000000');

INSERT INTO `construction_company`.`is_project_menager` (`Project_id`, `Personal_id_Number`, `Start_date`) VALUES ('1', '1234567891011', '2018-09-09');

INSERT INTO `construction_company`.`client` (`Personal_id_Number`) VALUES ('5555555555555');

INSERT INTO `construction_company`.`commissions` (`Personal_id_Number`, `Project_id`, `Date`) VALUES ('5555555555555', '1', '2018-01-05');

create view show_users as SELECT person.Personal_id_Number,First_Name, Last_Name, Username, Password, Privilege  FROM user_account inner join person on user_account.Personal_id_Number=person.Personal_id_Number;
create view employees_without_account as SELECT employee.Personal_id_Number,First_Name, Last_Name FROM employee  left join person on employee.Personal_id_Number=person.Personal_id_Number where employee.Personal_id_Number not in(select user_account.Personal_id_Number from user_account);
create view show_employees as SELECT Hourly_rate, Salary, Username, Password, Privilege, First_Name, Last_Name, person.Personal_id_Number, Date_of_birth, Phone_number, E_mail, Address, City, Street, Zip_code, House_number FROM employee left join person on employee.Personal_id_Number=person.Personal_id_Number left join user_account on employee.Personal_id_Number=user_account.Personal_id_Number left join address on person.Address=address.Address_id;
create view get_worktime as SELECT `Work_hours`, `Personal_id_Number`, `Date` FROM `worktime_record` ORDER BY Date DESC LIMIT 0 , 30;

create view get_managers as select Personal_id_Number, First_Name, Last_Name from person where person.Personal_id_Number in (select Personal_id_Number from is_project_menager where is_project_menager.Project_id = is_project_menager.Project_id);
create view get_clients as select Personal_id_Number as Client_id, First_Name as Client_name, Last_Name as Client_last_name from person where person.Personal_id_Number in (select commissions.Personal_id_Number from commissions where Project_id = commissions.Project_id);

create view get_projects as SELECT * from project inner join  get_managers inner join get_clients;

delimiter //
create procedure get_address(in id integer, out res varchar(256))
begin
	set res='';
	set res=concat(res, (SELECT City FROM construction_company.address where Address_id=id));

end //
delimiter ;



delimiter //
create procedure save_address(in City varchar(50), in Street varchar(50), in House_number varchar(20), in Zip_code varchar(20), out res integer)
begin
	set res=0;
    
INSERT INTO `construction_company`.`address` (`City`, `Street`, `Zip_code`, `House_number`) VALUES (City, Street, House_number, Zip_code);

set res=(select LAST_INSERT_ID());

end //
delimiter ;


delimiter //
create procedure save_employee(in Personal_id_Number varchar(20), in First_Name varchar(20), in Last_Name varchar(20), in Date_of_birth varchar(20), in Address integer, in Phone_number varchar(20), in E_mail varchar(100), in Hourly_rate integer, in Salary integer, out res varchar(256))
begin
	set res='false';
    set Address = (SELECT IF(Address<0, NULL, Address)); 
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`, `Login_Success_Count`) VALUES (Personal_id_Number, First_Name, Last_Name, Date_of_birth, Address, Phone_number, E_mail, 0);
INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Hourly_rate`) VALUES (Personal_id_Number, Hourly_rate, Salary);

set res='true';
end //
delimiter ;


delimiter //
create procedure update_employee(in Personal_id_Number varchar(20), in First_Name varchar(20), in Last_Name varchar(20), in Date_of_birth varchar(20), in Address integer, in Phone_number varchar(20), in E_mail varchar(100), in Hourly_rate integer, in Salary integer, out res varchar(256))
begin
	set res='false';
    set Address = (SELECT IF(Address<0, NULL, Address));
    UPDATE `construction_company`.`employee` SET `Salary`=Salary, `Hourly_rate`=Hourly_rate WHERE employee.Personal_id_Number= Personal_id_Number;
	UPDATE `construction_company`.`person` SET `First_Name`=First_Name, `Last_Name`=Last_Name, `Date_of_birth`=Date_of_birth, `Address`=Address, `Phone_number`=Phone_number, `E_mail`=E_mail WHERE person.Personal_id_Number=Personal_id_Number;
set res='true';
end //
delimiter ;

delimiter //
create procedure save_project(in Name varchar(20), in Start_date varchar(20), in Completion_date varchar(20), in Price float, in Personal_id_Number varchar(20), in Client_id_Number varchar(20), out project_id integer)
begin
INSERT INTO `construction_company`.`project` (`Name`, `Start_date`, `Completion_date`, `Price`) VALUES (Name, Start_date, Completion_date, Price);
set project_id = (select LAST_INSERT_ID());
INSERT INTO `construction_company`.`is_project_menager` (`Project_id`, `Personal_id_Number`, `Start_date`) VALUES (project_id, Personal_id_Number, (SELECT CURDATE()));

INSERT INTO `construction_company`.`commissions` (`Personal_id_Number`, `Project_id`, `Price`, `Date`) VALUES (Client_id_Number, project_id, '0', (SELECT CURDATE()));

end //
delimiter ;