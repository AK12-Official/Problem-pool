select max(num) as num
from 
(select num,count(num) as cishu
from MyNumbers
group by num)as temp
where cishu=1