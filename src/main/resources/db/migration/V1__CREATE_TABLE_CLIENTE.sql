create table cliente(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    data_nascimento date not null,
    numero_documento varchar(20) not null,
    tipo_documento varchar(20) not null,

    primary key(id)
);

