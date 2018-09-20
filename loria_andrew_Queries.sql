SELECT  FirstName, LastName 
FROM Guest
JOIN Reservation
ON Guest.GuestID = Reservation.GuestID
JOIN Room
ON Reservation.RoomID = Room.RoomID
WHERE Room.RoomType = 'Executive';

SELECT FirstName, LastName
FROM Guest
JOIN Reservation
ON Guest.GuestID = Reservation.GuestID
WHERE Reservation.RoomID IN (100, 104);

SELECT ReservationID, CheckInDate, CheckOutDate
FROM Reservation;

SELECT * 
FROM Reservation 
WHERE NumberOfGuests BETWEEN 3 AND 5;

SELECT PoolName, Floor
FROM Pool
WHERE MaxDepth < 8
AND HasHotTub = 'yes';

SELECT *
FROM HotelFloor 
WHERE NumberOfRooms = 50;

SELECT *
FROM Guest
WHERE FirstName LIKE '%a%';

SELECT GuestID
FROM Guest
WHERE Email LIKE '%uw.edu';

SELECT PoolName
FROM Pool
WHERE Floor < 5;