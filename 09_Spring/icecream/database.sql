-- 1. 데이터베이스 생성 및 사용
DROP DATABASE IF EXISTS icecream_db;

CREATE DATABASE icecream_db;
USE icecream_db;

-- 2. 아이스크림 테이블 생성
DROP TABLE IF EXISTS tbl_icecream;

CREATE TABLE tbl_icecream (
                              no INT AUTO_INCREMENT PRIMARY KEY,
                              name VARCHAR(100) NOT NULL,         -- 아이스크림 이름
                              flavor VARCHAR(200) NOT NULL,       -- 맛 설명
                              price INT NOT NULL,                 -- 가격 (단위: 원)
                              reg_date DATETIME DEFAULT CURRENT_TIMESTAMP  -- 등록일
);

-- 3. 아이스크림 데이터 삽입
INSERT INTO tbl_icecream (name, flavor, price) VALUES
                                                   ('바닐라빈 클래식', '진한 바닐라의 정석', 3200),
                                                   ('초코펀치', '쌉싸름한 다크 초콜릿과 우유의 조화', 3500),
                                                   ('민트초코', '시원한 민트에 초콜릿 칩이 가득', 3400),
                                                   ('쿠키앤크림', '바삭한 쿠키 조각과 부드러운 크림의 만남', 3600),
                                                   ('말차라떼', '쌉싸름한 말차와 달콤한 라떼의 조화', 3700),
                                                   ('체리쥬빌레', '상큼한 체리와 크림의 달콤한 맛', 3900),
                                                   ('레몬셔벗', '입안을 깨우는 상큼한 레몬의 향연', 3100),
                                                   ('복숭아요거트', '달콤한 복숭아와 상큼한 요거트의 만남', 3400),
                                                   ('고구마크림', '달달한 고구마를 듬뿍 담은 부드러운 아이스크림', 3600),
                                                   ('아몬드카라멜', '고소한 아몬드와 진한 카라멜이 어우러진 맛', 3800),
                                                   ('꿀수박소르베', '수박과 꿀의 환상적인 여름 조합', 3300),
                                                   ('블루베리치즈', '진한 치즈와 새콤한 블루베리의 조화', 3700),
                                                   ('솔티드피넛', '짭짤한 땅콩과 달콤한 바닐라의 대조적인 맛', 3600),
                                                   ('흑임자모찌', '전통 흑임자와 쫀득한 모찌의 만남', 3900),
                                                   ('망고탱고', '열대 망고의 풍미와 탱글탱글한 식감', 3500);

-- 4. 확인용 조회
SELECT * FROM tbl_icecream;

show tables;
show databases ;
use icecream_db;