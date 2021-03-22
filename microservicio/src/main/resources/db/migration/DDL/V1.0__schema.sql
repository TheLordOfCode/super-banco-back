create table incremento (
 id int(11) not null auto_increment,
 fechaInicio date not null,
 fechaFin date not null,
 montoInicial double not null,
 montoFinal double not null,
 primary key (id)
);