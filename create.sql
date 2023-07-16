
    create table posts (
       id bigserial not null,
        text varchar(255) not null,
        title varchar(255) not null,
        primary key (id)
    );

    alter table if exists posts 
       add constraint UK_17h9osytfi41h20dw5yt7fjoy unique (text);

    create table post (
       id bigserial not null,
        text varchar(255) not null,
        title varchar(255) not null,
        primary key (id)
    );

    alter table if exists post 
       add constraint UK_f4a39kws7uu0ckas0i1ba3iy6 unique (text);

    create table post (
       id bigserial not null,
        text varchar(255) not null,
        title varchar(255) not null,
        primary key (id)
    );

    alter table if exists post 
       add constraint UK_f4a39kws7uu0ckas0i1ba3iy6 unique (text);

    create table post (
       id bigserial not null,
        text varchar(255) not null,
        title varchar(255) not null,
        primary key (id)
    );

    alter table if exists post 
       add constraint UK_f4a39kws7uu0ckas0i1ba3iy6 unique (text);

    create table posts (
       id bigserial not null,
        text varchar(255) not null,
        title varchar(255) not null,
        primary key (id)
    );

    alter table if exists posts 
       add constraint UK_17h9osytfi41h20dw5yt7fjoy unique (text);
