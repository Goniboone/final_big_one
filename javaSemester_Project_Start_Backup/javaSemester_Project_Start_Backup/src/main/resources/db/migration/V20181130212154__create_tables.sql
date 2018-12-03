create table customer (
  customer_id serial not null constraint customer_pk primary key,
  last_name  varchar(35) not null,
  first_name varchar(35) not null
);

create table part(
  part_id serial not null constraint parts_pk primary key,
  cost double precision not null,
  component_name varchar(50)
);

create table design(
  design_id serial not null constraint design_pk primary key,
  customer_id int constraint design_pk_customer_id_fk
  references customer,
  design_name varchar(50)
);

create table Job_form(
  job_id serial not null constraint job_pk primary key,
  job_name varchar(50) not null,
  completion_date date
);

create table employee(
  employee_id serial not null constraint employee_pk primary key,
  employee_firstName varchar(50),
  employee_lastName varchar(50)
);

create table sale_chart(
  sale_id serial not null constraint sale_pk primary key,
  sale_name varchar(50) not null,
  sale double precision,
  sale_date date
);