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

 
SELECT * FROM employee left join person on employee.Personal_id_Number=person.Personal_id_Number;
SELECT * FROM employee left join user_account on employee.Personal_id_Number=user_account.Personal_id_Number where ;