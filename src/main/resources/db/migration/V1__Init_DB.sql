create table addresses (
    id int8 not null,
    city varchar(255) not null,
    mail_index varchar(255) not null,
    street varchar(255) not null,
    street_number int4 not null,
    primary key (id)
);

create table contacts (
    id int8 not null,
    contact varchar(255) not null,
    contact_type varchar(255) not null,
    person_id int8 not null,
    primary key (id)
);

create table documents (
    id int8 not null,
    document_type varchar(255) not null,
    person_id int8 not null,
    value varchar(255) not null,
    primary key (id)
);

create table persons (
    id int8 not null,
    name varchar(255) not null,
    patronymic varchar(255) not null,
    surname varchar(255) not null,
    primary key (id)
);

create table persons_addresses (
    address_id int8 not null,
    address_type varchar(255) not null,
    person_id int8 not null,
    primary key (address_id)
);

create table vaccination_centres (
    id int8 not null,
    address varchar(255) not null,
    name varchar(255) not null,
    primary key (id)
);

create table vaccinations (
    id int8 not null,
    passport varchar(255) not null,
    patient_name varchar(255) not null,
    patient_patronymic varchar(255) not null,
    patient_surname varchar(255) not null,
    point_id int8 not null,
    vaccination_date timestamp not null,
    vaccine_id int8 not null,
    primary key (id)
);

create table vaccines (
    id int8 not null,
    name varchar(255) not null,
    primary key (id)
)