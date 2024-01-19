create table compra(
    id bigint not null auto_increment,
    valor_total DOUBLE not null,
    id_cliente bigint not null,
    tipo_pagamento varchar(20) not null,


    primary key(id)
);

