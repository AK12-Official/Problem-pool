select
    a.ID
from
    weather as a
    cross join weather as b on timestampdiff (day, a.recordDate, b.recordDate) = -1
where
    a.temperature > b.temperature;

    -- 日期相关 回头记得看