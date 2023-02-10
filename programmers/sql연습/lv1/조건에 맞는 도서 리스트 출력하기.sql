-- 코드를 입력하세요
SELECT b.book_id, date_format(b.published_date,"%Y-%m-%d")
from book b
where DATE_FORMAT(b.published_date,"%Y") ="2021" and b.category="인문"
order by b.published_date;