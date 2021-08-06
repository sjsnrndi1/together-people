CREATE TABLE userInfo (
	user_re_level NUMBER NOT NULL,
	user_id VARCHAR2(100) NOT NULL,
	user_password VARCHAR2(100) NOT NULL,
	user_postCode NUMBER NOT NULL,
	user_roadAddress VARCHAR2(1000) NOT NULL,
	user_jibunAddress VARCHAR2(1000) NOT NULL,
	user_detailAddress VARCHAR2(1000) NOT NULL,
	user_name VARCHAR2(1000) NOT NULL,
	user_gender VARCHAR2(50) NOT NULL,
	user_birthday_year VARCHAR2(100) NOT NULL,
	user_birthday_month VARCHAR2(100) NOT NULL,
	user_birthday_day VARCHAR2(100) NOT NULL,
	user_email VARCHAR2(300),
	user_phone NUMBER NOT NULL,
	user_date DATE NOT NULL,
	user_picture VARCHAR2(300),
	
	PRIMARY KEY(user_id, user_phone)
);

CREATE SEQUENCE userInfo_seq;

select * from userInfo

INSERT INTO userInfo VALUES(userInfo_seq.nextval, 'admin', 'tkFKD465!@', '12345', '관리자', '관리자', '관리자', '관리자', '남성', '1', '1', '1', 'admin', '1234', sysdate, 'null');

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE postingInfo(
	postingNumber NUMBER PRIMARY KEY,
	userId VARCHAR2(100),
	userName VARCHAR2(20),
	postingTitle VARCHAR2(100) NOT NULL,
	postingContent VARCHAR2(3000) NOT NULL,
	postingPictureTitle VARCHAR2(100) NULL,
	postingRecommandCount NUMBER NOT NULL,
	postingAnswerCount NUMBER NOT NULL,
	postingDate DATE NOT NULL
	
)

CREATE SEQUENCE postingNumber_seq;

select * from postingInfo

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table popupInfo (
	popupNumber NUMBER NOT NULL,
	userId VARCHAR2(100) NOT NULL,
	
	PRIMARY KEY(popupNumber, userId)
)
create sequence popupNumber_seq

select * from popupInfo

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table popupChatInfo (
	popupChatNumber NUMBER NOT NULL,
	popupNumber NUMBER NOT NULL,
	userId VARCHAR2(100) NOT NULL,
	userChatContent VARCHAR2(2000),
	adminChatContent VARCHAR2(2000),
	chat_date DATE NOT NULL,
	
	PRIMARY KEY(popupChatNumber)
)

create sequence popupChatNumber_seq

select * from popupChatInfo

insert into popupChatInfo values(popupChatNumber_seq.nextval, 1, 'admin', '관리자 테스트', '관리자 테스트', sysdate)

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE boardInfo (
	boardNumber NUMBER NOT NULL,
	boardUserId VARCHAR2(100) NOT NULL,
	boardTitle VARCHAR2(1000) NOT NULL,
	boardWriter VARCHAR2(100) NOT NULL,
	boardContent VARCHAR2(3000) NOT NULL,
	boardDate DATE NOT NULL,
	boardSubject VARCHAR2(100) NOT NULL,
	boardViews NUMBER NOT NULL,
	
	PRIMARY KEY(boardNumber)
)

CREATE SEQUENCE boardNumber_seq;

select * from boardInfo;

insert into boardInfo values (boardNumber_seq.nextval, 'sjsnrndi12', '테스트', '김민성', '테스트중입니다.', sysdate, '자유', 0);
insert into boardInfo values (boardNumber_seq.nextval, 'sjsnrndi12', '테스트2', '김민성', '테스트2중입니다.', sysdate, '자유', 0);
insert into boardInfo values (boardNumber_seq.nextval, 'sjsnrndi12', '테스트3', '김민성', '테스트3중입니다.', sysdate, '자유', 0);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE boardSympathyInfo (
	boardSympathyNumber NUMBER NOT NULL,
	boardNumber NUMBER,
	userId VARCHAR2(100) NOT NULL,
	boardSympathy NUMBER,
	
	PRIMARY KEY(boardSympathyNumber)
);

CREATE SEQUENCE boardSympathyNumber_seq;

select * from boardSympathyInfo;

drop TABLE boardSympathyInfo;
drop SEQUENCE boardSympathyNumber_seq;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE boardCommentInfo (
	boardCommentNumber NUMBER NOT NULL,
	boardNumber NUMBER NOT NULL,
	userId VARCHAR2(100) NOT NULL,
	userName VARCHAR2(100) NOT NULL,
	boardComment VARCHAR2(4000) NOT NULL,
	boardCommentDate DATE NOT NULL,
	
	PRIMARY KEY(boardCommentNumber)
);

CREATE SEQUENCE boardCommentNumber_seq;

select * from boardCommentInfo;

drop TABLE boardCommentInfo;
drop SEQUENCE boardCommentNumber_seq;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE joinBoardInfo (
	joinBoardNumber NUMBER NOT NULL,
	joinBoardUserId VARCHAR2(100) NOT NULL,
	joinBoardTitle VARCHAR2(1000) NOT NULL,
	joinBoardWriter VARCHAR2(100) NOT NULL,
	joinBoardContent VARCHAR2(3000) NOT NULL,
	joinBoardDate DATE NOT NULL,
	joinBoardSubject VARCHAR2(100) NOT NULL,
	joinBoard_joinUserNumber NUMBER NOT NULL,
	
	PRIMARY KEY(joinBoardNumber)
);

CREATE SEQUENCE joinBoardNumber_seq;

select * from joinBoardInfo;

drop TABLE joinBoardInfo;
drop SEQUENCE joinBoardNumber_seq;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE joinBoard_joinUserInfo (
	joinBoard_number NUMBER NOT NULL,
	joinBoard_boardNumber NUMBER NOT NULL,
	joinBoard_userId VARCHAR2(1000) NOT NULL,
	joinBoard_userName VARCHAR2(100),
	verified CHAR(1) CONSTRAINT joinBoard_joinCheck CHECK(verified = '0' OR verified = '1'),
		
	PRIMARY KEY(joinBoard_number)
);

CREATE SEQUENCE joinBoard_number_seq;

select * from joinBoard_joinUserInfo;

drop TABLE joinBoard_joinUserInfo;
drop SEQUENCE joinBoard_number_seq;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------





























CREATE TABLE postingRecommandInfo(
	postingRecommandNumber NUMBER PRIMARY KEY,
	postingNumber NUMBER,
	userId VARCHAR2(20),
	postingRecommandCountCheck NUMBER
)

CREATE SEQUENCE postingRecommandNumber_seq;

INSERT INTO postingRecommandInfo VALUES(postingNumber_seq.nextval, 29, 'c', 0);


CREATE TABLE noticeInfo(
	noticeRegistNumber NUMBER NOT NULL,
	noticeNumber NUMBER PRIMARY KEY,
	noticeTitle VARCHAR2(200) NOT NULL,
	noticeWriter VARCHAR2(20) NOT NULL,
	noticeContent VARCHAR2(3000) NOT NULL,
	noticeDate DATE NOT NULL,
	noticeReadCount NUMBER
)

CREATE SEQUENCE noticeNumber_seq;

CREATE TABLE boardInfo (
	boardRegistNumber NUMBER NOT NULL,
	boardNumber NUMBER PRIMARY KEY,
	boardUserId VARCHAR2(20) NOT NULL,
	boardTitle VARCHAR2(200) NOT NULL,
	boardWriter VARCHAR2(20) NOT NULL,
	boardContent VARCHAR2(3000) NOT NULL,
	boardDate DATE NOT NULL,
	boardJoinUserNumber NUMBER,
	boardSubject VARCHAR2(20) NOT NULL,
	boardFavorites VARCHAR2(3000),
	boardJoins VARCHAR2(3000)
)

CREATE SEQUENCE boardNumber_seq;

CREATE TABLE boardJoinUserInfo (
	boardJoinNumber NUMBER PRIMARY KEY,
	boardJoinUser_id VARCHAR2(20) NOT NULL,
	boardJoinUser_name VARCHAR2(20) NOT NULL,
	boardNumber NUMBER NOT NULL,
	boardJoinUserCheck NUMBER NOT NULL,
	chatJoinCheck NUMBER NOT NULL
)

CREATE SEQUENCE boardJoinNumber_seq;

CREATE TABLE chatInfo(
	chatNumber NUMBER PRIMARY KEY,
	chatNum NUMBER NOT NULL,
	chatUserId VARCHAR2(20) NOT NULL,
	chatContent VARCHAR2(3000) NOT NULL,
	chatDate DATE NOT NULL
)

CREATE SEQUENCE chatNumber_seq;

CREATE TABLE qnaInfo(
	qnaNumber NUMBER PRIMARY KEY,
	qnaRegistNumber NUMBER NOT NULL,
	qnaTitle VARCHAR2(100) NOT NULL,
	qnaContent VARCHAR2(3000) NOT NULL,
	qnaWriter VARCHAR2(20) NOT NULL,
	qnaUserId VARCHAR2(20) NOT NULL,
	qnaDate DATE NOT NULL,
	qnaComment VARCHAR2(1000) NOT NULL
)

CREATE SEQUENCE qnaNumber_seq;

CREATE TABLE alarmInfo(
	alarmNumber NUMBER PRIMARY KEY,
	alarmContent VARCHAR2(1000) NOT NULL,
	alarmMyId VARCHAR2(20) NOT NULL,
	alarmYouId VARCHAR2(20) NOT NULL,
	alarmDate DATE NOT NULL
)

CREATE SEQUENCE alarmNumber_seq;