create database 20231164010027_manipula_produto;
use 20231164010027_manipula_produto;

create table produto (
    id int not null primary key auto_increment,
    nome varchar(20) not null,
    valor decimal(4,2) not null,
    quantidade int not null,
    medida varchar(10) not null
);

insert into produto (nome, valor, quantidade, medida) 
values ("arroz", 1.90, 33, "kg");

insert into produto (nome, valor, quantidade, medida)
values ("feijão", 3.85, 82, "kg");
 
insert into produto (nome, valor, quantidade, medida)
values ("miojo", 1.20, 22, "unidade");
 
insert into produto (nome, valor, quantidade, medida)
values ("tomate", 3.05, 128, "kg");
 
insert into produto (nome, valor, quantidade, medida)
values ("cenoura", 2.50, 173, "kg");
 
insert into produto (nome, valor, quantidade, medida)
values ("batata", 2.38, 74, "kg");
 
insert into produto (nome, valor, quantidade, medida)
values ("pão", 10.25, 570, "g");
 
insert into produto (nome, valor, quantidade, medida)
values ("queijo", 12.50, 120, "kg");
 
insert into produto (nome, valor, quantidade, medida)
values ("água", 2.21, 88, "l");
 
set sql_safe_updates = 0;

update produto
set quantidade = 100 
where medida = 'kg';

delete from produto 
where valor <= 2 or quantidade < 90;

update produto 
set valor = 2 * valor;

select * from produto;
