create table "Guest" (
	"id" INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	"firstName" VARCHAR(64) NOT NULL DEFAULT '',
	"surname" VARCHAR(64) NOT NULL DEFAULT '',
	"emailAddress" VARCHAR(64) NOT NULL DEFAULT '',
	"telephoneNumber" VARCHAR(64) NOT NULL DEFAULT '',
	"debitCardNumber" VARCHAR(64) NULL DEFAULT '',
	"debitCardType" VARCHAR(64) NULL DEFAULT '',
	"debitCardName" VARCHAR(64) NULL DEFAULT '',
	"debitCardExpiryMonth" INT(11) NULL DEFAULT '-1',
	"debitCardExpiryYear" INT(11) NULL DEFAULT '-1'
);

create table "Location" (
	"id" INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	"name" VARCHAR(16) NOT NULL DEFAULT '',
	"description" TEXT NULL DEFAULT ''
);

create table "HotelType" (
	"id" INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	"name" VARCHAR(16) NOT NULL DEFAULT ''
);

create table "Hotel" (
	"id" INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	"name" VARCHAR(16) NOT NULL DEFAULT '',
	"description" TEXT NULL DEFAULT '',
	"emailAddress" VARCHAR(16) NOT NULL DEFAULT '',
	"grade" VARCHAR(16) NOT NULL DEFAULT '',
	"locationID" INT(11) NOT NULL DEFAULT '-1',
	"hotelTypeID" INT(11) NOT NULL DEFAULT '-1',
	"checkInTime" DATETIME NULL DEFAULT '1970-12-31 23:59:59',
	"checkOutTime" DATETIME NULL DEFAULT '1970-12-31 23:59:59',
	CONSTRAINT "Location_ibfk_1" FOREIGN KEY ("locationID") REFERENCES "Location" ("id"),
	CONSTRAINT "HotelType_ibfk_4" FOREIGN KEY ("hotelTypeID") REFERENCES "HotelType" ("id")
);

create table "RoomType" (
	"id" INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	"name" VARCHAR(16) NOT NULL DEFAULT '',
	"hotelID" INT(11) NOT NULL DEFAULT '-1',
	"roomRatePerDay" FLOAT NOT NULL DEFAULT 0,
	"description" TEXT NULL DEFAULT '',
	"maxNumberOfPeople" INT(11) NOT NULL DEFAULT '-1',
	CONSTRAINT "Hotel_ibfk_4" FOREIGN KEY ("hotelID") REFERENCES "Hotel" ("id")
);

create table "Booking" (
	"id" INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	"hotelID" INT(11) NOT NULL DEFAULT '-1',
	"guestID" INT(11) NOT NULL DEFAULT '-1',
	"checkInTime" DATETIME NULL DEFAULT '1970-12-31 23:59:59',
	"checkOutTime" DATETIME NULL DEFAULT '1970-12-31 23:59:59',
	"comments" TEXT NULL DEFAULT '',
	CONSTRAINT "Guest_ibfk_1" FOREIGN KEY ("guestID") REFERENCES "Guest" ("id"),
);

create table "BookingRoom" (
	"id" INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	"roomTypeID" INT(11) NOT NULL DEFAULT '-1',
	"bookingID" INT(11) NOT NULL DEFAULT '-1',
	CONSTRAINT "RoomType_ibfk_1" FOREIGN KEY ("roomTypeID") REFERENCES "RoomType" ("id"),
	CONSTRAINT "Booking_ibfk_4" FOREIGN KEY ("bookingID") REFERENCES "Booking" ("id")
);

INSERT INTO "Guest" VALUES(1, 'Crimore', 'Chingwenje', 'kuerrymau@gmail.com', '0715849764');
INSERT INTO "Guest" VALUES(2, 'Andrew', 'Goboza', 'kuerrymau1@gmail.com', '0715849764');
INSERT INTO "Guest" VALUES(3, 'Mike', 'Gabuza', 'kuerrymau@gmail2.com', '0715849764');

INSERT INTO "RoomType" VALUES(3, 'Queen Luxury', 1, 5.00, '', 3);
INSERT INTO "RoomType" VALUES(1, 'Double Luxury', 2, 3.00, '', 2);
INSERT INTO "RoomType" VALUES(2, 'Single Luxury', 3, 2.00, '', 1);
INSERT INTO "RoomType" VALUES(4, 'Single Standard', 4, 2.00, '', 1);

INSERT INTO "Hotel" VALUES(1, 'Sun Hotels', '', '', 'Five Star', 1, 1, '1970-12-31 23:59:59', '1970-12-31 23:59:59');
INSERT INTO "Hotel" VALUES(2, 'Protea Hotels', '', '', 'Four Star', 2, 2, '1970-12-31 23:59:59', '1970-12-31 23:59:59');
INSERT INTO "Hotel" VALUES(3, 'Camps Bay Hotel', '', '', 'Three Star', 3, 3, '1970-12-31 23:59:59', '1970-12-31 23:59:59');
INSERT INTO "Hotel" VALUES(4, 'Sandy Bay Hotel', '', '', 'Two Star', 1, 2, '1970-12-31 23:59:59', '1970-12-31 23:59:59');

INSERT INTO "Location" VALUES(1, 'Cape Town', '');
INSERT INTO "Location" VALUES(2, 'Durban', '');
INSERT INTO "Location" VALUES(3, 'London', '');

INSERT INTO "HotelType" VALUES(1, 'Hotel', '');
INSERT INTO "HotelType" VALUES(2, 'Motel', '');
INSERT INTO "HotelType" VALUES(3, 'Game Lodge', '');