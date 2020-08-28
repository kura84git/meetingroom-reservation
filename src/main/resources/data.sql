-- 会議室
INSERT INTO meeting_room (room_name) VALUES ('本町');
INSERT INTO meeting_room (room_name) VALUES ('肥後橋');
INSERT INTO meeting_room (room_name) VALUES ('難波');
INSERT INTO meeting_room (room_name) VALUES ('堺筋本町');
INSERT INTO meeting_room (room_name) VALUES ('梅田');
INSERT INTO meeting_room (room_name) VALUES ('新大阪');
INSERT INTO meeting_room (room_name) VALUES ('江坂');

-- 会議室の予約可能日(room_idが2～6用のSQLは省略)
-- 本町
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 1);

-- 江坂
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 7);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 7);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 7);

-- ダミーユーザー(password = demo)
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES('taro-yamada', '太郎', '山田', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'USER');

-- 認証確認用のテストユーザー(password = demo)
INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES('aaaa', 'aaa', 'aaa', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'USER');

INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES('bbbb', 'bbb', 'bbb', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'USER');

INSERT INTO usr (user_id, first_name, last_name, password, role_name) VALUES('cccc', 'ccc', 'ccc', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'ADMIN');
