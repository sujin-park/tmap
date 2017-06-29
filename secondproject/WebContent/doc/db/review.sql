-- ¸®ºä ¸®½ºÆ® Äõ¸®
SELECT
	*
FROM
	(
		SELECT 
			rownum rn,
			A.*
		FROM
			(
				SELECT
					r.*,
					z.gng_count,
					z.gng_sum,
					x.good_count,
					(z.gng_count - x.good_count) nogood_count,
					(SELECT count(review_comment_id) comment_count FROM review_comment WHERE review_id = r.review_id) comment_count
				FROM
					review r,
					(SELECT COUNT(review_id) gng_count, SUM(good_or_nogood) gng_sum  FROM review_check WHERE shop_id = 1) Z,
					(SELECT count(good_or_nogood) good_count FROM review_check WHERE shop_id = 1 and good_or_nogood = 1) x
				WHERE r.shop_id = 1 and is_blind = 0
			) A
		WHERE rownum <= 20
	) B
WHERE B.rn > 10;
