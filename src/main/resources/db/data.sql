INSERT INTO USER (id, name, surname, email, password, username, profile_picture) VALUES
(1, 'Ponas', 'Bebras', '1@email.com', '{bcrypt}$2y$12$7GqAo8CRAnXRL0xPZS//C.VcrUMKvlv/htwFrEd1YnGQTcGWGAPXG', 'admin', '#'),
(2, 'Useris', 'Pirmasis', '2@email.com', '{bcrypt}$2y$12$4fUdY6AjflJLJ3eNCQSOUeixT9MlC/6jpf6QaNAmnSlGBmYTlbESy','user', '#'),
(3, 'Antrasis', 'Useris', '3@email.com', '{bcrypt}$2y$12$mZ4Gew7EpxGS8QjiMJxlnuZ7Qe1Uc3HhHi2w3tLav8MQE5nJo7zDG','company', '#');


INSERT INTO ROLE (id, role_name) VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2);


INSERT INTO Company (id, registration_code, company_name, address, logo_url, company_url)
VALUES (1, 11111, 'INVL Asset Management', 'Vilniaus rajonas, London, UK',
        'https://www.invl.com/img/invl_logo.png', '#'),
       (2, 22222, 'Revolut', 'JFK str 6, New York, USA',
        'https://pbs.twimg.com/profile_images/1252626966836060162/qXAAYQYP.png', '#'),
       (3, 33333, 'DevBridge', 'Word str 7, Word, Wales',
        'https://media-exp1.licdn.com/dms/image/C560BAQH32zNds7mloQ/company-logo_200_200/0?e=2159024400&v=beta&t=H9s6cXo2d5cgIsBpnwD49yAXkbjmTDxqJev2C4n1BjI', '#'),
       (4, 44444, 'Bark', 'Bulldog str 11, London, UK',
        'https://jobs.github.com/rails/active_storage/blobs/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBazJYIiwiZXhwIjpudWxsLCJwdXIiOiJibG9iX2lkIn19--b3a8ac07fa740beac12f8583814bcace4529db42/Bark-Primary-Logo-Black-1.png', '#'),
       (5, 55555, 'Strategic Financial Solutions', 'Sausio 13, Kaunas, Lithuania',
        'https://pbs.twimg.com/profile_images/1218201378050453507/R1g1alxT.jpg', '#'),
       (6, 66666, 'Google Lietuva', 'Sausio 13, Jonava, Lithuania',
        'https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg', '#');

INSERT INTO POST (id, title, type, description, summary, created_at, location, apply_url, company_id)
VALUES (1, 'Senior AWS Engineer', 'Remote',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when',
        'Looking for an individual who is passionate about learning new things and solving problems. ',
        CURRENT_TIMESTAMP(), 'Vilnius', '#', 1),
       (2, 'Mid/Senior Data Engineer', 'Full Time',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''''s standard dummy text ever since the 1500s, when',
        'Looking for an individual who is passionate about learning new things and solving problems. ',
        CURRENT_TIMESTAMP(), 'Kaunas','#', 1),
       (3, 'Junior Implementation Developer', 'Part Time',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''''s standard dummy text ever since the 1500s, when',
        'Looking for an individual who is passionate about learning new things and solving problems. ',
        CURRENT_TIMESTAMP(),
        'Vilnius','#', 2),
       (4, 'Senior full-stack developer', 'Full Time',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''''s standard dummy text ever since the 1500s, when',
        'Looking for an individual who is passionate about learning new things and solving problems. ',
        CURRENT_TIMESTAMP(),
        'Vilnius', '#', 3),
       (5, 'Senior Backend Engineer', 'Internship',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''''s standard dummy text ever since the 1500s, when',
        'Looking for an individual who is passionate about learning new things and solving problems. ',
        CURRENT_TIMESTAMP(),
        'Klaipėda', '#', 4),
       (6, 'Mid Node.js Developer', 'Full Time',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''''s standard dummy text ever since the 1500s, when',
        'Looking for an individual who is passionate about learning new things and solving problems. ',
        CURRENT_TIMESTAMP(),
        'Vilnius', '#', 5),
       (7, 'Mid Node.js Developer', 'Full Time',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''''s standard dummy text ever since the 1500s, when',
        'Looking for an individual who is passionate about learning new things and solving problems. ',
        CURRENT_TIMESTAMP(),
        'Vilnius', '#', 5),
       (8, 'Mid Node.js Developer', 'Full Time',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''''s standard dummy text ever since the 1500s, when',
        'Looking for an individual who is passionate about learning new things and solving problems. ',
        CURRENT_TIMESTAMP(),
        'Vilnius', '#', 5),
       (9, 'Mid Node.js Developer', 'Full Time',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''''s standard dummy text ever since the 1500s, when',
        'Looking for an individual who is passionate about learning new things and solving problems. ',
        CURRENT_TIMESTAMP(),
        'Vilnius', '#', 5);
