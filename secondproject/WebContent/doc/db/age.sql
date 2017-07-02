select
sum(age between 10 and 19 , 1, 0) as age_10,
sum(age between 20 and 29 , 1, 0) as age_20,
sum(age between 30 and 39 , 1, 0) as age_30,
sum(age between 40 and 49 , 1, 0) as age_40,
sum(age between 50 and 59 , 1, 0) as age_50,
sum(age between 60 and 69 , 1, 0) as age_60
from users

select count(select age from users where age between 10 and 19) from users;

select * from users;

select count(user_id) from users
where age between 10 and 19

select count(user_id) from users
where age between 20 and 29

select count(user_id) from users
where age between 30 and 39

select count(user_id) from users
where age between 40 and 49

select count(user_id) from users
where age between 50 and 59