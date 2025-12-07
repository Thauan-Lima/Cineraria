CREATE DATABASE escola;

USE escola;

CREATE TABLE aluno (
    numero INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    nota1 DOUBLE NOT NULL,
    nota2 DOUBLE NOT NULL,
    nota3 DOUBLE NOT NULL,
    nota4 DOUBLE NOT NULL
);
