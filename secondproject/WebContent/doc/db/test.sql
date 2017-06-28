SELECT a.*
FROM (SELECT rownum r, shop_id, category_id, title FROM shop WHERE category_id = 1 and rownum < 20 ORDER BY shop_id DESC) a
where a.r > 10