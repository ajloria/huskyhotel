CREATE DATABASE loria_andrew_db;
USE loria_andrew_db;

CREATE TABLE Hotel (
	HotelID	 Integer  NOT NULL,
    Name	Char(30)	NOT NULL,
    City	Char(30)	NOT NULL,
    State 	Char(30)	NOT NULL,
    CONSTRAINT	Hotel_PK	PRIMARY KEY(HotelID)
    );
    
 CREATE TABLE Guest (
	GuestID	 	Integer  	NOT NULL,
    FirstName	Char(30)	NOT NULL,
    LastName	Char(30)	NOT NULL,
    Phone		Char(10)	NOT NULL,
    Email       Char(30)	NOT NULL,
    CONSTRAINT	Guest_PK	PRIMARY KEY(GuestID)
    );   
    
CREATE TABLE HotelFloor (
	FloorID	 	Integer  	NOT NULL,
    FloorName	Char(30)	NOT NULL,
    NumberOfRooms	Integer	NOT NULL,
    CONSTRAINT HotelFloor_PK PRIMARY KEY (FloorID) 
    );   
    
CREATE TABLE Room (
	RoomID		Integer 		NOT NULL,
    Price		Decimal(9,2)	NOT NULL,
    RoomType	Char(30)		NOT NULL,
    CONSTRAINT Room_PK	PRIMARY KEY (RoomID) 
    );   
    
CREATE TABLE Reservation (
	ReservationID		Integer 	NOT NULL,
    GuestID				Integer		NOT NULL,
    RoomID				Integer		NOT NULL,
    NumberOfGuests		Integer		NOT NULL,
    CheckInDate			Date		NOT NULL,
    CheckOutDate		Date		NOT NULL,
    CONSTRAINT		Reservation_PK	PRIMARY KEY (ReservationID, GuestID), 
    CONSTRAINT		Reservation_Guest_Relationship  FOREIGN KEY(GuestID) 
						REFERENCES Guest(GuestID)
    );   
    
CREATE TABLE CreditCard (
	CardID 			Integer 	   NOT NULL,
	CardProvider	Char (20) 	   NOT NULL,
	GuestID  	    Integer	       NOT NULL,
	CONSTRAINT 		CreditCard_PK     PRIMARY KEY (CardID, GuestID),
	CONSTRAINT		Card_Guest_Relationship  FOREIGN KEY(GuestID) 
						REFERENCES Guest(GuestID)
	);
    
CREATE TABLE Employee (
	EmployeeID		Integer 	   NOT NULL,
	RoleID			Char (20) 	   NOT NULL,
	FirstName  	    Char (30)      NOT NULL,
    LastName		Char(30)	   NOT NULL,
	CONSTRAINT 		Employee_PK     PRIMARY KEY (EmployeeID)
	);
    
CREATE TABLE EmployeeRole (
	RoleID			Integer 	   NOT NULL,
	Title			Char (20) 	   NOT NULL,
	Description     Char (30)      NOT NULL,
	CONSTRAINT 		EmployeeRole_PK     PRIMARY KEY (RoleID)
	);
    
CREATE TABLE HotelRestaurant (
	RestaurantID	Integer 	   NOT NULL,
	ResturantName	Char (20) 	   NOT NULL,
	CuisineType	    Char (20)      NOT NULL,
    HasHappyHour	Char(10)	   NOT NULL,
	CONSTRAINT 		HotelRestaurant_PK    PRIMARY KEY (RestaurantID)
	);
    
CREATE TABLE Breakfast (
	BreakfastID		Integer 	   NOT NULL,
	RestaurantID	Char (20) 	   NOT NULL,
	Price		    Decimal(9,2)   NOT NULL,
    Description		Char(30)	   NOT NULL,
	CONSTRAINT 		Breakfast_PK    PRIMARY KEY (BreakfastID)
	);
    
CREATE TABLE KeyCard (
	KeyCardID		Integer		NOT NULL,
	RoomID			Integer		NOT NULL,
	CONSTRAINT 		KeyCard_PK    PRIMARY KEY (KeyCardID)
	);
    
CREATE TABLE Parking (
	ParkingID		Integer		NOT NULL,
	Location		Char(30)		NOT NULL,
    TotalParkingSpaces	Integer		NOT NULL,
	CONSTRAINT 		Parking_PK    PRIMARY KEY (ParkingID)
	);
    
CREATE TABLE Pool (
	PoolID		Integer		NOT NULL,
    Floor		Integer		NOT NULL,
    MaxDepth	Integer 	NOT NULL,
    HasHotTub	Char(10)	NOT NULL,
	PoolName	Char(30)		NOT NULL,
	CONSTRAINT 		Pool_PK    PRIMARY KEY (PoolID)
	);
    
CREATE TABLE FitnessRoom (
	FitnessRoomID		Integer		NOT NULL,
	Floor				Integer		NOT NULL,
    Description			Char(30)	NOT NULL,
	CONSTRAINT 			FitnessRoom_PK    PRIMARY KEY (FitnessRoomID)
	);
    
    
CREATE TABLE Wifi (
	WifiID		Integer		NOT NULL,
	WifiName	Char(30)		NOT NULL,
	CONSTRAINT 	Wifi_PK    PRIMARY KEY (WifiID)
	);
    
CREATE TABLE ExtraCharges (
	ExtraChargeID		Integer		NOT NULL,
	GuestID				Integer		NOT NULL,
    ChargeType			Char(30)	NOT NULL,
    Price				Double(9,2)	NOT NULL,
    ChargeDate			Date		NOT NULL,
	CONSTRAINT 			ExtraCharges_PK    PRIMARY KEY (ExtraChargeID, GuestID),
	CONSTRAINT		Charge_Guest_Relationship  FOREIGN KEY(GuestID) 
						REFERENCES Guest(GuestID)
	);
    
CREATE TABLE Rating (
	RatingID		Integer		NOT NULL,
	GuestID			Integer		NOT NULL,
    Rating			Char(30)		NOT NULL,
    RatingDate		Date		NOT NULL,
	CONSTRAINT 		Rating_PK    PRIMARY KEY (RatingID, GuestID),
    CONSTRAINT		Rating_Guest_Relationship  FOREIGN KEY(GuestID) 
						REFERENCES Guest(GuestID)
	);
    
CREATE TABLE HotelAccount (
	AccountID		Integer		NOT NULL,
	Username		Char(30)	NOT NULL,
    AccountType		Char(30)	NOT NULL,
	CONSTRAINT 		HotelAccount_PK    PRIMARY KEY (AccountID)
	);
    

INSERT INTO Hotel VALUES (
	1, 'Husky Hotel', 'Seattle', 'Washington');
    
INSERT INTO Guest VALUES (reservation
	1000, 'Andrew Joshua', 'Loria', '1234567899','username@email.edu');
INSERT INTO Guest VALUES (
	1001, 'John', 'Smith', '2062062062','johnsmith@email.edu');
INSERT INTO Guest VALUES (
	1002, 'Brandon', 'Bostonian', '2533522531','brandon@mail.com');
INSERT INTO Guest VALUES (
	1003, 'Russell', 'Wilson', '1234567890','russell@seahawks.com');
INSERT INTO Guest VALUES (
	1004, 'LeBron', 'James', '232323232','lebron@lakeshow.com');    
    
INSERT INTO HotelFloor VALUES (
	100, 'First', 50 );
INSERT INTO HotelFloor VALUES (
	200, 'Second', 80 );
INSERT INTO HotelFloor VALUES (
	300, 'Third', 80 );
INSERT INTO HotelFloor VALUES (
	400, 'Fourth', 80 );
INSERT INTO HotelFloor VALUES (
	500, 'Fifth', 100 );
INSERT INTO HotelFloor VALUES (
	600, 'Sixth', 100 );
INSERT INTO HotelFloor VALUES (
	700, 'Seventh', 100 );
INSERT INTO HotelFloor VALUES (
	800, 'Eighth', 100 );
INSERT INTO HotelFloor VALUES (
	900, 'Ninth', 100 );
INSERT INTO HotelFloor VALUES (
	1000, 'Tenth', 100 );

INSERT INTO Room VALUES (
	100, 90, 'Suite');
INSERT INTO Room VALUES (
	101, 90, 'Suite');
INSERT INTO Room VALUES (
	102, 90, 'Suite');
INSERT INTO Room VALUES (
	103, 90, 'Suite');
INSERT INTO Room VALUES (
	104, 150, 'Executive');

INSERT INTO Reservation VALUES (
	100000, 1000, 100, 2, '2018-05-25', '2018-05-25');
INSERT INTO Reservation VALUES (
	100001, 1001, 101, 4, '2018-05-20', '2018-05-25');
INSERT INTO Reservation VALUES (
	100002, 1002, 102, 3, '2018-05-20', '2018-05-22');
INSERT INTO Reservation VALUES (
	100004, 1004, 104, 5, '2018-05-23', '2018-05-25');
    
    
INSERT INTO Pool VALUES (
	50, 2, 9, 'yes', 'Splash');
INSERT INTO Pool VALUES (
	51, 4, 7, 'no', 'Ripple');
INSERT INTO Pool VALUES (
	52, 5, 9, 'no', 'Tide');
INSERT INTO Pool VALUES (
	53, 10, 9, 'yes', 'Ocean');
INSERT INTO Pool VALUES (
	54, 8, 5, 'yes', 'Shore');
    
INSERT INTO hotelrestaurant VALUES (
	500, 'Oasis', 'Chinese', 'yes');
INSERT INTO hotelrestaurant VALUES (
	501, 'Kwan Tip', 'Thai', 'no');
INSERT INTO hotelrestaurant VALUES (
	502, 'Bahama Wind', 'Jamaican','yes');
INSERT INTO hotelrestaurant VALUES (
	503, 'Keg', 'American', 'no');
    
INSERT INTO breakfast VALUES (
	1, 503, 0, 'American breakfast buffet.');
INSERT INTO breakfast VALUES (
	2, 502, 4, 'International breakfast.');
    
INSERT INTO parking VALUES (
	700, 'East Entrance', 1000);
INSERT INTO parking VALUES (
	701, 'West Entrance', 500);
INSERT INTO parking VALUES (
	702, 'Dubs Garage', 2000);
INSERT INTO parking VALUES (
	703, 'North Garage', 1500);

INSERT INTO wifi VALUES (
	300, 'HuskyHotel-LOBBY');
INSERT INTO wifi VALUES (
	301, 'HuskyHotel-ROOM');
INSERT INTO wifi VALUES (
	302, 'HuskyHotel-POOL');
INSERT INTO wifi VALUES (
	303, 'HuksyHotel-FITNESS');
    
INSERT INTO rating VALUES (
	1, 1000, 10, '2018-06-01');
INSERT INTO rating VALUES (
	2, 1001, 9, '2018-06-01');
INSERT INTO rating VALUES (
	3, 1002, 9, '2018-06-01');
INSERT INTO rating VALUES (
	4, 1003, 9, '2018-06-01');
INSERT INTO rating VALUES (
	5, 1004, 10, '2018-06-01');
