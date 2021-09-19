Uygulamada JPA entity ve JPA repository oluşturdum, classların tutulduğu model katmanı oluşturuldu. Daha sonra Listeleme GET PUT POST DELETE 
aşamaları oluşturuldu ve hepsi test edildi bu işlemleri controller classında gerçekleştirdim. MySQL'e bağlanısını da Application properties oluşturdum.


1.Veritabanı olarak mySQL kullanılmıştır. ve dosyanın içerisine koyulmuştur. (books.SQL)
2.Uygulama da GET - POST- DELETE - PUT işlerimleri postman de başarılı şekilde 200OK çalışıyor.
3. Postmande test işleminde http://localhost:8080/api/v1/books (GET ve POST) kullanılan URL 
4. http://localhost:8080/api/v1/books{Id} bu da PUT ve DELETE işleminde girilmesi gereken URL
