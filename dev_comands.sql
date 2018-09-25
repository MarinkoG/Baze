use construction_company;

drop schema if exists construction_company;
create schema construction_company default character set utf8 default collate utf8_unicode_ci;
use construction_company;
drop schema if exists construction_company;
create schema construction_company default character set utf8 default collate utf8_unicode_ci;
use construction_company;

DELETE FROM `construction_company`.`person` WHERE `Personal_id_Number`=Address_id;
DELETE FROM `construction_company`.`address` WHERE `Address_id`=Address_id;
System.out.println(selectedEmployee+" "+selectedEmployee.getPersonalIdNumber()+" -"+selectedEmployee.getAddress().getId());

SELECT * FROM user where username='Admin' and password='admin';
SELECT person.Personal_id_Number,First_Name, Last_Name, Username, Privilege  FROM user inner join person on user.Personal_id_Number=person.Personal_id_Number;
SELECT person.Personal_id_Number,First_Name, Last_Name FROM person inner join user on person.Personal_id_Number!=user.Personal_id_Number;
SELECT person.Personal_id_Number,First_Name, Last_Name FROM person inner join user on person.Personal_id_Number!=user.Personal_id_Number where person.name is null;

SELECT person.Personal_id_Number,First_Name, Last_Name FROM person where person.Personal_id_Number not in(select user.Personal_id_Number from user);

SELECT person.Personal_id_Number,First_Name, Last_Name, Username, Privilege  FROM user inner join person on user.Personal_id_Number=person.Personal_id_Number and user.Privilege='Administrator';

select name from privileges;
select password from user where Personal_id_Number='1234567891012';
update user set Username='ddddddddd', Password='ddddddddd',Privilege='Guest' where Personal_id_Number='1234567891012';
SELECT * from employee inner join person on employee.Personal_id_Number=person.Personal_id_Number;

create view show_users as SELECT person.Personal_id_Number,First_Name, Last_Name, Username, Password, Privilege  FROM user inner join person on user.Personal_id_Number=person.Personal_id_Number;
create view employees_without_account as SELECT person.Personal_id_Number,First_Name, Last_Name FROM person where person.Personal_id_Number not in(select user.Personal_id_Number from user);

SELECT person.Personal_id_Number,First_Name, Last_Name FROM person where employee.Personal_id_Number = person.Personal_id_Numbernot and person.Personal_id_Number not in(select user_account.Personal_id_Number from user_account);
SELECT * from employee  left join person on employee.Personal_id_Number=person.Personal_id_Number;

SELECT person.Personal_id_Number,First_Name, Last_Name FROM person where person.Personal_id_Number not in(SELECT * from employee  left join person on employee.Personal_id_Number=person.Personal_id_Number);

SELECT * FROM employee left join person on employee.Personal_id_Number=person.Personal_id_Number where employee.Personal_id_Number not in(select user_account.Personal_id_Number from user_account);

 
SELECT * FROM employee left join person on employee.Personal_id_Number=person.Personal_id_Number left join user_account on employee.Personal_id_Number=user_account.Personal_id_Number;
      
  
SELECT Profession, Hourly_rate, Salary, Bank_account, Username, Password, Privilege, First_Name, Last_Name, person.Personal_id_Number, Date_of_Birth, Address, Phone_number, E_mail  FROM employee left join person on employee.Personal_id_Number=person.Personal_id_Number left join user_account on employee.Personal_id_Number=user_account.Personal_id_Number;


SELECT City FROM construction_company.address where Address_id=1;

delimiter //
create procedure get_address(in id integer, out res varchar(256))
begin
	set res='';
	set res=concat(res, (SELECT City FROM construction_company.address where Address_id=id));

end //
delimiter ;

SELECT Hourly_rate, Salary, Username, Password, Privilege, First_Name, Last_Name, person.Personal_id_Number, Date_of_birth, Phone_number, E_mail, City, Street, Zip_code, House_number  FROM employee left join person on employee.Personal_id_Number=person.Personal_id_Number left join user_account on employee.Personal_id_Number=user_account.Personal_id_Number left join address on person.Address=address.Address_id;


INSERT INTO `tools` (`Name`, `Description`, `Amount`) VALUES ('Hmare', 'Basic small hammer', '15');
select LAST_INSERT_ID();




delimiter //
create procedure save_employee(in Personal_id_Number varchar(20), in First_Name varchar(20), in Last_Name varchar(20), in Date_of_birth varchar(20), in Address integer, in Phone_number varchar(20), in E_mail varchar(20), out res varchar(256))
begin
	set res=1;
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`) VALUES (Personal_id_Number, First_Name, Last_Name, Date_of_birth, Address, Phone_number, E_mail);

end //
delimiter ;


delimiter //
create procedure save_person(in Personal_id_Number varchar(20), in First_Name varchar(20), in Last_Name varchar(20), in Date_of_birth varchar(20), in Address integer, in Phone_number varchar(20), in E_mail varchar(20), out res varchar(256))
begin
	set res='false';
    set Address = (SELECT IF(Address<0, NULL, Address)); 
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`) VALUES (Personal_id_Number, First_Name, Last_Name, Date_of_birth, Address, Phone_number, E_mail);

set res='true';
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
create procedure save_employee(in Personal_id_Number varchar(20), in First_Name varchar(20), in Last_Name varchar(20), in Date_of_birth varchar(20), in Address integer, in Phone_number varchar(20), in E_mail varchar(20), in Hourly_rate integer, in Salary integer, out res varchar(256))
begin
	set res='false';
    set Address = (SELECT IF(Address<0, NULL, Address)); 
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`) VALUES (Personal_id_Number, First_Name, Last_Name, Date_of_birth, Address, Phone_number, E_mail);
INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Hourly_rate`) VALUES (Personal_id_Number, Hourly_rate, Salary);

set res='true';
end //
delimiter ;


delimiter //
create procedure save_employee(in Personal_id_Number varchar(20), in First_Name varchar(20), in Last_Name varchar(20), in Date_of_birth varchar(20), in Address integer, in Phone_number varchar(20), in E_mail varchar(20), out res varchar(256))
begin
	set res=1;
INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`) VALUES (Personal_id_Number, First_Name, Last_Name, Date_of_birth, Address, Phone_number, E_mail);

end //
delimiter ;


delimiter //
create procedure delete_employee(in Personal_id_Number varchar(20), in Address_id integer)
begin
DELETE FROM `construction_company`.`employee` WHERE `Personal_id_Number`= Personal_id_Number;
DELETE FROM `construction_company`.`employee` WHERE `Personal_id_Number`='565656565';

DELETE FROM `construction_company`.`person` WHERE `Personal_id_Number`= Personal_id_Number;
DELETE FROM `construction_company`.`address` WHERE `Address_id`= Address_id;
end //
delimiter ;


delimiter //
create procedure update_employee(in Personal_id_Number varchar(20), in First_Name varchar(20), in Last_Name varchar(20), in Date_of_birth varchar(20), in Address integer, in Phone_number varchar(20), in E_mail varchar(20), in Hourly_rate integer, in Salary integer, out res varchar(256))
begin
	set res='false';
    set Address = (SELECT IF(Address<0, NULL, Address));
    UPDATE `construction_company`.`employee` SET `Salary`=Salary, `Hourly_rate`=Hourly_rate WHERE employee.Personal_id_Number= Personal_id_Number;
	UPDATE `construction_company`.`person` SET `First_Name`=First_Name, `Last_Name`=Last_Name, `Date_of_birth`=Date_of_birth, `Address`=Address, `Phone_number`=Phone_number, `E_mail`=E_mail WHERE person.Personal_id_Number=Personal_id_Number;
set res='true';
end //
delimiter ;


insert into construction_company.login_log (Personal_id_Number, Login_Date, Success_Login) values (2222222222222, '1987-09-18', 1);

delimiter //
create procedure update_employee(in Personal_id_Number varchar(20), in First_Name varchar(20), in Last_Name varchar(20), in Date_of_birth varchar(20), in Address integer, in Phone_number varchar(20), in E_mail varchar(20), in Hourly_rate integer, in Salary integer)
begin
    set Address = (SELECT IF(Address<0, NULL, Address));
    UPDATE `construction_company`.`employee` SET `Salary`=Salary, `Hourly_rate`=Hourly_rate WHERE `Personal_id_Number`=Personal_id_Number;
	end //
delimiter ;
SELECT * FROM construction_company.worktime_record;

SELECT `title` , `text` , `date_time`
FROM `post_table`
ORDER BY date_time DESC
LIMIT 0 , 30

SELECT * from construction_company.worktime_record ORDER BY date DESC LIMIT 5;
INSERT INTO `construction_company`.`worktime_record` (`Work_hours`, `Personal_id_Number`, `Date`) VALUES ('10', '1234567891011', '2001-05-05');

SELECT `Work_hours`, `Personal_id_Number`, `Date` FROM `worktime_record` ORDER BY Date DESC LIMIT 0 , 30;
LIMIT 0 , 30

Float workHours, String personalIdNumber, String Date

create trigger addWage after insert on worktime_record
for each row
update employee  e
set Salary=Salary + Hourly_rate*new.Work_hours
where Personal_id_Number=new.Personal_id_Number;

create trigger deleteWage after delete on worktime_record
for each row
update employee  e
set Salary=Salary - Hourly_rate*Work_hours
where Personal_id_Number=Personal_id_Number;

create trigger updateWage after update on worktime_record
for each row
update employee  e
set Salary=Salary - Hourly_rate*old.Work_hours+Hourly_rate*new.Work_hours
where Personal_id_Number=new.Personal_id_Number;

create trigger deleteWage after delete on worktime_record
for each row
update employee  e
set Salary=Salary - Hourly_rate*(select Hourly_rate from worktime_record where worktime_record.Personal_id_Number=old.Personal_id_Number and worktime_record.Date=old.Date)
where Personal_id_Number=Personal_id_Number;

INSERT INTO `construction_company`.`project` (`Name`, `Start_date`, `Completion_date`, `Price`) VALUES ('asdas', '2005-05-05', '2005-05-05', '599');
SELECT 'Project_id', 'Name', 'Start_date', Completion_date, Price, Personal_id_Number, person.First_Name, person.Last_Name  FROM construction_company.project inner join is_project_menager on project.Project_id=is_project_menager.Project_id inner join person on is_project_menager.Personal_id_Number=person.Personal_id_Number;
create view get_managers as select Personal_id_Number, First_Name, Last_Name from person where person.Personal_id_Number in (select Personal_id_Number from is_project_menager where is_project_menager.Project_id = is_project_menager.Project_id);
create view get_clients as select Personal_id_Number, First_Name, Last_Name from person where person.Personal_id_Number in (select Personal_id_Number from commissions where commissions.Personal_id_Number = commissions.Project_id);


select Personal_id_Number, First_Name, Last_Name from person where person.Personal_id_Number in (select Personal_id_Number from is_project_menager where is_project_menager.Project_id = is_project_menager.Project_id);

select Personal_id_Number as Client_id, First_Name as Client_name, Last_Name as Client_last_name from person where person.Personal_id_Number in (select commissions.Personal_id_Number from commissions where Project_id = commissions.Project_id);

SELECT * from project inner join  get_managers inner join get_clients;

SELECT * from project inner join  get_managers inner join get_clients;


String name, String manager, String client, String startDate, String completionDate, Float price

INSERT INTO `construction_company`.`project` (`Name`, `Start_date`, `Completion_date`, `Price`) VALUES ('dsfsdf', '2015', 'dfgd', 'fdghd');


delimiter //
create procedure save_project(in Name varchar(20), in Start_date varchar(20), in Completion_date varchar(20), in Price float, in Personal_id_Number varchar(20), in Client_id_Number varchar(20), out project_id integer)
begin
INSERT INTO `construction_company`.`project` (`Name`, `Start_date`, `Completion_date`, `Price`) VALUES (Name, Start_date, Completion_date, Price);
set project_id = (select LAST_INSERT_ID());
INSERT INTO `construction_company`.`is_project_menager` (`Project_id`, `Personal_id_Number`, `Start_date`) VALUES (id, Personal_id_Number, (SELECT CURDATE()));

INSERT INTO `construction_company`.`person` (`Personal_id_Number`, `First_Name`, `Last_Name`, `Date_of_birth`, `Address`, `Phone_number`, `E_mail`, `Login_Success_Count`) VALUES (Personal_id_Number, First_Name, Last_Name, Date_of_birth, Address, Phone_number, E_mail, 0);
INSERT INTO `construction_company`.`employee` (`Personal_id_Number`, `Salary`, `Hourly_rate`) VALUES (Personal_id_Number, Hourly_rate, Salary);
INSERT INTO `construction_company`.`commissions` (`Personal_id_Number`, `Project_id`, `Price`, `Date`) VALUES (Client_id_Number, id, '0', (SELECT CURDATE()));

set res='true';
end //
delimiter ;


delimiter //
create procedure save_project(in Name varchar(20), in Start_date varchar(20), in Completion_date varchar(20), in Price float, in Personal_id_Number varchar(20), in Client_id_Number varchar(20), out project_id integer)
begin
INSERT INTO `construction_company`.`project` (`Name`, `Start_date`, `Completion_date`, `Price`) VALUES (Name, Start_date, Completion_date, Price);
set project_id = (select LAST_INSERT_ID());
INSERT INTO `construction_company`.`is_project_menager` (`Project_id`, `Personal_id_Number`, `Start_date`) VALUES (id, Personal_id_Number, (SELECT CURDATE()));

INSERT INTO `construction_company`.`commissions` (`Personal_id_Number`, `Project_id`, `Price`, `Date`) VALUES (Client_id_Number, project_id, '0', (SELECT CURDATE()));

end //
delimiter ;