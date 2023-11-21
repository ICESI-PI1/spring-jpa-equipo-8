INSERT INTO author (name, nationality) VALUES ('Isabel Allende', 'Chilena');
INSERT INTO author (name, nationality) VALUES ('Gabriel García Márquez', 'Colombiana');
INSERT INTO author (name, nationality) VALUES ('Mario Vargas Llosa', 'Peruana');
INSERT INTO author (name, nationality) VALUES ('Jorge Luis Borges', 'Argentina');
INSERT INTO author (name, nationality) VALUES ('Carlos Fuentes', 'Mexicana');

INSERT INTO book (release_date, title, author_id) VALUES ('1982-01-01', 'La casa de los espíritus', (SELECT id FROM author WHERE name = 'Isabel Allende'));
INSERT INTO book (release_date, title, author_id) VALUES ('1967-06-05', 'Cien años de soledad', (SELECT id FROM author WHERE name = 'Gabriel García Márquez'));
INSERT INTO book (release_date, title, author_id) VALUES ('1969-01-01', 'Conversación en La Catedral', (SELECT id FROM author WHERE name = 'Mario Vargas Llosa'));
INSERT INTO book (release_date, title, author_id) VALUES ('1949-01-01', 'El Aleph', (SELECT id FROM author WHERE name = 'Jorge Luis Borges'));
INSERT INTO book (release_date, title, author_id) VALUES ('1985-01-01', 'La región más transparente', (SELECT id FROM author WHERE name = 'Carlos Fuentes'));
