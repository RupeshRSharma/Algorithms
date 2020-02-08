package com.intelizest;

public class Test15 {

}




/*
 * select name, sum(case when money >=0 then money end) as a.sum_of_deposits,
 * sum(case when trans_amount < 0 then money end) as sum_of_withdrawls from
 * transfers group by name
 * 
 * 
 * 
 * SELECT name, a.sum_of_deposits, b.sum_of_withdrawls from (select name,
 * sum(money) as sum_of_desposits from transfers group by name having money>0 )
 * a, (select name, sum(money) as sum_of_withdrawls from transfers group by name
 * having money<0 ) b where a.name=b.name order by name
 */