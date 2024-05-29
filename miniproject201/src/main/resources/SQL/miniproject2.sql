use spring;
SHOW TABLES;

-- admin 1234qwer
-- 회원리스트
DROP TABLE memberlist;
CREATE TABLE memberlist (
    member_id VARCHAR(100) PRIMARY KEY,
    member_pass VARCHAR(100) NOT NULL,
    member_nick VARCHAR(100) NOT NULL,
    member_address VARCHAR(500) NOT NULL,
    member_point DECIMAL(15, 0),
    member_phone VARCHAR(100),
    member_email VARCHAR(300)
);

-- 물품 리스트 테이블
DROP TABLE itemlist;
CREATE TABLE itemlist (
    item_num VARCHAR(100) PRIMARY KEY,
    item_name VARCHAR(100) NOT NULL,
    item_producer VARCHAR(100),
    item_content VARCHAR(1000),
    item_price DECIMAL(15, 0) NOT NULL,
    item_file VARCHAR(1000),
    item_itr CHAR(1) DEFAULT '0',
    item_start_date VARCHAR(100) NOT NULL,
    item_end_date VARCHAR(100) NOT NULL,
    member_id VARCHAR(100),
    CONSTRAINT fk_itemlist_member FOREIGN KEY (member_id) REFERENCES memberlist(member_id)
);


-- 관심물품리스트
DROP TABLE bid_list;
CREATE TABLE bid_list (
    fonky_member_id VARCHAR(100),
    fonky_item_num VARCHAR(100),
    bid_num VARCHAR(100) PRIMARY KEY,
    CONSTRAINT fk_bid_list_member FOREIGN KEY (fonky_member_id) REFERENCES memberlist(member_id),
    CONSTRAINT fk_bid_list_item FOREIGN KEY (fonky_item_num) REFERENCES itemlist(item_num)
);

-- 실시간옥션리스트
DROP TABLE auction;
CREATE TABLE auction (
    auction_num VARCHAR(100) primary key,
    member_id VARCHAR(100),
    item_num VARCHAR(100),
    reg_price DECIMAL(15, 0),
    CONSTRAINT fk_auction_member FOREIGN KEY (member_id) REFERENCES memberlist(member_id),
    CONSTRAINT fk_auction_item FOREIGN KEY (item_num) REFERENCES itemlist(item_num)
);

-- 내가 구매한 리스트
DROP TABLE purchased_list;
CREATE TABLE purchased_list (
    purchase_id VARCHAR(100) PRIMARY KEY,
    member_id VARCHAR(100),
    item_num VARCHAR(100),
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_purchased_member FOREIGN KEY (member_id) REFERENCES memberlist(member_id),
    CONSTRAINT fk_purchased_item FOREIGN KEY (item_num) REFERENCES itemlist(item_num)
);

-- 아이템 시퀀스 생성 밑 아이템 insert 할때 자동으로 생성되게 연동
DROP TABLE item_seq;
CREATE TABLE item_seq (
    id INT AUTO_INCREMENT PRIMARY KEY,
    seq_value INT NOT NULL
);

-- 초기 값 설정
INSERT INTO item_seq (seq_value) VALUES (0);
SHOW TABLES;

DELIMITER $$

CREATE TRIGGER before_insert_itemlist
BEFORE INSERT ON itemlist
FOR EACH ROW
BEGIN
    -- 시퀀스 값 증가
    UPDATE item_seq SET seq_value = LAST_INSERT_ID(seq_value + 1);
    
    -- 새로운 item_num 생성
    SET NEW.item_num = CONCAT('itn-', LPAD(LAST_INSERT_ID(), 5, '0'));
END $$

DELIMITER ;

-- 옥션 시퀀스 생성 밑 옥션생성할때 자동으로 생성되게 연동
DROP TABLE auction_seq;
CREATE TABLE auction_seq (
    id INT AUTO_INCREMENT PRIMARY KEY,
    seq_value INT NOT NULL
);

-- 초기 값 설정
INSERT INTO auction_seq (seq_value) VALUES (0);


DELIMITER $$

CREATE TRIGGER before_insert_auction
BEFORE INSERT ON auction
FOR EACH ROW
BEGIN
    -- 시퀀스 값 증가
    UPDATE auction_seq SET seq_value = LAST_INSERT_ID(seq_value + 1);
    
    -- 새로운 item_num 생성
    SET NEW.auction_num = CONCAT('atn-', LPAD(LAST_INSERT_ID(), 5, '0'));
END $$

DELIMITER ;

-- 아이템리스트 셀렉트--
select * from itemList;
	SELECT
	i.*,
	m.member_nick
	FROM
	itemlist i
	JOIN
	memberlist m
	ON
	i.member_id = m.member_id
	ORDER BY
	CAST(SUBSTRING(i.item_num, 5) AS UNSIGNED) DESC;
    delete from itemList where item_producer like '%캐딜락%';
    update itemList set member_id='admin' where item_num like '%itn%';
    Select * from itemList;
    update memberList set member_point=40000000 where member_id='admin';
    select * from itemlist where item_num='itn-00011';
    
    -- 옥션 셀렉트
    		SELECT 
    a.auction_num,
    a.reg_price,
    a.member_id,
    m.member_nick
FROM 
    auction a
JOIN 
    memberlist m ON a.member_id = m.member_id
ORDER BY 
    CAST(SUBSTRING(a.auction_num, 5) AS UNSIGNED) DESC;
    
    

use spring;
select * from itemList;
select * from memberList;

-- 회원추가   admin 1234qwer
insert into memberList values ('knj1111','$2a$10$Mz2k7pAeyMwwVrj5O9CEo.dUV3xAJJUo5kpqw.wf7qj4hFJoB5q0u','dfweio','서울 강서구 강서로18길 103 (화곡동, 아줄포레)',0,'010-3141-1355','skh9301@naver.com');
insert into memberList values ('admin','$2a$10$1N169NpG4BDv3fmJmx8Hdu2IMeVqmJn/SGY7qlqNBqQkAuYLQBzTC','운영자','서울 서대문구 가좌로 15 (연희동, 연궁아파트)',0,null,'gmial@naver.com');
-- 물품추가
insert into itemList values ('itn-00015','KGM 토레스 세션정장','KGM ','경형 해치백 2024',12900000,'6967e5c3-dde3-4ed7-8762-035ba384a7f9_다운로드.jpg',0,'2024-05-27T15:30','2024-05-30T12:00','admin');
insert into itemList values ('itn-00016','KGM 토레스 세션정장','KGM ','경형 해치백 2024',12900000,'6967e5c3-dde3-4ed7-8762-035ba384a7f9_다운로드.jpg',0,'2024-05-27T16:00','2024-05-28T15:00','admin');
insert into itemList values ('itn-00017','KGM 토레스 세션정장','KGM ','경형 해치백 2024',12900000,'6967e5c3-dde3-4ed7-8762-035ba384a7f9_다운로드.jpg',0,'2024-05-28T14:30','2024-05-31T10:30','admin');
insert into itemList values ('itn-00018','KGM 토레스','몰라유 ','중형SUV',800000,'b62eacaf-7524-4118-9343-878e511c1b92_다운로드.jpg',0,'2024-05-29T10:30','2024-08-15T12:30','admin');
insert into itemList values ('itn-00019','KGM 토레스 세션정장','KGM ','경형 해치백 2024',12900000,'6967e5c3-dde3-4ed7-8762-035ba384a7f9_다운로드.jpg',0,'2024-05-30T15:00','2024-06-10T14:00','admin');

-- 경매 시작 및 종료 여부
SELECT i.*, i.item_start_date < sysdate() isStarted, i.item_end_date < sysdate() isFinished FROM itemList i;