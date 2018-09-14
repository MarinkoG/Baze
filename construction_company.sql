drop schema if exists construction_company;
create schema construction_company default character set utf8 default collate utf8_unicode_ci;
use construction_company;


CREATE TABLE ADDRESS
(
	Address_id            INTEGER AUTO_INCREMENT,
	City                  VARCHAR(50) NULL,
	Street                VARCHAR(50) NULL,
	Zip_code              VARCHAR(20) NULL,
	House_number          VARCHAR(20) NULL,
	 PRIMARY KEY (Address_id)
)
;



CREATE TABLE BUILDING
(
	Building_id           INTEGER AUTO_INCREMENT,
	Name                  VARCHAR(20) NULL,
	Description           VARCHAR(20) NULL,
	Address_id            INTEGER NULL,
	 PRIMARY KEY (Building_id)
)
;



CREATE TABLE CLIENT
(
	Invoice               INTEGER NULL,
	Personal_id_Number    VARCHAR(20) NOT NULL,
	 PRIMARY KEY (Personal_id_Number)
)
;



CREATE TABLE COMMISSIONS
(
	Personal_id_Number    VARCHAR(20) NOT NULL,
	Project_id            INTEGER NOT NULL,
	Price                 INTEGER NULL,
	Date                  DATE NULL,
	 PRIMARY KEY (Personal_id_Number,Project_id)
)
;



CREATE TABLE DEPARTMENT
(
	Department_id         INTEGER AUTO_INCREMENT,
	Name                  VARCHAR(20) NULL,
	Description           VARCHAR(100) NULL,
	Phone_number          VARCHAR(20) NULL,
	E_mail                VARCHAR(20) NULL,
	 PRIMARY KEY (Department_id)
)
;



CREATE TABLE EMPLOYEE
(
	Personal_id_Number    VARCHAR(20) NOT NULL,
	Salary                INTEGER NULL,
	Bank_account          VARCHAR(20) NULL,
	Profession            VARCHAR(20) NULL,
	Hourly_rate           INTEGER NULL,
	 PRIMARY KEY (Personal_id_Number)
)
;



CREATE TABLE HEAVY_EQUIPEMENT
(
	Power                 INTEGER NULL,
	Vehicle_id            INTEGER NOT NULL,
	 PRIMARY KEY (Vehicle_id)
)
;



CREATE TABLE MATERIAL
(
	Material_id           INTEGER AUTO_INCREMENT,
	Name                  VARCHAR(20) NULL,
	Description           VARCHAR(100) NULL,
	Unit                  VARCHAR(20) NULL,
	 PRIMARY KEY (Material_id)
)
;



CREATE TABLE MATERIAL_IN_PURCHASE_ORDER
(
	Material_id           INTEGER NOT NULL,
	Purchase_order_id     INTEGER NOT NULL,
	Amount                INTEGER NULL,
	Price_per_unit        INTEGER NULL,
	 PRIMARY KEY (Material_id,Purchase_order_id)
)
;



CREATE TABLE MATERIAL_IN_WAREHOUSE
(
	Material_id           INTEGER NOT NULL,
	Amount                INTEGER NULL,
	Building_id           INTEGER NOT NULL,
	 PRIMARY KEY (Material_id,Building_id)
)
;



CREATE TABLE MATERIAL_USED_IN_STAGE
(
	Required_amount       INTEGER NULL,
	Delivered_amount      INTEGER NULL,
	Stage_id              INTEGER NOT NULL,
	Material_id           INTEGER NOT NULL,
	 PRIMARY KEY (Stage_id,Material_id)
)
;



CREATE TABLE PERSON
(
	Personal_id_Number    VARCHAR(20) NOT NULL,
	First_Name            VARCHAR(20) NULL,
	Last_Name             VARCHAR(20) NULL,
	Date_of_birth         DATE NULL,
	Address               INTEGER NULL,
	Phone_number          VARCHAR(20) NULL,
	E_mail                VARCHAR(50) NULL,
	 PRIMARY KEY (Personal_id_Number)
)
;



CREATE TABLE PRIVILEGE
(
	Name                  VARCHAR(20) NOT NULL,
	Description           VARCHAR(50) NULL,
	 PRIMARY KEY (Name)
)
;



CREATE TABLE PROJECT
(
	Project_id            INTEGER AUTO_INCREMENT,
	Name                  VARCHAR(20) NULL,
	Description           VARCHAR(100) NULL,
	Client                VARCHAR(20) NULL,
	Start_date            DATE NULL,
	Completion_date       DATE NULL,
	Price                 INTEGER NULL,
	Project_manager       VARCHAR(20) NULL,
	Address_id            INTEGER NULL,
	 PRIMARY KEY (Project_id)
)
;



CREATE TABLE PURCHASE_ORDER
(
	Purchase_order_id     INTEGER AUTO_INCREMENT,
	Description           VARCHAR(50) NULL,
	Supplier              INTEGER NULL,
	Total_price           INTEGER NULL,
	Delivery_date         DATE NULL,
	Warehouse             INTEGER NOT NULL,
	 PRIMARY KEY (Purchase_order_id)
)
;



CREATE TABLE STAGE
(
	Stage_id              INTEGER AUTO_INCREMENT,
	Name                  VARCHAR(20) NULL,
	Description           VARCHAR(100) NULL,
	Stage_start_date      DATE NULL,
	Stage_completion_date  DATE NULL,
	Project_id            INTEGER NOT NULL,
	 PRIMARY KEY (Stage_id)
)
;



CREATE TABLE TOOLS
(
	Name                  VARCHAR(20) NULL,
	Tool_id               INTEGER AUTO_INCREMENT,
	Description           VARCHAR(100) NULL,
	Amount                INTEGER NOT NULL,
	 PRIMARY KEY (Tool_id)
)
;



CREATE TABLE TOOLS_USED_IN_STAGE
(
	Tool_id               INTEGER NOT NULL,
	Stage_id              INTEGER NOT NULL,
	Required              INTEGER NULL,
	 PRIMARY KEY (Tool_id,Stage_id)
)
;



CREATE TABLE TRANSPORT_VEHICLE
(
	Vehicle_id            INTEGER NOT NULL,
	Carrying_capacity     INTEGER NULL,
	 PRIMARY KEY (Vehicle_id)
)
;



CREATE TABLE USER_ACCOUNT
(
	Username              VARCHAR(20) NULL,
	Password              VARCHAR(20) NULL,
	Privilege             VARCHAR(20) NOT NULL,
	Personal_id_Number    VARCHAR(20) NOT NULL,
	 PRIMARY KEY (Personal_id_Number)
)
;



CREATE TABLE VEHICLE
(
	Vehicle_id            INTEGER AUTO_INCREMENT,
	Name                  VARCHAR(20) NULL,
	Description           VARCHAR(50) NULL,
	Registration          VARCHAR(20) NULL,
	Status                VARCHAR(20) NULL,
	 PRIMARY KEY (Vehicle_id)
)
;



CREATE TABLE VEHICLES_USED_IN_STAGE
(
	Vehicle_id            INTEGER NOT NULL,
	Stage_id              INTEGER NOT NULL,
	 PRIMARY KEY (Vehicle_id,Stage_id)
)
;



CREATE TABLE WAREHOUSE
(
	Manager               INTEGER NULL,
	Phone_number          VARCHAR(20) NULL,
	Building_id           INTEGER NOT NULL,
	Personal_id_Number    VARCHAR(20) NULL,
	 PRIMARY KEY (Building_id)
)
;



CREATE TABLE WORKS_IN
(
	Personal_id_Number    VARCHAR(20) NOT NULL,
	Workplace             VARCHAR(50) NULL,
	Department_id         INTEGER NOT NULL,
	 PRIMARY KEY (Personal_id_Number,Department_id)
)
;



CREATE TABLE WORKS_ON
(
	From_date             DATE NULL,
	To_date               DATE NULL,
	Employee              VARCHAR(20) NOT NULL,
	Stage_id              INTEGER NOT NULL,
	 PRIMARY KEY (Employee,Stage_id)
)
;



CREATE TABLE WORKTIME_RECORD
(
	Work_hours            INTEGER NULL,
	Overtime              INTEGER NULL,
	Personal_id_Number    VARCHAR(20) NOT NULL,
	Date                  DATE NULL,
	 PRIMARY KEY (Personal_id_Number)
)
;



ALTER TABLE BUILDING
	ADD FOREIGN KEY LOCATION (Address_id) REFERENCES ADDRESS(Address_id)
;



ALTER TABLE CLIENT
	ADD FOREIGN KEY (Personal_id_Number) REFERENCES PERSON(Personal_id_Number)
		ON DELETE CASCADE
;



ALTER TABLE COMMISSIONS
	ADD FOREIGN KEY C_C (Personal_id_Number) REFERENCES CLIENT(Personal_id_Number)
;


ALTER TABLE COMMISSIONS
	ADD FOREIGN KEY P_C (Project_id) REFERENCES PROJECT(Project_id)
;



ALTER TABLE EMPLOYEE
	ADD FOREIGN KEY (Personal_id_Number) REFERENCES PERSON(Personal_id_Number)
;



ALTER TABLE HEAVY_EQUIPEMENT
	ADD FOREIGN KEY (Vehicle_id) REFERENCES VEHICLE(Vehicle_id)
		ON DELETE CASCADE
;



ALTER TABLE MATERIAL_IN_PURCHASE_ORDER
	ADD FOREIGN KEY M_MIPO (Material_id) REFERENCES MATERIAL(Material_id)
;


ALTER TABLE MATERIAL_IN_PURCHASE_ORDER
	ADD FOREIGN KEY PO_MIPO (Purchase_order_id) REFERENCES PURCHASE_ORDER(Purchase_order_id)
;



ALTER TABLE MATERIAL_IN_WAREHOUSE
	ADD FOREIGN KEY M_MIW (Material_id) REFERENCES MATERIAL(Material_id)
;


ALTER TABLE MATERIAL_IN_WAREHOUSE
	ADD FOREIGN KEY W_MIW (Building_id) REFERENCES WAREHOUSE(Building_id)
;



ALTER TABLE MATERIAL_USED_IN_STAGE
	ADD FOREIGN KEY S_MUIS (Stage_id) REFERENCES STAGE(Stage_id)
;


ALTER TABLE MATERIAL_USED_IN_STAGE
	ADD FOREIGN KEY M_MUIS (Material_id) REFERENCES MATERIAL(Material_id)
;



ALTER TABLE PERSON
	ADD FOREIGN KEY LIVES (Address) REFERENCES ADDRESS(Address_id)
;



ALTER TABLE PROJECT
	ADD FOREIGN KEY IS_PROJECT_MANAGER (Project_manager) REFERENCES EMPLOYEE(Personal_id_Number)
;


ALTER TABLE PROJECT
	ADD FOREIGN KEY IS_LOCATED (Address_id) REFERENCES ADDRESS(Address_id)
;



ALTER TABLE PURCHASE_ORDER
	ADD FOREIGN KEY DELIVERY_LOCATION (Warehouse) REFERENCES WAREHOUSE(Building_id)
;



ALTER TABLE STAGE
	ADD FOREIGN KEY CONSISTS_OF (Project_id) REFERENCES PROJECT(Project_id)
;



ALTER TABLE TOOLS_USED_IN_STAGE
	ADD FOREIGN KEY T_TUIS (Tool_id) REFERENCES TOOLS(Tool_id)
;


ALTER TABLE TOOLS_USED_IN_STAGE
	ADD FOREIGN KEY S_TUIS (Stage_id) REFERENCES STAGE(Stage_id)
;



ALTER TABLE TRANSPORT_VEHICLE
	ADD FOREIGN KEY (Vehicle_id) REFERENCES VEHICLE(Vehicle_id)
		ON DELETE CASCADE
;



ALTER TABLE USER_ACCOUNT
	ADD FOREIGN KEY IS_GRANTED (Privilege) REFERENCES PRIVILEGE(Name)
;


ALTER TABLE USER_ACCOUNT
	ADD FOREIGN KEY LOGS_IN_WITH (Personal_id_Number) REFERENCES EMPLOYEE(Personal_id_Number)
		ON DELETE CASCADE
;



ALTER TABLE VEHICLES_USED_IN_STAGE
	ADD FOREIGN KEY V_VU (Vehicle_id) REFERENCES VEHICLE(Vehicle_id)
;


ALTER TABLE VEHICLES_USED_IN_STAGE
	ADD FOREIGN KEY S_VU (Stage_id) REFERENCES STAGE(Stage_id)
;



ALTER TABLE WAREHOUSE
	ADD FOREIGN KEY (Building_id) REFERENCES BUILDING(Building_id)
		ON DELETE CASCADE
;


ALTER TABLE WAREHOUSE
	ADD FOREIGN KEY IS_MANAGER (Personal_id_Number) REFERENCES EMPLOYEE(Personal_id_Number)
;



ALTER TABLE WORKS_IN
	ADD FOREIGN KEY E_WI (Personal_id_Number) REFERENCES EMPLOYEE(Personal_id_Number)
;


ALTER TABLE WORKS_IN
	ADD FOREIGN KEY D_WI (Department_id) REFERENCES DEPARTMENT(Department_id)
;



ALTER TABLE WORKS_ON
	ADD FOREIGN KEY E_WO (Employee) REFERENCES EMPLOYEE(Personal_id_Number)
;


ALTER TABLE WORKS_ON
	ADD FOREIGN KEY S_WO (Stage_id) REFERENCES STAGE(Stage_id)
;



ALTER TABLE WORKTIME_RECORD
	ADD FOREIGN KEY WORKED (Personal_id_Number) REFERENCES EMPLOYEE(Personal_id_Number)
;


