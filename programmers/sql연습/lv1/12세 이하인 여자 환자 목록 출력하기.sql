-- 코드를 입력하세요
SELECT p.pt_name,p.pt_no,p.gend_cd,p.age,ifnull(p.tlno,'NONE') as tlno
from patient as p
where age<=12 and p.gend_cd="W"
order by age desc, pt_name;