Create table users(
	id serial primary key
,	first_name varchar(16) not null
,	last_name varchar(16) not null
,	email text UNIQUE not null
,	password varchar(16) not null
,	is_logging boolean DEFAULT false
);

create table items(
	id serial primary key
,	name varchar(30) not null
,	info_title varchar(50) not null
,	info text DEFAULT null
,	price integer not null
,	stock integer not null
,	number_sold integer not null DEFAULT 0
,	player_min integer not null
,	player_max integer not null
,	time_min integer not null
,	time_max integer not null
,	is_soldout boolean DEFAULT false
);

create table photos(
	id serial primary key
,	info_base64 text 
,	item_id integer not null REFERENCES items(id)
,	master_item_id integer UNIQUE REFERENCES items(id)
);

create table favorite_items(
	id serial primary key
,	user_id integer not null REFERENCES users(id)
,	item_id integer not null REFERENCES items(id)
);

create table purchase_items(
	id serial primary key
,	user_id integer not null REFERENCES users(id)
,	item_id integer not null REFERENCES items(id)
);

create table cart(
	id serial primary key
,	user_id integer not null REFERENCES users(id)
,	item_id integer not null REFERENCES items(id)
);
