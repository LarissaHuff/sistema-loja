create table cupom(
    id bigint not null auto_increment,
    valor bigint not null,
    codigo varchar(60) not null,
    tipo_desconto varchar(60) not null,
    valor_minimo_da_compra INTEGER not null,
    quantidade INTEGER not null,
    data_expiracao DATE not null,
    ativo VARCHAR(5) not null,


    primary key(id)
);

