select class
from
(select class,count(student) as num
from Courses
group by class )
as temp_table
-- 不加上面的as报错
-- Every derived table must have its own alias
where num>=5