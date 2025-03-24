-- Script para criação de usuário no banco de dados (pode rodar tudo de uma vez só).
-- Responsável por conectar o banco de dados ao back-end.
-- Autora: Amanda Caetano Nasser
-- Data: 21/03/2025

USE master -- Importante começar no banco de dados "master"

CREATE LOGIN techsmart_user WITH PASSWORD = '$Ue+bes7AH{$';
GO

USE TechSmartDB -- Após o script acima, as linhas seguintes irão rodar no banco TechSmartDB
CREATE USER techsmart_user FOR LOGIN techsmart_user;
GO

ALTER ROLE db_owner ADD MEMBER techsmart_user;
GO