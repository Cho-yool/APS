SELECT FLAVOR
FROM
(
SELECT SHIPMENT_ID, FLAVOR, TOTAL_ORDER
FROM FIRST_HALF

UNION

SELECT SHIPMENT_ID, FLAVOR, TOTAL_ORDER
FROM JULY
) a 
GROUP BY FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3;