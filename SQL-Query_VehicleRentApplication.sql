# Vehicle Rent Application
create database VehicleRentApplication_8035;
use VehicleRentApplication_8035;


create table role_8035(roleId_8035 int primary key, roleName_8035 varchar(20));
insert into role_8035(roleId_8035, roleName_8035) values (101, 'Admin'),(102, 'Customer');


create table userDetails_8035
(uid_8035 int primary key, uname_8035 varchar(50) , upassword_8035 varchar(50) , 
ucity_8035 varchar(50) , uemail_8035 varchar(100) , ucontactnumber_8035 long , roleId_8035 int,
constraint fk_roleId foreign key (roleId_8035) references role_8035(roleId_8035));

insert into userdetails_8035 (uid_8035, upassword_8035, roleId_8035) values (1111, 'admin@1111',101);


create table vehicleDetails_8035
(vehicleType_8035 varchar(50), vehicleName_8035 varchar(50), 
bookingPrice_8035 double, vehicleNumber_8035 varchar(50) primary key, 
vehicleDiscount_8035 double, feedback_8035 varchar(100));



create table bookingDetails_8035
(vehicleNumber_8035 varchar(50) , vehiclePrice_8035 double , 
vehicleDiscount_8035 double, finalPrice_8035 double, 
constraint fk_vNum foreign key (vehicleNumber_8035) references vehicleDetails_8035(vehicleNumber_8035));
