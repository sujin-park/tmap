DROP SEQUENCE SEQ_SHOP_ID;
CREATE SEQUENCE SEQ_SHOP_ID start with 1;

TRUNCATE TABLE SHOP;

Insert into MAP.SHOP (SHOP_ID,CATEGORY_ID,TITLE,LAT,LNG,OWNER_ID,IMG,RESERVE_URL,ADDRESS,TEL,BUSINESS_TIME,DETAIL) values (seq_shop_id.nextval,1,'은행골',37.4841582,126.9070172,null,null,null,'서울특별시 관악구 신림동 1648-9 ','02-4567-7896',null,null);
Insert into MAP.SHOP (SHOP_ID,CATEGORY_ID,TITLE,LAT,LNG,OWNER_ID,IMG,RESERVE_URL,ADDRESS,TEL,BUSINESS_TIME,DETAIL) values (seq_shop_id.nextval,1,'THE BOB',37.4852258,126.8988427,null,null,null,'서울특별시 구로구 구로동 187-10 지하 1층','070-0700-0770',null,'메뉴 매일 바뀜');
Insert into MAP.SHOP (SHOP_ID,CATEGORY_ID,TITLE,LAT,LNG,OWNER_ID,IMG,RESERVE_URL,ADDRESS,TEL,BUSINESS_TIME,DETAIL) values (seq_shop_id.nextval,1,'싸움보쌈',37.4835113,126.9002307,null,null,null,'서울특별시 구로구 구로동 1124-35 ','010-4567-4567',null,null);
Insert into MAP.SHOP (SHOP_ID,CATEGORY_ID,TITLE,LAT,LNG,OWNER_ID,IMG,RESERVE_URL,ADDRESS,TEL,BUSINESS_TIME,DETAIL) values (seq_shop_id.nextval,1,'Day and Days',37.4842991,126.9031876,null,null,null,'서울특별시 관악구 신림동 1643 -','02-012-3456',null,'24시인데 주말에 사람 엄청남');
Insert into MAP.SHOP (SHOP_ID,CATEGORY_ID,TITLE,LAT,LNG,OWNER_ID,IMG,RESERVE_URL,ADDRESS,TEL,BUSINESS_TIME,DETAIL) values (seq_shop_id.nextval,4,'버거킹',37.4824769,126.9006817,null,null,null,'서울특별시 구로구 구로동 1126-6 1층 버거킹','02-1234-4567',null,null);
Insert into MAP.SHOP (SHOP_ID,CATEGORY_ID,TITLE,LAT,LNG,OWNER_ID,IMG,RESERVE_URL,ADDRESS,TEL,BUSINESS_TIME,DETAIL) values (seq_shop_id.nextval,4,'주주헤어클럽',37.4808509,126.9021974,null,null,null,'서울특별시 관악구 신림동 1663-24 ','02-789-7894',null,'미용실인데 가면안됌');
Insert into MAP.SHOP (SHOP_ID,CATEGORY_ID,TITLE,LAT,LNG,OWNER_ID,IMG,RESERVE_URL,ADDRESS,TEL,BUSINESS_TIME,DETAIL) values (seq_shop_id.nextval,1,'풍년집 독산점',37.4777183,126.9038849,null,null,null,'서울특별시 금천구 독산동 961-8 ','02-4567-4567',null,'배고프다..');
Insert into MAP.SHOP (SHOP_ID,CATEGORY_ID,TITLE,LAT,LNG,OWNER_ID,IMG,RESERVE_URL,ADDRESS,TEL,BUSINESS_TIME,DETAIL) values (seq_shop_id.nextval,1,'빨강떡뽁이',37.480602,126.9017735,null,null,null,'서울특별시 관악구 신림동 1664-21 ','02-022-2222',null,null);
Insert into MAP.SHOP (SHOP_ID,CATEGORY_ID,TITLE,LAT,LNG,OWNER_ID,IMG,RESERVE_URL,ADDRESS,TEL,BUSINESS_TIME,DETAIL) values (seq_shop_id.nextval,1,'낭만부대찌게',37.4840446,126.8956738,null,null,null,'서울특별시 구로구 구로동 212-8 지하1층','010-0111-1454',null,null);
