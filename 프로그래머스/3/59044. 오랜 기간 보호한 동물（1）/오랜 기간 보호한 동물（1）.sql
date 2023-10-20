SELECT
I.Name,
I.DATETIME
from ANIMAL_INS I Left join ANIMAL_OUTS O on I.ANIMAL_ID = O.ANIMAL_ID where O.Animal_id is null
Order by I.DATETIME aSC 
limit 3