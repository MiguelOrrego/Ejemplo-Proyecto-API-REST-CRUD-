
create database libros_crud;
use libros_crud;

create table libros(
id int auto_increment primary key,
nombre varchar(50),
autor varchar(50),
edicion varchar(5)
)