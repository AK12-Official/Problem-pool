select name
from SalesPerson
where sales_id not in 
(select Orders.sales_id
from Orders inner join Company ON Orders.com_id=Company.com_id
where Company.name ='RED')