-- Member table data
INSERT INTO member (id, reg_date, email, password, profile_img, profile_name)
VALUES (1, '2024-10-14 11:00:00', 'user1@example.com', 'password1', 'https://example.com/user1.png', 'User One');
INSERT INTO member (id, reg_date, email, password, profile_img, profile_name)
VALUES (2, '2024-10-14 11:30:00', 'user2@example.com', 'password2', 'https://example.com/user2.png', 'User Two');
INSERT INTO member (id, reg_date, email, password, profile_img, profile_name)
VALUES (3, '2024-10-14 12:00:00', 'user3@example.com', 'password3', 'https://example.com/user3.png', 'User Three');
INSERT INTO member (id, reg_date, email, password, profile_img, profile_name)
VALUES (4, '2024-10-14 12:30:00', 'user4@example.com', 'password4', 'https://example.com/user4.png', 'User Four');
INSERT INTO member (id, reg_date, email, password, profile_img, profile_name)
VALUES (5, '2024-10-14 13:00:00', 'user5@example.com', 'password5', 'https://example.com/user5.png', 'User Five');
INSERT INTO member (id, reg_date, email, password, profile_img, profile_name)
VALUES (6, '2024-10-14 16:00:00', 'user6@example.com', 'password6', 'https://example.com/user6.png', '홍길동');
INSERT INTO member (id, reg_date, email, password, profile_img, profile_name)
VALUES (7, '2024-10-14 16:30:00', 'user7@example.com', 'password7', 'https://example.com/user7.png', '김철수');
INSERT INTO member (id, reg_date, email, password, profile_img, profile_name)
VALUES (8, '2024-10-14 17:00:00', 'user8@example.com', 'password8', 'https://example.com/user8.png', '이영희');

-- Website table data
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (1, '2024-10-14 12:00:00', 'Example Website 1', 'https://example1.com', 1);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (2, '2024-10-14 12:30:00', 'Example Website 2', 'https://example2.com', 2);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (3, '2024-10-14 13:30:00', 'Example Website 3', 'https://example3.com', 3);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (4, '2024-10-14 14:00:00', 'Example Website 4', 'https://example4.com', 4);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (5, '2024-10-14 14:30:00', 'Example Website 5', 'https://example5.com', 5);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (6, '2024-10-14 15:00:00', 'Example Website 6', 'https://example6.com', 1);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (7, '2024-10-14 15:30:00', 'Example Website 7', 'https://example7.com', 2);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (8, '2024-10-14 17:30:00', '홍길동의 블로그', 'https://hongblog.com', 6);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (9, '2024-10-14 18:00:00', '김철수의 쇼핑몰', 'https://cheolshop.com', 7);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (10, '2024-10-14 18:30:00', '이영희의 맛집', 'https://leefood.com', 8);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (11, '2024-10-15 09:00:00', '홍길동의 프로그래밍 강좌', 'https://hongcode.com', 6);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (12, '2024-10-15 09:30:00', '김철수의 스포츠 뉴스', 'https://cheolsports.com', 7);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (13, '2024-10-15 10:00:00', '이영희의 여행 블로그', 'https://leetravel.com', 8);
INSERT INTO website (id, reg_date, name, url, member_id)
VALUES (14, '2024-10-15 10:30:00', '이영희의 요리 레시피', 'https://leerecipe.com', 8);

-- Category table data
INSERT INTO category (id, website_id, name)
VALUES (1, 1, 'Tech');
INSERT INTO category (id, website_id, name)
VALUES (2, 1, 'News');
INSERT INTO category (id, website_id, name)
VALUES (3, 2, 'Entertainment');
INSERT INTO category (id, website_id, name)
VALUES (4, 2, 'Sports');
INSERT INTO category (id, website_id, name)
VALUES (5, 3, 'Education');
INSERT INTO category (id, website_id, name)
VALUES (6, 3, 'Science');
INSERT INTO category (id, website_id, name)
VALUES (7, 4, 'Business');
INSERT INTO category (id, website_id, name)
VALUES (8, 5, 'Health');
INSERT INTO category (id, website_id, name)
VALUES (9, 6, 'Travel');
INSERT INTO category (id, website_id, name)
VALUES (10, 7, 'Food');
INSERT INTO category (id, website_id, name)
VALUES (11, 7, 'Lifestyle');
INSERT INTO category (id, website_id, name)
VALUES (12, 8, '개인 블로그');
INSERT INTO category (id, website_id, name)
VALUES (13, 8, 'IT');
INSERT INTO category (id, website_id, name)
VALUES (14, 9, '전자상거래');
INSERT INTO category (id, website_id, name)
VALUES (15, 9, '패션');
INSERT INTO category (id, website_id, name)
VALUES (16, 10, '맛집');
INSERT INTO category (id, website_id, name)
VALUES (17, 10, '여행');

INSERT INTO category (id, website_id, name)
VALUES (18, 8, 'IT');
INSERT INTO category (id, website_id, name)
VALUES (19, 8, '개인 블로그');
INSERT INTO category (id, website_id, name)
VALUES (20, 11, 'IT');
INSERT INTO category (id, website_id, name)
VALUES (21, 11, '교육');
INSERT INTO category (id, website_id, name)
VALUES (22, 9, '전자상거래');
INSERT INTO category (id, website_id, name)
VALUES (23, 9, '패션');
INSERT INTO category (id, website_id, name)
VALUES (24, 12, '스포츠');
INSERT INTO category (id, website_id, name)
VALUES (25, 12, '뉴스');
INSERT INTO category (id, website_id, name)
VALUES (26, 10, '맛집');
INSERT INTO category (id, website_id, name)
VALUES (27, 10, '여행');
INSERT INTO category (id, website_id, name)
VALUES (28, 13, '여행');
INSERT INTO category (id, website_id, name)
VALUES (29, 13, '사진');
INSERT INTO category (id, website_id, name)
VALUES (30, 14, '음식');
INSERT INTO category (id, website_id, name)
VALUES (31, 14, '건강');


-- WebsiteImage table data
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (1, TRUE, 1, 'https://example1.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (2, FALSE, 1, 'https://example1.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (3, TRUE, 2, 'https://example2.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (4, FALSE, 2, 'https://example2.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (5, TRUE, 3, 'https://example3.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (6, FALSE, 3, 'https://example3.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (7, TRUE, 4, 'https://example4.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (8, FALSE, 4, 'https://example4.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (9, TRUE, 5, 'https://example5.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (10, FALSE, 5, 'https://example5.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (11, TRUE, 6, 'https://example6.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (12, FALSE, 6, 'https://example6.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (13, TRUE, 7, 'https://example7.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (14, FALSE, 7, 'https://example7.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (15, TRUE, 8, 'https://hongblog.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (16, FALSE, 8, 'https://hongblog.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (17, TRUE, 9, 'https://cheolshop.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (18, FALSE, 9, 'https://cheolshop.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (19, TRUE, 10, 'https://leefood.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (20, FALSE, 10, 'https://leefood.com/images/banner.png');

INSERT INTO website_image (id, is_default, website_id, src)
VALUES (21, TRUE, 11, 'https://hongcode.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (22, FALSE, 11, 'https://hongcode.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (23, TRUE, 12, 'https://cheolsports.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (24, FALSE, 12, 'https://cheolsports.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (25, TRUE, 13, 'https://leetravel.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (26, FALSE, 13, 'https://leetravel.com/images/banner.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (27, TRUE, 14, 'https://leerecipe.com/images/logo.png');
INSERT INTO website_image (id, is_default, website_id, src)
VALUES (28, FALSE, 14, 'https://leerecipe.com/images/banner.png');



