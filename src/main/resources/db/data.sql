INSERT INTO Company (id, email, registration_code, company_name, address, logo_url) VALUES
(1, 'google@gmail.com', 11111, 'Google Lietuva', 'Verkiu 1, Vilnius', 'profile.jpg'),
(2, 'billgates@ms.com', 22222, 'Microsoft Lietuva', 'Verkiu 2, Kaunas', 'profile.jpg');


INSERT INTO POST (id, title, type, description, created_at, location, apply_url, company_url, logo_url, company_id)
VALUES
(1, 'Junior JAVA developer', 'full-time', 'Bla bla bla', CURRENT_TIMESTAMP(),
'Vilnius', '#', '#', 'logo.jpg', 1),
(2, 'Senior C# developer', 'full-time', 'Bla bla bla', CURRENT_TIMESTAMP(),
 'Kaunas', '#', '#', 'logo.jpg', 2);


INSERT INTO Company_Posts(company_id, posts_id) VALUES
(1, 1),
(2, 2);