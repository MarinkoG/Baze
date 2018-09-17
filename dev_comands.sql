use construction_company;


drop schema if exists construction_company;
create schema construction_company default character set utf8 default collate utf8_unicode_ci;
use construction_company;


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
