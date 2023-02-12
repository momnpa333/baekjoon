-- 코드를 입력하세요
SELECT d.dr_name, d.dr_id,d.mcdp_cd,DATE_FORMAT(d.hire_ymd, "%Y-%m-%d") 
from doctor d 
where d.mcdp_cd='cs' or d.mcdp_cd='GS'
order by d.hire_ymd desc,d.dr_name;