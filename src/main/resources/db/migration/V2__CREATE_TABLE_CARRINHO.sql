create table carrinho(
    id bigint not null auto_increment,
    cliente_id bigint not null,
    produto_id bigint not null,
    quantidade_produto integer,

    primary key(id)
);

