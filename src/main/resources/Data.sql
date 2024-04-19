INSERT INTO users VALUES (1, 'Adam', 'test@example.com')

INSERT INTO categories VALUES (1, 'Travel')
INSERT INTO categories VALUES (2, 'Food')
INSERT INTO categories VALUES (3, 'Shopping')

--create table expenses (category_id bigint, expense_date timestamp(6) with time zone, id bigint not null, user_id bigint, description varchar(255), location varchar(255), primary key (id))
INSERT INTO expenses VALUES (1, '2020-01-01T06:00:00.000Z', 1, 1, 'Flight', 'London')
INSERT INTO expenses VALUES (1, '2020-01-02T10:00:00.000Z', 2, 1, 'Hotel', 'London')
INSERT INTO expenses VALUES (2, '2020-01-02T20:00:00.000Z', 3, 1, 'Dinner', 'London')
INSERT INTO expenses VALUES (3, '2020-01-03T12:00:00.000Z', 4, 1, 'T-Shirt', 'London')