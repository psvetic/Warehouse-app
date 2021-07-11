create table parts
(
    serial_number    int          not null,
    manufacture_date date         not null,
    part_name        varchar(255) not null,
    primary key (serial_number)
);

create table makes
(
    idmake int          not null,
    name   varchar(255) not null,
    primary key (idmake)
);

create table models
(
    idmodel int          not null,
    idmake  int          not null references makes (idmake),
    name    varchar(255) not null,
    primary key (idmodel)
);

create table model_parts
(
    serial_number int not null references parts (serial_number),
    idmodel       int not null references models (idmodel)
);

create table products
(
    serial_number    int          not null,
    manufacture_date date         not null,
    product_name     varchar(255) not null,
    base_price       numeric(16,2)         not null,
    primary key (serial_number)
);

create table discounts
(
    iddiscount    int  not null,
    starting_date date,
    ending_date   date,
    percent       int not null,
    primary key (iddiscount)
);

create table product_discounts
(
    serial_number int not null references products (serial_number),
    iddiscount    int not null references discounts (iddiscount)
);

insert into parts (serial_number, manufacture_date, part_name)
VALUES (1, '2020-01-01', 'volan'),
       (2, '2020-02-02', 'filter ulja'),
       (3, '2020-11-11', 'akumulator 64Ah'),
       (4, '2018-05-05', 'tepih'),
       (5, '2021-03-10', 'kočioni disk');

insert into makes (idmake, name)
VALUES (10, 'Audi'),
       (20, 'Mitsubishi'),
       (30, 'Citroen'),
       (40, 'Dodge');

insert into models (idmodel, idmake, name)
VALUES (101, 10, 'A1'),
       (102, 10, 'A3'),
       (103, 10, 'A6'),
       (201, 20, 'Lancer'),
       (202, 20, 'Carisma'),
       (203, 20, 'Pajero'),
       (301, 30, 'C3'),
       (302, 30, 'C4'),
       (401, 40, 'Viper'),
       (402, 40, 'Challenger'),
       (403, 40, 'Charger');

insert into model_parts (serial_number, idmodel)
VALUES (1, 102),
       (2, 101),
       (2, 102),
       (1, 101),
       (4, 301),
       (4, 302),
       (3, 201),
       (3, 202),
       (3, 203),
       (2, 201),
       (5, 401),
       (5, 402),
       (5, 403);

insert into products (serial_number, base_price, manufacture_date, product_name)
VALUES (1, 250, '2020-01-01', 'volan'),
       (2, 48, '2020-02-02', 'filter ulja'),
       (3, 780.90, '2020-11-11', 'akumulator 64Ah'),
       (4, 150, '2018-05-05', 'tepih'),
       (5, 300, '2021-03-10', 'kočioni disk');

insert into discounts (iddiscount, starting_date, ending_date, percent)
VALUES (111, '2020-01-01', '2020-02-02', 15),
       (222, '2020-02-02', '2020-03-03', 20),
       (333, '2020-03-03', '2020-04-04', 50);

insert into product_discounts (serial_number, iddiscount)
VALUES (3, 111),
       (1, 333),
       (4, 333);
