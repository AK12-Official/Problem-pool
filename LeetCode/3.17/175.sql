SELECT  Person.LastName, Person.FirstName, City, State
FROM Person
LEFT OUTER JOIN Address 
ON Person.PersonID = Address.PersonID