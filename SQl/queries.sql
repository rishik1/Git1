
Select MAX(Salary) from Employees;


/*find 2nd largest salary */
Select Salary from Employees
Where Salary<(Select Max(Salary) from Employees);


/*find max salary*/
Select Max(Salary) from Employees
Where Salary ( Select Max(Salary) from Employees);

/*find top 2 salary*/
Select Salary from
(Select DISTINCT TOP 2 Salary
From Employees
Order By Salary Desc)
Result;


/*find nth largest salary*/

Select TOP 1 Salary from 
(Select DISTINCT TOP 2 Salary
From Employees
Order By Salary Desc)
Result
Order By Salary;


/* find nth largest using dense rank*/
/* NOTE this does not work with ROW_NUMBER() function */
Select * from Employees order by Salary desc
WITH Result AS
{
    Select Salary  DENSE_RANK() over ( order by Salary DESC) as DENSERANK
    from Employees;
}
Select top 1 Salary
From Result
Where Result.DENSERANK=3


/*Inner join === common between tables*/
Select * from TableCountry
    inner join TableState
    on TableCCountry.CountryId = TableState.CountryId;
    

/*Left Join only distinct left */

Select * from TableCOuntry left join TableState
    on TableCountry.CountryId=TableState.CountryId;
    

/*FULL Outer join shows everything mathcing and non matcing*/
select * from tblCounrty full outer join TableState
    on tableCountry.CountryIdTableState.CountryId;
    
    
    
/*Between for range */
Select * from from Employee
were employed_id between 2003 and 2008


/* Reference between tables used to fect data*/

Select first_name , last_name , department_name
from Employee e Inner Join Department d ON(e.department_id=d.department_id)
where salary in (Select MAX(Salary) from Employee)


Select frist_name  last_name  department_name
from Employee e Inner Join Department d ON(e.department_id==d.department_id)
where salary in (Select Max(Salary) from Employee group by department_id)



/* Aggregate function SUM Group by*/

Select Employedd_id ,Sum(Amount)
From Grant
Group by Employee_id

/*Count Aggregate function */

select Employeed_id. Count(Amount)
From Grant
Group By Employee_id


/* DUAL table has only 1 row and 1 column */
selcct * from dual;

/*Dual used for arthematic operation */
selct 3*15 from dual;

/* get sysdate from dual*/
select SYSDATE from dual;


/* only admin can insert into dual table */
insert into dual values ("y");


/* Backup a Table in SQL*/
CREATE table Sales1 AS select * from Sales;


/* Can we drop all the columns from a table : NO 

We get erro ORA12983: Cannot drop all column from tabke
*/



/* PSEUDO COLOUMS: Bhevaes like tbale but data is not stored in atble 
   you can select pseudo column bu cannot insert update delete a pseudo column
   SSDATE
   ROWNUM
   ROWID
   OBJECT_ID
   OBJECT_VALUE
   
   
   
   DIfference between count(1)  and count (*) is NOTHING  te use same amount of resource and gemrate same output
   
   Difference between IN and = Operator ? == acept only 1 valye wile IN accepts a set of values 
   
   Maximum number of values IN operator ccan take is 999 values
*/


Select Employee_Id , EmployeeName ,Department_id 
From Employees
Where DEPARTMENT_ID =90;

Select Employee_Id , EmployeeName ,Department_id 
From Employees
Where DEPARTMENT_ID IN (90 , 95 , 99 , 100);


/* Deference between IN and EXISTS query 

IN ==> the Inner query is executed first the outer query uses the values from Inner query's result set

EXISTS ==> Outer query is matched 1 by one with inner query elements */

select * from Customer_Details cs
Where EXISTS (
    Select * from OrderDetails ord
    Where ord.customer_id = cs.customer_id
);


/* Difference between Having and Wheere≠=
Where used to filter out the data before the aggregation takes place
Havingg used to filter out te data after the aggregation takes place
*/

Select * from department_id , sum(salary) as salary
From Employees
Where Depratment_id IN (20 , 30, 70 ,90)
Group by department_id 
Having sum(Salary) > 10000;



/*
DELET vs TURNCATE 

Delete => selectively remove data from a tabke ,keeps UNDO logs , supports ability to commit and roll back. SOLWER.
 Delte triggers are fired before the delete

TURNCATE => remove all the data in the table at once , NO UNDO logs , Faster ,does not effecct any table indexes or triggers or dependencies.

We ccannot use WHERE condition with turncate .

*/


/* Delete a record simultenously from more than 1 table*/
Delete t1 , t2
FROM t1 INNER JOIN t2
Where t1.id =t2.id
And t2.id =t3.id;


/* Delete a duplicate record from Tables*/
Delete from department d1
Where d1.rowid > 
{
    select min(d2.rowid) from department d2
    where d1.department_id = d2.department_id
    and d1.department_name =d2.department_name
    and d1.branch =d2.branch
}


/*
Inner Join - returns all the entries where matvhing conditon is met 
Left outer join - returns all the entries from left table and only matching entries from righ table 
Right uter join - returns all the entries from right table and only matching entries from left table.

CROSS JOIN =- when matchind condition of join is missed CARTISION JOIN occurs 
ex tabl1 has 5 entries and table 2 has 10 then on matchin ccondtion miss CROSS join produces 10*5 = 50 enrties join result
*/


/*Self join -- when a table is joined with itself */
Select e1.employee_name  e2.manager_name
From employee e1 ,  employee e2
Where e1.mngr = e2.empno;

/* Get employee who has same location as "joe" */
Select e1.employee_name 
From emplouee e1 , employee e2
Where e1.employee_location e2.employee_location
and e2.employee_name="Joe";


/*
Conversion fucntions are used to conver one data type into anoter
TO_CHAR
TO_NUMER
TO_DATE
*/

/*
LPAD & RPAD - left padding and right padding around a string , 
Default padding character is space*/

/*
Single row function return a result for each row as an output example to_char()
Multi Row Function reterns only single results for all rows in the table ex-> sum(emploee_Salary)
*/

/*
Most common Date function used
1)MONTHS_BETWEEN -> number of monts between 2 dates
2)LAST_DAY => returns te last Day of a month
3)NEXTDAY => returns the next Day of a month.
4)ADD_MONTHS => Used to add months to give Date .
ADD_MONTHS(SYSDATE, 1) from dual;
ADD_MONTHS(SYSDATE , 1) from dual;
ADD_MONTHS(SYSDATE , 1/24) from dual; // add hours to a date
5)EXTRACT > Used to extract either date  time hours or seconds from Date



DECODE & CASE are used for if then else functionality
DECODE{
'if this'
'matches this',"result this",
'matches this' , "result this",
..,
..,
else alternative results"
}

CASE > uses WHEN clause to do if and else test condition
CASE
WHEN A then B
WHEN C then D
WHEN E then F
ELSE Q

Any Arthmeatic operation performed on NULL is null in SQL
Select 1+NULL from dual; //NULL

NVL => return A Default value if 1 parameter is NULL
NVL2 => return A second paramter if 1st paramter is Not NUll or returns 3 rd parameter if 1st parameter is NULL

NULLIF accepts 2 paramter and returns NULL if both are equal
if not equal then 1st parameter value is returned

*/


/* if the table has null values then 0 rows are returned , search on value null using "=" & "IN" is not allowed*/
Select * from test1 where customer_phone = null;
Select * from test1 where customer_phone IN null;



/*Concatenation Ignore thes NULL Value */
Select 'tom' || null || 'joe' from dual;

/* NOT NULL is used to define a NOT NULL value of a coloumn constraint */

/* CONSTRAINTS in used to enforce rules in database and maintains integrity
NOT NULL   ==> Prohibits value in databse from being NULL
UNIQUE     ==> Prohibits Same value in same columns but allows NULL values
PRIMARY KEY ==> UNIQUE+NOT NULL
FOREIGN KEY ==> Macth values in 1 table to match values in anoter table
CHECK       ==> Value in database to coml with specified condition
REF         ==>  It allows to describe a realationship between REF column and object it references.

Table can only have 1 primary key   

ALTER TABLE DISABLE CONSTRAINTS Constraintsname;

SYSDATE ROWID ROWNUMBER UID LEVEL NEXTVAL cannot be used in CECK CONSTRAINTS as te are dymanic in nature

HOW TO inserat a CHECK CONSTRAINT FOR DATE valye Check? USE TRIGGERS
 



*/

CREATE OR REPLACE TRIGGER test4_dob BEFORE INSERT OR UPDATE on test4
BEGIN:
    IF new.dob > SYSDATE THEN
        RAISE APPLICATION_ERROR(num -2000, msg => 'DOB cannot be in future' );
    ENDIF;
END;


/*CASCADE CONSTRAINTS ==> USed to drop all the referential integrity constraints refering to unique key or primary key
if the table is dropped
If this contraints in not there ten referential integrioty will not allow you to drop the table */
DROP TABLE table4 CASCADE CONSTRAINTS;

/* ON CASCADE DELETE ==> Automatically delete foregin key if the parent is deleted

1st TRIGGERS are executed then CONSTRAINTS are executed then after TRIGERS are executed


CIRCULAR Reference => when 2 tables have different foregin key Constraints on each other. BIG NO NO!!

*/


/* SEQUENCE IS USED to generate a sequence of number*/

CREATE SQEUENCE sequencce_name
MINVALUE value,
MAXVALUE value,
START WITH value,
INCREMENT BY value;

Alter SEQUENCE x incerement by 4;

/*MOST COMMON SET OPERATORs 
UNION = A+B -CCOMMON
UNION ALL = A+B + COMMON
MINUS = A-B or B-A
INTERSECT = ONL COMMON
NUMBER OF COLUMNS MUST BE SAME WHILE PERFORMING SET OPERATIONs
DATA TYPE OF COMIBINING CCOLOUMNS MUST BE SAME
*/

/*
SUB QUERY Query that appears in WHERE CLause is called subQuery
INLINE QUERY SUB QUERY Which appears in from clause is callled inline quer
*/

SELECT * from sales s (selct customer_id from customer WHERE regions="EAST") c
WHERE s.customer_id = c.customer_id;


/*
SCALAR SUB QUERY => SUB QUERY TAT APPEARS IN SELCT CLAUSE */
Select s.customer_id , s.total_amount, (Select first_name from customer c WHERE c.customer_id = s.customer_id ) first_name
FROM sales s;



/* WITH CLAUSE: using WITH clause we can execute sub query once and use again and again.
                WITH clause help to improve the performance of quer*/
                
WITH dept_count AS{
    Select deptno , COUNT(*) AS dept_count From emp 
    GROUP BY deptno
}
Select e.ename as Employee_name , 
        dc1.dept_count AS emp_dpt_count,
        m.ename as Manager_name,
        dc2.dept_count AS mngr_count
FROM emp e ,
    dept_count dc1,
    emp m,
    dept_count dc2
WHERE e.deptno = dc1.deptno
AND e.mgr = m.empno;


/* CORRELATED SUB QUERY is where INNER QUERY is executed every time for outer query ROW like a nested for LOOP.
   Comapring to NESTED SUB QUERY te INNER QUERY is executed ONLY ONCE!!! */
Select e.empname  e.eid ,e.salary
FROM emp e WHERE=(
        Select AVG(salary) from emp WHERE  deptid=e.deptid
);


/*
Indexes are used for faster data retriveal from the DB 
Types of Indexes are
B-TREE INDEX
BITMAP INDEX
BITMAP JOIN INDEX
FUNCTION BASED INDEX
UNIQUE INDEX
NON UNIQUE INDEX
COMPOSITE INDEX : Index build on 2 ore more columns
*/   

/* REBUILD AND INDEX : Due to Many UPDATES or DELETE Btree INdex will ave Empty sapce and performeance would be poor
or lot more data have been inserted ten REBUILD is required to improve indexing performance*/
ALTER INDEX index_name REBUILD; 

SELECT * FROM ALL_INDEXES where table_name="CUSTOEMR";

/*
INDEXING SUPPRESSED wen you are using function on column,CONCATINATION ,ARTEMATIC OPERATION, NULL OR NOT NULL,
COMPARING CARACTER INDEX VALUE*/

        



















    


    

