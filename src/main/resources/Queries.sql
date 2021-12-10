use atm;

SELECT * FROM Banks;
SELECT * FROM ATMs;
SELECT * FROM Accounts;
SELECT * FROM Cards;

select
a.account_number as account_number, a.money as account_money, c.card_number as card_number, c.card_pin as card_pin, a.lock_status as lock_status
from
Accounts a left join Cards c
        on a.id = c.account_id
where
card_number = '4578091276840365';

Select * from Cards where card_number = 4578091276840365;