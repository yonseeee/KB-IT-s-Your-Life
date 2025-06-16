-- 📄 테이블 삭제 (이미 존재하면 삭제)
DROP TABLE IF EXISTS tbl_board;

-- 📋 테이블 생성
CREATE TABLE tbl_board
(
    no          INTEGER AUTO_INCREMENT PRIMARY KEY, -- 게시글 번호 (자동 증가)
    title       VARCHAR(200) NOT NULL,              -- 제목
    content     TEXT,                               -- 내용
    writer      VARCHAR(50)  NOT NULL,              -- 작성자
    reg_date    DATETIME DEFAULT CURRENT_TIMESTAMP, -- 등록일 (기본값: 현재 시간)
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP  -- 수정일 (기본값: 현재 시간)
);

-- 📝 테스트 데이터 삽입
INSERT INTO tbl_board(title, content, writer)
VALUES ('테스트 제목1', '테스트 내용1', 'user00'),
       ('테스트 제목2', '테스트 내용2', 'user00'),
       ('테스트 제목3', '테스트 내용3', 'user00'),
       ('테스트 제목4', '테스트 내용4', 'user00'),
       ('테스트 제목5', '테스트 내용5', 'user00');

-- 🔍 데이터 조회
SELECT *
FROM tbl_board;-- 📄 테이블 삭제 (이미 존재하면 삭제)
DROP TABLE IF EXISTS tbl_board;

-- 📋 테이블 생성
CREATE TABLE tbl_board
(
    no          INTEGER AUTO_INCREMENT PRIMARY KEY, -- 게시글 번호 (자동 증가)
    title       VARCHAR(200) NOT NULL,              -- 제목
    content     TEXT,                               -- 내용
    writer      VARCHAR(50)  NOT NULL,              -- 작성자
    reg_date    DATETIME DEFAULT CURRENT_TIMESTAMP, -- 등록일 (기본값: 현재 시간)
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP  -- 수정일 (기본값: 현재 시간)
);

-- 📝 테스트 데이터 삽입
INSERT INTO tbl_board(title, content, writer)
VALUES ('테스트 제목1', '테스트 내용1', 'user00'),
       ('테스트 제목2', '테스트 내용2', 'user00'),
       ('테스트 제목3', '테스트 내용3', 'user00'),
       ('테스트 제목4', '테스트 내용4', 'user00'),
       ('테스트 제목5', '테스트 내용5', 'user00');

-- 🔍 데이터 조회
SELECT *
FROM tbl_board;


DROP TABLE IF EXISTS tbl_board_attachment;
CREATE TABLE tbl_board_attachment
(
    no           INTEGER AUTO_INCREMENT PRIMARY KEY,
    filename     VARCHAR(256) NOT NULL,
    path         VARCHAR(256) NOT NULL,
    content_type VARCHAR(56),
    size         INTEGER,
    bno          INTEGER NOT NULL,
    reg_date     DATETIME DEFAULT now(),
    CONSTRAINT FOREIGN KEY (bno) REFERENCES tbl_board (no)
);

CREATE TABLE tbl_buy (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         stock_code VARCHAR(20) NOT NULL,
                         stock_name VARCHAR(100) NOT NULL,
                         price INT NOT NULL,
                         buy_date DATETIME DEFAULT CURRENT_TIMESTAMP
);