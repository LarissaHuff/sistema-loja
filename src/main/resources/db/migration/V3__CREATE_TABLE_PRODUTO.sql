create table produto(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    quantidade_minima varchar(100) not null,
    preco varchar(100) not null,
    descricao varchar(100) not null,
    quantidade varchar(100) not null,

    primary key(id)
);

