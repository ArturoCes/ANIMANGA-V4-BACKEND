
INSERT INTO category (id, name, description ) VALUES ('ac1b039a866e153381866e298c1d0001', 'Shonen','El manga que va dirigido a los chicos adolescentes recibe el nombre de shōnen. Son series con grandes dosis de acción, en las que a menudo se dan situaciones humorísticas. Destaca el compañerismo entre miembros de un colectivo o de un equipo de combate');
INSERT INTO category (id, name, description ) VALUES ('ac1b039a866e153381866e298c1d0002', 'Seinen','El seinen.');

INSERT INTO manga (id, author, description, name, poster_path, publisher, release_date) VALUES ('ac1b039a866e153381866e298c1d0003','Masashi Kishimoto','Manga de ninjas','Jujutsu Kaisen','http://localhost:8080/download/1974728986_391575.jpg','Norma Editorial', '2020-03-03');
INSERT INTO manga (id, author, description, name, poster_path, publisher, release_date) VALUES('ac1b039a866e153381866e298c1d0004','Gege Akutami', 'Manga de hechizeros','Jujutsu Kaisen','http://10.0.2.2:8080/download/jujutsu-kaisen-vol-11.jpg','Norma Editorial','2020-04-04');
INSERT INTO manga (id, author, description, name, poster_path, publisher, release_date) VALUES('ac1b039a866e153381866e298c1d0005','Gege Akutami', 'Manga de hechizeros','Jujutsu Kaisen','http://10.0.2.2:8080/download/image.jpg','Norma Editorial','2020-04-04');

INSERT INTO categories(manga_id, category_id)VALUES ('ac1b039a866e153381866e298c1d0003','ac1b039a866e153381866e298c1d0001');
INSERT INTO categories(manga_id, category_id)VALUES ('ac1b039a866e153381866e298c1d0004','ac1b039a866e153381866e298c1d0001');
INSERT INTO categories(manga_id, category_id)VALUES ('ac1b039a866e153381866e298c1d0005','ac1b039a866e153381866e298c1d0002');