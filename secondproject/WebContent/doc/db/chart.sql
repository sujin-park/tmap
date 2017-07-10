-------- 연령대별 쿼리 ---------

select substr(age,0,1),
	   count(age) from users 
	   group by substr(age,0,1) 
	   order by 1 desc 

-------- 당일 ------------
select substr(age,0,1),
	   count(age) from users
	   where reg_date = sysdate
	   group by substr(age,0,1) 
	   order by 1 desc 
	   
-------- 연도별 쿼리 -----------
select to_char(reg_date, 'yyyy') as regdate,
count (user_id)
from users
where gender = 1
group by to_char(reg_date, 'yyyy')


select to_char(reg_date, 'yyyy') as regdate,
count (user_id)
from users
where gender = 2
group by to_char(reg_date, 'yyyy')
	   
-------- 카테고리별 후기갯수 (연령대, 성별)---------

-- 전체

select count(r.review_id), sc.category_title
	   from review r, shop s, shop_category sc
	   where r.shop_id = s.shop_id
	   and s.category_id = sc.category_id
	   group by sc.category_title

-- 성별 ( 여자 )

select count(r.review_id), sc.category_title
	   from review r, shop s, shop_category sc, users u
	   where r.shop_id = s.shop_id
	   and s.category_id = sc.category_id
	   and u.user_id = r.user_id
	   and u.gender = 1
	   group by sc.category_title

-- 성별 ( 남자 )

select count(r.review_id), sc.category_title
	   from review r, shop s, shop_category sc, users u
	   where r.shop_id = s.shop_id
	   and s.category_id = sc.category_id
	   and u.user_id = r.user_id
	   and u.gender = 2
	   group by sc.category_title

-------- 지역별 등록된 매장 수 ---------

select count(shop_id) as count, 
substr(address, 0, instr(address,' ')) as addressgroup
from shop
group by substr(address, 0, instr(address,' '));

-------- 카테고리별 선호도 (성별) ---------

select NVL((SELECT avg(score) FROM review WHERE shop_id = s.shop_id), 0) as score
FROM SHOP s, shop_category sc
where s.category_id = sc.category_id


-------- 카테고리별 선호도 (성별) ---------
SELECT AVG(score), (select category_title from shop_category where category_id = s.category_id) as category_title
FROM review r
JOIN shop s ON r.shop_id = s.shop_id
GROUP BY s.category_id