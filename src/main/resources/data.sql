INSERT INTO Users (USERNAME, PASSWORD, EMAIL, FIRSTNAME, LASTNAME, USERROLE)
VALUES ('Bookshelf', '$2a$10$.15JpEdwxJObxGn2q.3nCu9JThPI3DCZZavQcXLSVY5h.Fh.ZDjwi', 'test@bookshelf.com', 'Testbruker', 'Testersen', 'ADMIN');

INSERT INTO Books (bookId, title, author, smallPicture, largePicture, releaseYear, issn, publisher, pages)
VALUES ('27b23bb0bdc7e60ddb88f02235325400', 'Harry Potter og de vises stein', 'Rowling, J.K. (Joanne Kathleen), Høverstad, Torstein Bugge', 'https://www.nb.no/services/image/resolver/URN:NBN:no-nb_digibok_2018090507083_C1/full/0,64/0/native.jpg', 'https://www.nb.no/services/image/resolver/URN:NBN:no-nb_digibok_2018090507083_C1/full/0,200/0/native.jpg', '2014', null, 'Cappelen Damm', 293);

INSERT INTO Books (bookId, title, author, smallPicture, largePicture, releaseYear, issn, publisher, pages)
VALUES ('0c866e15d22785ca75c0f68da628b61c', 'Blodmåne', 'Nesbø, Jo', 'https://www.nb.no/services/image/resolver/URN:NBN:no-nb_pliktmonografi_000020369_C1/full/0,64/0/native.jpg', 'https://www.nb.no/services/image/resolver/URN:NBN:no-nb_pliktmonografi_000020369_C1/full/0,200/0/native.jpg', '2023', null, 'Aschehoug', 492);

INSERT INTO Books (bookId, title, author, smallPicture, largePicture, releaseYear, issn, publisher, pages)
VALUES ('b2d89affdfe69b25ee4440063fc1dcd9', 'Brukeravgifter i veisektoren', 'Hagen, Kåre P., Pedersen, Karl R.', 'https://www.nb.no/services/image/resolver/URN:NBN:no-nb_digibok_2018071807239_C1/full/0,64/0/native.jpg', 'https://www.nb.no/services/image/resolver/URN:NBN:no-nb_digibok_2018071807239_C1/full/0,200/0/native.jpg', '2014', '08039763', 'Ex Ante', 71);

INSERT INTO Library (userId, bookId, isFavorite, hasRead, readDate)
VALUES ('1', '27b23bb0bdc7e60ddb88f02235325400', true, false, null);

INSERT INTO Library (userId, bookId, isFavorite, hasRead, readDate)
VALUES ('1', 'b2d89affdfe69b25ee4440063fc1dcd9', false, false, null);