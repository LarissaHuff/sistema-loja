create table detalhe_compra(
    id bigint not null auto_increment,
    id_produto bigint not null,
    id_compra bigint not null,
    quantidade_produto INTEGER not null,


    primary key(id)
);

