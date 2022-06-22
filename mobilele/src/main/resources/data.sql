INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES (1, 'lucho@abv.bg', 'Lucho', 'Balew', null, 1,
        'b82b7b3277646dc24c49761ecf4846563c5ff772b7f52700871b7dc9d844f89dfede30ec3786dad4');

INSERT INTO brands(id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, NULL, 1,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsOIQwiq0_3bs7BwDa2Qk9x4PI9wv56E25VigviSG8SQ&s"),
       (2, 'Escort', 'CAR', 1976, 2000, 1, "https://autoprofi.bg/modeltypecar_image/ford-escort-vii-(gal-aal-abl).jpg"),
       (3, 'Yaris', 'CAR', 1999, NULL, 2, "https://autoprofi.bg/modeltypecar_image/ford-escort-vii-(gal-aal-abl).jpg");